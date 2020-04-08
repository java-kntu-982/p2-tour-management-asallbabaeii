package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Tour {
    private String tourName;
    private int longOf;
    private int price;
    private int maxParticipant;
    private int minParticipant;
    private String origin;
    private String destination;
    private boolean isAboard;
    private String theWholePlease;
    private TourLeader leader;
    private boolean flag = false;
    private static final ArrayList<SpectacularLocation> locations = new ArrayList<>();


    public Tour(String tourName, int longOf, int price, int maxParticipant, int minParticipant) {
        this.tourName = tourName;
        this.longOf = longOf;
        this.price = price;
        this.maxParticipant = maxParticipant;
        this.minParticipant = minParticipant;
    }

    public int getLongOf() {
        return longOf;
    }

    public void setLongOf(int longOf) {
        this.longOf = longOf;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxParticipant() {
        return maxParticipant;
    }

    public void setMaxParticipant(int maxParticipant) {
        this.maxParticipant = maxParticipant;
    }

    public int getMinParticipant() {
        return minParticipant;
    }

    public void setMinParticipant(int minParticipant) {
        this.minParticipant = minParticipant;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDAndO(String destination) {
        this.destination = destination;
    }

    public boolean isAboard() {
        return isAboard;
    }

    public void setAboard(boolean aboard) {
        isAboard = aboard;
    }

    public String getTheWholePlease() {
        return theWholePlease;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public void setTheWholePlease(String theWholePlease) {
        this.theWholePlease = theWholePlease;
    }

    public TourLeader getLeader() {
        return leader;
    }

    public void setLeader(TourLeader leader) {
        this.leader = leader;
    }

    public String whereAreYouOnYourChosenDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the day you want to see where the tour is");
        int count = scanner.nextInt();
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getCountForDay() == count) {

                flag = true;
                if (flag) {
                    return locations.get(i).getLocationName();
                }
            }
        }
        if (flag == false) {
            return "The tour is not define";
        }
        return null;
    }

    public void addToRegion(ArrayList<SpectacularLocation> areas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the city");
        String cityName = scanner.nextLine();
        for (int j = 0; j < areas.size(); j++) {
            if (areas.get(j).getLocationName().equals(cityName)) {
                //areas.get(j).setLocationName(cityName);
                flag = true;
            }
            if (flag) {
                areas.get(j).setLocationName(cityName);
            }
        }
        if (flag == false) {
            System.out.println("Define region!");
            return;
        }
        System.out.printf("---Tour date");
        System.out.println();
        System.out.println("Enter year");
        String Year = scanner.nextLine();
        if (!Year.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int year = Integer.parseInt(Year);
        System.out.println("Enter month");
        String Month = scanner.nextLine();
        if (!Month.matches("\\d")) {
            System.out.println("something wrong");
            return;
        }
        int month = Integer.parseInt(Month);
        System.out.println("Enter day");
        String Day = scanner.nextLine();
        if (!Day.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int day = Integer.parseInt(Day);
        MyDate date = new MyDate(year, month, day);
        System.out.println("Say in which day you want to visit this place");
        String c = scanner.nextLine();
        if (!c.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int count = Integer.parseInt(c);
        if (count > longOf || count == 1 || count == count - 1) {
            System.out.println("Out of rang");
            return;
        }
        SpectacularLocation location1 = new SpectacularLocation(cityName, date, count);
        locations.add(location1);
    }

    public void addToRegion2(ArrayList<SpectacularLocation> areas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the location");
        String locationName = scanner.nextLine();
        for (int j = 0; j < areas.size(); j++) {
            if (areas.get(j).getLocationName().equals(locationName)) {
                flag = true;
            }
            if (flag) {
                areas.get(j).setLocationName(locationName);
            }
        }
        if (flag == false) {
            System.out.println("Define region!");
            return;
        }
        System.out.println("---Tour date");
        System.out.println();
        System.out.println("Enter year");
        String Y = scanner.nextLine();
        if (!Y.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int year = Integer.parseInt(Y);
        System.out.println("Enter month");
        String M = scanner.nextLine();
        if (!M.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int month = Integer.parseInt(M);
        System.out.println("Enter day");
        String D = scanner.nextLine();
        if (!D.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int day = Integer.parseInt(D);
        MyDate date = new MyDate(year, month, day);
        System.out.println("Say in which day you want to visit this place");
        String c = scanner.nextLine();
        if (!c.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int count = Integer.parseInt(c);
        if (count > longOf) {
            System.out.println("Out of rang");
        }
        SpectacularLocation location1 = new SpectacularLocation(locationName, date, count);
        locations.add(location1);
    }

    public void removeRegion() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of the region");
        String cityName = in.nextLine();
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getLocationName().equals(cityName))
                locations.remove(i);
        }
    }

    public void editRegion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the city");
        String name = scanner.nextLine();
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getLocationName().equals(name)) {
                System.out.println("Enter new name");
                String newName = scanner.nextLine();
                System.out.println("---Travel date");
                System.out.println();
                System.out.println("Enter year");
                int year = scanner.nextInt();
                System.out.println("Enter month");
                int month = scanner.nextInt();
                System.out.println("Enter day");
                int day = scanner.nextInt();
                MyDate date = new MyDate(year, month, day);
                locations.get(i).setLocationName(newName);
                locations.get(i).setDate(date);
            }


        }
    }

    public boolean isAboardOrNot(String typOfTour) {

        if (typOfTour.equals("aboard")) {
            isAboard = true;
        }
        if (typOfTour.equals("domestic")) {
            isAboard = false;
        }
        return isAboard;
    }

    public boolean isDefineOrNot() {
        if (locations.isEmpty() == true) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Tour:" +
                "tourName='" + tourName + "\n" +
                ", longOf=" + longOf + "\n" +
                ", price=" + price + "\n" +
                ", maxParticipant=" + maxParticipant + "\n" +
                ", minParticipant=" + minParticipant + "\n" +
                ", origin='" + origin + "\n" +
                ", destination='" + destination + "\n" +
                ", isAboard=" + isAboard + "\n" +
                ", theWholePlease='" + theWholePlease + "\n" +
                ", leader=" + leader + "\n";
    }

    public ArrayList<SpectacularLocation> getLocations() {
        return locations;
    }

    public boolean searchInLocations(String locationName) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getLocationName().equals(locationName)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchInDate1(MyDate date) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getDate().getYear() > date.getYear()
                    && locations.get(i).getDate().getMonth() > date.getMonth()
                    && locations.get(i).getDate().getDay() > date.getDay()) {
                return true;
            }
        }
        return false;
    }

    public boolean searchInDate2(MyDate date) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getDate().getYear() < date.getYear()
                    && locations.get(i).getDate().getMonth() < date.getMonth()
                    && locations.get(i).getDate().getDay() < date.getDay()) {
                return true;
            }
        }
        return false;
    }

    public boolean searchInDate3(MyDate date1, MyDate date2) {
        for (int i = 0; i < locations.size(); i++) {
            if (date1.getYear() < locations.get(i).getDate().getYear() &&
                    date2.getYear() < locations.get(i).getDate().getYear() &&
                    date1.getMonth() < locations.get(i).getDate().getMonth() &&
                    date2.getMonth() < locations.get(i).getDate().getMonth()
                    && date1.getDay() < locations.get(i).getDate().getDay() &&
                    date2.getDay() < locations.get(i).getDate().getDay()) {
                return true;
            }
        }
        return false;
    }

    public String searchDate(MyDate date) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getDate().equals(date)) {
                return locations.get(i).getLocationName();
            }
        }
        return null;
    }

    public String searchLocation() {
        for (int i = 0; i < locations.size(); i++) {
            return locations.get(i).getLocationName();
        }
        return null;
    }
}
