class Solution {

    public List<String> braceExpansionII(String expression) {
        Set<String> result = dfs(expression, 0, expression.length() - 1);

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    private Set<String> dfs(String s, int l, int r) {

        Set<String> result = new HashSet<>();

        // Current expression ko parts mein split karenge
        List<Set<String>> parts = new ArrayList<>();

        int i = l;

        while (i <= r) {

            // Agar opening brace hai
            if (s.charAt(i) == '{') {

                int count = 1;
                int j = i + 1;

                // Matching '}'
                while (count > 0) {
                    if (s.charAt(j) == '{') {
                        count++;
                    } else if (s.charAt(j) == '}') {
                        count--;
                    }
                    j++;
                }

                // Inside braces: i+1 to j-2
                String inside = s.substring(i + 1, j - 1);

                // Comma se split at top level
                List<String> expressions = split(inside);

                Set<String> union = new HashSet<>();

                for (String exp : expressions) {
                    union.addAll(dfs(exp, 0, exp.length() - 1));
                }

                parts.add(union);

                i = j;

            } else if (s.charAt(i) == ',') {

                // Comma should be handled by split()
                i++;

            } else {

                // Consecutive letters ko ek word/part bana do
                int j = i;

                while (j <= r && Character.isLetter(s.charAt(j))) {
                    j++;
                }

                Set<String> single = new HashSet<>();
                single.add(s.substring(i, j));

                parts.add(single);

                i = j;
            }
        }

        // Concatenate all parts
        result.add("");

        for (Set<String> part : parts) {

            Set<String> next = new HashSet<>();

            for (String a : result) {
                for (String b : part) {
                    next.add(a + b);
                }
            }

            result = next;
        }

        return result;
    }

    // Split expression by top-level commas
    private List<String> split(String s) {

        List<String> list = new ArrayList<>();

        int start = 0;
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '{') {
                balance++;
            } else if (c == '}') {
                balance--;
            } else if (c == ',' && balance == 0) {

                list.add(s.substring(start, i));
                start = i + 1;
            }
        }

        list.add(s.substring(start));

        return list;
    }
}