public class Accountant extends BusinessEmployee{

    public Accountant(String name) {
        super(name);
        this.setBonusBudget(0.00); //start with a bonus budget of 0
        this.currentlySupporting = null; //no team they are official supporting
    }

    public TechnicalLead getTeamSupported() {
        return this.currentlySupporting;
    }

    public void supportTeam(TechnicalLead lead) {
        this.currentlySupporting = lead;
        //this.currentlySupporting.setManager(lead);
        this.setBonusBudget(lead.getSalaries() + (lead.getSalaries() * 0.10)); //To check at lead.getSalaries if match with total of technical lead's software engineer base salary.
    }

    public boolean approveBonus(double bonus) {
        if (this.currentlySupporting != null){ //check if accountant is supporting any team
            if(bonus > this.getBonusBudget()){
                return false; //not enough budget
            }else{
                return true; //the bonus is within the remaining budget
            }
        }else{
            return false; //if the accountant is not supporting any team
        }
    }

    public String employeeStatus() {
        if (this.currentlySupporting != null) {
            //return this.getEmployeeID() + " " + this.getName() + " with a budget of " + super.getBonusBudget() + " is supporting " + currentlySupporting.getName();
            return super.toString() + " with a budget of " + String.format("%.1f",this.getBonusBudget()) +" is currently supporting "+ currentlySupporting.getName();
        } else {
            //return this.getEmployeeID() + " " + this.getName() + " with a budget of " + super.getBonusBudget() + " and is currently not supporting anyone.";
            return super.toString() + " with a budget of " + String.format("%.1f",this.getBonusBudget())+" is currently not supporting anyone";
        }
    }
}
