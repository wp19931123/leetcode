package exam.grandgame;

import java.util.Scanner;

/**
 * 自动驾驶汽车起始位置position = 0，起始speed = 1，每次按照一种指令前进
 * 指令A：position += speed, speed *= 2;
 * 指令R:speed = speed > 0 ? -1 : 1;
 * 输入为目标终止位置，输出最少需要执行多少次指令可以到达终止位置
 */
public class GGame3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            x = Math.abs(x);
            System.out.println(help(x));
        }
    }

    public static long help(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        if (x == 2) return 2;
        long count;
        if (x % 2 == 0) {
            count = help(x / 2) + 1;
        } else {
            long q1 = help((x + 1) / 2) + 1;
            long q2 = help((x - 1) / 2) + 1;
            count = Math.min(q1, q2);
        }

        return count;
    }
}
