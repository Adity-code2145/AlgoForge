class Solution {
    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        dfs(s, 0, left, right, 0, new StringBuilder());

        return new ArrayList<>(set);
    }

    void dfs(String s, int index, int leftRemove,
             int rightRemove, int balance, StringBuilder curr) {

        if (index == s.length()) {
            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                set.add(curr.toString());
            }
            return;
        }

        char ch = s.charAt(index);
        if (ch == '(' && leftRemove > 0) {
            dfs(s, index + 1, leftRemove - 1,
                rightRemove, balance, curr);
        }
        if (ch == ')' && rightRemove > 0) {
            dfs(s, index + 1, leftRemove,
                rightRemove - 1, balance, curr);
        }
        curr.append(ch);

        if (ch != '(' && ch != ')') {
            dfs(s, index + 1, leftRemove,
                rightRemove, balance, curr);
        }
        else if (ch == '(') {
            dfs(s, index + 1, leftRemove,
                rightRemove, balance + 1, curr);
        }
        else if (ch == ')' && balance > 0) {
            dfs(s, index + 1, leftRemove,
                rightRemove, balance - 1, curr);
        }

        curr.deleteCharAt(curr.length() - 1);
    }
}