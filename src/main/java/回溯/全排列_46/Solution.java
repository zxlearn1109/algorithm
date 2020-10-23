package 回溯.全排列_46;

import java.util.*;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
// 👍 956 👎 0
public class Solution {

    //Time:O(n * n!)    Time:O(n)
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);

        backTracking(list, 0, result);
        return result;
    }

    void backTracking(List<Integer> nums, int start, List<List<Integer>> result) {
        if (start == nums.size()) {
            result.add(new ArrayList(nums));
        } else {
            for (int i = start; i < nums.size(); i++) {
                Collections.swap(nums,i,start);
                backTracking(nums,start + 1,result);
                Collections.swap(nums,i,start);
            }
        }
    }
    //start为分界点,start左边为选择好的路径，start+右边为可选择的项。


    public List<List<Integer>> permute2(int[] nums) {
        if (nums == null) return Collections.EMPTY_LIST;

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        backTracking2(nums, path, resultList, visited);

        return resultList;
    }

    private void backTracking2(int[] nums, List<Integer> path, List<List<Integer>> resultList, Set<Integer> visited) {
        if (path.size() == nums.length) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i)) continue;
            path.add(nums[i]);
            backTracking2(nums, path, resultList, visited);
            path.remove(path.size() - 1);
            visited.remove(i);
        }

    }

}
