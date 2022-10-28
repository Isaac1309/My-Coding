import java.util.Arrays;

public class CountingSortArbitrary {
    private int[] nums;
    private int max;
    private int min;

    public CountingSortArbitrary(int[] nums) {
        this.nums = nums;
        this.min = Arrays.stream(nums).min().getAsInt();
        this.max = Arrays.stream(nums).max().getAsInt();
    }

    public void sort(){
        int[] output=new int[nums.length];
        int[] count=new int[max-min+1];
        for(int i=0;i<nums.length;++i)
            count[nums[i]-min]++;
        for(int i=1;i<count.length;++i)
            count[i] += count[i-1];
        for(int i=nums.length-1;i>=0;--i){
            count[nums[i]-min]--;
            output[count[nums[i]-min]]=nums[i];
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
