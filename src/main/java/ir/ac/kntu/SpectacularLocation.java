package ir.ac.kntu;

public class SpectacularLocation {

    private String locationName;
    private MyDate date;
    private int countForDay;

    public SpectacularLocation(String locationName, MyDate date, int countForDay) {
        this.locationName = locationName;
        this.date = date;
        this.countForDay = countForDay;
    }

    public SpectacularLocation(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public int getCountForDay() {
        return countForDay;
    }

    public void setCountForDay(int countForDay) {
        this.countForDay = countForDay;
    }

    @Override
    public String toString() {
        return "SpectacularLocation{" +
                "locationName='" + locationName + '\'' +
                ", date=" + date +
                ", in this day we are in=" + countForDay +
                '}';
    }
}
