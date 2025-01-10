import java.util.*;

public class DFS {

    private static void dfs(Map<Integer, List<Integer>> graph, int startNode, Set<Integer> visited) {
        // Mark the current node as visited
        visited.add(startNode);
        System.out.print(startNode + " ");

        // Recur for all the vertices adjacent to this vertex
        for (int neighbor : graph.getOrDefault(startNode, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        // Create a graph as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(0, 3));
        graph.put(3, Arrays.asList(3));

        // Start DFS from node 2
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS Traversal: ");
        dfs(graph, 2, visited);
    }
}