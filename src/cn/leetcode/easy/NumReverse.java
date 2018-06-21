package cn.leetcode.easy;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 */
public class NumReverse {
    public static void main(String[] args) {
        System.out.println(new NumReverse().reverse(120));
    }
    public int reverse(int x) {
        int flag = 1;
        if(x < 0) {
            x = -x;
            flag = -1;
        }
        while(x % 10 == 0) {
            x /= 10;
        }
        String str = Integer.toString(x);
        String re = reverse(str);
        int result = Integer.valueOf(re);

        return flag*result;
    }

    //Nowcoder
    public int reverse2(int x) {
        int res=0;
        while(x!=0){
            //最后一位
            int tail=x%10;
            int newRes=res*10+tail;
            //如果newRes-tail)/10!=res说明产生了溢出
            if((newRes-tail)/10!=res) {
                return 0;
            }
            res=newRes;
            x=x/10;
        }
        return res;
}

    public static String reverse(String str) {
        char[] ch = str.toCharArray();
        int i = 0;
        while(i < ch.length/2) {
            swap(ch,i);
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : ch) {
            sb.append(c);
        }
        return sb.toString();
    }
    public static void swap(char[] ch,int i) {
        char tmp = ch[i];
        ch[i] = ch[ch.length - 1 -i];
        ch[ch.length - 1 -i] = tmp;
    }
}
