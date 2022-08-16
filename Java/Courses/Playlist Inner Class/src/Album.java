import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new SongList();
    }
    public boolean addSong(String titleSong, double duration){
        return this.songs.add(new Song(titleSong, duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        Song checkedSong = this.songs.findSong(trackNumber);
        if (checkedSong!=null){
            playList.add(checkedSong);
            return true;
        }
        return false;
    }
    public boolean addToPlayList(String titleSong, LinkedList<Song> playList){
        Song checkedSong = this.songs.findSong(titleSong);
        if (checkedSong!=null){
            playList.add(checkedSong);
            return true;
        }
        return false;
    }

    private class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs=new ArrayList<>();
        }

        public boolean add(Song song){
            if (this.songs.contains(song)){
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String titleSong){
            for (Song songToFind:this.songs){
                if (songToFind.getTitle().equals(titleSong)) return songToFind;
            }
            return null;
        }
        public Song findSong(int trackNumber){
            int i =trackNumber-1;
            if (i>=0&&i<this.songs.size()) return this.songs.get(i);
            return null;
        }
    }
}