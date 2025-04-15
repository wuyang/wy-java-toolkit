class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (right > left) {
            maxArea = Math.max(maxArea,
                    (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
