class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

public class Manager extends Employee {
    int teamSize;

    Manager(int employeeID, String department, double salary, int teamSize) {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
    }

    void displayManagerDetails() {
        System.out.println("Employee ID: " + employeeID + ", Department: " + department + ", Team Size: " + teamSize + ", Salary: Rs." + getSalary());
    }

    public static void main(String[] args) {
        Manager mgr = new Manager(501, "Sales", 75000.0, 8);
        mgr.displayManagerDetails();

        mgr.setSalary(85000.0);
        System.out.println("Updated salary: Rs." + mgr.getSalary());
    }
}