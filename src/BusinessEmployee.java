import java.util.ArrayList;

public class BusinessEmployee extends Employee{

    private double bonusBudget;
    public TechnicalLead currentlySupporting;

    ////Constructor new Business employee, default salary is 50000
    public BusinessEmployee (String name) {
        super(name,0);
        super.setBaseSalary(50000);
    }

    //set bonus budget
    public void setBonusBudget(double bonusBudget) {
        this.bonusBudget = bonusBudget;
    }

    //Get bonus budget
    public double getBonusBudget() {
        return this.bonusBudget;
    }

    //Return Business Employee Status
    public String employeeStatus() {
        return this + " with a budget of  " + String.format("%.1f",getBonusBudget());
    }
}