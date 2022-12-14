import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Album> albums=new ArrayList<>();

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer",4.6);
        album.addSong("Love don't mean a thing",4.22);
        album.addSong("Holy man",4.3);
        album.addSong("Hold on",5.6);
        album.addSong("Lady double dealer",3.21);
        album.addSong("You can't do it right",6.23);
        album.addSong("High ball shooter",4.27);
        album.addSong("The gypsy",4.2);
        album.addSong("Soldier of fortune",3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock",5.44);
        album.addSong("I put the finger on you",3.25);
        album.addSong("Lets go",3.45);
        album.addSong("Inject the venom",3.33);
        album.addSong("Snowballed",4.51);
        album.addSong("Evil walks",3.45);
        album.addSong("C.O.D.",5.25);
        album.addSong("Breaking the rules",5.32);
        album.addSong("Night of the long knives",5.12);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlayList("You can't do it right",playlist);
        albums.get(0).addToPlayList("Holy man",playlist);
        albums.get(0).addToPlayList("Speed king",playlist);
        albums.get(0).addToPlayList(9,playlist);
        albums.get(1).addToPlayList(3,playlist);
        albums.get(1).addToPlayList(2,playlist);
        albums.get(1).addToPlayList(24,playlist);

        play(playlist);
    }

    private static void play(LinkedList<Song> playList){
        ListIterator<Song> listIterator = playList.listIterator();
        boolean quit = false;
        boolean forward=true;
        if (playList.size()==0){
            System.out.println("No songs in playlist");
        }else {
            System.out.println("Now playing "+listIterator.next().toString());
        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist complete.");
                    quit=true;
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext())
                            listIterator.next();
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else {
                        System.out.println("We have reached the end of the playlist");
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious())
                            listIterator.previous();
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("We are at the start of the playlist");
                    }
                    break;
                /*case 3:
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;*/
            }
        }
    }

}
