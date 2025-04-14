class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() < numRows)
            return s;
        /*
         * 0 1 2
         * - - -
         * row 0|
         * 1|
         * 2|
         */
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        int row = 0, step = 1; // +1 is up, and -1 is down
        for (char c : s.toCharArray()) {
            rows[row].append(c);
            if (row + step >= numRows || row + step < 0) {
                step *= -1;
            }
            row += step;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder r : rows) {
            result.append(r.toString());
        }
        return result.toString();

    }
}
