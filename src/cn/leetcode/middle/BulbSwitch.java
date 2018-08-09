package cn.leetcode.middle;

/**
 * 初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。
 * 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。
 * 第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。
 * 找出 n 轮后有多少个亮着的灯泡。
 */
public class BulbSwitch {

    public static void main(String[] args) {
        System.out.println(new BulbSwitch().bulbSwitch(4));
    }

    //超出时间限制
    public int bulbSwitch(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {   //第i轮
            for (int j = i - 1; j < n; j += i) {
                arr[j] ^= 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //简化为了求1到n之间完全平方数的个数
    public int bulbSwitch2(int n) {
        return (int)Math.sqrt(n);
    }
}
