import DataBase.Artist;
import DataBase.DB;
import DataBase.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DB db = new DB();
        if (!db.open()){
            System.out.println("Can't open db");
            return;
        }
        List<Artist> artists = db.queryArtists(db.ORDER_BY_NONE);
        if (artists==null){
            System.out.println("No artists");
            return;
        }
        artists.forEach(artist->System.out.println("ID = "+artist.getId()+", Name = "+artist.getName()));

        List<String> albumsForArtist =
                db.queryAlbumsForArtist("Carole King", db.ORDER_BY_ASC);
        albumsForArtist.forEach(album-> System.out.println(album));

        List<SongArtist> songArtists = db.queryArtistForSong("She's On Fire",db.ORDER_BY_NONE);
        if (songArtists==null){
            System.out.println("Couldn't find the artist for the song");
            return;
        }
        songArtists.forEach(artist->System.out.println("Artist name = "+artist.getArtistName()
                +", Album name = "+artist.getAlbumName()
                +", Track = "+artist.getTrack()));

        db.querySongsMetadata();

        int count = db.getCount(db.TABLE_SONGS);
        System.out.println("Number of songs is "+count);

        db.createViewForSongArtists();


        /**Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title: ");
        String title = scanner.nextLine();
        songArtists = db.querySongInfoView(title);
        if (songArtists.isEmpty()){
            System.out.println("Couldn't find the artist for the song");
            return;
        }
        songArtists.forEach(artist->System.out.println("FROM VIEW - Artist name = "+artist.getArtistName()
                +", Album name = "+artist.getAlbumName()
                +", Track = "+artist.getTrack()));*/

        db.insertSong("Bird Dog", "Everly Brothers", "All-Time Greatest Hits", 7);

        db.close();
    }
}
