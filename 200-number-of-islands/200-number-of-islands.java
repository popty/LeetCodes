class Solution {
    char[][] grid;
    boolean[][] visited;
    int m, n;
    int[][] dir ={{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int numIslands = 0;
    
    public boolean isValid(int i, int j){
        if(i>-1 && j>-1 && i<m && j<n && grid[i][j] != '0' && visited[i][j] == false)return true;
        
        return false;
    }
    
    public void helper(int i, int j){
        visited[i][j] = true;
        
        if(grid[i][j] == '1'){
            for(int[] d: dir){
                if(isValid(i+d[0], j+d[1]))
                    helper(i+d[0], j+d[1]);
            }
        }
        
        return;
    }
    
    public int numIslands(char[][] grid) {
        
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        
        this.visited = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(isValid(i, j)){
                    helper(i, j);
                    this.numIslands+=1;
                }
            }
           
        }
        
        return this.numIslands;
        
    }
}