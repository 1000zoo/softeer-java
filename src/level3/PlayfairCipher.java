package level3;

import java.util.*;
import java.io.*;

public class PlayfairCipher {

    public static Map<Character, int[]> map;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        String message = st.nextToken();
        st = new StringTokenizer(in.readLine());
        String key = st.nextToken();
        map = new HashMap<>();
        char[][] code = getCode(key);
        String[] divided = divide(message);
        StringBuilder sb = new StringBuilder();

        for (String di : divided) {
            char s = di.charAt(0);
            char e = di.charAt(1);
            int[] sc = map.get(s);
            int[] ec = map.get(e);

            if (sc[0] == ec[0]) {
                s = code[sc[0]][(sc[1] + 1) % 5];
                e = code[ec[0]][(ec[1] + 1) % 5];
            } else if (sc[1] == ec[1]) {
                s = code[(sc[0] + 1) % 5][sc[1]];
                e = code[(ec[0] + 1) % 5][ec[1]];
            } else {
                s = code[sc[0]][ec[1]];
                e = code[ec[0]][sc[1]];
            }
            sb.append("" + s + e);
        }
        System.out.println(sb.toString());
    }


    private static String[] divide(String message) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (i == message.length() - 1) {
                sb.append("" + message.charAt(i) + 'X');
                break;
            }
            char s = message.charAt(i);
            char e = message.charAt(i + 1);

            if (s == e) {
                char toChange = s != 'X' ? 'X' : 'Q';
                sb.append("" + s + toChange);
            } else {
                sb.append("" + s + e);
                i++;
            }
            sb.append("/");
        }
        return sb.toString().split("/");
    }

    private static char[][] getCode(String key) {
        char[][] res = new char[5][5];
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        for (char c = 'A'; c <= 'Z'; c++) set.add(c);
        set.remove('J');

        for (char k : key.toCharArray()) {
            if (set.contains(k)) {
                map.put(k, new int[]{i, j});
                res[i][j++] = k;
                set.remove(k);
                if (j == 5) {
                    if (i == 5) break;
                    j = 0;
                    i++;
                }
            }
        }

        if (!set.isEmpty()) {
            for (char k : set) {
                map.put(k, new int[]{i, j});
                res[i][j++] = k;
                if (j == 5) {
                    j = 0;
                    i++;
                }
            }
        }
        return res;
    }
}
