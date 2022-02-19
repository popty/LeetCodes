class Solution {
    public void duplicateZeros(int[] arr) {
        int  count = 0;
        int n = arr.length;
        int i = 0;
        for(i = 0; i+count<arr.length; i++)
            if(arr[i] == 0) count++;
        
        for(i = i-1; count>0; i--){
            if(i+count < n)arr[i+count] = arr[i];
            if(arr[i] == 0) arr[i+--count] = arr[i];
        }
        
    }
}