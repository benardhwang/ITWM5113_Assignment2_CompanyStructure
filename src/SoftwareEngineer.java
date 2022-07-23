public class SoftwareEngineer extends TechnicalEmployee{
    private boolean codeAccess;

    //Default SE Code assess privileges is no = disallow to change code
    public SoftwareEngineer(String name) {
        super(name);
        this.codeAccess = false;
    }

    //return the SE is it have access to make changes the code base
    public boolean getCodeAccess() {
        return this.codeAccess;
    }

    //Allow or disallow SE code privileges to changes the code
    public void setCodeAccess(boolean access) {
        if (access) {
            this.codeAccess = true;
        }
        else {
            this.codeAccess = false;
        }

    }

    //Check in to code
    public boolean checkInCode() {
        // Need to verify if manager approves checkIn. Return true and increment checkIns by 1. Else, false.
        TechnicalLead manager = (TechnicalLead)this.getManager(this);
        if (manager.approveCheckIn(this)) {
            super.checkIn();
            return true;
        } else {
            if (codeAccess) { codeAccess = false; }
            return false;
        }
    }

    public int getSuccessfulCheckIns() {
        return super.getSuccessfulCheckIns();
    }

    public String employeeStatus() {
        return this.getEmployeeID() + " " + this.getName() + " has " + this.getSuccessfulCheckIns() + " successful check ins.";
    }

}
