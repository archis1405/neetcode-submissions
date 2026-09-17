class MedianFinder {
    PriorityQueue<Integer> leftMax;
    PriorityQueue<Integer> rightMin;
    public MedianFinder() {
        leftMax = new PriorityQueue<>(Collections.reverseOrder());
        rightMin = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftMax.isEmpty()){
            leftMax.add(num);
        }

        else if(num>leftMax.peek()){
            rightMin.add(num);
        }

        else{
            leftMax.add(num);
        }

        if(leftMax.size()-rightMin.size()>1){
            int temp = leftMax.poll();

            rightMin.add(temp);
        }
        else if(rightMin.size() - leftMax.size() > 1){
            int temp = rightMin.poll();

            leftMax.add(temp);
        }
    }
    
    public double findMedian() {
        if(leftMax.size()==rightMin.size()){
            int n1 = leftMax.peek();
            int n2 = rightMin.peek();

            double ans = (n1+n2) / 2.0;

            return ans;
        }

        else if (leftMax.size() - rightMin.size() == 1){
            double n1 = leftMax.peek();

            return n1;
        }

        else{
            double n2 = rightMin.peek();

            return n2;
        }
    }
}
