package exam.CMBCard;

import java.util.Arrays;

public class CMBCard3 {

    private static int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        Arrays.sort(piles);
        int high = piles[piles.length - 1];
        while (low < high) {
            int mid = (low + high) >> 1;
            if (possible(piles, mid, H)) {     //如果满足在H小时内以最慢的速度吃完香蕉
                high = mid;                    //说明最慢的速度在[min, mid]之间
            } else {
                low = mid + 1;  //如果H小时无法吃完香蕉就说明最慢速度在[mid+1,high]之间
            }
        }
        return low;
    }

    private static boolean possible(int[] piles, int K, int H) { //以mid为速度K
        int times = 0;
        for (int pile : piles) {           //对数组里面的元素进行遍历，计算出吃每一堆香蕉所需要的时间
            times += (pile - 1) / K + 1;   //并获取吃完所有需要时间
        }
        return times <= H;
    }
}
