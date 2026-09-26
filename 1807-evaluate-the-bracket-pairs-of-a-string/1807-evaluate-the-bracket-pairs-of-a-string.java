class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        // Store key-value pairs
        HashMap<String, String> map = new HashMap<>();

        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == '(') {

                // Find closing bracket
                int j = i + 1;

                while (s.charAt(j) != ')') {
                    j++;
                }

                // Extract key
                String key = s.substring(i + 1, j);

                // Get value or '?'
                if (map.containsKey(key)) {
                    ans.append(map.get(key));
                } else {
                    ans.append('?');
                }

                // Move after ')'
                i = j + 1;

            } else {

                // Normal character
                ans.append(s.charAt(i));
                i++;
            }
        }

        return ans.toString();
    }
}