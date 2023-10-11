// Basic Calculator II

// Given a string s which represents an expression, evaluate this expression and return its value. 
// The integer division should truncate toward zero.
// You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

class Solution {
    public int calculate(String s) {

        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        int sign = '+';
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9){
                num = num * 10 + s.charAt(i) - '0';
            }
            if(s.charAt(i) != ' ' && !Character.isDigit(s.charAt(i)) || i == s.length() - 1){
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int ans = 0;
        while(!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }
}