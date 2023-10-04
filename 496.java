// 单调栈+哈希表

// The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
// You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
// Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = nums2.length - 1; i >= 0; i--){
            int num = nums2[i];
            while( !stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(num, -1);
            }else{
                map.put(num, stack.peek());
            }
            stack.push(num);
        }

        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }

        return res;


    }
}