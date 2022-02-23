class Solution {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int m, n;
    int[][] heights;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        if(heights.length == 0 || heights[0].length == 0)
            return new ArrayList<>();
        
        this.m = heights.length;
        this.n = heights[0].length;
        this.heights = heights;
        
        
        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();
        
        for(int i = 0; i<m; i++){
            pacific.offer(new int[]{i, 0});
            atlantic.offer(new int[]{i,n-1 });
        }
        
        for(int i = 0; i<n; i++){
            pacific.offer(new int[]{0, i});
            atlantic.offer(new int[]{m-1, i});
        }
        
        boolean[][] pacificReachable = bfs(pacific);
        boolean[][] atlanticReachable = bfs(atlantic);
        
        List<List<Integer>> commonCells = new ArrayList<>();
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(pacificReachable[i][j] && atlanticReachable[i][j])
                    commonCells.add(List.of(i, j));
            }
        }
        
        return commonCells;
        
    }
    
    
    private boolean[][] bfs(Queue<int[]> ocean){
        boolean[][] reachable = new boolean[m][n];
        while(!ocean.isEmpty()){
            int[] cell = ocean.poll();
            reachable[cell[0]][cell[1]] = true;
            for(int[] d: dir){
                int newRow = cell[0]+d[0];
                int newCol = cell[1]+d[1];
                
                
                if(newRow <0 || newRow >= m || newCol < 0 || newCol>= n)
                    continue;
                
                if(reachable[newRow][newCol]) continue;
                
                if(heights[newRow][newCol] < heights[cell[0]][cell[1]]) continue;
                
                ocean.offer(new int[]{newRow, newCol});
                
            }
        }
        
        return reachable;
    }
}