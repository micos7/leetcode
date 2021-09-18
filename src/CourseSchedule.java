import java.util.ArrayList;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //https://leetcode.com/problems/course-schedule/ 207
        ArrayList<Integer>[] l = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            l[i] = new ArrayList();
        }

        for (int[] p : prerequisites) {
            l[p[0]].add(p[1]);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(l, visited, i)) return false;
        }
        return true;
    }

    private boolean dfs(ArrayList<Integer>[] l, int[] visited, int v) {
        if (visited[v] == 1) return false;
        if (visited[v] == 2) return true;
        visited[v] = 1;
        for (int li : l[v]) {
            if (!dfs(l, visited, li)) return false;
        }

        visited[v] = 2;
        return true;
    }
}
