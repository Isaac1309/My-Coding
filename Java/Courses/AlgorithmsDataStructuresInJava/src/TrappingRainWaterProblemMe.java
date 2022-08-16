public class TrappingRainWaterProblemMe {
    public int solve(int[] heights){
        if(heights.length < 3) return 0;

        int[] leftMax= new int[heights.length];
        int[] rightMax= new int[heights.length];

        for (int i=1;i<leftMax.length;++i){
            leftMax[i]=Math.max(leftMax[i-1],heights[i-1]);
        }

        rightMax[rightMax.length-1] = 0;
        for(int i=rightMax.length-2;i>=0;--i){
            rightMax[i]=Math.max(rightMax[i+1],heights[i+1]);
        }

        int returned=0;
        int mathMin;
        for (int i=1; i<rightMax.length-1;i++){
            mathMin = Math.min(leftMax[i], rightMax[i]);
            if (mathMin>heights[i])
                returned += mathMin-heights[i];
        }
        return returned;
    }
}
