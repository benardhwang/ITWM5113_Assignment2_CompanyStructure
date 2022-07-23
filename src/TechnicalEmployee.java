public abstract class TechnicalEmployee extends Employee{
    private int checkIns;

    //Setting default salary 75000 for technical employee
    public TechnicalEmployee(String name) {
        super(name, 0);
        super.setBaseSalary(75000);
    }

    //Employee status of technical employee
    public String employeeStatus() {
        return super.toString() + " has " + this.getSuccessfulCheckIns() + " successful check ins";
    }

    //Return number of successful check ins
    public int getSuccessfulCheckIns() {
        return this.checkIns;
    }

    //Successful check in + 1
    public void checkIn() {
        checkIns ++;
    }
}
