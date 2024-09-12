import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;


    public Employee(String name, int id) { //constructor
        this.name = name;
        this.id = id;
    }

    public String getName() {   //getter
        return name;
    }

    public int getId() {
        return id;
    }

    //abstract method
    public abstract double calculateSalary(); // no body provided not declaration occurs, body only provinded when other method extends


@Override
    public String toString(){
       return "Employee [name="+name+", id="+id+", salary="+calculateSalary()+"]";
   }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {  //construcor
        super(name, id);  // accessing parent construction
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
    class PartTimeEmployee extends Employee{

        private int hoursWorked;
        private double hourlyRate;
        public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
            super(name,id);
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculateSalary(){
            return hoursWorked * hourlyRate;
        }
    }


    class PayrollSystem{
    private ArrayList<Employee> employeeList;
    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for(Employee employee : employeeList ){
            System.out.println(employee);
        }
    }


    }

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1, 50000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Rajeshwari", 2,30,200 );
        FullTimeEmployee emp3 = new FullTimeEmployee("Abhishek", 3, 30000);
        PartTimeEmployee emp4 = new PartTimeEmployee("Arti", 4,20,150 );
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);

        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployees();
        System.out.println("Removing Employees");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaing Employees Details: ");
        payrollSystem.displayEmployees();

    }
}