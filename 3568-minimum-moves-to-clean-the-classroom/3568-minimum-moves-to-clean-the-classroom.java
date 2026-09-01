import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        
        int[][] litterId = new int[m][n];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int startR = 0;
        int startC = 0;
        int litterCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                }

                if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        
        if (litterCount == 0) {
            return 0;
        }

        
        int fullMask = (1 << litterCount) - 1;

       
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << litterCount];

       
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{
                startR,
                startC,
                energy,
                fullMask
        });

        visited[startR][startC][energy][fullMask] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            
            for (int i = 0; i < size; i++) {

                int[] state = queue.poll();

                int r = state[0];
                int c = state[1];
                int currEnergy = state[2];
                int mask = state[3];

                // All litter collected
                if (mask == 0) {
                    return moves;
                }

                
                if (currEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                 
                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    char cell = classroom[nr].charAt(nc);

                   
                    int newEnergy = currEnergy - 1;

                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    int newMask = mask;

                  
                    if (cell == 'L') {

                        int id = litterId[nr][nc];

                        newMask = newMask & ~(1 << id);
                    }

                    if (!visited[nr][nc][newEnergy][newMask]) {

                        visited[nr][nc][newEnergy][newMask] = true;

                        queue.offer(new int[]{
                                nr,
                                nc,
                                newEnergy,
                                newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}