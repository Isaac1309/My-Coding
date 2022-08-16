import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class TamArchivo extends RecursiveTask<Long> {

    /**
     *
     */

    // file path
    private String path = ".\\";

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public TamArchivo(String path) {
        this.path = path;

    }

    public static void main(String[] args) {
        float tam;
        TamArchivo task = new TamArchivo(".\\");
        ForkJoinPool pool = new ForkJoinPool();

        pool.execute(task);

        do {
            System.out.format("\nActive threads: %d \n", pool.getActiveThreadCount());
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        pool.shutdown();
        if (task.isCompletedNormally())
            System.out.format("\n\nCompleted!");

        try {
            if(task.get()>(1048576*1024)){
                tam= (float) (task.get()) / (1048576*1024);
            System.out.format("Folder is %.2f GB",tam);
            }else if(task.get()>1048576){
                tam= (float) (task.get()) / 1048576;
                System.out.format("Folder is %.0f MB",tam);
            }else if(task.get()>1024){
                tam= (float) (task.get()) / 1024;
                System.out.format("Folder is %.0f KB",tam);
            }else{
                System.out.println("Folder is " + task.get() + " B");
            }

        } catch (InterruptedException | ExecutionException e) {

            e.printStackTrace();
        }

    }

    protected Long compute() {
        long d = 0;
        String paths[];
        String currentpath;
        File f = new File(path);
        paths = f.list();

        for (int i = 0; i < paths.length; i++) {
            File fs = new File(path + paths[i]);
            d += fs.length();
            System.out.println(path + paths[i] + ": " + fs.length()+" B");
            if (fs.isDirectory()) {

                currentpath = path + fs.getName() + "\\";
                System.out.println("folder found " + currentpath);
                TamArchivo t = new TamArchivo(currentpath);
                invokeAll(t);
                try {
                    d = d + t.get();
                } catch (InterruptedException | ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
        

        return d;
    };

    
}
