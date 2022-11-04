public class Main {
    public static void main(String[] args){
        int[] numbers=new int[1000000];
        for(int i=0;i<numbers.length;i++)
            numbers[i]=i;
        long time = System.currentTimeMillis();
        search(numbers, numbers.length-1);
        System.out.println("Time taken search: "+ (System.currentTimeMillis()-time)+" in milliseconds");
        long timeSum = System.currentTimeMillis();
        sum(numbers);
        System.out.println("Time taken the sum: "+ (System.currentTimeMillis()-timeSum)+" in milliseconds");
    }

    //O(N)
    public static int sum(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        return sum;
    }

    //O(N)
    public static int search(int[] nums, int item){
        for(int i=0;i<nums.length;i++)
            if(nums[i]==item)
                return i;
        return -1;
    }
}
