import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    int employeeId;
    String name;
    String department;
    double salary;

    public Employee(int employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name       = name;
        this.department = department;
        this.salary     = salary;
    }

    public void display() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : Rs." + salary);
    }
}

public class EmployeeSerialization {
    static final String FILE = "employee.ser";

    static void serializeEmployee(Employee emp) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(emp);
            System.out.println("Employee serialized and saved to " + FILE);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }
    }

    static void deserializeEmployee() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            Employee emp = (Employee) ois.readObject();
            System.out.println("\n===== Recovered Employee Information =====");
            emp.display();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Serialized file not found.");
        } catch (IOException e) {
            System.out.println("Deserialization IO error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Employee class not found during deserialization.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Enter Employee Details =====");
        System.out.print("Employee ID  : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name         : ");
        String name = sc.nextLine();

        System.out.print("Department   : ");
        String dept = sc.nextLine();

        System.out.print("Salary       : ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, dept, salary);

        serializeEmployee(emp);
        deserializeEmployee();
    }
}