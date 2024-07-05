public interface Measurable {
    double getMeasure();
}

public class Employee implements Measurable {
    private double salary;
    private String name;

    public Employee(double salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static double average(Measurable[] objects) {
        double sum = 0;
        for (Measurable obj : objects) {
            sum += obj.getMeasure();
        }
        return objects.length == 0 ? 0 : sum / objects.length;
    }

    public static Measurable largest(Measurable[] objects) {
        if (objects.length == 0) return null;
        Measurable largest = objects[0];
        for (Measurable obj : objects) {
            if (obj.getMeasure() > largest.getMeasure()) {
                largest = obj;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee(50000, "John Doe"),
                new Employee(60000, "Jane Smith"),
                new Employee(55000, "Alice Johnson")
        };

        System.out.println("Average salary: " + average(employees));

        Employee highestPaid = (Employee) largest(employees);
        if (highestPaid != null) {
            System.out.println("Employee with highest salary: " + highestPaid.getName());
        }
    }
}