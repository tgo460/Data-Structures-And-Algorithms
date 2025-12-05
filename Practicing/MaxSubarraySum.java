public class MaxSubarraySum {

    /**
     * Finds the maximum sum of a contiguous subarray using Kadane's Algorithm.
     * * Time Complexity: O(n) - We pass through the array once.
     * Space Complexity: O(1) - We only use two variables for tracking sums.
     */
    public static int maxSubArray(int[] nums) {
        // Edge case: Handle empty array or null input
        if (nums == null || nums.length == 0) {
            return 0; 
            // In an interview, ask if you should throw an exception instead
            // throw new IllegalArgumentException("Array cannot be empty");
        }

        // Initialize variables based on the first element.
        // using nums[0] instead of 0 handles arrays with all negative numbers correctly.
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // Core Logic:
            // Do we start a new subarray at 'num', or extend the existing one?
            // If (currentSum + num) < num, it means the history is weighing us down, so we restart.
            currentSum = Math.max(num, currentSum + num);

            // Update the global maximum found so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    /**
     * Finds the maximum sum using the Prefix Sum approach.
     * Logic: Max Subarray = Current Prefix Sum - Minimum Prefix Sum seen previously.
     */
    public static int maxSubArrayPrefixSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxSum = Integer.MIN_VALUE;
        int currentPrefixSum = 0;
        
        // The prefix sum before the array starts is effectively 0
        int minPrefixSum = 0; 

        for (int num : nums) {
            currentPrefixSum += num;

            // The max subarray ending at the current position is the 
            // current cumulative sum minus the smallest cumulative sum seen before it.
            maxSum = Math.max(maxSum, currentPrefixSum - minPrefixSum);

            // Update the minimum prefix sum encountered so far
            minPrefixSum = Math.min(minPrefixSum, currentPrefixSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Test Case 1: The classic example
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test Case 1 (Kadane): " + maxSubArray(nums1)); 
        System.out.println("Test Case 1 (Prefix): " + maxSubArrayPrefixSum(nums1));
        
        System.out.println("-----------------");

        // Test Case 2: All negative numbers
        int[] nums2 = {-10, -2, -5, -1};
        System.out.println("Test Case 2 (Kadane): " + maxSubArray(nums2));
        System.out.println("Test Case 2 (Prefix): " + maxSubArrayPrefixSum(nums2));
        
        System.out.println("-----------------");

        // Test Case 3: Single element
        int[] nums3 = {5};
        System.out.println("Test Case 3 (Kadane): " + maxSubArray(nums3));
        System.out.println("Test Case 3 (Prefix): " + maxSubArrayPrefixSum(nums3));
    }
}