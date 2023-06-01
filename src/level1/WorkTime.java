//2023-05-31
//근무 시간

package level1;

import java.util.*;

public class WorkTime {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int answer = 0;

            for (int i = 0; i < 5; i++) {

                String start = sc.next();
                String end = sc.next();

                int workTime = toTime(end) - toTime(start);
                answer += workTime;
            }
            System.out.println(answer);
        }

        private static int toTime(String time) {
        String[] temp = time.split(":");
        return 60 * Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]);
    }
}
