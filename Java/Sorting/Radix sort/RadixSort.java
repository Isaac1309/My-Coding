import java.util.Arrays;

public class RadixSort {
    private static final int ITEMS=10;
    private int[] nums;

    public RadixSort(int[] nums) {
        this.nums = nums;
    }
    public void sort(){
        int place=1;
        for(int i=0;i<getmaxDigit();i++){
            countingSort(place);
            place*=10;
        }
        showSortedArray();
    }

    private void countingSort(int place){
        int[] output=new int[nums.length];
        int[] count=new int[ITEMS];
        for(int i=0;i<nums.length;++i)
            count[(nums[i]/place)%ITEMS]++;
        for(int i=1;i<count.length;++i)
            count[i] += count[i-1];
        for(int i=nums.length-1;i>=0;--i){
            count[(nums[i]/place)%ITEMS]--;
            output[count[(nums[i]/place)%ITEMS]]=nums[i];
        }
        for(int i=0;i<nums.length;++i)
            nums[i]=output[i];
    }

    private int getmaxDigit(){
        int max = Arrays.stream(nums).max().getAsInt();
        return String.valueOf(max).length();
    }
    
    private void showSortedArray(){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }
    }
}
