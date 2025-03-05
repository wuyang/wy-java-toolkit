class Solution {
    public String longestPalindrome(String s) {
        int start = 0; // start index of the longest palindrome so far
        int length = 0; // length of the longest palindrome so far
        for (int i = 0; i < s.length(); i++) {
            // expand odd palindrome like aba from center i
            int oddLength = expandFromCenter(s, i, i);
            // expand even palindrome like abba from center i and i+1
            int evenLength = expandFromCenter(s, i, i + 1);
            int maxLength = Math.max(oddLength, evenLength);
            if (maxLength > length) {
                length = maxLength;
                start = i - (maxLength - 1) / 2;
            }
        }
        return s.substring(start, start + length);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // [left + 1, right - 1] is the longest palindrome
        return right - 1 - (left + 1) + 1;
    }
}
