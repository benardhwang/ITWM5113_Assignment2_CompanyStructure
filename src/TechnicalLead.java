import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    private int headCount;
    private ArrayList<SoftwareEngineer> team = new ArrayList<>();
    //private int totalCheckIns = 0;

    public TechnicalLead(String name) {
        super(name);
        super.setBaseSalary(1.3*super.getBaseSalary());
        setHeadCount(4);
    }

    public void setHeadCount(int i) {
        headCount = i;
    }

    public boolean hasHeadCount() {
        if (team.size() < headCount) {
            return true; }
        else {
            return false; }
    }

    public boolean addReport(SoftwareEngineer e) {
        if (hasHeadCount()) {
            team.add(e);
            e.setManager(this);
            return true;
        } else {
            return false;
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e) {
        if ((team.contains(e)) && (e.getCodeAccess())) {
            //this.totalCheckIns++;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean requestBonus(Employee e, double bonus) {
        return false;
    }

    public String getTeamStatus() {
        //get Team total check ins
        int checkInsCount = 0;
        for (int i = 0; i < team.size(); i++) {
            checkInsCount += team.get(i).getSuccessfulCheckIns();
        }

        String outputString = "";
        outputString += this.getEmployeeID() + " ";
        outputString += this.getName() + " ";
        outputString += "has ";
        outputString += checkInsCount + " successful check ins";
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

    public double getSalaries() {
        double salary = 0.0;
        for (int i = 0; i < this.team.size(); i++) {
            salary += team.get(i).getBaseSalary();
        }
        return salary;
    }
}
