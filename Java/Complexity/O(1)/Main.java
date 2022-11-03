public class Main{
    public static void main(String[] args){
        int[] numbers=new int[100000];
        for(int i=0;i<numbers.length;i++)
            numbers[i]=i;
        long start = System.currentTimeMillis();
        getFirst(numbers);
        System.out.println("Time taken: "+ (System.currentTimeMillis()-start)+" in milliseconds");
    }

    //O(1)
    public static int getFirst(int[] nums){
        return nums[0];
    }
}