// Minimum Size Subarray Sum

// Given an array of positive integers nums and a positive integer target, return the minimal length of a 
// subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

// My code: use slide window to get length
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int head = 0;
        int tail = 0;
        int current = nums[0];
        int length = Integer.MAX_VALUE;
        while(head < nums.length && tail < nums.length){
            if(current < target){
                tail++;
                if(tail >= nums.length){
                    break;
                }
                current += nums[tail];
            }else if(current >= target){
                length = Math.min(tail - head + 1, length);
                current -= nums[head];
                head ++;
            }

            if(head > tail){
                tail++;
                if(tail >= nums.length){
                    break;
                }
                current += nums[tail];
            }
        }

        if(length == Integer.MAX_VALUE){
            return 0;
        }else{
            return length;
        }
    }
}