public class TechnicalEmployee extends Employee{

    private int checkIns=0;

    ////Constructor new technical, employee Setting default salary 75000 for technical employee
    public TechnicalEmployee(String name) {
        super(name, 0);
        this.setBaseSalary(75000);
    }

    //Employee status of technical employee
    public String employeeStatus() {
        return this + " has " + getSuccessfulCheckIns() + " successful check ins";
    }

    //Return employee successful check ins
    public int getSuccessfulCheckIns(){
        return this.checkIns;
    }

    //Successful check in + 1
    public void checkIn() {
        checkIns ++;
    }

}
