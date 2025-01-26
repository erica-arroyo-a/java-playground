import java.util.PriorityQueue;

/**
 * Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map,
 * return the volume of water it can trap after raining.
 *
 * Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * Output: 4
 * Explanation: After the rain, water is trapped between the blocks.
 * We have two small ponds 1 and 3 units trapped.
 * The total volume of water trapped is 4.
 *
 * Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * Output: 10
 */
public class TrappingRainWater {

    /**
     * BFS with priority queue
     * @param height
     * @return the volume of water it can trap after raining
     */
    public int trapRainWater(int[][] height) {
        int n = height.length;
        int m = height[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] vis = new boolean[n][m];

        // Add first and last column
        for (int i = 0; i < n; i++) {
            vis[i][0] = true;
            vis[i][m - 1] = true;
            pq.offer(new int[]{height[i][0], i, 0});
            pq.offer(new int[]{height[i][m - 1], i, m - 1});
        }

        // Add first and last row
        for (int i = 0; i < m; i++) {
            vis[0][i] = true;
            vis[n - 1][i] = true;
            pq.offer(new int[]{height[0][i], 0, i});
            pq.offer(new int[]{height[n - 1][i], n - 1, i});
        }

        int ans = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int h = curr[0], r = curr[1], c = curr[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {
                    ans += Math.max(0, h - height[nr][nc]);
                    pq.offer(new int[]{Math.max(h, height[nr][nc]), nr, nc});
                    vis[nr][nc] = true;
                }
            }
        }

        return ans;
    }
}
