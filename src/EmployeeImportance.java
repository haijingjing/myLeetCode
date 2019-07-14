import java.util.*;

//690 雇员权重
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Employee target = this.findEmployeeById(employees, id);
        Queue<Employee> employeeQueue = new LinkedList<>();
        employeeQueue.add(target);
        int sum = 0;
        while (!employeeQueue.isEmpty()){
            int size = employeeQueue.size();
            for(int i = 0; i < size; i++){
                Employee current = employeeQueue.poll();
                sum += current.importance;
                for(Integer subid :current.subordinates){
                    Employee subemployee = this.findEmployeeById(employees,subid);
                    employeeQueue.add(subemployee);
                }
           }
        }
        return sum;
    }
    public Employee findEmployeeById(List<Employee> employees, int id){
        for(Employee employee: employees){
            if(employee.id == id)
                return employee;
        }
        return null;
    }

//    public int getImportance2(List<Employee> employees, int id) {
//
//    }
}
