class Solution {
    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return getGCD(max, min);
    }

    public int getGCD(int a, int b){
        for(int i = Math.min(a, b); i > 1; i--){
            if (a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 1;
    }
    
    // the best way to find GCD
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}