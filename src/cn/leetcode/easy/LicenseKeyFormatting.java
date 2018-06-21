package cn.leetcode.easy;

/**
 * 输入：该字符串仅由字母数字字符和破折号组成。该字符串被分成N + 1个组，分为N个破折号。
 * 重新格式化字符串，使得每个组包含完全K个字符，但第一个组可能比K短，但仍然必须至少包含一个字符
 * Input: S = "5F3Z-2e-9-w", K = 4
 * Output: "5F3Z-2E9W"
 */
public class LicenseKeyFormatting {

    public static void main(String[] args) {
        String S = "5F3Z-2e-9-w";
        String S2 = "2-5g-3-J";
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting(S2,2));
    }

    public String licenseKeyFormatting(String S, int K) {
        String str = S.replaceAll("-","");
        StringBuilder sb = new StringBuilder();
        if(str.length() == 0 ) {
            return sb.toString();
        }
        int length = str.length();
        int yu = length % K;
        if(yu == 0) {
            for(int i = 0;i < length/K;i++) {
                sb.append(str.substring(i*K,(i+1)*K));
                if(i != length / K-1) {
                    sb.append("-");
                }
            }
        }else{
            sb.append(str.substring(0,yu));
            length -= yu;
            for(int i = 0;i < length/K;i++) {
                sb.append("-");
                sb.append(str.substring(i*K+yu,(i+1)*K+yu));
            }
        }
        return sb.toString().toUpperCase();
    }
}
