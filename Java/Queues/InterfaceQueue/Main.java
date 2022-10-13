public class Main {
    public static void main(String[] args) {
        //Queue is an interface but it can be instanced with a LinkedList
        //We process the data with a Fifo manner
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        //element() return the first data without removing 
        System.out.println(queue.element());
        //remove() method is the dequeue() method
        while(!queue.isEmpty()){
            System.out.println(queue.remove());
        }
        
        //working with a class in a queue
        Queue<Task> queueClass = new LinkedList<>();

        queueClass.add(new Task(1));
        queueClass.add(new Task(2));
        queueClass.add(new Task(3));

        System.out.println(queueClass.element());
        
        while(!queueClass.isEmpty()){
            Task task = queueClass.remove();
            task.execute();
        }
    }
}
