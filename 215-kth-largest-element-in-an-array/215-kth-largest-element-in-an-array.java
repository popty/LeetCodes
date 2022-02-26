class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        
        for(int num: nums){
            pq.offer(num);
        }
        
        int res = Integer.MAX_VALUE;
        
        while(!pq.isEmpty() && k-- > 0){
            res = pq.poll();
        }
        
        return res;
    }
}