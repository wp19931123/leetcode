package cn.leetcode.middle;

/**
 * 猜数字游戏
 * 输入: secret = "1123", guess = "0111"
 * 输出: "1A1B"
 * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
 */
public class GetHint {

    public static void main(String[] args) {
        System.out.println(new GetHint().getHint("1807","7810"));
    }

    //时间复杂度O(n^2)
    public String getHint(String secret, String guess) {
        int n = secret.length();
        boolean[] isUse = new boolean[n];
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
                isUse[i] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                for (int j = 0; j < n; j++) {
                    if (isUse[j] == false && secret.charAt(j) == guess.charAt(i)) {
                        isUse[j] = true;
                        b++;
                        break;
                    }
                }
            }
        }
        return a + "A" + b + "B";
    }
}
