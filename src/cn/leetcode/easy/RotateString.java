package cn.leetcode.easy;

public class RotateString {

    public boolean rotateString(String A, String B) {
        if(A == null || B == null || A.length() != B.length()) {
            return false;
        }
        String extA = A + A;
        return extA.contains(B);
    }
}
