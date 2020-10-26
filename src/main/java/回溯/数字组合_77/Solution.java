package 回溯.数字组合_77;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    // Time: O(k*C(n, k)), Space: O(k)
    public List<List<Integer>> combine(int n, int k) {
        if (n < k || n < 1 || k < 1) return Collections.EMPTY_LIST;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(n, k, 1, path, result);
        return result;
    }

    //思路:k为决策次数，初始情况[1,n]为总的可选项，start为决策可选项的上界。
    //当k为0时，说明找到一个合法组合。每次决策，k-1，决策上界为决策树i+1。

    private void backtracking(int n, int k, int start, List<Integer> path, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            path.add(i);
            backtracking(n, k - 1, i + 1, path, result);
            path.remove(path.size() - 1);
        }

    }

}
