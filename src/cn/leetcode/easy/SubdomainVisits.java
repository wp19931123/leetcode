package cn.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输出:
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 */
public class SubdomainVisits {

    public static void main(String[] args) {
        String[] strs = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(new SubdomainVisits().subdomainVisits(strs));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i < cpdomains.length;i++) {
            int space = cpdomains[i].indexOf(" ");
            int count = Integer.valueOf(cpdomains[i].substring(0,space));
            String s = cpdomains[i].substring(space+1);
            String[] strs = s.split("\\."); //{"google","xx","com"}
            for(int j = strs.length-1;j >=0;j--) {
                String domain = "";
                for(int k = j;k <= strs.length-1;k++) {
                    if(k != strs.length - 1) {
                        domain = domain + strs[k] + ".";
                    }else{
                        domain = domain + strs[k];
                    }
                }
                if(map.containsKey(domain)) {
                    map.put(domain,map.get(domain) + count);
                }else{
                    map.put(domain,count);
                }
            }
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }
        return list;
    }
}
