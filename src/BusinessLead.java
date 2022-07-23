import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee{
    private int headCount;
    private ArrayList<Accountant> team = new ArrayList<>();

    public BusinessLead(String name){
        super(name);
        super.setManager(this);
        super.setBaseSalary(2*super.getBaseSalary()); //twice base salary of an accountant (PLS CHECK!!)
        headCount = 10;
    }

    public boolean hasHeadCount() {
        if (team.size() < headCount) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if (this.hasHeadCount()){
            this.team.add(e);
            e.setManager(this); //added 20220723
            e.supportTeam(supportTeam);
            this.bonusBudget += this.getBaseSalary()*1.1; //added 20220723
            this.currentlySupporting = supportTeam; //added 20220723
            return true;
        }else{
            return false;
        }

    }

    public boolean requestBonus(Employee e, double bonus){
        if (bonus < this.getBonusBudget()){ //check if the bonus amount requested fit in current businessLead budget
            this.bonusBudget -= bonus; //businessLead budget should be deducted
            return true;
        }else {
            return false;
        }
    }

    public boolean approveBonus (Employee e, double bonus){
        double checkBonusAfford = super.getBonusBudget();
        for (int i = 0; i < this.team.size(); i++){
            checkBonusAfford -= team.get(i).getBonusBudget();
        }
        if(checkBonusAfford > 0){
            return true;
        } else {
            return false;
        }
    }

    String getTeamStatus() {
        //get Team total bonus
        int bonus = 0;
        for (int i = 0; i < team.size(); i++) {
            bonus += team.get(i).getBonusBudget();
        }

        String outputString = "";
        outputString += this.getEmployeeID() + " ";
        outputString += this.getName() + " ";
        outputString += "with a budget of ";
        outputString += String.format("%.1f",(bonus+this.bonusBudget));
        if (team.size() > 0) {
            outputString += ", and is managing:";
            for (int i = 0; i < team.size(); i++) {
                outputString += "\n \t" + team.get(i).employeeStatus();
            }
        } else {
            outputString += " and no direct reports yet.";
        }
        return outputString;
    }
}
