package 动态规划.爬楼梯的最小代价_746;

public class Solution {

    //Time:O(n)     Space:O(1)
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length ==0) return 0;
        int n = cost.length;
        int first = cost[0],second = n > 1 ?cost[1]:0;
        for(int i=2;i<n;i++){
            int cur =Math.min(first,second) + cost[i];
            first = second;
            second = cur;
        }
        return Math.min(first,second);
    }
    //mincost[i] = Math.min(mincost[i-1],mincost[i-2])

}
