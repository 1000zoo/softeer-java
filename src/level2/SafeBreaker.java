//2023-06-01
//금고털이

package level2;

import java.io.*;
import java.util.*;

public class SafeBreaker {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int answer = 0;
        int weight = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<int[]> inputs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            inputs.add(new int[] {m, p});
        }

        inputs.sort((o1, o2) -> o2[1] - o1[1]);

        for (int[] k : inputs) {
            int cw = k[0];
            int cp = k[1];

            if (weight > cw) {
                weight -= cw;
                answer += cw * cp;
            } else {
                answer += weight * cp;
                break;
            }
        }
        System.out.println(answer);
    }
}
