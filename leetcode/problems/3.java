class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIndexMap = new HashMap<>();  // value -> last see index
        int maxLength = 0, left = -1; // left is the index of the elment before the substring (exclusive)
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charIndexMap.containsKey(currentChar)) {
                left = Math.max(charIndexMap.get(currentChar), left);
            }
            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
