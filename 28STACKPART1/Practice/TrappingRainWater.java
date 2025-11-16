// Solution 4: Trapping Rain Water
import java.util.*;

public class TrappingRainWater {
    public static int maxWater(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int totalWater = 0;
        int n = height.length;

        for(int i = 0; i <n; i++) {
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int bottomIndex = stack.pop();

                if(stack.isEmpty()) {
                    break;
                }

                int leftIndex = stack.peek();
                int rightIndex = i;

                int width = rightIndex - leftIndex - 1;
                int waterHeight = Math.min(height[leftIndex], height[rightIndex]) - height[bottomIndex];

                totalWater += width * waterHeight;
            }
            stack.push(i);
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.print(maxWater(arr)); // output: 6
    }
}