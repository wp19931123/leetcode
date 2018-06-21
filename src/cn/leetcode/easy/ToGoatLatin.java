package cn.leetcode.easy;

/**
 * 山羊拉丁文的规则如下：
 *
 * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 * 例如，单词"apple"变为"applema"。
 *
 * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词"goat"变为"oatgma"。
 *
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推
 *
 * S 中仅包含大小写字母和空格。单词间有且仅有一个空格。
 */
public class ToGoatLatin {
    public static void main(String[] args) {
        System.out.println(new ToGoatLatin().toGoatLatin("I speak Goat Latin"));
    }

    public String toGoatLatin(String S) {
        StringBuilder res = new StringBuilder();
        String[] strs = S.split(" ");
        for(int i = 0;i < strs.length;i++) {
            String tail = "";
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j <=i;j++) {
                tail += "a";
            }
            if(isYuanYin(strs[i].charAt(0))) {
                sb.append(strs[i]);
                sb.append("ma");
                sb.append(tail);
            }else{
                sb.append(strs[i].substring(1));
                sb.append(strs[i].charAt(0));
                sb.append("ma");
                sb.append(tail);
            }
            if(i == strs.length - 1) {
                res.append(sb);
            }else{
                res.append(sb);
                res.append(" ");
            }
        }
        return res.toString();
    }

    public boolean isYuanYin(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
