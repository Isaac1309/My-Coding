public class QuickSort {
    private int[] nums;

    public QuickSort(int[] nums) {
        this.nums = nums;
    }
    
    public void sort(){
        sort(0,nums.length-1);

        showSortedArray();
    }

    private void sort(int low,int high){
        if(high<low) return;
        int pivot=partition(low, high);
        sort(low, pivot-1);
        sort(pivot+1,high);
    }

    private int partition(int low,int high){
        int middleItem=(low+high)/2;
        swap(middleItem, high);
        int i = low;
        for(int j=low;j<high;++j){
            if(nums[j]<=nums[high]){
                swap(i, j);
                i++;
            }
        }
        swap(i, high);
        return i;
    }

    private void swap(int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private void showSortedArray(){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }
    }
}
