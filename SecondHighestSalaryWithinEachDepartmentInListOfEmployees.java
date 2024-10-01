import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SecondHighestSalaryWithinEachDepartmentInListOfEmployees {

    public static void main(String[] args) {
        List<EmployeeDifferent> employees = Arrays.asList(
                new EmployeeDifferent("John", "IT", 6000),
                new EmployeeDifferent("Jane", "HR", 7000),
                new EmployeeDifferent("Bob", "IT", 8000),
                new EmployeeDifferent("Alice", "HR", 6500),
                new EmployeeDifferent("Charlie", "Finance", 7500),
                new EmployeeDifferent("David", "IT", 5000),
                new EmployeeDifferent("Dude", "IT", 4000),
                new EmployeeDifferent("Nenokkidane", "HR", 4000),
                new EmployeeDifferent("Avu", "IT", 4000)
        );

        Map<String, Optional<Integer>> map = employees.stream().collect(Collectors.groupingBy(EmployeeDifferent::getDepartment,
                Collectors.collectingAndThen(Collectors.mapping(EmployeeDifferent::getSalary, Collectors.toList()),
                salaries -> {
                        salaries.sort(Comparator.reverseOrder());
                        return salaries.size() > 1 ? Optional.of(salaries.get(1)) : Optional.empty();
                })));

        System.out.println(map);
    }
}
