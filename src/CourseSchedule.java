import java.util.*;

public class CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            // courses with no pre-reqs
            if (indegree[i] == 0) {
                order[index++] = i;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int prerequisite = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                int course = prerequisites[i][0];
                if (prerequisites[i][1] == prerequisite) {
                    indegree[course]--;
                    if (indegree[course] == 0) {
                        order[index++] = course;
                        queue.offer(course);
                    }
                }
            }
        }

        return (index == numCourses) ? order : new int[0];
    }
}
