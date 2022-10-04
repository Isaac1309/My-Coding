package Management;

import java.io.*;

public class ClassFile {
    public static void createFile(String nameFile) {
        File file = new File(nameFile);
        try {
            PrintWriter out = new PrintWriter(file);
            out.close();
            System.out.println("Created file");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void writeFile(String nameFile, String data) {
        File file = new File(nameFile);
        try {
            PrintWriter out = new PrintWriter(new FileWriter(file, true));
            out.println(data);
            out.close();
            System.out.println("Written file");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    public static void readFile(String nameFile) {
        File file = new File(nameFile);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String reading = in.readLine();
            System.out.println("The file "+nameFile+" has:\n");
            while(reading!=null){
                System.out.println(reading);
                reading = in.readLine();
            }
            in.close();
            System.out.println("\nRead file");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    public static void deleteFile(String nameFile) {
        File file = new File(nameFile);
        if(file.exists()){
            file.delete();
            System.out.println("The file was deleted");
        }else{
            System.out.println("The file doesn't exists");
        }
    }
}
