
/**
 * @description: 加一
 * @author: yangshumin
 * @create: 2020-08-29 23:53
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 新数组默认元素初始值为 0.
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{2, 8, 9})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9, 9, 9})));
    }
}
