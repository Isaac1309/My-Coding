import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player tim=new Player("Tim",10,15);
        System.out.println(tim.toString());
        saveObject(tim);

        tim.setHitPoints(8);
        System.out.println(tim);
        tim.setWeapon("Stormbringer");
        saveObject(tim);
        loadObject(tim);
        System.out.println(tim);
    }

    public static void saveObject(ISaveable objetToSave){
        for (int i=0; i<objetToSave.write().size();i++){
            System.out.println("Saving "+objetToSave.write().get(i)+" to storage device");
        }
    }

    public static void loadObject(ISaveable objetToLoad) {
        ArrayList<String> values = readValues();
        objetToLoad.read(values);
    }
    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index=0;
        System.out.println("Choose\n1 to enter a string\n0 to quit");
        while (!quit){
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    quit=true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput=scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
}
