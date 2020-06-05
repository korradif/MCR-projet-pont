public class MilitaryTime extends Time implements IMilitaryTime{

    public MilitaryTime(int hrs, int min) {
        super(hrs, min);
    }

    @Override
    public int getHrs() {
        return  this.hrs;
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

        if(min < 10){
            if(hrs < 10 ){
                System.out.println("Military times : 0" + hrs + "0" + min);
            }else {
                System.out.println("Military times : " + hrs + "0" + min);
            }
        }else {
            if(hrs < 10){
                System.out.println("Military times : 0" + hrs + "" +min);
            }else {
                System.out.println("Military times : " + hrs + "" +min);
            }

        }
    }

    @Override
    public void tellHrs() {
        if(hrs < 10){
            System.out.println("Military hours : 0"+ hrs + "00" );
        }else {
            System.out.println("Military hours : "+ hrs + "00" );
        }

    }

    @Override
    public void tellMin() {
        if(min < 10){
            System.out.println("Military minutes : 00"+ "0" +min);
        }else {
            System.out.println("Military minutes : 00"+ "" +min);
        }

    }
}

