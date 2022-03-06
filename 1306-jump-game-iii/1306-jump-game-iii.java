class Solution {
    HashSet<Integer> set = new HashSet<>();
    
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length || set.contains(start)) return false;
        
        set.add(start);
        
        return (arr[start] == 0 || canReach(arr, start+arr[start]) || canReach(arr, start-arr[start]));
        
        
    }
}