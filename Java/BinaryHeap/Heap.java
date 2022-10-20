public class Heap {
    private int[] heap;
    private int heapSize;

    public Heap() {
        heap = new int[Constants.CAPACITY];
    }

    public void insert(int data){
        if(isFull()) throw new RuntimeException("Heap is full");
        heap[heapSize]=data;
        heapSize++;
        fixUp(heapSize-1);
    }

    private void fixUp(int index){
        int parentIndex=(index-1)/2;
        if(index>0 && heap[index]>heap[parentIndex]){
            swap(index, parentIndex);
            fixUp(parentIndex);
        }
    }

    public int getMax(){
        return heap[0];
    }
    
    public void heapSort(){
        int n = heapSize;
        for(int i=0; i<n;i++){
            int max=poll();
            System.out.println(max);
        }
    }

    public int poll(){
        int max=getMax();
        swap(0, heapSize-1);
        heapSize--;
        fixDown(0);
        return max;
    }
    
    private void fixDown(int index){
        int leftChildIndex=2*index+1;
        int rightChildIndex=2*index+2;
        int largestIndex=index;
        if(leftChildIndex<heapSize && heap[leftChildIndex]>heap[index])
            largestIndex=leftChildIndex;
        if(rightChildIndex<heapSize && heap[rightChildIndex]>heap[largestIndex])
            largestIndex=rightChildIndex;
        if(index!=largestIndex){
            swap(index, largestIndex);
            fixDown(largestIndex);
        }
    }

    private void swap(int index1, int index2){
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public boolean isEmpty(){
        return heapSize==0;
    }


    private boolean isFull(){
        return heapSize==heap.length;
    }
}
