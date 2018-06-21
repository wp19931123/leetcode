package cn.leetcode.easy;

public class CountAndSay {

    public static void main(String[] args) {
        String pre = "1124444";
        System.out.println(new CountAndSay().wtoSay(pre));

    }

    public String countAndSay(int n) {
        if(n <= 0) {
            return null;
        }
        if(n == 1) {
            return "1";
        }else{
            return wtoSay(countAndSay(n-1));
        }
    }
    public String wtoSay(String pre) {
        int len = pre.length();
        int i = 1;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while(i < len) {
            if(pre.charAt(i) == pre.charAt(i-1)) {
                i++;
                count++;
            }else{
                sb.append(count);
                sb.append(pre.charAt(i-1));
                count = 1;
                i++;
            }
        }
        sb.append(count);
        sb.append(pre.charAt(i-1));
        return sb.toString();
    }
}
