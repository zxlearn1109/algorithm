package 回溯.课程表Ⅱ_210;

import java.util.*;

public class Solution {

    // Time: O(V+E), Space: O(V+E)
    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new LinkedList<>());

        int[] indregee = new int[numCourses];
        for (int[] presites : prerequisites) {
            graph.get(presites[1]).add(presites[0]);
            indregee[presites[0]]++;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indregee[i] == 0) stack.push(i);
        }
        int[] res = new int[numCourses];
        int cnt = 0;
        while (!stack.isEmpty()) {
            Integer val = stack.pop();
            res[cnt++] = val;
            List<Integer> enums = graph.get(val);
            for (int per : enums) {
                indregee[per]--;
                if (indregee[per] == 0) stack.push(per);
            }
        }

        return cnt == numCourses ? res : new int[0];
    }

    // Time: O(V+E), Space: O(V+E)
    public int[] findOrderDFS(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new LinkedList<>());
        for (int[] presites : prerequisites) graph.get(presites[1]).add(presites[0]);
        boolean[] visited = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!checked[i] && hasCycle(i, order, visited, checked, graph)) return new int[]{};
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = order.get(numCourses-i-1);
        }

        return res;
    }

    private boolean hasCycle(int position, List<Integer> order, boolean[] visited, boolean[] checked, List<List<Integer>> graph) {
        if (visited[position]) return true;
        List<Integer> enums = graph.get(position);
        visited[position] = true;
        for (int decide : enums) {
            if (checked[decide]) continue;
            if (hasCycle(decide, order, visited, checked, graph)) return true;
        }
        visited[position] = false;
        checked[position] = true;
        order.add(position);
        return false;
    }
}
