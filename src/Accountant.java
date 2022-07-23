public class Accountant extends BusinessEmployee{
    //private double bonusBudget = 0.0;
    private TechnicalLead currentlySupporting = null;

    public Accountant(String name) {
        super(name);
    }

    public TechnicalLead getTeamSupported() {
        return this.currentlySupporting;
    }

    public void supportTeam(TechnicalLead lead) {
        this.currentlySupporting = lead;
        super.setBonusBudget(lead.getSalaries() + (lead.getSalaries() * 0.10));
    }

    public boolean approveBonus(double bonus) {
        if (bonus < super.getBonusBudget()) {
            super.setBaseSalary(super.getBonusBudget()-bonus);
            return true; }
        else {
            return false;
        }
    }

    public String employeeStatus() {
        if (!(currentlySupporting == null)) {
            return this.getEmployeeID() + " " + this.getName() + " with a budget of " + super.getBonusBudget() + " is supporting " + currentlySupporting.getName();
        } else {
            return this.getEmployeeID() + " " + this.getName() + " with a budget of " + super.getBonusBudget() + " and is currently not supporting anyone.";
        }
    }
}
