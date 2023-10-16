// Find Peak Element

// A peak element is an element that is strictly greater than its neighbors.
// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
// You must write an algorithm that runs in O(log n) time.

// My code : Binary Search
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        if(nums.length == 2){
            if(nums[0] > nums[1]){
                return 0;
            }else{
                return 1;
            }
        }
        return binarySearch(0, nums.length - 1, nums);
    }

    public int binarySearch(int l, int r, int[] nums){
        int mid = (l+r) / 2;
        if(l>r || mid+1 > nums.length-1){
            if(nums[mid] > nums[nums.length-1]){
                return mid;
            }else{
                return nums.length-1;
            }
            
        }

        if(mid - 1 < 0){
            if(nums[0] > nums[1]){
                return 0;
            }else{
                return 1;
            }
        }

        if(nums[mid] < nums[mid - 1]){
            return binarySearch(l, mid-1, nums);
        }else if (nums[mid] < nums[mid + 1]){
            return binarySearch(mid+1, r, nums);
        }else{
            return mid;
        }
    }
}