package algorithm_day01.cn.test;

public class TestSwitch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        for(int i = 0; i < arr.length; i++) {
            System.out.println("-------------");
            if (arr[i]%2 == 0) {
                switch (arr[i]) {
                    case 1:
                        System.out.println(arr[i]);
                        continue;
                    case 2:
                        System.out.println(arr[i]);
                        continue;
                    case 3:
                        System.out.println(arr[i]);
                        continue;
                    case 4:
                        System.out.println(arr[i]);
                        continue;
                    case 5:
                        System.out.println(arr[i]);
                        continue;
                    default:
                        System.out.println(arr[i]);
                        continue;
                }
//                System.out.println("do anyone else");
            }
        }
    }
}
