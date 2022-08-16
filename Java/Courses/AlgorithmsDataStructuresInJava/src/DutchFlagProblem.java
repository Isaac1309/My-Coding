import java.util.Arrays;

public class DutchFlagProblem {
    private int[] nums;

    public DutchFlagProblem(int[] nums) {
        this.nums = nums;
    }
    public void solve(){
        for (int i=0; i<nums.length;i++){
            for (int j=0; j<nums.length;j++){
                if (i!=j){
                    if (nums[i]<nums[j]) swap(i,j);
                }
            }
        }
    }
    private void swap(int index1, int index2){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }
    public void showResult(){
        System.out.println(Arrays.toString(nums));
    }
}
