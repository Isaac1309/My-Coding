package Models;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ImplementationMoviesCatalog implements IMovieCatalog{
    private final ArrayList<String> movieList;

    public ImplementationMoviesCatalog(){
        this.movieList=new ArrayList<>();
    }

    @Override
    public void insertMovie(Movie nameMovie) {
        this.movieList.add(nameMovie.toString());
    }
    @Override
    public void listMovies() {
        JOptionPane.showMessageDialog(null, this.movieList, "List of Movies", JOptionPane.INFORMATION_MESSAGE);
    }
    @Override
    public void searchMovie(String nameMovie) {
        String result = null;
        for (String movie : this.movieList) {
            if(movie.equals(nameMovie.toString())){
                result=movie;
                break;
            }else{
                result=movie;
            }
        }
        if(nameMovie.equals(result)){
            JOptionPane.showMessageDialog(null, "Result = "+result, "Wanted Movie", JOptionPane.QUESTION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "The wanted movie doesn't found = "+nameMovie, "Wanted Movie", JOptionPane.WARNING_MESSAGE);
        }
    }
}
