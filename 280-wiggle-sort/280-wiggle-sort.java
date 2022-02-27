class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> pq_min = new PriorityQueue<>();
        PriorityQueue<Integer> pq_max = new PriorityQueue<>((n1, n2)->n2-n1);
        
        for(int num: nums){
            pq_min.offer(num);
            pq_max.offer(num);
        }
        
        int i = 0;
        while(i<nums.length){
            nums[i] = i%2==0 ? pq_min.poll() : pq_max.poll(); 
            i++;
        }
        
        return;
    }
}