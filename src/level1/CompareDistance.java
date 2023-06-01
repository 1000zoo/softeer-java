//2023-05-31
//주행거리 비교

package level1;

import java.util.*;

public class CompareDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String answer = a > b ? "A" : a != b ? "B" : "same";
        System.out.println(answer);
    }
}
