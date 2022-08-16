import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Result= "+new IntegerReversion().reverse(1234));

        int[] array={1,5,9,3,5,0};
        DutchFlagProblemCourseSolution dutchFlagProblem = new DutchFlagProblemCourseSolution(array);
        dutchFlagProblem.showResult();
        dutchFlagProblem.solve();
        dutchFlagProblem.showResult();

        int[] arr={1,0,2,1,3,1,2,0,3};
        TrappingRainWaterProblem tapping = new TrappingRainWaterProblem();
        System.out.println(tapping.solve(arr));

    }
}
