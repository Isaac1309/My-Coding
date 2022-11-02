public class Fenwick {
    private int[] fenwickTree;

    public Fenwick(int[] nums) {
        this.fenwickTree = new int[nums.length+1];
        construct(nums);
    }
    
    public int rangeSum(int startIndex, int endIndex){
        return sum(endIndex)-sum(startIndex-1);
    }

    public int sum(int index){
        index++;
        int sum=0;
        while(index>0){
            sum+=this.fenwickTree[index];
            index=parent(index);
        }
        return sum;
    }

    private void construct(int[] nums){
        for(int i=1;i<=nums.length;i++)
            update(i, nums[i-1]);
    }

    public void update(int index,int num){
        while(index<this.fenwickTree.length){
            this.fenwickTree[index]+=num;
            index=next(index);
        }
    }

    public int next(int index){
        return index+(index&-index);
    }
    
    public int parent(int index){
        return index-(index&-index);
    }
}
