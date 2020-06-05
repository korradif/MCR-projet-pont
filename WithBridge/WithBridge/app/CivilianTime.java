public class CivilianTime extends Time implements ICivilianTime {

    public CivilianTime(int hrs, int min) {
        super(hrs, min);
    }

    @Override
    public int getHrs() {
        return this.hrs;
    }

    @Override
    public int getMins() {
        return this.min;
    }

    @Override
    public void setHrs(int hrs) {
        this.hrs = hrs;
    }

    @Override
    public void setMins(int mins) {
        this.min = mins;
    }

    @Override
    public void tell() {

        System.out.println("Civilian time : " + this.getAmPmHours() + " and " + min + " minutes.");
    }

    @Override
    public void tellHrs() {

        System.out.println("Civilian time : "  +  this.getAmPmHours() + ".");
    }

    @Override
    public void tellMin() {

        System.out.println("Civilian hours : " + this.min +" minutes.");
    }

    @Override
    public String getAmPmHours() {
        String ampm;
        if(this.hrs > 12){
            ampm = (this.hrs - 12 ) +" pm";
        }else {
            ampm = hrs +" am";
        }
        return ampm;
    }
}

