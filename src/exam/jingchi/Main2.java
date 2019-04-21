package exam.jingchi;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cur = 1;
        //1,召集 2，扫描 3，克隆
        List<Integer> res = primeFactor(N);
        Collections.sort(res);
        int tmp = 1;
        for(int i = 0;i < res.size();i++) {
            if(tmp < Math.sqrt(N)) {
                tmp *= res.get(i);
            }
        }
    }

    public static List<Integer> primeFactor(int num) {// 该方法将一个正整数分解成质因数相乘的形式
        List<Integer> list = new ArrayList<>();
        if (num < 2) {// 若输入的数小于2,输出提示信息
            System.out.println("必须输入不小于2的正整数！");
        } else {
            int primeNumber = 2;// 定义最小的质数
            System.out.print(num + " = ");
            while (primeNumber <= num) {// 在质数小于输入的数时，进行循环
                if (primeNumber == num) {// 当质数等于输入的数时,直接输出
                    list.add(num);
                    break;// 跳出循环
                } else if (num % primeNumber == 0) {// 当输入的数与质数的余数为0时,输出这个质数
                    list.add(primeNumber);
                    num = num / primeNumber;// 把剩下的结果赋给num
                } else {// 在余数不为0时,质数递增
                    primeNumber++;
                }
            }
        }
        return list;
    }
}
