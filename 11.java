// Container With Most Water

// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.



// My code: two pointer
class Solution {
    public int maxArea(int[] height) {
        int head = 0;
        int tail = height.length - 1;
        int result = 0;
        while(head <= tail){
            result = Math.max((tail - head) * Math.min(height[head], height[tail]), result);
            if(height[head] < height[tail]){
                head++;
            }else{
                tail--;
            }
        }

        return result;
    }
}