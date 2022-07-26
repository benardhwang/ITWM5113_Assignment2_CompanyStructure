public class SoftwareEngineer extends TechnicalEmployee{

    private boolean codeAccess;


    //Default SE Code assess privileges is no = disallow to change code
    public SoftwareEngineer(String name) {
        super(name);
        this.codeAccess = false; //start without access to code
    }

    //return the SE is it have access to make changes the code base
    public boolean getCodeAccess() {
        return this.codeAccess;
    }

    //Allow or disallow SE code privileges to change the code
    public void setCodeAccess(boolean access) {
        this.codeAccess = access;

    }

    //Check in to code
    public boolean checkInCode() {
        // Need to verify if manager approves checkIn. Return true and increment checkIns by 1. Else, false.
        TechnicalLead manager = (TechnicalLead)this.getManager(this);
        if (manager.approveCheckIn(this)) {
            //checkIns++;
            this.checkIn();
            return true;
        } else {
            this.codeAccess = false;
            return false;
        }
    }

}
