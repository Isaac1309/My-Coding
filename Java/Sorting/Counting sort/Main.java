public class Main {
    public static void main(String[] args) {
        int[] nums = {6,0,2,1,3,7,9,2,4};
        CountingSort sort = new CountingSort(nums);
        sort.sort();
    }
}
