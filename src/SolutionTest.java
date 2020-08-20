import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testFindCircleNumber() {

        List<TestCase> testCases = getTestCases();

        for (int i = 0; i < testCases.size(); i++) {

            System.out.printf("case %d\n", i);
            TestCase testCase = testCases.get(i);

            int actual = Solution.findCircleNum(testCase.pyq);

            assertEquals(testCase.expect, actual);
        }
    }

    private List<TestCase> getTestCases() {
        List<TestCase> testCases = new ArrayList<>();

        testCases.add(new TestCase(new int[][]
                {
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 1},
                }, 2));
        testCases.add(new TestCase(new int[][]
                {
                        {1, 1, 0},
                        {1, 1, 1},
                        {0, 1, 1},
                }, 1));
        testCases.add(new TestCase(new int[][]
                {
                        {1, 0, 1},
                        {0, 1, 0},
                        {1, 0, 1},
                }, 2));

        return testCases;
    }
}
