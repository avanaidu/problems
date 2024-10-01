import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployee {

    public static void main(String[] args) {
        Employee employee1 = new Employee(2, "anil", 10);
        Employee employee2 = new Employee(10, "naidu", 20);
        Employee employee3 = new Employee(2, "avu", 5);
        Employee employee4 = new Employee(3, "abhi", 6);
        Employee employee5 = new Employee(6, "ram", 20);
        Employee employee6 = new Employee(2, "nenu", 15);
        Employee employee7 = new Employee(7, "pri", 3);

        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6, employee7);

        System.out.println(sortEmployees(employees));

    }

    private static List<Employee> sortEmployees(List<Employee> employees) {

     return   employees.stream().sorted(Comparator.comparing(Employee::getEmpId).thenComparing(Employee::getEmpSalary).reversed()).collect(Collectors.toList());
    }
}
