
public class OrderDate {
    private final int day;
    private final int month;
    private final int year;

    public OrderDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getFormattedDate() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
}

