//你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
//
// 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
//
//
//
// 示例 1:
//
// 输入: 2, [[1,0]]
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
//
// 示例 2:
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
//
//
//
// 提示：
//
//
// 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
// 你可以假定输入的先决条件中没有重复的边。
// 1 <= numCourses <= 10^5
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序
// 👍 611 👎 0
package 回溯.课程表_207;

import java.util.*;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0
                || prerequisites[0] == null || prerequisites[0].length == 0)
            return true;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new LinkedList<>());

        Map<Integer, Integer> indepthMap = new HashMap<>();
        for (int[] arr : prerequisites) {
            graph.get(arr[1]).add(arr[0]);
            indepthMap.put(arr[0], indepthMap.getOrDefault(arr[0], 0) + 1);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indepthMap.getOrDefault(i, 0) == 0) stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            List<Integer> list = graph.get(pop);
            if (indepthMap.containsKey(pop)) indepthMap.remove(pop);
            for (Integer per : list) {
                indepthMap.put(per, indepthMap.get(per) - 1);
                if (indepthMap.get(per) == 0) stack.push(per);
            }
        }

        return indepthMap.isEmpty();
    }

}
