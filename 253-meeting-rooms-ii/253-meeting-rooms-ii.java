class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals.length == 0) return 0;
        
        int rooms = 0;
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            intervals.length,
            new Comparator<Integer>() {
              public int compare(Integer a, Integer b) {
                return a - b;
              }
            });
        
        
        
        for(int[] i: intervals){
            if(pq.isEmpty()){
                pq.offer(i[1]);
            }else{
               
                if(i[0] >= pq.peek()){
                    pq.poll();
                }
                pq.offer(i[1]);
            }
            
        }
        
       
        return pq.size();
    }
}