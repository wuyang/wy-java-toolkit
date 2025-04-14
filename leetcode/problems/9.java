class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int t = x; // temp variable to keep x unchanged
        long r = 0; // reversed x
        while (t > 0) {
            r = r * 10 + t % 10;
            t /= 10;
        }
        return x == r;
    }
}
