//200 岛的数量
public class NumberofIslands {
    //dfs算法
    /*public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res ++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i ,j + 1);
    }*/

    //union-find算法

}
