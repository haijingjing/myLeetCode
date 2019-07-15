import java.util.*;

//690 雇员权重
public class EmployeeImportance {
    HashMap<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for(Employee employee: employees){
            map.put(employee.id, employee);
        }
        return dfs(id);
    }

    private int dfs(int id) {
        Employee employee = map.get(id);
        int ans = employee.importance;
        for(Integer subid : employee.subordinates){
            ans += dfs(subid);
        }
        return ans;
    }

//    public int getImportance2(List<Employee> employees, int id) {
//        for(Employee employee: employees){
//            map.put(employee.id, employee);
//        }
//
//    }
}
