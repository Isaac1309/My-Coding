public class Main {
    public static void main(String[] args){
        int[] numbers=new int[1000000];
        for(int i=0;i<numbers.length;i++)
            numbers[i]=i;
        long start = System.currentTimeMillis();
        search(numbers, numbers.length-1);
        System.out.println("Time taken: "+ (System.currentTimeMillis()-start)+" in milliseconds");
    }

    //O(LogN)
    public static int search(int[] nums, int item){
        int left=0;
        int right=nums.length-1;
        while (left<=right) {
            int middle = (left+right)/2;
            if(nums[middle]==item)
                return middle;
            if(nums[middle]<item)
                left=middle+1;
            else
                right=middle-1;
        }
        return -1;
    }
}
