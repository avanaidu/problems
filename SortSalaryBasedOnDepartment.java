import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class SortSalaryBasedOnDepartment {


    public static void main(String[] args) {

        List<Employee> employeeList= List.of(new Employee(1, "anil", 10, "IT"),
                Employee.builder().empId(2).empName("abhi").empSalary(20).department("HR").build(),
                Employee.builder().empId(3).empName("ram").empSalary(15).department("MR").build(),
                Employee.builder().empId(4).empName("pri").empSalary(40).department("HR").build(),
                Employee.builder().empId(5).empName("naidu").empSalary(1).department("IT").build(),
                Employee.builder().empId(6).empName("avu").empSalary(20).department("MR").build(),
                Employee.builder().empId(7).empName("venkat").empSalary(2).department("IT").build());

         Map.Entry<String, Integer> result = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getEmpSalary)))
                .entrySet()
                 .stream()
                 .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                 .skip(1)
                 .findFirst()
                 .orElseThrow();

        System.out.println(result.getKey() + " department has second highest salary :: "+ result.getValue());
    }
}
