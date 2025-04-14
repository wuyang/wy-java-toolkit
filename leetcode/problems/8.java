class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int result = 0;
        int i = 0;
        int len = s.length();
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }
        if (i < len && s.charAt(i) == '+') {
            i++;
        } else if (i < len && s.charAt(i) == '-') {
            i++;
            sign = -1;
        }
        for (; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = c - '0';
                // Use long will be easier. If not allowed, check the
                // range before multiplication.
                // signed 32-bit integer range is [-2^31, 2^31 - 1]
                // Integer.MAX_VALUE = 2,147,483,647
                // Integer.MIN_VALUE = -2,147,483,648
                int full_result = sign * result;
                if (full_result > Integer.MAX_VALUE / 10 ||
                        full_result == Integer.MAX_VALUE / 10 &&
                                digit >= 7) {
                    return Integer.MAX_VALUE;
                } else if (full_result < Integer.MIN_VALUE / 10 ||
                        full_result == Integer.MIN_VALUE /
                                10 &&
                                digit >= 8) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + digit;
            } else {
                break;
            }
        }
        return sign * result;

    }
}
