public class Main {
    public static void main(String[] args) {
        String nameFile = "Test.txt";
        FileManagement.fileCreate(nameFile);
        FileManagement.writeFile(nameFile, "Hello from java");
        FileManagement.addDataFile(nameFile, "Goodbye");
        FileManagement.readFile(nameFile);
    }
}
