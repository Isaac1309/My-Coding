import static Management.ClassFile.*;

public class Main {
    public static void main(String[] args) {
        createFile("Files\\Hello.txt");
        writeFile("Files\\Hello.txt", "Hello there");
        writeFile("Files\\Hello.txt", "General Kenobi");
        readFile("Files\\Hello.txt");
        deleteFile("Files\\Hello.txt");
    }
}
