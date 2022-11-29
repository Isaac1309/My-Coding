import java.io.*;

public class FileManagement {
    public static void fileCreate(String nameFile){
        File file = new File(nameFile);
        try {
            PrintWriter out = new PrintWriter(file);
            out.close();
            System.out.println("The file was created.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String nameFile, String data){
        File file = new File(nameFile);
        try {
            PrintWriter out = new PrintWriter(file);
            out.println(data);
            out.close();
            System.out.println("The file was written.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addDataFile(String nameFile, String data){
        File file = new File(nameFile);
        try {
            PrintWriter out = new PrintWriter(new FileWriter(file, true));
            out.println(data);
            out.close();
            System.out.println("The data was written in the file.");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void readFile(String nameFile){
        File file = new File(nameFile);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String read = in.readLine();
            while(read!=null){
                System.out.println(read);
                read=in.readLine();
            }
            in.close();
            System.out.println("The file was read.");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}