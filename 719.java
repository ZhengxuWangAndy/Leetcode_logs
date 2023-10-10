// Find K-th Smallest Pair Distance
// The distance of a pair of integers a and b is defined as the absolute difference between a and b.
// Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.

// my first solution:
    // public int smallestDistancePair(int[] nums, int k) {
    //     PriorityQueue<Integer> list = new PriorityQueue<>(Comparator.reverseOrder());

    //     for (int i = 0; i < nums.length - 1; i++){
    //         for (int j = i+1; j < nums.length; j++){
    //             list.offer(Math.abs(nums[i]-nums[j]));
    //         }
    //     }

    //     while(list.size() > k){
    //         list.poll();
    //     }
    //     return list.poll();
    // }


// binary search

class Solution {
    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);
        int l = 0, r = (int)1e6;

        while(l<=r){
            int mid = (l + r) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++){
                int j = binarySearch(nums, i, nums[i] - mid);
                cnt += i - j;
            }
            if (cnt >= k){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }

    public int binarySearch(int[] nums, int end, int target){
        int left = 0, right = end;
        while (left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    
}