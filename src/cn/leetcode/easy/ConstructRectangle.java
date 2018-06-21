package cn.leetcode.easy;

public class ConstructRectangle {

    public static void main(String[] args) {
        int[] res = new ConstructRectangle().constructRectangle2(56);
        System.out.println(res[0]+" " +res[1]);
    }
    //超时
    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        res[0] = area;res[1] = 1;
        for(int i = area;i > 0;i--) {
            for(int j = i;j > 0;j--) {
                if(i*j == area && i < res[0]) {
                    res[0] = i;
                    res[1] = j;
                }else if(i*j < area) {
                    break;
                }
            }
        }
        return res;
    }

    public int[] constructRectangle2(int area) {
        int x = (int) Math.ceil(Math.sqrt(area));
        while (area % x != 0) {
            x++;
        }
        int y = area / x;
        return new int[] {x, y};
    }

}
