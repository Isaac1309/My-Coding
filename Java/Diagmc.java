import java.util.Random;

public class Diagmc {

    public Diagmc() {
        Random r = new Random();
        int numal = r.nextInt((10) + 1) + 10;
        int[] nums = new int[numal];
        System.out.println("Array size = " + numal);
        int nal1 = 0;
        int nal2 = 0;
        for (int i = 0; i < numal; i++) {

            boolean lleno = true;
            boolean creado = true;

            while (lleno == true) {
                Random r1 = new Random();
                nal1 = r1.nextInt((numal));
                if (nums[nal1] == 0) {
                    System.out.println("Position " + nal1 + " is empty");
                    lleno = false;
                } else {
                    System.out.println("Position " + nal1 + " is filled");
                }
            }

            while (creado == true) {
                Random r2 = new Random();
                nal2 = r2.nextInt((numal) + 1);
                creado = false;
                for (int j = 0; j < numal; j++) {
                    if (nums[j] == nal2) {
                        creado = true;
                    }
                }

                if (creado == false) {
                    nums[nal1] = nal2;
                    System.out.println("Filling position " + nal1 + " with " + nal2);
                }

            }

        }
        for (int i = 0; i < numal; i++) {
            System.out.println("Position " + i + " is " + nums[i]);
        }

    }

    public static void wastedTime() throws InterruptedException {
        Thread.sleep(5000);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        new Diagmc();
        
        
       long endTime = System.nanoTime();
       long duration = (endTime - startTime);
       System.out.println("Process lasted " + duration/1000000 + " miliseconds");
    }
}
