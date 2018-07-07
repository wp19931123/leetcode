package cn.leetcode.middle;

/**
 * 环形加油站问题
 */
public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, total = 0, sum = 0;
        for(int i = 0;i < gas.length;i++) {
            total += gas[i] - cost[i];  //记录总的gas减去总的cost
            sum += gas[i] - cost[i];
            //如果剩余的的gas加上当前gas再减去cost小于0，当前节点不能作为起点
            if(sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return total < 0 ? -1 : start;  //加到最后的值
    }
}
