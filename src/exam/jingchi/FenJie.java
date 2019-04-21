package exam.jingchi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FenJie {

        public static void main(String[] args) {
            primeFactor();// 调用primeFactor()方法
        }

        public static List<Integer> primeFactor() {// 该方法将一个正整数分解成质因数相乘的形式
            Scanner scan = new Scanner(System.in);// 接收控制台输入的信息
            List<Integer> list = new ArrayList<>();
            try {
                int num = scan.nextInt();// 取出控制台输入的信息
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
            } catch (Exception e) {
                System.out.println("必须输入正整数！");// 捕捉异常,输出必须输入整数
            }
            return list;
        }
}
