/***
 * Create an an class that vrape and delegate all request to it
 */
public class TimeImpl implements ITimeImpl {
    protected ITime timeImplementation;

    public TimeImpl(int hrs, int mins, String impl){
        if(impl.equals("SimpleCivilianTime")){
            this.timeImplementation = new CivilianTime(hrs, mins);
        }else if(impl.equals("SimpleMilitaryTime")){
            this.timeImplementation = new CivilianTime(hrs, mins);
        }else if(impl.equals("SyncronizedCivilTime")) {
            this.timeImplementation = new SyncronizedTimeImpl(hrs,mins,impl);
        }else if(impl.equals("SyncronizedMilitaryTime")){
            this.timeImplementation = new SyncronizedTimeImpl(hrs,mins, impl);
        }else{
            throw new IllegalArgumentException("Invalid implementation ! ");
        }
    }

    public TimeImpl(int hrs, int min){
        this( hrs, min, "SimpleCivilianTime");
    }


    public TimeImpl(){
        this( 0,0, "SimpleCivilianTime");
    }

    @Override
    public int getHrs() {
        return this.timeImplementation.getHrs();
    }

    @Override
    public int getMins() {
        return this.timeImplementation.getMins();
    }

    @Override
    public void setHrs(int hrs) {
        this.timeImplementation.setHrs(hrs);
    }

    @Override
    public void setMins(int mins) {
        this.timeImplementation.setMins(mins);
    }

    @Override
    public void tell() {
        this.timeImplementation.tell();
    }

    @Override
    public void tellHrs() {
        this.timeImplementation.tellHrs();
    }

    @Override
    public void tellMin() {
        this.timeImplementation.tellMin();
    }


    @Override
    public ITime getImplementation() {
        return this.timeImplementation;
    }
}

