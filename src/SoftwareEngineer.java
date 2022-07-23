public class SoftwareEngineer extends TechnicalEmployee{

    private int checkIns;
    private boolean codeAccess;


    //Default SE Code assess privileges is no = disallow to change code
    public SoftwareEngineer(String name) {
        super(name);
        this.codeAccess = false; //start without access to code
        this.checkIns = 0; //start with 0 code check ins
    }

    //return the SE is it have access to make changes the code base
    public boolean getCodeAccess() {
        return this.codeAccess;
    }

    //Allow or disallow SE code privileges to change the code
    public void setCodeAccess(boolean access) {
        this.codeAccess = access;

    }

    public int getSuccessfulCheckIns() {
        return this.checkIns;
    }

    //Check in to code
    public boolean checkInCode() {
        // Need to verify if manager approves checkIn. Return true and increment checkIns by 1. Else, false.
        TechnicalLead manager = (TechnicalLead)this.getManager(this);
        if (manager.approveCheckIn(this)) {
            checkIns++;
            return true;
        } else {
            this.codeAccess = false;
            return false;
        }
    }

    public int getCheckIns(){
        return this.checkIns;
    }

}
