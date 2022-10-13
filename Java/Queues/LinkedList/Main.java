public class Main {
    public static void main(String[] args) {
        System.out.println("Working with a Queue class that I create");
        Queue<Integer> myQueue = new Queue<Integer>();

        System.out.println("Adding to the Queue 3 datas");
        myQueue.enqueque(10);
        myQueue.enqueque(100);
        myQueue.enqueque(1000);

        System.out.println("Checking the sizo of the Queue");
        System.out.println(myQueue.size());

        System.out.println("Taking the data of the queue");
        System.out.println(myQueue.dequeque());
        System.out.println(myQueue.dequeque());
        System.out.println(myQueue.dequeque());
    }
}
