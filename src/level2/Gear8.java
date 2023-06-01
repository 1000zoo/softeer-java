//2023-06-01
//8단 기어;

package level2;

import java.io.*;
import java.util.*;

public class Gear8 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] gear = new int[8];
        for (int i = 0; i < 8; i++) {
            gear[i] = Integer.parseInt(st.nextToken());
        }

        int d = gear[0] == 1 ? 1 : -1;
        String ans = gear[0] == 1 ? "ascending" : "descending";

        for (int i = 1; i < gear.length; i++) {
            if (gear[i] - gear[i - 1] != d) {
                System.out.println("mixed");
                return;
            }
        }
        System.out.println(ans);
    }
}
