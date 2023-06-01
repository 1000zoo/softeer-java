//2023-05-31;
//A + B

package level1;

import java.util.*;

public class APlusB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int end = sc.nextInt();
        for (int i = 1; i <= end; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.printf("Case #%d: %d\n", i, a + b);
        }
    }
}
