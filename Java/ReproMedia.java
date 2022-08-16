import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

@SuppressWarnings("serial")
public class ReproMedia extends JFrame implements ActionListener, ChangeListener {
    JFileChooser jfcSel = new JFileChooser();
    final String sVLCpath = "C:/Program Files/VideoLAN/VLC";
    JPanel jPanel = new JPanel(new GridLayout(2, 4, 4, 4));
    JButton jbArch, jbRepPaus, jbDetener;
    JOptionPane fileOptions = new JOptionPane();
    JLabel jlReproducido = new JLabel(" Reproducido: 00:00:00"),
    		jlRemanente = new JLabel(" Remanente: 00:00:00 "),
    		jlTotal = new JLabel(" Total: 00:00:00");
    JCheckBox chbopcion = new JCheckBox(" Tiempo/Sonido");
    File fArchivo;
    String path;
    JLabel jVol; 
    int vol = 50;
    boolean bPausa = false;
    boolean bTiem = false;
    boolean bSoni = true;
    boolean bProgreso = true;
    
    private JSlider jsBarra = new JSlider( SwingConstants.HORIZONTAL);
    EmbeddedMediaPlayerComponent reproductor;
    final FileNameExtensionFilter filExt = new FileNameExtensionFilter( "Tipos de Media", "mp3", "mp4", "mkv", "ogg", "mpg", "avi");
    
