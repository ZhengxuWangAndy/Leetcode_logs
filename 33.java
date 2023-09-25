// Search in Rotated Sorted Array

// There is an integer array nums sorted in ascending order (with distinct values).
// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
// You must write an algorithm with O(log n) runtime complexity.




// When doing binary search, mid = (l+r) / 2, l = mid - 1
class Solution {
    public int search(int[] nums, int target) {
        
        int head = 0;
        int tail = nums.length - 1;

        int pointer = nums.length / 2;

        if (nums.length < 1){
            return -1;
        }

        if (nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }

        while(nums[pointer] != target){
            if (tail <= head){
                return -1;
            }

            // the target in the left ordered side
            if (nums[head] < nums[pointer] && nums[pointer] > target && target > nums[head]){
                tail = pointer - 1;
            }
            // the target in the right unordered side
            else if (nums[head] < nums[pointer] && (nums[pointer] < target || target < nums[head])){
                head = pointer + 1;
            }
            // the target in the right ordered side
            else if (nums[tail] > nums[pointer] && target < nums[tail] && target > nums[pointer]){
                head = pointer + 1;
            }
            // the target in the left unordered side
            else if (nums[tail] > nums[pointer] && (target < nums[pointer] || target > nums[tail])){
                tail = pointer - 1;
            }

            pointer = (head + tail) / 2;


        }

        return pointer;



        // int n = nums.length;
        // if (n == 0) {
        //     return -1;
        // }
        // if (n == 1) {
        //     return nums[0] == target ? 0 : -1;
        // }
        // int l = 0, r = n - 1;
        // while (l <= r) {
        //     int mid = (l + r) / 2;
        //     if (nums[mid] == target) {
        //         return mid;
        //     }
        //     if (nums[0] <= nums[mid]) {
        //         if (nums[0] <= target && target < nums[mid]) {
        //             r = mid - 1;
        //         } else {
        //             l = mid + 1;
        //         }
        //     } else {
        //         if (nums[mid] < target && target <= nums[n - 1]) {
        //             l = mid + 1;
        //         } else {
        //             r = mid - 1;
        //         }
        //     }
        // }
        // return -1;


    }
}