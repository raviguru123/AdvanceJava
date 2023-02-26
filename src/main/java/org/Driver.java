package org;


// CODE EXAMPLE VALID FOR COMPILING

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int age;
    double salary;
    String city;
    String last_name;

    public Employee(int age, double salary, String city, String last_name) {
        this.age = age;
        this.salary = salary;
        this.city = city;
        this.last_name = last_name;
    }
}


class empComp implements Comparator<Employee> {
    public int compare(Employee emp1, Employee emp2) {
        if (emp1.last_name.compareTo(emp2.last_name) > 1) {
            return 1;
        } else if (emp1.last_name.compareTo(emp2.last_name) > 1) {
            return -1;
        }

        return 0;
    }
}


class Driver {
    public static void main(String[] args) {

        Employee emp1 = new Employee(12, 34, "delhi", "singh");
        Employee emp2 = new Employee(24, 87797, "satna", "patil");
        Employee emp3 = new Employee(30, 4566, "gurgaon", "sharma");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        Set<Integer> integerSet = new HashSet<>();

        System.out.println("Hello, World!");
        List<Employee> employees1 = employeeList.stream().filter(emp -> {
                    if (emp.age > 25 && emp.age < 35) {
                        return true;
                    }
                    return false;

                }).filter(emp -> emp.salary > 100)
                .sorted(Comparator.comparing(employee -> employee.last_name))
                .collect(Collectors.toList());


        System.out.println("employeeList" + employees1);


    }
}