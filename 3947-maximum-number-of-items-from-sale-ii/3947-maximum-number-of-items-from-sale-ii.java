import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] freq = new int[n + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        int[] total = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                total[i] += freq[j];
            }
        }

        int[] gain = new int[n];

        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int factor = items[i][0];

            gain[i] = total[factor] - 1;

            minPrice = Math.min(minPrice, items[i][1]);
        }

       
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) ->
            Integer.compare(items[a][1], items[b][1])
        );


        long remaining = budget;
        long ans = 0;

        for (int idx : indices) {
            long price = items[idx][1];

            
            if (price >= 2L * minPrice) {
                break;
            }

            long count = Math.min(
                (long) gain[idx],
                remaining / price
            );

            ans += count * 2;
            remaining -= count * price;
        }

        ans += remaining / minPrice;

        return (int) ans;
    }
}