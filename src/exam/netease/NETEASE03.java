package exam.netease;

import java.util.LinkedList;
import java.util.List;

/**
 * m个a，n个z，求全排列的第k个字符串
 */
public class NETEASE03 {
    public static void main(String[] args) {
        char[] arr = {'a', 'a', 'z','z'};
        List<List<Character>> res = new NETEASE03().permuteUnique(arr);
        System.out.println(res.get(5).toString());
    }

    List<List<Character>> res;
    boolean[] used;

    public List<List<Character>> permuteUnique(char[] chs) {
        res = new LinkedList<>();
        used = new boolean[chs.length];
        if (chs == null || chs.length == 0) {
            return res;
        }
        List<Character> tmp = new LinkedList<>();
        helper(chs, tmp);
        return res;
    }

    private void helper(char[] chs, List<Character> tmp) {
        if (tmp.size() == chs.length) {
            List<Character> list = new LinkedList<>(tmp);
            res.add(list);
        } else {
            for (int idx = 0; idx < chs.length; idx++) {
                // 遇到已经加过的元素就跳过
                if (used[idx]) {
                    continue;
                }

                // 加入该元素后继续搜索
                used[idx] = true;
                tmp.add(chs[idx]);
                helper(chs, tmp);
                tmp.remove(tmp.size() - 1);
                used[idx] = false;
                // 跳过本轮的重复元素，确保每一轮只会加unique的数字
                while (idx < chs.length - 1 && chs[idx] == chs[idx + 1]) {
                    idx++;
                }
            }
        }
    }
}
