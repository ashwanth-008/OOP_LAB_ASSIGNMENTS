/*Q3.)Create a class called employee that include three instance variable 
a)name (type string)
b)last name (type string) and 
c) monthly salary(double). 
Provide a constructor that initialize the three instance variable. Provide a set and a get method of instance variable. 
if the monthly salary is not positive do not set its value. 
Write a test aplication named employeetest that demonstrate class employee capabilities.
Create two employee object and display each object yearly salary. 
Then give each employee a 10% hike and display each employee yearly salary again. */
public class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;
    public Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (monthlySalary > 0)
            this.monthlySalary = monthlySalary;
    }
    public double getMonthlySalary() {
        return monthlySalary;
    }
    public void setMonthlySalary(double salary) {
        if (salary > 0)
            this.monthlySalary = salary;
    }
}
