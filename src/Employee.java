abstract class Employee {
    private String empName;
    private double baseSalary;
    private int empId;
    // set static to ensure each employee object getting new employee number
    private static int autoNumber;
    private Employee manager;
    //private String empStatus;

    //Constructor new employee
    public Employee (String name, double baseSalary) {
        this.empName = name;
        this.baseSalary = baseSalary;
        this.setEmpId(++autoNumber);
    }

    //return employee base salary
    public double getBaseSalary() {
        return this.baseSalary;
    }

    //return employee name
    public String getName() {
        return this.empName;
    }

    //Return Employee ID
    public int getEmployeeID() {
        return this.empId;
    }

    //return base salary
    public void setBaseSalary(double salary) {

        this.baseSalary = salary;
    }

    //Return employee's manager object
    public Employee getManager(Employee e) {
        return this.manager;
    }

    //Set employee's Manager
    public void setManager(Employee name) {
        this.manager = name;
    }

    //Check employee id is it duplicated, yes = duplicated
    public boolean equals(Employee e) {
        return this.getEmployeeID() == e.getEmployeeID();
    }

    //Return Employee id + employee Name
    public String toString() {
        return empId + " " + empName;
    }

    //set employee id
    public void setEmpId(int id) {
        this.empId =  id;
    }

    //Return employee status this will different for every subclass of employee
    abstract String employeeStatus();

}


