//2023-06-03
//장애물 인식 프로그램

package level2;

import java.util.*;
import java.io.*;

public class ObstacleAwarenessProgram {

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            String line = st.nextToken();

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt("" + line.charAt(j));
            }
        }
        solution();
    }

    private static void solution() {
        int blockCount = 0;
        List<Integer> areas = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (canGo(new int[]{i, j})) {
                    q.offer(new int[] {i, j});
                    blockCount++;
                    int area = 0;

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        visited[curr[0]][curr[1]] = true;
                        area++;
                        for (int[] dir : directions) {
                            int[] next = new int[] {curr[0] + dir[0], curr[1] + dir[1]};
                            if (!isWithinBoundary(next[0], next[1])) continue;
                            if (canGo(next)) {
                                q.offer(next);
                                visited[next[0]][next[1]] = true;
                            }
                        }
                    }
                    areas.add(area);
                }
            }
        }
        System.out.println(blockCount);
        Collections.sort(areas);
        for (int ans : areas) {
            System.out.println(ans);
        }
    }

    private static boolean canGo(int[] coor) {
        return map[coor[0]][coor[1]] == 1 && !visited[coor[0]][coor[1]];
    }
    private static boolean isWithinBoundary(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}
