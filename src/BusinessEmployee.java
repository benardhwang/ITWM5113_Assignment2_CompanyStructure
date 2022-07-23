import java.util.ArrayList;

public class BusinessEmployee extends Employee{
    public void setBonusBudget(double bonusBudget) {
        this.bonusBudget = bonusBudget;
    }

    private double bonusBudget;
    TechnicalLead currentlySupporting;

    public BusinessEmployee (String name) {
        super(name,0);
        super.setBaseSalary(50000);
    }

    public double getBonusBudget() {
        return this.bonusBudget;
    }

    public String employeeStatus() {
        return this + " with a budget of  " + String.format("%.1f",getBonusBudget());
    }
}