public class Main{
    public static void main(String[] args){
        int[] nums = {3,2,-1,6,5,4,-3,3,7,2,3};
        Fenwick fenwickTree = new Fenwick(nums);
        System.out.println(fenwickTree.rangeSum(8,10));
    }
}