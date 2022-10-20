public class Main{
    public static void main(String[] args){
        Heap heap = new Heap();

        heap.insert(6);
        System.out.println(heap.getMax());
        heap.insert(1);
        System.out.println(heap.getMax());
        heap.insert(12);
        System.out.println(heap.getMax());
        heap.insert(-2);
        heap.insert(3);
        heap.insert(8);
        heap.insert(-5);
        System.out.println(heap.getMax());

        System.out.println("\nDoing the heap sort");
        heap.heapSort();
    }
}