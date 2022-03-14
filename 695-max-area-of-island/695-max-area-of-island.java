class Solution {
    
    int[][] grid;
    int m, n;
    boolean[][] visited;
    int[][] dirs = {{1, 0}, {0,1}, {-1,0}, {0, -1}};
    
    private boolean isValid(int i, int j){
        if(i >= 0 && i < m && j >= 0 && j < n && 
           !visited[i][j] && grid[i][j] == 1) return true;
        
        return false;
    }
    
    private int calculateArea(int i, int j, int area){
        
        visited[i][j] = true;
        
        area+=1;
        
        for(int[] dir: dirs){
            int newRow = i+dir[0];
            int newCol = j+dir[1];
            if(isValid(newRow, newCol)){
               area = Math.max(area, calculateArea(newRow, newCol, area));
            }
        }
        
        return area;
        
        
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(isValid(i, j)){
                    int area = calculateArea(i,j,0);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        
        return maxArea;
        
    }
}