    public ReproMedia () {
    	setTitle("Reproductor_de_Media");
    	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    	jPanel.setBackground(new Color(140, 0, 0));
    	NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), sVLCpath);
    	reproductor = new EmbeddedMediaPlayerComponent();
    	
    	jVol = new JLabel(" Volumen: 0%");
    	jVol.setOpaque(true);
    	chbopcion.add(jVol);
    	jPanel.add(jVol);
    	
    	jbArch = new JButton();
    	jbRepPaus = new JButton();
    	jbDetener = new JButton();
    	
    	jbArch.addActionListener( this );
    	jbRepPaus.addActionListener( this );
    	jbDetener.addActionListener( this );
    
    	jbArch.setText("Abrir");
    	jbArch.setBackground(Color.WHITE);
    	jbArch.setFont(new Font("Arial", Font.BOLD,12));
    	jbRepPaus.setText("Play");
    	jbRepPaus.setBackground(Color.WHITE);
    	jbRepPaus.setFont(new Font("Arial", Font.BOLD,12));
    	jbDetener.setText("Stop");
    	jbDetener.setBackground(Color.WHITE);
    	jbDetener.setFont(new Font("Arial", Font.BOLD,12));
		jsBarra.setMajorTickSpacing(0);
		jsBarra.setFont( new Font("Console", Font.PLAIN, 25 ));
		jsBarra.setPaintTicks( true );
		jsBarra.setPaintLabels( true );
		jsBarra.setOpaque(false);
		
		jPanel.add(jlReproducido);
		jlReproducido.setOpaque(true);
		jPanel.add(jlRemanente);
		jlRemanente.setOpaque(true);
		jPanel.add(jlTotal);
		jlTotal.setOpaque(true);
		jPanel.add(jsBarra);
		add(reproductor,BorderLayout.CENTER );
    	add(jPanel,BorderLayout.SOUTH );
    	chbopcion.setBackground(Color.WHITE);

    	jPanel.add(jbArch);
    	jPanel.add(jbRepPaus);
    	jPanel.add(jbDetener);
    	jPanel.add(chbopcion);
    	
		jsBarra.addChangeListener(new javax.swing.event.ChangeListener() {
    	    public void stateChanged(javax.swing.event.ChangeEvent evt) {
    	    	if(bTiem==true) {
    	    		jSliderVolumenStateChanged(evt);
    	    	}else {
    	    		jSlider_progresoStateChanged(evt);
    	    	}
    	            }
    	        });
		
		
		jsBarra.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mousePressed(java.awt.event.MouseEvent evt) {
                jSlider_progresoMousePressed(evt);
            }
    public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider_progresoMouseReleased(evt); 
                }});
		
		reproductor.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
			public void positionChanged(MediaPlayer mp, float posicion){
				jlReproducido.setText("	Reproducido: " + msToTime(reproductor.getMediaPlayer().getTime()));
				jlRemanente.setText(" Remanente: " + (msToTime(reproductor.getMediaPlayer().getLength() - reproductor.getMediaPlayer().getTime())) + " ");
				jlTotal.setText(" Total: " + msToTime(reproductor.getMediaPlayer().getLength()));
				
				if(bProgreso && bTiem==false) {
				int value = Math.min(100, Math.round(posicion * 100.0f));        
	            jsBarra.setValue(value);    
			}
			if(bTiem==false && bSoni==true) {
				int value = Math.min(100, Math.round(posicion * 100.0f));        
	            jsBarra.setValue(value);   
	            bSoni = false;
			}
			}
		});
    	chbopcion.addItemListener(new ItemListener(){
    		
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(chbopcion.isSelected()==true) {
					bTiem = true;
				}else {
					bTiem = false;
					bSoni = true;
				}
			}
    	});
    	setLocation(250, 0);
    	setSize(900, 620);
    	setVisible(true);
    }

    public String msToTime(long iTime){ 
    	int time = (int)iTime; 
    	String formatedTime = "", sSeconds = "", sMinutes = "", sHours = ""; 
    	int seconds = (time / 1000) % 60,
    		minutes = (time / (1000 * 60)) % 60, 
    		hours = (time / (1000 * 60 * 60)) % 24;
    	
    	sHours = (hours < 10) ? "0" + Integer.toString(hours) : Integer.toString(hours);
    	sMinutes = (minutes < 10) ? "0" + Integer.toString(minutes) : Integer.toString(minutes); 
    	sSeconds = (seconds < 10) ? "0" + Integer.toString(seconds) : Integer.toString(seconds); 
    	formatedTime = sHours + ":" + sMinutes + ":" + sSeconds;
    	return formatedTime;
    }
    
	public static void main(String[] args) {
           new ReproMedia();
	}
	
	 public void jSlider_progresoMousePressed(java.awt.event.MouseEvent evt) {
		 bProgreso=false;
	    }
	 
	    public void jSlider_progresoMouseReleased(java.awt.event.MouseEvent evt) {
	    	bProgreso=true;
	    }
	
	public void jSlider_progresoStateChanged(javax.swing.event.ChangeEvent evt) {
        if(!bProgreso){
            float posicion = jsBarra.getValue()/100f; 
            reproductor.getMediaPlayer().setPosition(posicion); 
        }
    }
	
	public void jSliderVolumenStateChanged(javax.swing.event.ChangeEvent evt) {
        vol = jsBarra.getValue();
        reproductor.getMediaPlayer().setVolume(vol);
        jVol.setText("Volumen: " + vol + "%");
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbArch) {
			jfcSel.setFileFilter(filExt);
			jfcSel.showOpenDialog(null);
			fArchivo = jfcSel.getSelectedFile();
			if(fArchivo != null) {
				path = fArchivo.getAbsolutePath();
				reproductor.getMediaPlayer().prepareMedia(path);
			}
		}else if(e.getSource() == jbRepPaus) {
			jbRepPaus.setText("Pausa");
			if (bPausa) {
				reproductor.getMediaPlayer().pause();
				bPausa = false;
			}else {
				reproductor.getMediaPlayer().play();
				bPausa = true;
				jVol.setText("Volumen: " + vol + "%");
		    }
		}else if( e.getSource() == jbDetener ) {
	    	jbRepPaus.setText("Replay");
            reproductor.getMediaPlayer().stop();		
            bPausa = false;
		}
		if(bTiem) {
		}
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {}

}