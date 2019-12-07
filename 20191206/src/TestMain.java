import java.util.*;

public class TestMain {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e: employees) {
            map.put(e.id, e);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int result = 0;
        while (!queue.isEmpty()) {
            Employee e = queue.poll();
            result += e.importance;
            for (int subId: e.subordinates) {
                queue.offer(map.get(subId));
            }
        }
        return result;
    }








    Map<Integer, Employee> emap;
    public int getImportance1(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }

}
