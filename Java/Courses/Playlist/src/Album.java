import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<>();
    }
    public boolean addSong(String titleSong, double duration){
        if (findSong(titleSong)==null){
            Song song = new Song(titleSong, duration);
            this.songs.add(song);
            return true;
        }
        return false;
    }
    private Song findSong(String titleSong){
        for (Song songToFind:this.songs){
            if (songToFind.getTitle().equals(titleSong)) return songToFind;
        }
        return null;
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int i =trackNumber-1;
        if (i>=0&&i<this.songs.size()){
            playList.add(this.songs.get(i));
            return true;
        }
        return false;
    }
    public boolean addToPlayList(String titleSong, LinkedList<Song> playList){
        Song checkedSong = findSong(titleSong);
        if (checkedSong!=null){
            playList.add(checkedSong);
            return true;
        }
        return false;
    }
}