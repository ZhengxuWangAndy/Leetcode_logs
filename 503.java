// 503 Next Greater Element 2

// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

// Example 1:
// Input: nums = [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number. 
// The second 1's next greater number needs to search circularly, which is also 2.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }
}

// my code: final get monotone stack
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i = 0; i < 2*n; i++){
            while(!stack.isEmpty() && nums[i%n] > nums[stack.peek()]){
                result[stack.peek()] = nums[i%n];
                stack.pop();
                // System.out.println(i);
            }
            stack.push(i%n);  
        }
        
        return result;
    }
}