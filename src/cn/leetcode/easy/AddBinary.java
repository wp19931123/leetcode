package cn.leetcode.easy;

/**
 *
 */
public class AddBinary {

    public static void main(String[] args) {
        String s1 = "11";
        String s2 = "1";
        System.out.println(new AddBinary().addBinary(s1,s2));
    }
    //利用StringBuild从末尾往前依次添加并考虑进位
    public String addBinary(String a, String b) {
        if(a == null || b == null || a.length() == 0 || b.length() == 0) {
            return null;
        }
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if(i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }

}
