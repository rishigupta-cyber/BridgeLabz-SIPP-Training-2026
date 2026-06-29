public class EmployeeManagementSystem {
    final int id;
    String name;
    String designation;
    static String companyName = "Tech Solutions Pvt Ltd";
    static int totalEmployees = 0;

    EmployeeManagementSystem(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    void displayDetails(Object obj) {
        if (obj instanceof EmployeeManagementSystem) {
            System.out.println("Company: " + companyName + ", ID: " + id + ", Name: " + name + ", Designation: " + designation);
        }
    }

    static void displayTotalEmployees() {
        System.out.println("Total employees: " + totalEmployees);
    }

    public static void main(String[] args) {
        EmployeeManagementSystem e1 = new EmployeeManagementSystem("Rohit Sharma", 201, "Software Engineer");
        EmployeeManagementSystem e2 = new EmployeeManagementSystem("Anita Desai", 202, "Project Manager");

        e1.displayDetails(e1);
        e2.displayDetails(e2);

        EmployeeManagementSystem.displayTotalEmployees();
    }
}