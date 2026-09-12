class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int water = Integer.MIN_VALUE;
        int height = 0;
        int diff = 0;

        while(left<=right){
            diff = right - left;
            height = Math.min(heights[left] , heights[right]);

            int curr = diff*height;

            water = Math.max(water,curr);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return water;
    }
}
