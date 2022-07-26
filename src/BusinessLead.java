import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee{
    private int headCount;
    private ArrayList<Accountant> team = new ArrayList<>();

    public BusinessLead(String name){
        super(name);
        //super.setManager(this);
        super.setBaseSalary(2*super.getBaseSalary()); //twice base salary of an accountant
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

    //add accountant and technical lead report to him/her
    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if (this.hasHeadCount()){
            this.team.add(e);
            e.setManager(this); //added 20220723
            e.supportTeam(supportTeam);
            this.setBonusBudget(this.getBonusBudget()+this.getBaseSalary()*1.1) ; //added 20220723
            this.currentlySupporting = supportTeam; //added 20220723
            return true;
        }else{
            return false;
        }

    }

    /**check if the bonus amount requested would fit in current
    BusinessLead's budget. If it is, that employee should get that
    bonus, the BusinessLeader's budget should be deducted and
    true should be returned. False should be returned otherwise
     */
    public boolean requestBonus(Employee e, double bonus){
        if (bonus < this.getBonusBudget()){ //check if the bonus amount requested fit in current businessLead budget
            this.setBonusBudget(this.getBonusBudget()- bonus); //businessLead budget should be deducted
            return true;
        }else {
            return false;
        }
    }

    /**Should check if the bonus amount requested would fit in current
     BusinessLead's budget. If it is, that employee should get that
     bonus, the BusinessLeader's budget should be deducted and
     true should be returned. False should be returned otherwise
     */
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

    public String getTeamStatus() {
        //get Team total bonus
        double bonus = 0;
        for (int i = 0; i < team.size(); i++) {
            bonus += team.get(i).getBonusBudget();
        }

        String outputString = "";
        outputString += this.getEmployeeID() + " ";
        outputString += this.getName() + " ";
        outputString += "with a budget of ";
        outputString += String.format("%.1f",bonus);
        //outputString += String.format("%.1f",(bonus+this.getBonusBudget()));
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
