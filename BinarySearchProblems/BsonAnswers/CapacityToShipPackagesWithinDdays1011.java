public class CapacityToShipPackagesWithinDdays1011 {
    /* public static int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int w : weights){
            max = Math.max(max, w);
            sum += w;
        }

        for(int cap=max; cap<=sum; cap++){
            int daysRequired = daysNeeded(weights, cap);
            if(daysRequired <= days){
                return cap;
            }
        }

        return max;
    } */
    private static int daysNeeded(int[] weights, int cap){
        int days = 1;
        int load = 0;
        for(int i=0; i<weights.length; i++){
            if(load + weights[i] > cap){
                days++;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        return days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int w : weights){
            max = Math.max(max, w);
            sum += w;
        }
        int low = max;
        int high = sum;

        while(low <= high){
            int mid = low + (high - low)/2;
            int daysRequired = daysNeeded(weights, mid);
            if(daysRequired <= days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] weights = {1,2,3,1,1};
        int days = 4;
        System.out.println(shipWithinDays(weights, days));
    }
}