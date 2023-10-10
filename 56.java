// Merge Intervals

// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// sort + two pointer nlogn + n
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        for( int i = 1; i < intervals.length; i++){
            if (intervals[i][0] <= end){
                end = Math.max(intervals[i][1], end);
            }else{
                result.add(new int[] {start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[] {start,end});


        return result.toArray(new int[result.size()][]);
    }
}