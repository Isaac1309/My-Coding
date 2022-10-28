public class CountingSort {
    private static final int ITEMS=10;
    private int[] nums;

    public CountingSort(int[] nums) {
        this.nums = nums;
    }

    public void sort(){
        int[] output=new int[nums.length];
        int[] count=new int[ITEMS];
        for(int i=0;i<nums.length;++i)
            count[nums[i]]++;
        for(int i=1;i<count.length;++i)
            count[i] += count[i-1];
        for(int i=nums.length-1;i>=0;--i){
            count[nums[i]]--;
            output[count[nums[i]]]=nums[i];
        }
        for(int i=0;i<nums.length;++i)
            nums[i]=output[i];
        showSortedArray();
    }
    
    private void showSortedArray(){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }
    }
}
