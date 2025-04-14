class Solution {
    public int reverse(int x) {
        // signed 32-bit integer range is [-2^31, 2^31 - 1]
        // Integer.MAX_VALUE = 2,147,483,647
        // Integer.MIN_VALUE = -2,147,483,648
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if ((result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > 7)) ||
                    (result < Integer.MIN_VALUE / 10 ||
                            (result == Integer.MIN_VALUE / 10 && digit < -8))) {
                return 0;
            }
            result = result * 10 + digit;
        }
        return result;
    }
}
