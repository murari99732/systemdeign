import java.io.StringWriter;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class HandfulJava8Notes {

    static int r = 10;
//https://www.youtube.com/watch?v=ePJrt5-G8eM&list=PLVz2XdJiJQxzrdrpglCv_nWIO5CDIqOVj&index=11
    public static void main(String[] args) {
        Consumer singleNumber =
                t -> System.out.println(t);
        //  singleNumber.accept(10);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        //   list.stream().forEach(singleNumber);


        Predicate<Integer> predicate = (t) -> t % 2 == 0;
        list.stream().filter(t -> t % 2 == 0)
                .peek(a -> System.out.println(r++)).collect(Collectors.toList());


        Supplier<Integer> supplier = () -> 1;
        list.stream().findAny().orElseGet(supplier);

        streamapi();

    }

    static void streamapi() {
        List<String> list = Arrays.asList("Murari", "Kumar", "Amir", "Khan", "Pooja", "Dhoni");
        list.stream().forEach(a -> System.out.println(a + " "));

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        map.put(5, "e");
        map.put(6, "f");

        map.entrySet().stream().filter(a -> a.getKey() % 2 == 0).forEach(a -> System.out.println(a.getValue() + " "));
        map.forEach((a, b) -> System.out.println(a + "  " + b));

        getEmployee().stream().filter(a->a.salary>84000).forEach(a->System.out.println(a.name));


        //sorted
        getEmployee().stream().sorted((a,b)->a.salary-b.salary).forEach(a->System.out.println(a));
      //  getEmployee().stream().sorted(Comparator.reverseOrder()).forEach(a->System.out.println(a));
        getEmployee().stream().sorted(Comparator.comparing(emp->emp.salary)).forEach(a->System.out.println(a));
        getEmployee().stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
    }

    static List<Employee> getEmployee() {
        List<Employee> list = Arrays.asList(
                new Employee(1, "Kumar", 86000),
                new Employee(2, "Murari", 85000),
                new Employee(3, "Rahul", 84000),
                new Employee(4, "Shyam", 74000)
        );
        return list;
    }


    static class Employee {
        int id;
        String name;
        int salary;

        public Employee(int id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }
    }
}
