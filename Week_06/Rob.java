public class Rob{
    public int rob(int[] nums) {
        int prev = 0;
        int curr = 0;

        for (int i : nums) {
            int temp = Math.max(curr, prev + i);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}