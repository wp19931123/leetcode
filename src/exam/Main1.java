package exam;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

    public List<Integer> LastRemaining_Solution(int n, int m) {
        List<Integer> list = new ArrayList<>();
        if(n < 1 || m < 1) {
            return list;
        }
        int last = 0;
        for(int i = 2;i <=n;i++) {
            last = (last+m)%i;
            list.add(last);
        }
        return list;
    }
}
