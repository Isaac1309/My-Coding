package DataBase;

public class Song {
    private int id;
    private int tack;
    private String name;
    private int albumId;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getTack() {
        return tack;
    }
    public void setTack(int tack) {
        this.tack = tack;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAlbumId() {
        return albumId;
    }
    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
}
