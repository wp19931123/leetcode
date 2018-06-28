package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 考虑路径 = "/../" 的情况,在这种情况下，你需返回 "/" 。
 * 此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" ,在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
 */
public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/a/./b/../.../c/"));
    }

    //规律:中间是"."的情况直接去掉，是".."时删掉它上面挨着的一个路径，而下面的边界条件给的一些情况中可以得知，
    // 如果是空的话返回"/"，如果有多个"/"只保留一个
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] p = path.split("/");
        for (String t : p) {
            if (!s.isEmpty() && t.equals("..")) {
                s.pop();
            } else if (!t.equals(".") && !t.equals("") && !t.equals("..")) {
                s.push(t);
            }
        }
        List<String> list = new ArrayList(s);
        return "/" + String.join("/", list);
    }
}
