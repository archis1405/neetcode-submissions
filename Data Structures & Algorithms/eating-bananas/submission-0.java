class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for(int i=0 ; i<piles.length ; i++){
            high = Math.max(piles[i] , high);
        }

        int ans = 0;

        while(low<=high){
            int mid = low + (high - low) / 2;

            int hours = calculate(piles , mid);

            if(hours<=h){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }

    public int calculate(int[] piles, int speed){
        int hours = 0;

        for(int i=0 ; i<piles.length ; i++){
            hours = hours +(int) Math.ceil((double)piles[i] / (double)speed);
        }

        return hours;
    }
}
