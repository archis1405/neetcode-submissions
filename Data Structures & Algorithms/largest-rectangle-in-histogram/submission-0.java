class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] nextSmaller = findNextSmaller(heights);
        int[] prevSmaller = findPrevSmaller(heights);

        int maxArea = Integer.MIN_VALUE;

        for(int i=0 ; i<n ; i++){
            int w = nextSmaller[i] - prevSmaller[i] - 1;
            int area = (w*heights[i]);

            maxArea = Math.max(maxArea , area);
        }

        return maxArea;
    }

    public int[] findNextSmaller(int[] nums){
        int n = nums.length;

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i=n-1 ; i>=0 ; i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }

            ans[i] = (st.isEmpty()==true) ? n : st.peek();

            st.push(i);
        }

        return ans;
    }


    public int[] findPrevSmaller(int[] nums){
        int n = nums.length;

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i=0 ; i<n ; i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }

            ans[i] = (st.isEmpty()==true) ? -1 : st.peek();

            st.push(i);
        }

        return ans;
    }
}
