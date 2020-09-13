
public class Combine {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }

    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ret = new ArrayList<>();
            if (k <= 0 || n < k) {
                return ret;
            }

            List<Integer> path = new ArrayList<>();

            dfs(n, k, 1, path, ret);
            return ret;
        }

        private void dfs(int n, int k, int begin, List<Integer> path, List<List<Integer>> res) {

            // terminator
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }

            // 剪枝
            if (path.size() + (n - begin + 1) < k) {
                return;
            }

            // process && drill down
            for (int i = begin; i <= n; i++) {
                path.add(i);
                dfs(n, k, i + 1, path, res);

                // revert
                path.remove(path.size() - 1);
            }
        }
    }
}