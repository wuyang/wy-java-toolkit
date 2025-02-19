class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int compliment = target - nums[i];
            if (m.containsKey(compliment)) return new int[]{m.get(compliment), i};
            m.put(nums[i], i);
        }
        return new int[]{};
    }
}
