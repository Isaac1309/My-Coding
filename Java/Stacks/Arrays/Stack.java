public class Stack<T> {
    private T[] stack;
    private int count;

    public Stack(){
        this.stack = (T[]) new Object[1];
    }

    public void push(T newData){
        if(count==this.stack.length){
            resize(2*count);
        }
        this.stack[count++] = newData;
    }

    public T pop(){
        if(isEmpty()) return null;
        T item = this.stack[--count];
        this.stack[count]=null;
        if(count>0 && count==(this.stack.length/4)){
            resize(this.stack.length/2);
        }
        return item;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count==0;
    }

    private void resize(int capacity){
        System.out.println("Need to resize the Array");
        T[] stackCopy = (T[]) new Object[capacity];
        for(int i=0; i<count;i++){
            stackCopy[i]=this.stack[i];
        }
        this.stack=stackCopy;
    }
}
