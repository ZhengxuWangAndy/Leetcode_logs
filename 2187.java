// Minimum time to complete trips
// You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.
// Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the trips of any other bus.
// You are also given an integer totalTrips, which denotes the number of trips all buses should make in total. Return the minimum time required for all buses to complete at least totalTrips trips.


// good example of binary search
// search based on time
class Solution {
    public boolean check(int[] time, long t, int totalTrips){
        long trips = 0;
        for(int i = 0; i < time.length; i++){
            trips += t / time[i];
        }
        return trips >= totalTrips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        // int trips = 0;
        
        int minTime = time[0];
        for(int i = 0; i < time.length; i++){
            if(minTime > time[i]){
                minTime = time[i];
            }
        }
        long l = minTime;
        long r = 1L * minTime * totalTrips;
        System.out.println(r);

        while(l<r){
            long mid = (r+l)/2;
            if(check(time, mid, totalTrips)){
                r = mid;
                System.out.println(r);
            }else{
                l = mid + 1;
            }
        }


        return l;
    }
}