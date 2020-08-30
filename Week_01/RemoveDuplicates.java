/**
 * @description: 删除排序数组中的重复项
 * @author: yangshumin
 * @create: 2020-08-29 23:49
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != cur) {
                // 当前元素不等于已存在元素，赋值给 cur，同时指针后移
                cur = nums[i];
                if (i > len) {
                    nums[len] = nums[i];
                }
                len += 1;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}