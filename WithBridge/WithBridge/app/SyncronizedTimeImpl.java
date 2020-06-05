import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SyncronizedTimeImpl extends TimeImpl implements ISyncronizedTime {
    protected ITime implTime;
    protected String sincronizedAt;
    protected String myImpl;

    public SyncronizedTimeImpl(int hrs, int min, String impl) {
        this.myImpl = impl;
        final Date currentTime = new Date();
        final SimpleDateFormat sdf =
                new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        sincronizedAt = "Not a syncronized time. Created at : " + sdf.format(currentTime) + ".";
        if(impl.equals("SyncronizedCivilTime")){
            this.implTime = new CivilianTime(hrs, min);
        }else if(impl.equals("SyncronizedMilitaryTime") ){
            this.implTime = new MilitaryTime(hrs, min);
        }else{
            throw new IllegalArgumentException("Invalid implementation ! ");
        }

    }

    @Override
    public void sync() {
        final Date currentTime = new Date();
        final SimpleDateFormat sdf =
                new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");
        final SimpleDateFormat hours =
                new SimpleDateFormat("HH");
        final SimpleDateFormat minutes =
                new SimpleDateFormat("mm");

        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.sincronizedAt = "GMT Syncronized : " + sdf.format(currentTime) + ".";
        this.implTime.setHrs(Integer.parseInt(hours.format(currentTime)));
        this.implTime.setMins(Integer.parseInt(minutes.format(currentTime)));
    }

    @Override
    public int getHrs() {
        return this.implTime.getHrs();
    }

    @Override
    public int getMins() {
        return this.implTime.getMins();
    }

    @Override
    public void setHrs(int hrs) {
        this.implTime.setHrs(hrs);
    }

    @Override
    public void setMins(int mins) {
        this.implTime.setMins(mins);
    }

    @Override
    public void tell() {
        this.sync();
        this.implTime.tell();
        System.out.println(this.sincronizedAt);
    }

    @Override
    public void tellHrs() {
        this.sync();
        this.implTime.tellHrs();
        System.out.println(this.sincronizedAt);
    }

    @Override
    public void tellMin() {
        this.sync();
        this.implTime.tellMin();
        System.out.println(this.sincronizedAt);
    }
}
