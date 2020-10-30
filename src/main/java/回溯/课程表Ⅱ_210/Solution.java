package 回溯.课程表Ⅱ_210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }

    private static boolean hasCycle(List<List<Integer>> graph, boolean[] visited,
                             boolean[] checked, List<Integer> order, int v) {
        if (visited[v]) return true;
        visited[v] = true;
        for (int i : graph.get(v))
            if (!checked[i] && hasCycle(graph, visited, checked, order, i))
                return true;
        checked[v] = true;
        order.add(v);
        visited[v] = false;
        return false;
    }

    // Time: O(V+E), Space: O(V+E)
    public static int[] findOrderDFS(int n, int[][] pairs) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; ++i)
            graph.add(new LinkedList<>());

        for (int[] pair : pairs)
            graph.get(pair[1]).add(pair[0]);

        boolean[] checked = new boolean[n];
        boolean[] visited = new boolean[n];
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; ++i)
            if (!checked[i] && hasCycle(graph, visited, checked, list, i))
                return new int[]{};

        int[] order = new int[n];
        for (int v : list)
            order[--n] = v;
        return order;
    }
}
