public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", "Doe", 30000);
        Employee e2 = new Employee("Jane", "Smith", 40000);
        System.out.println("Yearly Salary of e1 = " + e1.getMonthlySalary() * 12);
        System.out.println("Yearly Salary of e2 = " + e2.getMonthlySalary() * 12);
        e1.setMonthlySalary(e1.getMonthlySalary() * 1.10);
        e2.setMonthlySalary(e2.getMonthlySalary() * 1.10);
        System.out.println("After 10% hike:");
        System.out.println("Yearly Salary of e1 = " + e1.getMonthlySalary() * 12);
        System.out.println("Yearly Salary of e2 = " + e2.getMonthlySalary() * 12);
    }
}

