public class Sqrt69 {
    /* public static int mySqrt(int x){
        int ans = 1;
        for(int i=1; i<=x; i++){
            if(i*i <= x){
                ans = i;
            }else{
                break;
            }
        }

        return ans;
    } */

    public static int mySqrt(int x){
        if(x < 2) return x;
        long low = 1;
        long high = x;
        long ans = x;

        while(low <= high){
            long mid = (low+high)/2;
            if(mid*mid <= x){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return (int)ans;
    }
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }
}