
// Logest Substring Without Repeating Characters

// Given a string s, find the length of the longest 
// substring without repeating characters.
// Example:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// My code: slide window iteratlly check maxlength, O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int head = 0;
        int tail = 0;
        while(head < s.length()){
            HashMap<Character, Integer> dict = new HashMap<>();
            int tmpLength = 0;
            for(tail = head; tail < s.length(); tail++){
                if (dict.containsKey(s.charAt(tail))){
                    // dict.get(s[tail]) += 1;
                    break;
                }else{
                    dict.put(s.charAt(tail), 0);
                    tmpLength += 1;
                }
            }
            maxLength = Math.max(tmpLength, maxLength);
            head++;
        }
        return maxLength;
    }
}


// Better way: slide the longest window to find is there any bigger one, O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int head = 0;
        int curLength = 0;
        Set<Character> check = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            curLength++;
            while(check.contains(s.charAt(i))){
                check.remove(s.charAt(head));
                head++;
                curLength--;
            }
            maxLength = Math.max(maxLength, curLength);
            check.add(s.charAt(i));
        }
        return maxLength;
    }
}

//Higher level:
public int lengthOfLongestSubstring04(String s) {
        // 单个字符作为key，字符在字符串中的下标作为value
        Map<Character, Integer> map = new HashMap<>();
        // 最大值
        int maxLen = 0;
        // 左边界
        int left = 0;
        // 这个循环的一些想法，之前老喜欢把字符串转字符数组，然后用数组去操作，其实直接遍历索引也是可以的
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            /**
             * 要理解下面的代码首先要想明白获得最长字串的逻辑
             * 这里一共存在两个变量：
             *  - left：表示字串最左边字符的索引位置
             *  - i：遍历的每个字符索引位置，我们全靠这个字符来完成这道题，i这个变量存在三种情况需要考虑
             *      1） s.charAt(i)在[left, i)之间不存在重复字符
             *          - 就把s.charAt(i)放到map中，最长长度同时也加一
             *      2） s.charAt(i)在[left, i)之间存在重复字符
             *          - 获得[left, i)范围内重复字符的下标h，让left = h + 1，此时新的字串开始匹配，新的长度变成了i - left + 1 = 1
             *          - 更新map中重复字符的索引位置为i
             *      3） s.charAt(i)在[0, left)之间存在重复字符
             *          - 我们在发现重复字符后都要更新该字符在map中的索引位置，就是为了避免之前的重复元素对当前判断造成影响
             *          - 但是譬如acbba这样一个字符：当遍历到第二个b时，可知h = map.get('b')，所以h=2，那么newLeft=h+1=3;
             *              之后遍历到字符a，h = map.get('a')，发现此时h=0，newLeft=h+1=1；这种情况明显不合理，所以要求left=Math.max(left, newLeft)
             *          - 更新map中重复字符的索引位置为i，最长长度同时也加一
             *
             */
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
}