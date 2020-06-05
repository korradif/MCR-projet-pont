import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SimpleTimeImpl extends TimeImpl implements ISimpleTime {
    protected ITime implTime;
    protected String sincronizedAt;
    protected String myImpl;

    public SimpleTimeImpl(int hrs, int min, String impl) {
        this.myImpl = impl;
        final Date currentTime = new Date();
        final SimpleDateFormat sdf =
                new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        sincronizedAt = "Not a syncronized time. Created at : " + sdf.format(currentTime) + ".";
        if(impl.equals("SimpleMilitaryTime")){
            this.implTime = new MilitaryTime(hrs, min);
        }else if(impl.equals("SimpleCivilianTime") ){
            this.implTime = new CivilianTime(hrs, min);
        }else{
            throw new IllegalArgumentException("Invalid implementation ! ");
        }

    }

    @Override
    public void tell() {
        implTime.tell();
    }

    @Override
    public void tellHrs() {
        implTime.tellHrs();
    }

    @Override
    public void tellMin() {
        implTime.tellMin();
    }
}
