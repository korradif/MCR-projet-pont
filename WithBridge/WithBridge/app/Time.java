public abstract class Time implements ITime{
    protected int hrs;
    protected int min;


    public Time(int hrs, int min) {
        if(!(hrs <= 24 && hrs >= 0 )||!(min <= 60 && min >= 0)){
            throw new IllegalArgumentException("Arguments invalid");
        }
        this.hrs = hrs;
        this.min = min;
    }

}

