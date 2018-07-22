package cn.leetcode.middle;

/**
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。. 字符不代表小数点，而是用于分隔数字序列。
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 * 示例 1:
 * 输入: version1 = "0.1", version2 = "1.1"
 * 输出: -1
 */
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null) {
            throw new RuntimeException("err");
        }
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int l1 = arr1.length;
        int l2 = arr2.length;
        int len = Math.min(l1,l2);
        for(int i = 0;i <= len-1;i++) {
            int v1 = Integer.parseInt(arr1[i]);
            int v2 = Integer.parseInt(arr2[i]);
            if(v1 > v2) {
                return 1;
            }else if(v1 < v2) {
                return -1;
            }
        }
        if(l1 > l2) {   //
            for(int i = l2;i < l1-1;i++) {
                int v = Integer.parseInt(arr1[i]);
                if(v > 0) {
                    return 1;
                }
            }
        }else if(l1 < l2){
            for(int i = l1;i < l2-1;i++) {
                int v = Integer.parseInt(arr2[i]);
                if(v > 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
