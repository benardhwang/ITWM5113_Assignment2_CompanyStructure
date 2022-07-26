import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    private int headCount;
    private BusinessLead supportedBy;
    private ArrayList<SoftwareEngineer> team = new ArrayList<>();

    //Constructor of new Technical lead and it's default values
    public TechnicalLead(String name) {
        super(name);
        super.setManager(this);
        super.setBaseSalary(1.3*super.getBaseSalary());
        setHeadCount(4);
    }

    //Setting for head count report to the technical lead
    public void setHeadCount(int i) {
        headCount = i;
    }

    //Checking of the default headcount vs actual headcount
    public boolean hasHeadCount() {
        if (team.size() < headCount) {
            return true; }
        else {
            return false; }
    }

    //add reporting staff
    public boolean addReport(SoftwareEngineer e) {
        if (hasHeadCount()) {
            team.add(e);
            e.setManager(this);
            return true;
        } else {
            return false;
        }
    }

    //approve reporting staff check in
    public boolean approveCheckIn(SoftwareEngineer e) {
        if ((team.contains(e)) && (e.getCodeAccess())) {
            return true; //if employee does report to this manager and code access is true
        }
        else {
            return false;
        }
    }

    //request bonus with business lead support the technical lead
    public boolean requestBonus(Employee e, double bonus) {
        if(this.supportedBy.approveBonus(e, bonus)) {
            return true;
        }else {
            return false;
        }
    }

    //return teams status
    public String getTeamStatus() {
        //get Team total check ins
        int checkInsCount =0;
        for (int i = 0; i < team.size(); i++) {
            checkInsCount += team.get(i).getSuccessfulCheckIns();
        }

        String outputString = "";
        outputString = super.toString() + " has "+checkInsCount+" successful check ins";
        if (team.size() > 0) {
            outputString += ", and is managing.";
            for (int i = 0; i < team.size(); i++) {
                outputString += "\n \t" + team.get(i).employeeStatus();
            }
        } else {
            outputString += " and no direct reports yet.";
        }
        return outputString;
    }

    //return total team salary
    public double getSalaries() {
        double salary = 0.0;
        for (int i = 0; i < this.team.size(); i++) {
            salary += team.get(i).getBaseSalary();
        }
        return salary;
    }
}
