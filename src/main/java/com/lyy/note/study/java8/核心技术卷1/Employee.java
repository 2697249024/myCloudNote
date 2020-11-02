package com.lyy.note.study.java8.核心技术卷1;

public class Employee implements Comparable<Employee> {


    private String name;

    private double salary;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }


    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent /100;
        salary += raise;
    }


    @Override
    public int compareTo(Employee other) {

        return Double.compare(salary,other.salary);
    }
}
