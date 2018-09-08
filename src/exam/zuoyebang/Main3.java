package exam.zuoyebang;

public class Main3 {

    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(maxWater(arr));
    }

    public static int maxWater(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int[] maxWater = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            maxWater[i] = 0;
            for (int j = i + 1; j < heights.length; j++) {
                maxWater[i] = Math.max(Math.min(heights[i], heights[j]) * (j - i), maxWater[i]);
            }
        }
        int res = 0;
        for (int i = 0; i < maxWater.length; i++) {
            res = Math.max(res, maxWater[i]);
        }
        return res;
    }
}
