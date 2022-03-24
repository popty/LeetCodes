class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int i = 0, j = people.length-1;
        int count = people.length;
        while(count > 0){
            if(i!=j && (people[i] + people[j] <= limit)){
                i++;
                j--;
                count-=2;
                boats++;
            }else if(people[j] <= limit){
                j--;
                boats++;
                count-=1;
            }else if(people[i] > limit) return -1;
        }
        
        return boats;
    }
}