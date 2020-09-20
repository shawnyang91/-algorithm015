public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        System.out.println(solution.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}));
    }

    class Solution {

        // 行数
        private int m;

        // 列数
        private int n;

        public int numIslands(char[][] grid) {
            int count = 0;
            m = grid.length;
            if (m == 0) {
                return count;
            }
            n = grid[0].length;

            System.out.println("m:" + m);
            System.out.println("n:" + n);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        // helper
                        helper(grid, i, j);
                        // 岛屿数+1
                        count++;
                    }
                }
            }
            return count;
        }

        // 把 i,j坐标的值更新成 0
        public void helper(char[][] grid, int i, int j) {
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            helper(grid, i + 1, j);
            helper(grid, i - 1, j);
            helper(grid, i, j + 1);
            helper(grid, i, j - 1);
        }
    }

}