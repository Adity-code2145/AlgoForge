import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) available.add(i);

        // {end_time, server_id}
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            int start = arrival[i];

            // jo servers free ho gaye unhe wapas available mein daalo
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.add(busy.poll()[1]);
            }

            if (available.isEmpty()) continue; // request dropped

            // i % k ya usse bada pehla free server, nahi mila to sabse chhota
            Integer idx = available.ceiling(i % k);
            if (idx == null) idx = available.first();

            available.remove(idx);
            count[idx]++;
            busy.offer(new int[]{start + load[i], idx});
        }

        int max = 0;
        for (int c : count) max = Math.max(max, c);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) res.add(i);
        }
        return res;
    }
}