public class Main {
    public static void main(String[] args){
        int[] numbers=new int[10000];
        for(int i=numbers.length-1;i<=0;i--)
            numbers[i]=i;
        long start = System.currentTimeMillis();
        sort(numbers);
        System.out.println("\nTime taken: "+ (System.currentTimeMillis()-start)+" in milliseconds");
    }

    //O(N*N)
    public static void sort(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<nums.length;j++){
                if(nums[j-1]>nums[j]){
                    int temp=nums[j-1];
                    nums[j-1]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        /*for(int i=0;i<nums.length;i++)
            System.out.print(nums[i]+"-");*/
    }
}