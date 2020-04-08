package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class TourLeader {
    private static final ArrayList<SpectacularLocation> locations = new ArrayList<>();
    private static final ArrayList<Tour> tours = new ArrayList<>();
    private String firstName;
    private String lastName;
    private int nationalCode;
    private int ID;
    private String maritalStatus;
    private MyDate birthDay;
    private MyDate recruitmentDate;


    public TourLeader(String firstName, String lastName, int nationalCode, int ID, String maritalStatus, MyDate birthDay, MyDate recruitmentDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.ID = ID;
        this.maritalStatus = maritalStatus;
        this.birthDay = birthDay;
        this.recruitmentDate = recruitmentDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }//.length

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }//.length

    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }//regex

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public MyDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(MyDate birthDay) {
        this.birthDay = birthDay;
    }

    public MyDate getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(MyDate recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }//equal

    public int getAge() {
        return 1399 - birthDay.getYear();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public static ArrayList<SpectacularLocation> getLocations() {
        return locations;
    }

    public static ArrayList<Tour> getTour() {
        return tours;
    }

    public boolean equals(TourLeader input) {
        if (this.firstName == input.firstName && this.lastName == input.lastName && this.ID == input.ID &&
                this.nationalCode == input.nationalCode && this.recruitmentDate.equals(input) &&
                this.birthDay.equals(input) && this.maritalStatus == input.maritalStatus) {
            return true;//
        }
        return false;
    }

    public String toString() {
        return "TourLeader:" + "\n" +
                "firstName='" + firstName + "\n" +
                ", lastName='" + lastName + "\n" +
                ", nationalCode=" + nationalCode + "\n" +
                ", ID=" + ID + "\n" +
                ", birthDay=" + birthDay + "\n" +
                ", recruitmentDate=" + recruitmentDate + "\n" +
                ", maritalStatus='" + maritalStatus + "\n";
    }

    public boolean KnowsCity(String cityName) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getLocationName().equals(cityName)) {
                return true;
            }
        }
        System.out.println("Not found!");
        return false;
    }

    public void addToKnowplace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The travel is domestic or aboard?");
        String typ = scanner.nextLine();
        if (typ.equals("help")) {
            System.out.println("we want to know you add locations or cities");
            addToKnowplace();
        }
        if (typ.equals("aboard")) {
            addToRegion();
        }
        if (typ.equals("domestic")) {
            addToRegion2();
        }
    }

    public void removeCityKnow() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of city or location");
        String cityName = in.nextLine();
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getLocationName() == cityName)
                locations.remove(i);
        }
    }

    public void addToRegion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the city or country");
        String cityName = scanner.nextLine();
        SpectacularLocation location1 = new SpectacularLocation(cityName);
        locations.add(location1);
    }

    public void addToRegion2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the location or city");
        String locationName = scanner.nextLine();
        SpectacularLocation location1 = new SpectacularLocation(locationName);
        locations.add(location1);
    }

    public boolean searchInKnowRegion(String regionName) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getLocationName().equals(regionName)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchInLeaderDate(MyDate date) {
        if (tours.isEmpty()) {
            return true;
        }
        for (int j = 0; j < tours.size(); j++) {
            for (int i = 0; i < tours.get(i).getLocations().size(); i++) {
                if (tours.get(j).getLocations().get(i).getDate().equals(date)) {
                    System.out.println(j + " " + i + " " + date);
                    return false;
                }

            }
        }
        return true;
    }

    public void setTour(Tour tour) {
        tours.add(tour);
    }
}
