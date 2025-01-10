import java.util.*;

class MenuNode {
    String key;
    int value;
    boolean active;
    List<MenuNode> children;

    public MenuNode(String key, int value, boolean active) {
        this.key = key;
        this.value = value;
        this.active = active;
        this.children = new LinkedList<>();
    }
}

public class MenuTree {

    /**
     *
     * @param existingMenu
     * @param newMenu
     * @return
     *
     * Output: Return the number of changed nodes in the tree.
     *
     * Existing tree
     *                a(1)
     *             /
     *          b(2)      c(3)
     *         /     \
     *       d(4)    e(5)      f(6)
     *
     *
     * New tree
     *             a(1)
     *
     *                c(3)
     *
     *                    f(66)
     */
    public static int countChangedNodes(MenuNode existingMenu, MenuNode newMenu) {
        int changedNodes = 0;

        // Initialize queues for BFS traversal
        Queue<MenuNode> existingQueue = new LinkedList<>();
        Queue<MenuNode> newQueue = new LinkedList<>();

        // Enqueue the root nodes
        existingQueue.offer(existingMenu);
        newQueue.offer(newMenu);

        // Perform BFS traversal
        while (!existingQueue.isEmpty() && !newQueue.isEmpty()) {
            MenuNode existingNode = existingQueue.poll();
            MenuNode newNode = newQueue.poll();

            // Compare the nodes
            if (!existingNode.key.equals(newNode.key) || existingNode.value != newNode.value || existingNode.active != newNode.active) {
                changedNodes++;
            }

            // Enqueue children for further comparison
            existingQueue.addAll(existingNode.children);
            newQueue.addAll(newNode.children);
        }

        return changedNodes + existingQueue.size() + newQueue.size(); //any items leftover in either queue count towards the changed nodes so add them here
    }
}