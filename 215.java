// Kth largest element in an array

// Given an integer array nums and an integer k, return the kth largest element in the array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
// Can you solve it without sorting?

// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4


// my code: using heap to keep kth largest queue
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> kNums = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++){
            kNums.offer(nums[i]);
            while(kNums.size() > k){
                kNums.poll();
            }
        }

        return kNums.poll();
        
    }
}


// using quick sort to search.
class Solution {
    int quickSelect(int[] nums, int l, int r, int k){
        // window size is one means it is the kth largest number
        if(l==r){
            return nums[k];
        }

        int x = nums[l];
        int i = l - 1;
        int j = r + 1;
        while( i < j){
            do i++; while (nums[i] > x);    // find wrong place element
            do j--; while (nums[j] < x);
            if (i < j){                     // swap if it is in wrong side
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
        if (k <= j){    // target in left side
            return quickSelect(nums, l, j, k);
        } else{         // target in right side
            return quickSelect(nums, j+1, r, k);
        }

    }
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n-1, k-1);
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = s.findKthLargest(nums, k);

        System.out.println("第 " + k + " 大的元素是: " + result);
//        System.out.println("Hello world!");
    }
}