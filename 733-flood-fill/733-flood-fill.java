class Solution {
    int[][] image;
    int m, n;
    int oldColor;
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    boolean [][] visited;
    private boolean isValid(int i, int j){
        if(i >= 0 && i<m && j >= 0 && j<n && !visited[i][j] && image[i][j] == oldColor)return true;
        
        return false;
    }
    
    private void dfs(int i, int j, int newColor){

        visited[i][j] = true;
        
        this.image[i][j] = newColor;
        
        for(int[] dir: dirs){
            int newRow = i+dir[0];
            int newCol = j+dir[1];
            if(isValid(newRow, newCol))dfs(newRow, newCol, newColor);
        }
        
        return;
    }
    
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        this.m = image.length;
        this.n = image[0].length;
        this.visited = new boolean[m][n];
        this.oldColor = image[sr][sc];
        dfs(sr, sc, newColor);
        return this.image;
    }
}