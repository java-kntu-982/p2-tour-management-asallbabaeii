package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;
import net.sf.saxon.trace.XSLTTraceCodeInjector;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<TourLeader> tourLeaders = new ArrayList<>();
    private static final ArrayList<Tour> tours = new ArrayList<>();
    private static final ArrayList<SpectacularLocation> areas = new ArrayList<>();
    private static boolean flag = false;


    public static void main(String[] args) {
        mainMenu();
//        MapUtil.showMap("@29.6257966,52.5563165,17z");
    }

    public static void mainMenu() {
        // screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" -------------");
        System.out.println("1.Leaders menu");
        System.out.println("2.Tours menu");
        System.out.println("3.Region menu");
        System.out.println("4.Map menu");
        System.out.println("5.Exit...");
        System.out.println(" -------------");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("enter 1 to see leader menu and related activities to leader (add,remove,edit)");
            System.out.println("enter 2 to see tour menu and related activities to tour (add,remove,edit)");
            System.out.println("enter 3 to see area menu and related activities to area (add,remove,edit)");
            System.out.println("****Attention: define areas in part 3 before add area to the tour ");
            System.out.println("enter 4 to see places that related to the tour or not on map");
            mainMenu();
        }
        while (!input.equals("5")) {

            switch (input) {
                case "1":
                    // leader();
                    leaderMenu();
                    break;
                case "2":
                    //tour();
                    tourMenu();
                    break;
                case "3":
                    // region();
                    areaMenu();
                    break;
                case "4":
                    //map
                    mapMenu();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println(" -------------");
            System.out.println("1.Leaders menu");
            System.out.println("2.Tours menu");
            System.out.println("3.Region menu");
            System.out.println("4.Map menu");
            System.out.println("5.Exit...");
            System.out.println(" -------------");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("enter 1 to see leader menu and related activities to leader (add,remove,edit)");
                System.out.println("enter 2 to see tour menu and related activities to tour (add,remove,edit)");
                System.out.println("enter 3 to see area menu and related activities to area (add,remove,edit)");
                System.out.println("****Attention: define areas in part 3 before add area to the tour ");
                System.out.println("enter 4 to see places that related to the tour or not on map");
                mainMenu();
            }
        }
    }

    public static void leaderMenu() {
        //screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------");
        System.out.println("1.See All Leaders Listed");
        System.out.println("2.Add leader");
        System.out.println("3.Remove leader");
        System.out.println("4.Edit leader");
        System.out.println("5.search leader");
        System.out.println("6.Add to the cities that tour leader know");
        System.out.println("7.Back to menu...");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("enter 1 to see name of the all tour leaders in list");
            System.out.println("enter 2 to enter initial details of leader");
            System.out.println("enter 3 to remove tour leader that you want from list");
            System.out.println("enter 4 to edit tour leader that you want");
            System.out.println("enter 5 to go to the search menu and search leader by diffrent things");
            System.out.println("enter 6 to completing leader details with knowing area");
            leaderMenu();
        }
        while (!input.equals("7")) {

            switch (input) {
                case "1":
                    // addUser();
                    printLeaders();
                    break;
                case "2":
                    //removeUser();
                    addTourLeader();
                    break;
                case "3":
                    // editUser();
                    removeTourLeader();
                    break;
                case "4":
                    //search leader by
                    editTourLeader();
                    break;
                case "5":
                    //for add know city
                    searchForTourLeader();
                    break;
                case "6":
                    //cities that he know
                    regionKnowLeader();
                    break;
                case "7":
                    mainMenu();
                default:
                    System.out.printf("Invalid input");
                    break;
            }
            System.out.println("-------------");
            System.out.println("1.See All Leaders Listed");
            System.out.println("2.Add leader");
            System.out.println("3.Remove leader");
            System.out.println("4.Edit leader");
            System.out.println("5.search leader");
            System.out.println("6.Add to the cities that tour leader know");
            System.out.println("7.Back to menu...");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("enter 1 to see name of the all tour leaders in list");
                System.out.println("enter 2 to enter initial details of leader");
                System.out.println("enter 3 to remove tour leader that you want from list");
                System.out.println("enter 4 to edit tour leader that you want");
                System.out.println("enter 5 to go to the search menu and search leader by diffrent things");
                System.out.println("enter 6 to completing leader details with knowing area");
                leaderMenu();
            }
        }
    }

    public static void addTourLeader() {
        //screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name of leader");
        String firstName = scanner.nextLine();
        if (firstName.equals("help")) {
            System.out.println("first name of leader should be more than 3 character");
            addTourLeader();
        }
        if (firstName.length() < 3) {
            System.out.println("Invalid input");
            return;
        }
        if (firstName.matches("\\d+")) {
            System.out.println("wrong input name can not be number");
            return;
        }
        System.out.println("Enter last name of leader");
        String lastName = scanner.nextLine();
        if (lastName.equals("help")) {
            System.out.println("last name of leader should be more than 3 character");
            addTourLeader();
        }
        if (lastName.length() < 3) {
            System.out.println("Invalid input");
            return;
        }
        if (firstName.matches("\\d+")) {
            System.out.println("wrong input name can not be number");
            return;
        }
        System.out.println("Enter national code of leader");
        String nationalCode = scanner.nextLine();
        if (!nationalCode.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int nCode = Integer.parseInt(nationalCode);
        System.out.println("Enter ID of leader");
        String ID = scanner.nextLine();
        if (!ID.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int id = Integer.parseInt(ID);
        System.out.println("Enter marital status");
        String maritalStatus = scanner.nextLine();
        if (maritalStatus.equals("help")) {
            System.out.println("you should enter single or in relationship");
            addTourLeader();
        }
        System.out.println("---birthday date");
        System.out.println("Enter year");
        String yearOfBirth = scanner.nextLine();
        if (yearOfBirth.equals("help")) {
            System.out.println("year of birth should be in this form -> 13..");
            addTourLeader();
        }
        if (!yearOfBirth.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int yearBirth = Integer.parseInt(yearOfBirth);
        if (yearBirth > 1400 || yearBirth < 1300) {
            System.out.println("Invalid input");
            return;
        }
        System.out.println("Enter month");
        String monthOfBirth = scanner.nextLine();
        if (monthOfBirth.equals("help")) {
            System.out.println("you can enter this part in these two form 0x or x");
            addTourLeader();
        }
        if (!monthOfBirth.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int monthBirth = Integer.parseInt(monthOfBirth);
        if (monthBirth < 0 || monthBirth > 13) {
            System.out.println("Invalid input");
            return;
        }
        System.out.println("Enter day");
        String dayOfBirth = scanner.nextLine();
        if (dayOfBirth.equals("help")) {
            System.out.println("you should enter positive number and fewer than 31");
            addTourLeader();
        }
        if (!dayOfBirth.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int birthODay = Integer.parseInt(dayOfBirth);
        if (birthODay > 32 || birthODay < 0) {
            System.out.println("Invalid input");
            return;
        }
        MyDate birthDay = new MyDate(yearBirth, monthBirth, birthODay);
        System.out.println("---Recruitment date");
        System.out.println("Enter year");
        String yearOfRecruitment = scanner.nextLine();
        if (yearOfRecruitment.equals("help")) {
            System.out.println("year of birth should be in this form -> 13..");
            addTourLeader();
        }
        if (!yearOfRecruitment.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int year = Integer.parseInt(yearOfRecruitment);
        if (year > 1400 || year < 1300) {
            System.out.println("Invalid input");
            return;
        }
        System.out.println("Enter month");
        String monthOfRecruitment = scanner.nextLine();
        if (monthOfRecruitment.equals("help")) {
            System.out.println("you can enter this part in these two form 0x or x");
            addTourLeader();
        }
        if (!monthOfRecruitment.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int month = Integer.parseInt(monthOfRecruitment);
        if (month < 0 || month > 13) {
            System.out.println("Invalid input");
            return;
        }
        System.out.println("Enter day");
        String dayOfRecruitment = scanner.nextLine();
        if (dayOfRecruitment.equals("help")) {
            System.out.println("you should enter positive number and fewer than 31");
            addTourLeader();
        }
        if (!dayOfRecruitment.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int day = Integer.parseInt(dayOfRecruitment);
        if (day > 32 || day < 0) {
            System.out.println("Invalid input");
            return;
        }
        MyDate Recruitment = new MyDate(year, month, day);
        TourLeader leader = new TourLeader(firstName, lastName, nCode, id, maritalStatus, birthDay, Recruitment);
        tourLeaders.add(leader);
    }

    public static void removeTourLeader() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter leader ID");
        String ID = in.nextLine();
        if (ID.equals("help")) {
            System.out.println("enter of considered leader to find & remove it");
            leaderMenu();
        }
        if (!ID.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        flag = false;
        int Id = Integer.parseInt(ID);
        for (int i = 0; i < tourLeaders.size(); i++) {
            if (tourLeaders.get(i).getID() == Id) {
                flag = true;
                if (flag) {
                    tourLeaders.remove(i);
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not be found");
        }
    }

    public static void editTourLeader() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter ID of leader");
        String ID = in.nextLine();
        if (ID.equals("help")) {
            System.out.println("enter of considered leader to find & remove it");
            leaderMenu();
        }
        if (!ID.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        flag = false;
        int Id = Integer.parseInt(ID);
        for (int i = 0; i < tourLeaders.size(); i++) {
            if (tourLeaders.get(i).getID() == Id) {
                flag = true;
                if (flag) {
                    System.out.println("Enter first name of leader");
                    String firstName = in.nextLine();
                    if (firstName.length() < 3) {
                        System.out.println("Invalid input");
                        return;
                    }
                    if (firstName.matches("\\d+")) {
                        System.out.println("wrong input name can not be number");
                        return;
                    }
                    System.out.println("Enter last name of leader");
                    String lastName = in.nextLine();
                    if (lastName.length() < 3) {
                        System.out.println("Invalid input");
                        return;
                    }
                    if (lastName.matches("\\d+")) {
                        System.out.println("wrong input name can not be number");
                        return;
                    }
                    System.out.println("Enter marital status");
                    String maritalStatus = in.nextLine();
                    System.out.println("Enter Id of leader");
                    int id = in.nextInt();
                    System.out.println("Enter national code of leader");
                    int nationalCode = in.nextInt();
                    System.out.println("---Birthday date");
                    System.out.println("Enter year");
                    int birthYear = in.nextInt();
                    if (birthYear > 1400 || birthYear < 1300) {
                        System.out.println("Invalid input");
                        return;
                    }
                    System.out.println("Enter month");
                    int birthMonth = in.nextInt();
                    if (birthMonth < 0 || birthMonth > 13) {
                        System.out.println("Invalid input");
                        return;
                    }
                    System.out.println("Enter day");
                    int birthday = in.nextInt();
                    if (birthday > 32 || birthday < 0) {
                        System.out.println("Invalid input");
                        return;
                    }
                    MyDate birthDay = new MyDate(birthYear, birthMonth, birthday);
                    System.out.println("---Recruitment date");
                    System.out.println("Enter year");
                    int recruitmentYear = in.nextInt();
                    if (recruitmentYear < 1300 || recruitmentYear > 1400) {
                        System.out.println("Invalid input");
                        return;
                    }
                    System.out.println("Enter month");
                    int recruitmentMonth = in.nextInt();
                    if (recruitmentMonth > 13 || recruitmentMonth < 0) {
                        System.out.println("Invalid input");
                        return;
                    }
                    System.out.println("Enter day");
                    int recruitmentDay = in.nextInt();
                    if (recruitmentDay < 0 || recruitmentDay > 32) {
                        System.out.println("Invalid input");
                        return;
                    }
                    MyDate recruitment = new MyDate(recruitmentYear, recruitmentMonth, recruitmentDay);
                    tourLeaders.get(i).setFirstName(firstName);
                    tourLeaders.get(i).setLastName(lastName);
                    tourLeaders.get(i).setID(id);
                    tourLeaders.get(i).setNationalCode(nationalCode);
                    tourLeaders.get(i).setBirthDay(birthDay);
                    tourLeaders.get(i).setRecruitmentDate(recruitment);
                    tourLeaders.get(i).setMaritalStatus(maritalStatus);
                }

            }
        }
        if (flag == false) {
            System.out.println("Could not be found");
        }
    }

    public static void searchForTourLeader() {
        screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("1.Search leader by first name");
        System.out.println("2.Search leader by last name");
        System.out.println("3.Search leader by region");
        System.out.println("4.Search leader by age");
        System.out.println("5.For back to the leader menu");
        System.out.println("----------------");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("enter 1 to search leader by first name");
            System.out.println("enter 2 to search leader by last name");
            System.out.println("enter 3 to search leader by region that he know");
            System.out.println("enter 4 to search leader by his age");
            searchForTourLeader();
        }
        while (!input.equals("5")) {
            switch (input) {
                case "1":
                    searchLeaderByFirstName();
                    break;
                case "2":
                    searchLeaderByLastName();
                    break;
                case "3":
                    //region
                    searchByRegion1();
                    break;
                case "4":
                    searchLeaderByAge();
                    break;
                case "5":
                    leaderMenu();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("----------------");
            System.out.println("1.Search leader by first name");
            System.out.println("2.Search leader by last name");
            System.out.println("3.Search leader by region");
            System.out.println("4.Search leader by age");
            System.out.println("5.For back to the leader menu");
            System.out.println("----------------");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("enter 1 to search leader by first name");
                System.out.println("enter 2 to search leader by last name");
                System.out.println("enter 3 to search leader by region that he know");
                System.out.println("enter 4 to search leader by his age");
                searchForTourLeader();
            }
        }
    }

    public static void searchLeaderByFirstName() {
        System.out.println("Enter leader first Name:");
        Scanner scanner = new Scanner(System.in);
        String leaderFirstName = scanner.nextLine();
        if (leaderFirstName.equals("help")) {
            System.out.println("in this part we show leaders that match with this given first name");
            searchLeaderByFirstName();
        }
        if (leaderFirstName.length() < 3) {
            System.out.println("Invalid input");
            return;
        }
        flag = false;
        for (int i = 0; i < tourLeaders.size(); i++) {
            if (tourLeaders.get(i).getFirstName().equals(leaderFirstName) || leaderFirstName.equals("")) {
                flag = true;
                if (flag) {
                    System.out.println(tourLeaders.get(i).toString());
                }

            }
        }
        if (flag == false) {
            System.out.println("Could not be found!");
        }
    }

    public static void searchLeaderByLastName() {
        System.out.println("Enter leader last Name:");
        Scanner scanner = new Scanner(System.in);
        String leaderLastName = scanner.nextLine();
        if (leaderLastName.equals("help")) {
            System.out.println("enter your leader last name we found it if exit");
            searchLeaderByLastName();
        }
        flag = false;
        for (int i = 0; i < tourLeaders.size(); i++) {
            if (tourLeaders.get(i).getLastName().equals(leaderLastName)) {
                flag = true;
                if (flag) {
                    System.out.println(tourLeaders.get(i).toString());
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not be found!");
        }
    }

    public static void searchLeaderByAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter age of leader");
        String Age = scanner.nextLine();
        if (Age.equals("help")) {
            System.out.println("enter age of leader that you want we found it for you");
            searchLeaderByAge();
        }
        if (!Age.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int age = scanner.nextInt();
        flag = false;
        for (int i = 0; i < tourLeaders.size(); i++) {
            if (tourLeaders.get(i).getAge() == age) {
                flag = true;
                if (flag) {
                    System.out.println(tourLeaders.get(i).getFullName());
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not be found!");
        }
    }

    public static void searchByRegion1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the country,city or place");
        String cityName = scanner.nextLine();
        if (cityName.equals("help")) {
            System.out.println("enter regions that you want to we show you leaders that know these places");
            searchByRegion1();
        }
        flag = false;
        for (int i = 0; i < tourLeaders.size(); i++) {
            if (tourLeaders.get(i).KnowsCity(cityName)) {
                flag = true;
                if (flag) {
                    System.out.println(tourLeaders.get(i));
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not be found!");
        }
    }

    public static void printLeaders() {
        for (int i = 0; i < tourLeaders.size(); i++) {
            System.out.println((i + 1) + "." + tourLeaders.get(i).getFullName());////////////////////////////////////
            if ((i + 1) % 5 == 0) {

            }
        }
    }

    public static void regionKnowLeader() {
        //screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("1.For add region");
        System.out.println("2.For remove region");
        System.out.println("3.For back to menu");
        System.out.println("----------------");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("enter 1 to add region to list of regions that leader know");
            System.out.println("enter 2 to remove region from list of regions that leader know");
            System.out.println("****Attention there are importent for when you wanna add leader for tour");
            regionKnowLeader();
        }
        while (!input.equals("3")) {
            switch (input) {
                case "1":
                    addCityLeaderKnow();
                    break;
                case "2":
                    removeCityThatLeaderKnow();
                    break;
                case "3":
                    leaderMenu();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("----------------");
            System.out.println("1.For add region");
            System.out.println("2.For remove region");
            System.out.println("3.For back to menu");
            System.out.println("----------------");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("enter 1 to add region to list of regions that leader know");
                System.out.println("enter 2 to remove region from list of regions that leader know");
                System.out.println("****Attention there are importent for when you wanna add leader for tour");
                regionKnowLeader();
            }
        }
    }

    public static void addCityLeaderKnow() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID of leader");
        String ID = scanner.nextLine();
        if (ID.equals("help")) {
            System.out.println("sho should add places that leader know them");
            addCityLeaderKnow();
        }
        if (!ID.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        flag = false;
        int id = Integer.parseInt(ID);
        for (int i = 0; i < tourLeaders.size(); i++) {
            if (tourLeaders.get(i).getID() == id) {
                flag = true;
                if (flag) {
                    tourLeaders.get(i).addToKnowplace();
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found!");
        }
    }

    public static void removeCityThatLeaderKnow() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID of leader");
        String ID = scanner.nextLine();
        if (ID.equals("help")) {
            System.out.println("enter of considered leader to find & remove city from his list");
            leaderMenu();
        }
        if (!ID.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        flag = false;
        int Id = Integer.parseInt(ID);
        for (int i = 0; i < tourLeaders.size(); i++) {
            if (tourLeaders.get(i).getID() == Id) {
                flag = true;
                if (flag) {
                    tourLeaders.get(i).removeCityKnow();
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found");
        }
    }

    public static void tourMenu() {
        // screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------");
        System.out.println("1.View tours");
        System.out.println("2.Add tour");
        System.out.println("3.Edit tour");
        System.out.println("4.Remove tour");
        System.out.println("5.search tour");
        System.out.println("6.completing tour data");
        System.out.println("7.Back to menu...");
        System.out.println("-------------");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("enter 1 to go to the print tours menu");
            System.out.println("enter 2 to enter initial details of tour");
            System.out.println("enter 3 to edit details of chosen tour");
            System.out.println("enter 4 to remove chosen tour");
            System.out.println("enter 5 tp go to the search menu");
            System.out.println("enter 6 to go to the complite details of tour like(add region,add leader,...");
            tourMenu();
        }
        while (!input.equals("7")) {

            switch (input) {
                case "1":
                    //view x:/
                    printTourMenu();
                    break;
                case "2":
                    addTour();
                    break;
                case "3":
                    // editUser();
                    editTour();
                    break;
                case "4":
                    //remove
                    removeTour();
                    break;
                case "5":
                    //searches
                    searchTourMenu();
                    break;
                case "6":
                    tourRegionMenu();
                    break;
                case "7":
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("-------------");
            System.out.println("1.View tours");
            System.out.println("2.Add tour");
            System.out.println("3.Edit tour");
            System.out.println("4.Remove tour");
            System.out.println("5.search tour");
            System.out.println("6.Continue to tour adding ");
            System.out.println("7.Back to menu...");
            System.out.println("-------------");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("enter 1 to go to the print tours menu");
                System.out.println("enter 2 to enter initial details of tour");
                System.out.println("enter 3 to edit details of chosen tour");
                System.out.println("enter 4 to remove chosen tour");
                System.out.println("enter 5 tp go to the search menu");
                System.out.println("enter 6 to go to the complite details of tour like(add region,add leader,...");
                tourMenu();
            }
        }
    }

    public static void setLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The travel is aboard or domestic?");
        String typOfTour = scanner.nextLine();
        if (typOfTour.equals("help")) {
            System.out.println("we want this to know you should add city or places in city");
            setLocation();
        }
        System.out.println("Enter name of tour");
        String name = scanner.nextLine();
        if (name.equals("help")) {
            System.out.println("we should find teh tour with your enter name");
            setLocation();
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getTourName().equals(name)) {
                if (tours.get(i).isAboardOrNot(typOfTour) == true) {
                    System.out.println("Enter country name");
                    String countyName = scanner.nextLine();
                    for (int j = 0; j < areas.size(); j++) {
                        if (areas.get(j).getLocationName().equals(countyName)) {
                            flag = true;
                            if (flag)
                                tours.get(i).setTheWholePlease(countyName);
                        }
                    }
                    if (flag == false) {
                        System.out.println("define region");
                        return;
                    }
                    System.out.println("Enter down town");
                    String origin = scanner.nextLine();
                    for (int j1 = 0; j1 < areas.size(); j1++) {
                        if (areas.get(j1).getLocationName().equals(origin)) {
                            flag = true;
                            if (flag) {
                                tours.get(i).setOrigin(origin);
                            }
                        }
                    }
                    if (flag == false) {
                        System.out.println("define region");
                        return;
                    }
                    System.out.println("Enter destination");
                    String destination = scanner.nextLine();

                    for (int j = 0; j < areas.size(); j++) {
                        if (areas.get(j).getLocationName().equals(destination)) {
                            flag = true;
                            if (flag)
                                tours.get(i).setDestination(destination);
                        }
                    }
                    if (flag == false) {
                        System.out.println("define region");
                        return;
                    }
                    System.out.println("Enter how many city you want to add");
                    int count = scanner.nextInt();
                    if (count > tours.get(i).getLongOf()) {
                        System.out.println("Out of rang");
                        return;
                    }
                    for (int j = 0; j < count; j++) {
                        tours.get(i).addToRegion(areas);
                    }
                }
                if (tours.get(i).isAboardOrNot(typOfTour) == false) {
                    System.out.println("Enter city name");
                    String cityName = scanner.nextLine();
                    for (int j = 0; j < areas.size(); j++) {
                        if (areas.get(j).getLocationName().equals(cityName)) {
                            flag = true;
                            if (flag) {
                                tours.get(i).setTheWholePlease(cityName);
                                tours.get(i).setOrigin(cityName);
                                tours.get(i).setDestination(cityName);
                            }
                        }
                    }
                    if (flag == false) {
                        System.out.println("define region");
                        return;
                    }
                    System.out.println("Enter how many locations you want to add");
                    int count = scanner.nextInt();
                    for (int k = 0; k < count; k++) {
                        tours.get(i).addToRegion2(areas);
                    }
                }
            }
        }
    }

    public static void addTour() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the tour");
        String name = scanner.nextLine();
        if (name.length() < 3) {
            System.out.println("Invalid input");
            return;
        }
        if (name.equals("help")) {
            System.out.println("we want name for tour like one person name can be city or country or... name with number but not only numbers");
            addTour();
        }
        if (name.matches("\\d+")) {
            System.out.println("tour name cannot be just number");
            return;
        }
        System.out.println("Enter long of the tour");
        String LongOf = scanner.nextLine();
        if (LongOf.equals("help")) {
            System.out.println("how many days tours should be");
            return;
        }
        if (!LongOf.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int longOf = Integer.parseInt(LongOf);
        if (longOf > 20) {
            System.out.println("Invalid input");
            return;
        }
        System.out.println("Enter price");
        String Price = scanner.nextLine();
        if (Price.equals("help")) {
            System.out.println("set price for tour that people should pay for it");
            addTour();
        }
        if (!Price.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int price = Integer.parseInt(Price);
        System.out.println("Enter maximum Participant");
        String max = scanner.nextLine();
        if (max.equals("help")) {
            System.out.println("we want to know this to Determine the maximum participant limit");
            addTour();
        }
        if (!max.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int maxParticipant = Integer.parseInt(max);
        if (maxParticipant > 10) {
            System.out.println("Invalid input");
            return;
        }
        System.out.println("Enter min Participant");
        String min = scanner.nextLine();
        if (min.equals("help")) {
            System.out.println("we want this part know we are able to set tour or not this should be more tahn 5");
            addTour();
        }
        if (!min.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int minParticipant = Integer.parseInt(min);
        if (minParticipant < 5) {
            System.out.println("Invalid input");
            return;
        }
        Tour tour = new Tour(name, longOf, price, maxParticipant, minParticipant);
        tours.add(tour);
    }

    public static void printBaseOfTours() {
        for (int i = 0; i < tours.size(); i++) {
            System.out.println((i + 1) + "." + tours.get(i).toString());
        }
    }

    public static void printTourMenu() {
        // screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------");
        System.out.println("1.Base of the tours in list");
        System.out.println("2.All defined tours in list");
        System.out.println("3.back to tour menu");
        System.out.println("-------------");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("enter 1 to see Tours whose only basic structure is defined");
            System.out.println("****Attention the tours dos not have Definite date");
            System.out.println("enter 2 to see definite tours with date");
            printTourMenu();
        }
        while (!input.equals("5")) {

            switch (input) {
                case "1":
                    //x
                    printBaseOfTours();
                    break;
                case "2":
                    printDefineTour();
                    break;
                case "3":
                    tourMenu();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("-------------");
            System.out.println("1.Base of the tours in list");
            System.out.println("2.All defined tours in list");
            System.out.println("3.back to tour menu");
            System.out.println("-------------");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("enter 1 to see Tours whose only basic structure is defined");
                System.out.println("****Attention the tours dos not have Definite date");
                System.out.println("enter 2 to see definite tours with date");
                printTourMenu();
            }
        }
    }

    public static void tourRegionMenu() {
        //screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------");
        System.out.println("1.Add regions ");
        System.out.println("2.Edit region");
        System.out.println("3.Remove region");
        System.out.println("4.Add tour leader");
        System.out.println("5.back to tour menu");
        System.out.println("-------------");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("****Attention before add region go to the region menu from main menu and define region if you did not do this you cant add region");
            System.out.println("enter 1 too add region and date that you want visit this place to complting tour datails ");
            System.out.println("enter 2 to edit given regions");
            System.out.println("enter 3 to remove given region");
            System.out.println("enter 4 to set tour leader for your tour");
            System.out.println("****Attention define leader before,and The leader should know the tour areas and not be the leader of another group on that day");
            tourRegionMenu();
        }
        while (!input.equals("5")) {

            switch (input) {
                case "1":
                    setLocation();
                    break;
                case "2":
                    editRegionFromTour();
                    break;
                case "3":
                    removeRegionFromTour();
                    break;
                case "4":
                    addLeaderForTour();
                    break;
                case "5":
                    tourMenu();
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("-------------");
            System.out.println("1.Add regions ");
            System.out.println("2.Edit region");
            System.out.println("3.Remove region");
            System.out.println("4.Add tour leader");
            System.out.println("5.back to tour menu");
            System.out.println("-------------");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("****Attention before add region go to the region menu from main menu and define region if you did not do this you cant add region");
                System.out.println("enter 1 too add region and date that you want visit this place to complting tour datails ");
                System.out.println("enter 2 to edit given regions");
                System.out.println("enter 3 to remove given region");
                System.out.println("enter 4 to set tour leader for your tour");
                System.out.println("****Attention define leader before,and The leader should know the tour areas and not be the leader of another group on that day");
                tourRegionMenu();
            }
        }
    }

    public static void editTour() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the tour");
        String name = scanner.nextLine();
        if (name.length() < 3) {
            System.out.println("Invalid input");
            return;
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getTourName().equals(name)) {
                flag = true;
                if (flag) {
                    System.out.println("Enter name of the tour");
                    String tourName = scanner.nextLine();
                    if (tourName.length() < 3) {
                        System.out.println("Invalid input");
                        return;
                    }
                    if (tourName.equals("help")) {
                        System.out.println("we want name for tour like one person name can be city or country or... name with number but not only numbers");
                        editTour();
                    }
                    if (!tourName.matches("\\d+")) {
                        System.out.println("tour name cannot be just number");
                        return;
                    }
                    System.out.println("Enter long of the tour");
                    String LongOf = scanner.nextLine();
                    if (LongOf.equals("help")) {
                        System.out.println("how many days tours should be");
                        editTour();
                    }
                    if (!LongOf.matches("\\d+")) {
                        System.out.println("something wrong");
                        return;
                    }
                    int longOf = Integer.parseInt(LongOf);
                    if (longOf > 20) {
                        System.out.println("Invalid input");
                        return;
                    }
                    System.out.println("Enter price");
                    String Price = scanner.nextLine();
                    if (Price.equals("help")) {
                        System.out.println("set price for tour that people should pay for it");
                        editTour();
                    }
                    if (!Price.matches("\\d+")) {
                        System.out.println("something wrong");
                        return;
                    }
                    int price = Integer.parseInt(Price);
                    System.out.println("Enter maximum Participant");
                    String max = scanner.nextLine();
                    if (max.equals("help")) {
                        System.out.println("we want to know this to Determine the maximum participant limit");
                        editTour();
                    }
                    if (!max.matches("\\d+")) {
                        System.out.println("something wrong");
                        return;
                    }
                    int maxParticipant = Integer.parseInt(max);
                    if (maxParticipant > 10) {
                        System.out.println("Invalid input");
                        return;
                    }
                    System.out.println("Enter min Participant");
                    String min = scanner.nextLine();
                    if (min.equals("help")) {
                        System.out.println("we want this part know we are able to set tour or not this should be more tahn 5");
                        editTour();
                    }
                    if (min.matches("\\d+")) {
                        System.out.println("something wrong");
                        return;
                    }
                    int minParticipant = Integer.parseInt(min);
                    if (minParticipant < 5) {
                        System.out.println("Invalid input");
                        return;
                    }
                    System.out.println("Enter origin");
                    String origin = scanner.nextLine();
                    System.out.println("Enter destination");
                    String destination = scanner.nextLine();
                    tours.get(i).setTourName(tourName);
                    tours.get(i).setLongOf(longOf);
                    tours.get(i).setPrice(price);
                    tours.get(i).setMaxParticipant(maxParticipant);
                    tours.get(i).setMinParticipant(minParticipant);
                    tours.get(i).setOrigin(origin);
                    tours.get(i).setDestination(destination);
                }
            }
        }
    }

    public static void removeTour() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the tour");
        String name = scanner.nextLine();
        if (name.equals("help")) {
            System.out.println("we want tour name to find and remove it");
            removeTour();
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getTourName().equals(name)) {
                flag = true;
                if (flag) {
                    tours.remove(i);
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found");
        }
    }

    public static void removeRegionFromTour() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the tour");
        String name = scanner.nextLine();
        if (name.equals("help")) {
            System.out.println("we want tour name to find and remove it");
            removeRegionFromTour();
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getTourName().equals(name)) {
                flag = true;
                if (flag) {
                    tours.get(i).removeRegion();
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found");
        }
    }

    public static void editRegionFromTour() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the tour");
        String name = scanner.nextLine();
        if (name.equals("help")) {
            System.out.println("we want tour name to find and edit it");
            editRegionFromTour();
        }
        if (name.length() < 3) {
            System.out.println("Invalid input");
            return;
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getTourName().equals(name)) {
                flag = true;
                if (flag) {
                    tours.get(i).editRegion();
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found");
        }
    }

    public static void printDefineTour() {
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).isDefineOrNot() == false)
                System.out.println((i + 1) + "." + tours.get(i).toString() + tours.get(i).getLocations());
        }

    }

    public static void whereIsTourChosenDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of tour");
        String name = scanner.nextLine();
        if (name.equals("help")) {
            System.out.println("we want tour name to find and see details");
            removeTour();
        }
        if (name.length() < 3) {
            System.out.println("Invalid input");
            return;
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getTourName().equals(name)) {
                flag = true;
                if (flag) {
                    MapUtil.showMap(tours.get(i).whereAreYouOnYourChosenDay());
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found");
        }
    }

    public static void areaMenu() {
        //screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------");
        System.out.println("1.See list of areas");
        System.out.println("2.Add area");
        System.out.println("3.Edit area");
        System.out.println("4.Remove area");
        System.out.println("5.Back to menu");
        System.out.println("-------------");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("enter 1 to see list of the defined tours ");
            System.out.println("enter 2 to add region to teh region list");
            System.out.println("enter 3 to edit the tour that you want");
            System.out.println("enter 4 to remove tour that you want");
            areaMenu();
        }
        while (!input.equals("5")) {

            switch (input) {
                case "1":
                    //print
                    printAreas();
                    break;
                case "2":
                    //add
                    addArea();
                    break;
                case "3":
                    //edit
                    editArea();
                    break;
                case "4":
                    //remove
                    removeArea();
                case "5":
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("-------------");
            System.out.println("1.See list of areas");
            System.out.println("2.Add area");
            System.out.println("3.Edit area");
            System.out.println("4.Remove area");
            System.out.println("5.Back to menu");
            System.out.println("-------------");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("enter 1 to see list of the defined tours ");
                System.out.println("enter 2 to add region to teh region list");
                System.out.println("enter 3 to edit the tour that you want");
                System.out.println("enter 4 to remove tour that you want");
                areaMenu();
            }
        }
    }

    public static void printAreas() {
        screenClear();
        for (int i = 0; i < areas.size(); i++) {
            System.out.println((i + 1) + "." + areas.get(i).getLocationName());
        }
    }

    public static void addArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many area you want to add?");
        String count = scanner.nextLine();
        if (count.equals("help")) {
            System.out.println("enter how many city you want to add to the list");
            leaderMenu();
        }
        if (!count.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int counter = Integer.parseInt(count);
        for (int i = 0; i < counter; i++) {
            System.out.println("Enter name of the area");
            String areaName = scanner.nextLine();
            SpectacularLocation location = new SpectacularLocation(areaName);
            areas.add(location);
        }
    }

    public static void editArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the area");
        String areaName = scanner.nextLine();
        if (!areaName.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        if (areaName.equals("help")) {
            System.out.println("we want name of area that you want edit it to find it");
            editArea();
        }
        System.out.println("Enter new name of area");
        String newName = scanner.nextLine();
        if (newName.matches("\\d+")) {
            System.out.println("name cannot be only number");
            return;
        }
        if (newName.equals("help")) {
            System.out.println("we want name to replace it with old name");
            editArea();
        }
        flag = false;
        for (int i = 0; i < areas.size(); i++) {
            if (areas.get(i).getLocationName().equals(areaName)) {
                flag = true;
                if (flag)
                    areas.get(i).setLocationName(newName);
            }
        }
        if (flag == false) {
            System.out.println("could not found");
            return;
        }
    }

    public static void removeArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the area");
        String areaName = scanner.nextLine();
        if (areaName.equals("help")) {
            System.out.println("we want name of the tour to find and remove it");
            removeArea();
        }
        flag = false;
        for (int i = 0; i < areas.size(); i++) {
            if (areas.get(i).getLocationName().equals(areaName)) {
                flag = true;
                if (flag)
                    areas.remove(i);
            }
        }
        if (flag == false) {
            System.out.println("Could not found");
            return;
        }
    }

    public static void searchTourMenu() {
        //screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------");
        System.out.println("1.Search types of tours");
        System.out.println("2.Search tours");
        System.out.println("3.back to tour menu");
        System.out.println("-------------");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("there is two tyo of tour you can chose and go to the searches menu");
            searchTourMenu();
        }
        while (!input.equals("3")) {

            switch (input) {
                case "1":
                    //x
                    //kinds
                    searchTypOfTours();
                    break;
                case "2":
                    //all define
                    searchInDefinedTours();
                    break;
                case "3":
                    tourMenu();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
            System.out.println("-------------");
            System.out.println("1.Search types of tours");
            System.out.println("2.Search tours");
            System.out.println("3.back to tour menu");
            System.out.println("-------------");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("there is two tyo of tour you can chose and go to the searches menu");
                searchTourMenu();
            }
        }
    }

    public static void searchInDefinedTours() {
        screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------");
        System.out.println("1.According to leader name");
        System.out.println("2.According to tour Date");
        System.out.println("3.According to digit days");
        System.out.println("4.According to spectacular locations");
        System.out.println("5.According to overall area");
        System.out.println("6.According to price");
        System.out.println("7.back to tour menu");
        System.out.println("-------------");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("you can search and find your intended tour with give with this details");
            searchInDefinedTours();
        }
        while (!input.equals("7")) {

            switch (input) {
                case "1":
                    //leader
                    searchByLeader();
                    break;
                case "2":
                    //date
                    dateMenu();
                    break;
                case "3":
                    //long of
                    searchByLongOfTour();
                    break;
                case "4":
                    //list mkn didni
                    searchBySpectacularLocation();
                    break;
                case "5":
                    //on mkne
                    searchByWholeArea();
                    break;
                case "6":
                    //price
                    priceMenu();
                    break;
                case "7":
                    tourMenu();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
            System.out.println("-------------");
            System.out.println("1.According to leader name");
            System.out.println("2.According to tour Date");
            System.out.println("3.According to digit days");
            System.out.println("4.According to spectacular locations");
            System.out.println("5.According to overall area");
            System.out.println("6.According to price");
            System.out.println("7.back to tour menu");
            System.out.println("-------------");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("you can search and find your intended tour with give with this details");
                searchInDefinedTours();
            }
        }
    }

    public static void searchByLeader() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter leaders  Name");
        String Name = scanner.nextLine();
        if (Name.equals("help")) {
            System.out.println("enter name of leader to give you the tour that the leader leads");
            searchByLeader();
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getLeader().getFullName().equals(Name)) {
                flag = true;
                if (flag)
                    System.out.println(tours.get(i).toString());
            }
        }
        if (flag == false) {
            System.out.println("Could not found");
            return;
        }
    }

    public static void searchTypOfTours() {
        // screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------");
        System.out.println("1.According to long of tor");
        System.out.println("2.According to visited areas");
        System.out.println("3.According to maxParticipant and minParticipant");
        System.out.println("4.According to price");
        System.out.println("5.back to tour menu");
        System.out.println("-------------");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("****you can search and find your intended tour with give with this details");
            searchTypOfTours();
        }
        while (!input.equals("5")) {

            switch (input) {
                case "1":
                    //long of
                    searchByLongOfTour();
                    break;
                case "2":
                    //area
                    searchByWholeArea();
                    break;
                case "3":
                    //max & min
                    maxAndMinMenu();
                    break;
                case "4":
                    //price
                    priceMenu();
                    break;
                case "5":
                    tourMenu();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
            System.out.println("-------------");
            System.out.println("1.According to long of tor");
            System.out.println("2.According to visited areas");
            System.out.println("3.According to maxParticipant and minParticipant");
            System.out.println("4.According to price");
            System.out.println("5.back to tour menu");
            System.out.println("-------------");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("****you can search and find your intended tour with give with this details");
                searchTypOfTours();
            }
        }


    }

    public static void priceMenu() {
        // screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------");
        System.out.println("1.Search More value");
        System.out.println("2.Search Values between");
        System.out.println("3.search  Less value");
        System.out.println("4.Back to search menu");
        System.out.println("-------------");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("****find your intended tour with this diffrent methods of given price");
            priceMenu();
        }
        while (!input.equals("4")) {

            switch (input) {
                case "1":
                    searchTourMValue();
                    break;
                case "2":
                    searchTourBValue();
                    break;
                case "3":
                    searchTourLValue();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
            System.out.println("-------------");
            System.out.println("1.Search More value");
            System.out.println("2.Search Values between");
            System.out.println("3.search  Less value");
            System.out.println("4.Back to search menu");
            System.out.println("-------------");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("****find your intended tour with this diffrent methods of given price");
                priceMenu();
            }
        }

    }

    public static void searchTourMValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter See the price you want for the tour for less");
        String price = scanner.nextLine();
        if (price.equals("help")) {
            System.out.println("enter price that you want find tours with more than given price");
            priceMenu();
        }
        if (!price.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int Price = Integer.parseInt(price);
        if (Price < 0) {
            System.out.println("Invalid input");
            return;
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getPrice() < Price) {
                flag = true;
                if (flag) {
                    System.out.println(tours.get(i).getTourName());
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found!");
        }
    }

    public static void searchTourLValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The more you want to see the more expensive the tour");
        String price = scanner.nextLine();
        if (price.equals("help")) {
            System.out.println("enter price that you want find tours with fewer than given price");
            priceMenu();
        }
        if (!price.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int Price = Integer.parseInt(price);
        if (Price < 0) {
            System.out.println("Invalid input");
            return;
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getPrice() > Price) {
                flag = true;
                if (flag) {
                    System.out.println(tours.get(i).getTourName());
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found!");
        }
    }

    public static void searchTourBValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The two values you want to see in between");
        String price1 = scanner.nextLine();
        if (price1.equals("help")) {
            System.out.println("enter price that you want find tours with more than given price");
            priceMenu();
        }
        if (!price1.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int Price1 = Integer.parseInt(price1);
        if (Price1 < 0) {
            System.out.println("Invalid input");
            return;
        }
        String price2 = scanner.nextLine();
        if (price2.equals("help")) {
            System.out.println("enter price that you want find tours with more than given price");
            priceMenu();
        }
        if (!price2.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int Price2 = Integer.parseInt(price1);
        if (Price2 < 0) {
            System.out.println("Invalid input");
            return;
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getPrice() > Price1 && tours.get(i).getPrice() < Price2) {
                flag = true;
                if (flag) {
                    System.out.println(tours.get(i).getTourName());
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found!");
            return;
        }
    }

    public static void dateMenu() {
        screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------");
        System.out.println("1.After given day");
        System.out.println("2.Between given dates");
        System.out.println("3.Before given date");
        System.out.println("4.Back to search menu");
        System.out.println("-------------");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("****find your intended tour with this diffrent methods of given date");
            dateMenu();
        }
        while (!input.equals("3")) {

            switch (input) {
                case "1":
                    searchAfterGivenDay();
                    break;
                case "2":
                    searchBetweenGivenDay();
                    break;
                case "3":
                    searchBeforeGivenDay();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
            System.out.println("-------------");
            System.out.println("1.After given day");
            System.out.println("2.Between given dates");
            System.out.println("3.Before given date");
            System.out.println("4.Back to search menu");
            System.out.println("-------------");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("***find your intended tour with this diffrent methods of given date");
                dateMenu();
            }
        }

    }

    public static void searchAfterGivenDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter year");
        String Year = scanner.nextLine();
        if (Year.equals("help")) {
            System.out.println("enter year of date that you want exit tours after this date");
            dateMenu();
        }
        if (!Year.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int year = Integer.parseInt(Year);
        if (year > 1400 || year < 1398) {
            System.out.println("Invalid input!");
            return;
        }
        System.out.println("Enter month");
        String Month = scanner.nextLine();
        if (Month.equals("help")) {
            System.out.println("enter month of date that you want exit tours after this date");
            dateMenu();
        }
        if (!Month.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int month = Integer.parseInt(Month);
        if (month < 0 || month > 13) {
            System.out.println("Invalid input!");
            return;
        }
        System.out.println("Enter day");
        String Day = scanner.nextLine();
        if (Day.equals("help")) {
            System.out.println("enter day of date that you want exit tours after this date");
            dateMenu();
        }
        if (!Day.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int day = Integer.parseInt(Day);
        if (day < 0 || day > 32) {
            System.out.println("Invalid input!");
            return;
        }
        MyDate date = new MyDate(year, month, day);
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).searchInDate1(date)) {
                System.out.println(tours.get(i));
            }
        }
    }

    public static void searchBeforeGivenDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter year");
        String Year = scanner.nextLine();
        if (Year.equals("help")) {
            System.out.println("enter year of date that you want exit tours before this date");
            dateMenu();
        }
        if (!Year.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int year = Integer.parseInt(Year);
        if (year > 1400 || year < 1398) {
            System.out.println("Invalid input!");
            return;
        }
        System.out.println("Enter month");
        String Month = scanner.nextLine();
        if (Month.equals("help")) {
            System.out.println("enter month of date that you want exit tours before this date");
            dateMenu();
        }
        if (!Month.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int month = Integer.parseInt(Month);
        if (month < 0 || month > 13) {
            System.out.println("Invalid input!");
            return;
        }
        System.out.println("Enter day");
        String Day = scanner.nextLine();
        if (Month.equals("help")) {
            System.out.println("enter day of date that you want exit tours before this date");
            dateMenu();
        }
        if (!Day.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int day = Integer.parseInt(Day);
        if (day < 0 || day > 32) {
            System.out.println("Invalid input!");
            return;
        }
        MyDate date = new MyDate(year, month, day);
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).searchInDate2(date)) {
                flag = true;
                if (flag)
                    System.out.println(tours.get(i));
            }
        }
        if (flag == false) {
            System.out.println("Could not found");
        }
    }

    public static void searchBetweenGivenDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter year for first date");
        String y1 = scanner.nextLine();
        if (y1.equals("help")) {
            System.out.println("enter year of first date that you want see day between this nad other bigger date");
            dateMenu();
        }
        if (!y1.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int year1 = Integer.parseInt(y1);
        if (year1 > 1400 || year1 < 1398) {
            System.out.println("Invalid input!");
            return;
        }
        System.out.println("Enter month for first date");
        String m1 = scanner.nextLine();
        if (m1.equals("help")) {
            System.out.println("enter month of first date that you want see day between this nad other bigger date");
            dateMenu();
        }
        if (!m1.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int month1 = Integer.parseInt(m1);
        if (month1 < 0 || month1 > 13) {
            System.out.println("Invalid input!");
            return;
        }
        System.out.println("Enter day for first date");
        String d1 = scanner.nextLine();
        if (d1.equals("help")) {
            System.out.println("enter day of first date that you want see day between this nad other bigger date");
            dateMenu();
        }
        if (!d1.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int day1 = Integer.parseInt(d1);
        if (day1 < 0 || day1 > 32) {
            System.out.println("Invalid input!");
            return;
        }
        System.out.println("Enter year for second date");
        String y2 = scanner.nextLine();
        if (y2.equals("help")) {
            System.out.println("enter year of second day that you want to see tours and date that you enter before");
            dateMenu();
        }
        if (!y2.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int year2 = Integer.parseInt(y2);
        if (year2 > 1400 || year2 < 1398) {
            System.out.println("Invalid input!");
            return;
        }
        System.out.println("Enter month for second date");
        String m2 = scanner.nextLine();
        if (m2.equals("help")) {
            System.out.println("enter month of second day that you want to see tours and date that you enter before");
            dateMenu();
        }
        if (!m2.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int month2 = Integer.parseInt(m2);
        if (month2 < 0 || month2 > 13) {
            System.out.println("Invalid input!");
            return;
        }
        System.out.println("Enter day for second date");
        String d2 = scanner.nextLine();
        if (d2.equals("help")) {
            System.out.println("enter month of second day that you want to see tours and date that you enter before");
            dateMenu();
        }
        if (!d2.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int day2 = Integer.parseInt(d2);
        if (day2 < 0 || day2 > 32) {
            System.out.println("Invalid input!");
            return;
        }
        MyDate date1 = new MyDate(year1, month1, day1);
        MyDate date2 = new MyDate(year2, month2, day2);
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).searchInDate3(date1, date2)) {
                flag = true;
                if (flag)
                    System.out.println(tours.get(i));
            }
        }
        if (flag == false) {
            System.out.println("Could not found");
        }
    }

    public static void maxAndMinMenu() {
        //screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------");
        System.out.println("1.By max ");
        System.out.println("2.By min");
        System.out.println("3.back to search menu");
        System.out.println("-------------");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("****search tour with max or min Participant");
            maxAndMinMenu();
        }
        while (!input.equals("3")) {

            switch (input) {
                case "1":
                    //max
                    searchByMax();
                    break;
                case "2":
                    //min
                    searchByMin();
                    break;
                case "3":
                    searchTourMenu();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
            System.out.println("-------------");
            System.out.println("1.By max ");
            System.out.println("2.By min");
            System.out.println("3.back to search menu");
            System.out.println("-------------");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("****search tour with max or min Participant");
                maxAndMinMenu();
            }
        }

    }

    public static void searchByLongOfTour() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter long of the tour");
        String LongOf = scanner.nextLine();
        if (LongOf.equals("help")) {
            System.out.println("enter duration by number of days");
            searchTourMenu();
        }
        if (!LongOf.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int longOf = Integer.parseInt(LongOf);
        if (longOf < 1) {
            System.out.println("Invalid input!");
            return;
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getLongOf() == longOf) {
                flag = true;
                if (flag) {
                    System.out.println(tours.get(i).getTourName());
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found!");
        }
    }

    public static void searchByWholeArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter whole area");
        String WholeArea = scanner.nextLine();
        if (WholeArea.equals("help")) {
            System.out.println("if the travel is domestic enter city and if is a aboard enter country");
            searchTourMenu();
        }
        if (WholeArea.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getTheWholePlease().equals(WholeArea) || WholeArea.equals(" ")) {
                flag = true;
                if (flag) {
                    System.out.println(tours.get(i).getTourName());
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found!");
        }

    }

    public static void searchBySpectacularLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of location");
        String locationName = scanner.nextLine();
        if (locationName.equals("help")) {
            System.out.println("if teh travel is domestic enter location names and if is a aboard enter city name");
            searchTourMenu();
        }
        if (locationName.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).searchInLocations(locationName)) {
                flag = true;
                if (flag) {
                    System.out.println(tours.get(i).getTourName());
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found!");
        }
    }

    public static void searchByMax() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter max of Participant");
        int max = scanner.nextInt();
        if (max > 10) {
            System.out.println("Invalid input!");
            return;
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getMaxParticipant() == max) {
                flag = true;
                if (flag) {
                    System.out.println(tours.get(i).getTourName());
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found!");
        }
    }

    public static void searchByMin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter min of Participant");
        int min = scanner.nextInt();
        if (min < 5) {
            System.out.println("Invalid input!");
            return;
        }
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getMinParticipant() == min) {
                flag = true;
                if (flag) {
                    System.out.println(tours.get(i).getTourName());
                }
            }
        }
        if (flag == false) {
            System.out.println("Invalid input!");
        }
    }

    public static void addLeaderForTour() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of tour");
        String tourName = scanner.nextLine();
        if (tourName.equals("help")) {
            System.out.println("enter tours name that you set before to check date and places with leader conditions");
            addLeaderForTour();
        }
        if (tourName.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        System.out.println("Enter first name of leader");
        String fName = scanner.nextLine();
        if (fName.equals("help")) {
            System.out.println("enter leaders first name to we check and see if is able we set him for your tours");
            addLeaderForTour();
        }
        if (fName.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        System.out.println("Enter last name of leader");
        String lName = scanner.nextLine();
        if (lName.equals("help")) {
            System.out.println("enter leaders last name to we check and see if is able we set him for your tours");
            addLeaderForTour();
        }
        if (lName.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        flag = true;
        int tourIndex = -1;
        int tourLeaderIndex = -1;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getTourName().equals(tourName)) {
                for (int j = 0; j < tourLeaders.size(); j++) {
                    if (tourLeaders.get(j).getFirstName().equals(fName) && tourLeaders.get(j).getLastName().equals(lName)) {
                        tourIndex = i;
                        tourLeaderIndex = j;
                        if (!tourLeaders.get(j).searchInKnowRegion(tours.get(i).getTheWholePlease())) {
                            flag = false;
                            System.out.println("Main location isnt known to leader");
                            break;
                        }
                        for (int k = 0; k < tours.get(i).getLocations().size(); k++) {
                            if (!tourLeaders.get(j).searchInKnowRegion(tours.get(i).getLocations().get(k).getLocationName()) ||
                                    !tourLeaders.get(j).searchInLeaderDate(tours.get(i).getLocations().get(k).getDate())) {
                                flag = false;
                                System.out.println(tours.get(i).getLocations().get(k).getLocationName() + " location isnt known to leader");
                                System.out.println(tours.get(i).getLocations().get(k).getDate() + " time isnt available to leader");
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (flag && tourIndex != -1 && tourLeaderIndex != -1) {
            tours.get(tourIndex).setLeader(tourLeaders.get(tourLeaderIndex));
            tourLeaders.get(tourLeaderIndex).setTour(tours.get(tourIndex));
            System.out.println("Successfully added");
        } else {
            System.out.println("leader/tour not found");
        }
    }

    public static void mapMenu() {
        //screenClear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------");
        System.out.println("1.Show origin ");
        System.out.println("2.Show destination");
        System.out.println("3.Show origin & destination together");
        System.out.println("4.Show now location of tour");
        System.out.println("5.Show locations of a one tour(for aboard tours)");
        System.out.println("6.Show where id tour in chosen day");
        System.out.println("7.Show one country or city that you want");
        System.out.println("8.Show two city that you want");
        System.out.println("9.Back to main menu");
        System.out.println("-------------");
        String input = scanner.nextLine();
        if (input.equals("help")) {
            System.out.println("****show places on map with diffrent details");
            mapMenu();
        }
        while (!input.equals("9")) {

            switch (input) {
                case "1":
                    //origin
                    showOrigin();
                    break;
                case "2":
                    //destination
                    showDestination();
                    break;
                case "3":
                    //together
                    showOriginAndDestination();
                    break;
                case "4":
                    //now tour location
                    showNowTourLocation();
                    break;
                case "5":
                    //location of aboard tour
                    showTourLocations();
                    break;
                case "6":
                    //one chosen city or county
                    whereIsTourChosenDay();
                    break;
                case "7":
                    //two chosen city
                    showOneCountry();
                    break;
                case "8":
                    showTwoCity();
                    break;
                case "9":
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
            System.out.println("-------------");
            System.out.println("1.Show origin ");
            System.out.println("2.Show destination");
            System.out.println("3.Show origin & destination together");
            System.out.println("4.Show now location of tour");
            System.out.println("5.Show locations of a one tour(for aboard tours)");
            System.out.println("6.Show one country or city that you want");
            System.out.println("7.Show two city that you want");
            System.out.println("8.Back to main menu");
            System.out.println("-------------");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("****show places on map with diffrent details");
                mapMenu();
            }
        }

    }

    public static void showOrigin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of tour");
        String tourName = scanner.nextLine();
        if (tourName.equals("help")) {
            System.out.println("in this part we show show given tour start from where");
            showOrigin();
        }
        if (tourName.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getTourName().equals(tourName)) {
                flag = true;
                if (flag) {
                    MapUtil.showMap(tours.get(i).getOrigin());
                }
            }
        }
        if (!flag) {
            System.out.println("Could not found!");
        }
    }

    public static void showDestination() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of tour");
        String tourName = scanner.nextLine();
        if (tourName.equals("help")) {
            System.out.println("in this part we show you the end of given tour is where");
            showDestination();
        }
        if (tourName.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getTourName().equals(tourName)) {
                flag = true;
                if (flag) {
                    MapUtil.showMap(tours.get(i).getDestination());
                }
            }
        }
        if (!flag) {
            System.out.println("Could not found");
        }
    }

    public static void showOriginAndDestination() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of tour");
        String tourName = scanner.nextLine();
        if (tourName.equals("help")) {
            System.out.println("in this part we show you given tour start from where and end from where");
            showOriginAndDestination();
        }
        if (tourName.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getTourName().equals(tourName)) {
                flag = true;
                if (flag) {
                    MapUtil.showMap(tours.get(i).getOrigin());
                    MapUtil.showMap(tours.get(i).getOrigin(), tours.get(i).getDestination());
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found!");
        }
    }

    public static void showNowTourLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of tour");
        String tourName = scanner.nextLine();
        if (tourName.equals("help")) {
            System.out.println("we need tour name to acess to the tour location and dates and other ditails");
            showNowTourLocation();
        }
        if (tourName.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        System.out.println("Today date");
        System.out.println("-----------");
        System.out.println("Enter year");
        String Year = scanner.nextLine();
        if (Year.equals("help")) {
            System.out.println("we need todays date to find matches tours");
            showNowTourLocation();
        }
        if (!Year.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int year = Integer.parseInt(Year);
        if (year < 1398 || year > 1400) {
            System.out.println("Invalid input!");
            return;
        }
        System.out.println("Enter month");
        String Month = scanner.nextLine();
        if (Month.equals("help")) {
            System.out.println("we need todays date to find matches tours");
            showNowTourLocation();
        }
        if (!Month.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int month = Integer.parseInt(Month);
        if (month < 0 || month > 13) {
            System.out.println("Invalid input!");
            return;
        }
        System.out.println("Enter day");
        String Day = scanner.nextLine();
        if (Day.equals("help")) {
            System.out.println("we need todays date to find matches tours");
            showNowTourLocation();
        }
        if (!Month.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        int day = Integer.parseInt(Day);
        if (day < 0 || day > 32) {
            System.out.println("Invalid input!");
            return;
        }
        MyDate date = new MyDate(year, month, day);
        flag = false;
        for (int i = 0; i < tours.size(); i++) {

            if (tours.get(i).getTourName().equals(tourName)) {
                flag = true;
                if (flag) {
                    MapUtil.showMap(tours.get(i).searchDate(date));
                }
            }
        }
        if (flag == false) {
            System.out.println("Could not found!");
        }
    }

    public static void showOneCountry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter country or city that you want to see");
        String countryName = scanner.nextLine();
        if (countryName.equals("help")) {
            System.out.println("you can see every city country or location that you want and its help you in chose region od tours");
            showOneCountry();
        }
        if (countryName.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        MapUtil.showMap(countryName);
    }

    public static void showTwoCity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first city that you want to see");
        String city1Name = scanner.nextLine();
        if (city1Name.equals("help")) {
            System.out.println("after enter all two cities you can see bouth on map and space between and its help you in chose region for your tour");
            showTwoCity();
        }
        if (city1Name.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        System.out.println("Enter first city that you want to see");
        String city2Name = scanner.nextLine();
        if (city2Name.equals("help")) {
            System.out.println("after enter all two cities you can see bouth on map and space between and its help you in chose region for your tour");
            showTwoCity();
        }
        if (city2Name.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        MapUtil.showMap(city1Name, city2Name);
    }

    public static void showTourLocations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter tour name");
        String Name = scanner.nextLine();
        if (Name.equals("help")) {
            System.out.println("we want tour name to search tour and find details like locations and dates");
            showTourLocations();
        }
        if (Name.matches("\\d+")) {
            System.out.println("something wrong");
            return;
        }
        flag = false;
        for (int i = 0; i < tours.size(); i++) {
            if (Name.matches("\\d+")) {
                System.out.println("something wrong");
                return;
            }
            if (tours.get(i).getTourName().equals(Name)) {
                flag = true;
                if (flag) {
                    MapUtil.showMap(tours.get(i).getTheWholePlease());
                    MapUtil.showMap(tours.get(i).searchLocation());
                }
            }
        }
        if (flag == false) {
            System.out.println("Invalid input!");
        }
    }

    public static void screenClear() {
        System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
    }
}
