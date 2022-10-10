public class ReversingArray {
    public static void main(String[] args) {
        System.out.println("Reversing Array with two Arrays");
        int[] arr={1,2,3,4,5};
        int[] reverse=new int[arr.length];
        int count=0;

        for(int i=arr.length;i>0;i--){
            reverse[count]=arr[i-1];
            count++;
        }

        for (int i=0;i<reverse.length;i++) {
            System.out.println(reverse[i]);
        }

        System.out.println("\nReversing Array without use additional memory");
        int i1=0, i2=arr.length-1;
        while(i1!=i2){
            reverse(arr, i1, i2);
            i1++;
            i2--;
        }

        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    private static void reverse(int[] nums, int i1, int i2){
        int temporal = nums[i1];
        nums[i1]=nums[i2];
        nums[i2]=temporal;
    }
}
