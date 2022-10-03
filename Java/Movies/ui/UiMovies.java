package ui;

import javax.swing.JOptionPane;
import Models.*;

public class UiMovies {
    public static void userInterface() {
        IMovieCatalog movies = new ImplementationMoviesCatalog();
        Movie movie;

        turnOff:
        while (true) {
            String option = JOptionPane.showInputDialog(null, 
             "1-Insert Movie\n2-Movie List\n3-Search Movie\n4-Close\n",
             "Select an option", 3);
            int optionInt = 0;
            try {
                optionInt = Integer.parseInt(option);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                 "Please, select an Integer Number\n" + e, "ERROR",JOptionPane.ERROR_MESSAGE);
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            switch(optionInt){
                case 1:
                    String nameMovie = JOptionPane.showInputDialog(null, 
                     "Insert the movie's name", "Input", 3);
                    movie = new Movie(nameMovie);
                    movies.insertMovie(movie);
                    break;
                case 2:
                    movies.listMovies();
                    break;
                case 3:
                    String sNameMovie = JOptionPane.showInputDialog(null, 
                    "Insert the movie's name", "Input", 3);
                    movies.searchMovie(sNameMovie);
                    break;
                case 4:
                    break turnOff;
                default:
                    JOptionPane.showMessageDialog(null, "Please, select a valid option (1 to 4)", "Error", 0);
                    break;
            }
        }
    }
}
