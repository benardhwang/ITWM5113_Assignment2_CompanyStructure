public abstract class BusinessEmployee extends Employee{
    private double bonusBudget;

    public BusinessEmployee (String name) {
        super(name,0);
        super.setBaseSalary(50000);
    }

    public double getBonusBudget() {
        return bonusBudget;
    }

    public void  setBonusBudget(double bonusBudget) {
        this.bonusBudget = bonusBudget;
    }

    public String employeeStatus() {
        return toString() + " with a budget of  " + getBonusBudget();
    }

}
