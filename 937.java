// You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

// There are two types of logs:

// Letter-logs: All words (except the identifier) consist of lowercase English letters.
// Digit-logs: All words (except the identifier) consist of digits.
// Reorder these logs so that:

// The letter-logs come before all digit-logs.
// The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
// The digit-logs maintain their relative ordering.
// Return the final order of the logs.

// Example 1:

// Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
// Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
// Explanation:
// The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
// The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".

// Example 2:

// Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
// Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]




// A great example for customize PirorityQueue or sort
// Remember the differences between String[] and ArrayList

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> digits = new ArrayList<>();
        // ArrayList<String> letters = new ArrayList<>();

        PriorityQueue<String> letters = new PriorityQueue<>((a,b) -> {
            String[] splitA = a.split(" ", 2);  // split once
            String[] splitB = b.split(" ", 2);
            int cmp = splitA[1].compareTo(splitB[1]);   // The result cmp will be negative if a comes before b, positive if a comes after b, and zero if they are equal based on content.
            if (cmp == 0){
                return splitA[0].compareTo(splitB[0]);  // equals 0 means same content, then compare the identifier.
            }
            return cmp;
        });

        for(int i = 0; i < logs.length; i++){
            String[] tmp = logs[i].split(" ");
            if (tmp[1].charAt(0) - '0' < 10){
                digits.add(logs[i]);
            }
            else{
                letters.offer(logs[i]);
            }
        }

        ArrayList<String> result = new ArrayList<>();
        while(!letters.isEmpty()){
            result.add(letters.poll());
        }
        result.addAll(digits);
        return result.toArray(new String[0]);


    }
}



// Customize sort solution:

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int length = logs.length;
        Pair[] arr = new Pair[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Pair(logs[i], i);
        }
        Arrays.sort(arr, (a, b) -> logCompare(a, b));
        String[] reordered = new String[length];
        for (int i = 0; i < length; i++) {
            reordered[i] = arr[i].log;
        }
        return reordered;
    }

    public int logCompare(Pair pair1, Pair pair2) {
        String log1 = pair1.log, log2 = pair2.log;
        int index1 = pair1.index, index2 = pair2.index;
        String[] split1 = log1.split(" ", 2);
        String[] split2 = log2.split(" ", 2);
        boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
        boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
        if (isDigit1 && isDigit2) {
            return index1 - index2;
        }
        if (!isDigit1 && !isDigit2) {
            int sc = split1[1].compareTo(split2[1]);
            if (sc != 0) {
                return sc;
            }
            return split1[0].compareTo(split2[0]);
        }
        return isDigit1 ? 1 : -1;
    }
}

class Pair {
    String log;
    int index;

    public Pair(String log, int index) {
        this.log = log;
        this.index = index;
    }
}