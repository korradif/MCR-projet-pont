public interface ITime {
    int getHrs();
    int getMins();
    void setHrs(int hrs);
    void setMins(int mins);
    void tell();
    void tellHrs();
    void tellMin();
}
