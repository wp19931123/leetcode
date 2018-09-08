package exam.other;

import java.util.ArrayList;
import java.util.List;

public class Main3 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] arr = new int[10];
//        for(int i = 0;i <10;i++) {
//            arr[i] = sc.nextInt();
//        }
        int[] arr = {0,1,1,1,1,1,1,1,1,0};
        res = new ArrayList<>();
        tmp = new ArrayList<>();
        dfs(arr,0);
        System.out.print(res);
    }

    static List<String> res;
    static List<Integer> tmp;
    private static void dfs(int[] arr,int index) {
        if(index == arr.length-1) {
            tmp.add(index);
            StringBuilder sb = new StringBuilder();
            for(Integer i :tmp) {
                sb.append(i);
            }
            res.add(sb.toString());
            return;
        }
        if(arr[index] == 0) {
            tmp.add(index);
            dfs(arr,index+1);
            tmp.remove(tmp.size()-1);
            dfs(arr,index+1);
        }else{
            tmp.add(index);
            dfs(arr,index+1);
        }
    }


}
