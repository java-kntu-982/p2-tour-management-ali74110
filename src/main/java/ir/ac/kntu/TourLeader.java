package ir.ac.kntu;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Seyed Ali Toliat
 */
public class TourLeader extends User {
    private String firstName ;
    private String lastName ;
    private long nationalCode;
    private long identityNum;
    private Date birthDate = new Date();
    private int age;
    private boolean married;
    private List<City> citiesKnow = new ArrayList<>();
    private List<String> nameOfCountriesKnow = new ArrayList<>();
    private List<Tour> tourInHand = new ArrayList<>() ;
    private List<Date> busyDates = new ArrayList<>();
    /*---------------------------------------------------*/

    public TourLeader(String userName, String password, String email, String phoneNumber, AccessLevel accessLevel, String firstName, String lastName, long nationalCode, long identityNum, Date birthDate, int age, boolean married, List<City> citiesKnow, List<String> nameOfCountriesKnow, List<Tour> tourInHand, List<Date> busyDates) {
        super(userName, password, email, phoneNumber, accessLevel);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.identityNum = identityNum;
        this.birthDate = birthDate;
        this.age = age;
        this.married = married;
        this.citiesKnow = citiesKnow;
        this.nameOfCountriesKnow = nameOfCountriesKnow;
        this.tourInHand = tourInHand;
        this.busyDates = busyDates;
    }

    public TourLeader() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationalCode(long nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setIdentityNum(long identityNum) {
        this.identityNum = identityNum;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        this.age = 1399 - birthDate.getYear();
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public long getNationalCode() { return nationalCode; }

    public long getIdentityNum() { return identityNum; }

    public Date getBirthDate() { return birthDate; }

    public int getAge() { return age; }

    public boolean isMarried() { return married; }

    public List<String> getNameOfCountriesKnow() {
        return nameOfCountriesKnow;
    }
    public void setNameOfCountriesKnow(List<String> nameOfCountriesKnow) {
        this.nameOfCountriesKnow = nameOfCountriesKnow;
    }
    public void addNameOfCountriesKnow(String nameOfCountryKnow) {
        this.nameOfCountriesKnow.add(nameOfCountryKnow);
    }
    public void removeNameOfCountriesKnow(int i) {
        this.nameOfCountriesKnow.remove(i);
    }

    public List<City> getCitiesKnow() { return citiesKnow; }
    public City getCityKnow(int i){return citiesKnow.get(i);}
    public void addCitiesKnow(List<City> citiesKnow) {
        this.citiesKnow.addAll(citiesKnow);
    }
    public void addCityKnow(City cityKnow) {
        this.citiesKnow.add(cityKnow);
    }
    public void removeCityKnow(int i) {
        this.citiesKnow.remove(i);
    }
    public void setCitiesKnow(List<City> citiesKnow) { this.citiesKnow = citiesKnow; }

    public List<Tour> getTourInHand() {
        return tourInHand;
    }
    public void addTourInHand(Tour tourInHand) {
        this.tourInHand.add(tourInHand);
    }
    public void setTourInHand(List<Tour> tourInHand) {
        this.tourInHand = tourInHand;
    }

    public List<Date> getBusyDates() {
        return busyDates;
    }
    public void addBusyDates(Date busyDate) {
        this.busyDates.add(busyDate);
    }
    public void setBusyDates(List<Date> busyDates) {
        this.busyDates = busyDates;
    }
    /*---------------------------------------------------*/

    public String toString() {
        String marriedText =" ";
        if (married){
            marriedText = "married";
        }
        else{
            marriedText = "single";
        }
        String returnString = firstName + " " + lastName + ":" +
                ", National Code: " + nationalCode +
                ", Identity number: " + identityNum +
                ", Age: " + age +
                ", Birth date: " + birthDate +
                ", Marriage: " + marriedText +
                ", Location Know: [" ;
        for (int i=0 ; i<citiesKnow.size() ; i++){
            if (i!=0){ returnString += ","; }
            returnString += citiesKnow.get(i).getName();
        }
        returnString +="], tours in hand: [";
        for (int i=0 ; i<tourInHand.size() ;i++){
            if (i!=0){ returnString += ","; }
            returnString+=tourInHand.get(i).toString();
        }
        returnString += "]";
        return returnString ;
    }
    /*---------------------------------------------------*/
    public static boolean checkRepeatCountryNameKnow(TourLeader tourLeader , String countryName){
        boolean a = false ;
        for (int i=0 ;i<tourLeader.getNameOfCountriesKnow().size();i++){
            if (tourLeader.getNameOfCountriesKnow().get(i).equals(countryName)){
                a = tourLeader.getNameOfCountriesKnow().get(i).equals(countryName);
                break;
            }
        }
        return a;
    }
    /*-------------------------------------------------------------------------------------------------------------------*/
    public static void tourLeaderMenu(List<TourLeader> tourLeaders , List<Country> countries,AccessLevel accessLevel){
        while (true){
            Scanner scanner = new Scanner(System.in);
            int choice;
            System.out.println("\n<< Tour Leaders >>\n1.show all tour leaders\n2.add leader\n3.delete leader\n4.edit leader\n5.search\n6.back\nEnter a number: ");
            choice = scanner.nextInt();
            if (choice == 1){ showTourLeaders(tourLeaders); Main.takeMeBack(); }
            else if (choice == 2){ addTourLeader(tourLeaders,countries);}
            else if (choice == 3){
                if (accessLevel == AccessLevel.Customer || accessLevel == AccessLevel.TourLeader){
                    System.out.println("you don't have access to this part!");
                    return;
                }
                Scanner scanner2 = new Scanner(System.in);
                int choice2 ;
                System.out.println("\n<< Deleter >>\nWhich leader you want to be deleted?\n");
                showTourLeaders(tourLeaders);
                System.out.println("\nBack '0'\nEnter a number: ");
                choice2 = scanner2.nextInt();
                deleteTourLeader(tourLeaders,choice2);
            }
            else if (choice == 4){
                if (accessLevel == AccessLevel.Customer || accessLevel == AccessLevel.TourLeader){
                    System.out.println("you don't have access to this part!");
                    return;
                }
                System.out.println("\n<< Editor >>\nWhich leader you want to be edited?\n");
                showTourLeaders(tourLeaders);
                System.out.println("0.Back\nEnter the number :");
                int tourLeaderChoice = scanner.nextInt();
                editTourLeader(tourLeaders, countries,tourLeaderChoice);
            }
            else if (choice == 5){
                if (accessLevel == AccessLevel.Customer || accessLevel == AccessLevel.TourLeader){
                    System.out.println("you don't have access to this part!");
                    return;
                }
                searchTourLeader(tourLeaders,countries); }
            else if (choice == 6){ break; }
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void addTourLeader(List<TourLeader> tourLeaders , List<Country> countries){
        TourLeader toAdd;
        toAdd = getTourLeader(0 , countries);
        toAdd.setPassword2("1234567");
        toAdd.setUserName(toAdd.getLastName());
        tourLeaders.add(toAdd);
        System.out.println("\nTour Leader added.(userName:"+ toAdd.getUserName() + ", Pass:" + toAdd.getPassword() +")"+ "\n");

    }
    /*-----------------------------------------------------------------------------------------------*/
    public static TourLeader getTourLeader (int type , List<Country> countries ,TourLeader... toEditTourLeader){
        Scanner scanner = new Scanner(System.in);
        TourLeader tourLeaderGetter = new TourLeader();
        String firstName , lastName ;
        long nationalCode , identityNum;
        Date birthDate = new Date();
        int day , month , year;
        int choice;
        boolean married;int marriedChoice;
        tourLeaderGetter.setAccessLevel(AccessLevel.TourLeader);
        if (type == 0){ System.out.println("\n<< Adder >>\nnew tour leader :");}
        if (type != 0){
            System.out.println("tour leader: " + toEditTourLeader[0].getFirstName() + " " + toEditTourLeader[0].getLastName());
            tourLeaderGetter.setLastName(toEditTourLeader[0].getLastName());
            tourLeaderGetter.setFirstName(toEditTourLeader[0].getFirstName());
            tourLeaderGetter.setNationalCode(toEditTourLeader[0].getNationalCode());
            tourLeaderGetter.setIdentityNum(toEditTourLeader[0].getIdentityNum());
            tourLeaderGetter.setBirthDate(toEditTourLeader[0].getBirthDate());
            tourLeaderGetter.setMarried(toEditTourLeader[0].isMarried());
            tourLeaderGetter.setNameOfCountriesKnow(toEditTourLeader[0].getNameOfCountriesKnow());
            tourLeaderGetter.setCitiesKnow(toEditTourLeader[0].getCitiesKnow());
            tourLeaderGetter.setEmail(toEditTourLeader[0].getEmail());
            tourLeaderGetter.setPhoneNumber(toEditTourLeader[0].getPhoneNumber());
            tourLeaderGetter.setUserName(toEditTourLeader[0].getUserName());
            tourLeaderGetter.setPassword(toEditTourLeader[0].getPassword());
        }
        if (type == 0 || type == 1){
            System.out.println("\nFirst Name:");
            firstName = scanner.nextLine();
            tourLeaderGetter.setFirstName(firstName);
        }
        if (type == 0 || type == 2){
            System.out.println("\nLast Name:");
            lastName = scanner.nextLine();
            tourLeaderGetter.setLastName(lastName);
        }
        if (type == 0 || type == 3){
            System.out.println("\nNational code: ");
            nationalCode = scanner.nextLong();
            tourLeaderGetter.setNationalCode(nationalCode);
        }
        if (type == 0 || type == 4){
            System.out.println("\nIdentify Number: ");
            identityNum = scanner.nextLong();
            tourLeaderGetter.setIdentityNum(identityNum);
        }
        if (type == 0 || type == 5){
            while (true){
                System.out.println("\nBirthDay Date: day->");
                day = scanner.nextInt();
                System.out.println("\nmonth->");
                month = scanner.nextInt();
                System.out.println("\nyear->");
                year = scanner.nextInt();
                birthDate.setDate(year,month,day);
                if (birthDate.getDay() == 0 && birthDate.getMonth() == 0 && birthDate.getYear() == 0 ){
                    System.out.println("\n wrong path !!!");
                    continue;
                }
                break;
            }
            tourLeaderGetter.setBirthDate(birthDate);
        }
        boolean EmailIsValid , phoneNumberIsValid;
        Scanner scanner1 = new Scanner(System.in);
        if (type == 0 || type == 9){
            do {
                String phoneNumber;
                System.out.println("\nPhone number:");
                phoneNumber = scanner1.nextLine();
                phoneNumberIsValid = tourLeaderGetter.setPhoneNumber(phoneNumber);
            }while (!phoneNumberIsValid);
        }
        scanner = new Scanner(System.in);
        if (type == 0 || type == 8){
            do {
                String Email;
                System.out.println("\nE-mail:");
                Email = scanner.nextLine();
                EmailIsValid = tourLeaderGetter.setEmail(Email);
            }while (!EmailIsValid);
        }
        if (type == 0 || type == 6){
            System.out.println("\nis married? ( Yes->'1' , No->'2' ) :");
            while (true){
                marriedChoice = scanner.nextInt();
                if (marriedChoice == 1){ married = true; break; }
                else if (marriedChoice == 2){ married = false; break; }
            }
            tourLeaderGetter.setMarried(married);
        }
        if (type == 0 ){
            System.out.println("\nLocations knows:\n");
            addLocationsForTourLeader(tourLeaderGetter,countries);
        }
        if (type == 7){
            while (true) {
                System.out.println("edit tour leader's locations:\n1.add\n2.delete\n3.back\nEnter a number:");
                choice = scanner.nextInt();
                if (choice == 1){
                    addLocationsForTourLeader(tourLeaderGetter , countries);
                    break;
                }
                else if (choice == 2){
                    deleteLocationForTourLeader(tourLeaderGetter , countries);
                    break;
                }
                else if (choice == 3){ break; }
            }
        }
        return tourLeaderGetter;
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void deleteLocationForTourLeader(TourLeader tourLeader , List<Country> countries){
        int choice , deleteChoice ;
        Scanner scanner = new Scanner(System.in) ;
        while (true) {
            System.out.println("tour leader: " + tourLeader.getFirstName() + " " + tourLeader.getLastName());
            System.out.println("1.delete country(if you delete a country ,related cities will be deleted too.)\n2.delete city\n3.back\nEnter a number:");
            choice = scanner.nextInt();
            if (choice == 1) {
                while (true){
                    showTourLeaderCountries(tourLeader);
                    System.out.println("\nwhich one you want to be deleted?(back-> '0')\nEnter a number");
                    deleteChoice = scanner.nextInt();
                    if (deleteChoice == 0){ break; }
                    else if (deleteChoice > 0 && deleteChoice <= tourLeader.getNameOfCountriesKnow().size()){
                        String deleteCountryName = tourLeader.getNameOfCountriesKnow().get(deleteChoice-1);
                        for (int i=tourLeader.getCitiesKnow().size()-1 ; i>=0 ; i--){
                            if (tourLeader.getCitiesKnow().get(i).getCountryName().equals(deleteCountryName)){
                                tourLeader.removeCityKnow(i);
                            }
                        }
                        tourLeader.removeNameOfCountriesKnow(deleteChoice-1);
                        System.out.println("country deleted.");
                    }
                    else {
                        System.out.println("do not exist.");
                        break;
                    }
                }
            } else if (choice == 2) {
                int  countryChoice;
                while (true){
                    showTourLeaderCountries(tourLeader);
                    System.out.println("\n0.back\nEnter a number:");
                    countryChoice = scanner.nextInt();
                    if (countryChoice == 0){ break; }
                    else if (countryChoice > 0 && countryChoice <= tourLeader.getNameOfCountriesKnow().size()){
                        while (true){
                            int chosenCountryCitiesNum ;
                            int[] a =new int[100];
                            chosenCountryCitiesNum =numOfCitiesOfTourLeaderCountry( tourLeader , tourLeader.getNameOfCountriesKnow().get(countryChoice-1) , a );
                            if (chosenCountryCitiesNum == 0){
                                int toAddChoice;
                                System.out.println("no cities from this country is added.(want to add? -> '1'");
                                toAddChoice = scanner.nextInt();
                                if (toAddChoice==1){
                                    Location.addLocation(countries);
                                }
                            }
                            System.out.println("\ncities from "+tourLeader.getNameOfCountriesKnow().get(countryChoice-1)+":");
                            for (int i=1 ; i<=chosenCountryCitiesNum ; i++){
                                System.out.println(i+":"+tourLeader.getCityKnow(a[i-1]).getName());
                            }
                            System.out.println("\nwhich one you want to be deleted?(back-> '0')\nEnter a number");
                            deleteChoice = scanner.nextInt();
                            if (deleteChoice == 0){break;}
                            else if (deleteChoice <= chosenCountryCitiesNum && deleteChoice > 0){
                                tourLeader.removeCityKnow(a [deleteChoice-1]);
                            }
                            else {
                                System.out.println("not found.");
                            }
                        }
                    }
                    else {
                        System.out.println("do not exist.");
                    }
                }

            } else if (choice == 3) {
                break;
            }
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void addLocationsForTourLeader(TourLeader tourLeader , List<Country> countries){
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nadd new locations:");
        if (countries.size() == 0){
            System.out.println("no country exist.\nwant to add? (Yes->'1' , No->any other number)\nenter a number:");
            choice = scanner.nextInt();
            if (choice == 1){
                Location.addCountry(countries);
            }
        }
        while (true){
            Location.showCountries(countries , true );
            System.out.println("choose a country:(back->'0')\nEnter a number");
            choice = scanner.nextInt();
            if (choice == 0){break;}
            else if (choice > 0 && choice <= countries.size()){
                int cityChoice;
                while (true){
                    System.out.println("\nwhich one you want to add?(back->'0')\n");
                    Location.showCities(countries.get(choice-1),1);
                    System.out.println("Enter a number:");
                    cityChoice = scanner.nextInt();
                    if (cityChoice == 0){ break; }
                    else if (cityChoice>0 && cityChoice<=countries.get(choice-1).getCities().size()){
                        if (tourLeader.getCitiesKnow().contains(countries.get(choice-1).getCities().get(cityChoice-1))){
                            System.out.println("this city is already added.");
                            continue;
                        }
                        tourLeader.addCityKnow(countries.get(choice-1).getCities().get(cityChoice-1));
                        if (!TourLeader.checkRepeatCountryNameKnow(tourLeader , countries.get(choice-1).getCities().get(cityChoice-1).getCountryName())){
                            tourLeader.addNameOfCountriesKnow(countries.get(choice-1).getCities().get(cityChoice-1).getCountryName());
                        }
                    }
                    else {
                        System.out.println("do not exist.");
                    }
                }
            }
            else {
                System.out.println("do not exist.");
            }
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void showTourLeaders(List<TourLeader> tourLeaders){
        int  num;
        System.out.println("\nThe Tour Leaders :");
        if (tourLeaders.size() == 0) System.out.println("no tour leader exist.");
        for (int i=0 ; i<tourLeaders.size() ; i++){
            num = i+1 ;
            System.out.println("\n" + num +": "+ tourLeaders.get(i).toString());
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void showTourLeaderCountries(TourLeader tourLeader){
        int num = 1 ;
        System.out.println("\ncountries know:\n");
        for (String name : tourLeader.getNameOfCountriesKnow()){
            System.out.println(num + "." + name);
            num++;
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static int numOfCitiesOfTourLeaderCountry(TourLeader tourLeader , String countryName , int[]numbers){
        int a=0;
        for (int i=0 ; i<tourLeader.getCitiesKnow().size() ; i++){
            if (tourLeader.getCityKnow(i).getCountryName().equals(countryName)){
                numbers[a]=i;
                a++;
            }
        }
        return a;
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void deleteTourLeader(List<TourLeader> tourLeaders , int choice){
        if (choice > 0 && choice <= tourLeaders.size()){
            tourLeaders.remove(choice-1);
            System.out.println("\ntour leader " + choice + " deleted.\n");
        }
        else if (choice!=0){
            System.out.println("not available.");
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void editTourLeader(List<TourLeader> tourLeaders , List<Country> countries , int tourLeaderChoice){
        Scanner scanner = new Scanner(System.in);
        int  editTypechoice;
        if (tourLeaderChoice > 0 && tourLeaderChoice <= tourLeaders.size()) {
            System.out.println("which part do you want to edit?\n1.first name\n2.last name\n3.national code\n4.identity number\n5.birth date\n" +
                    "6.marriage\n7.Locations know\n8.E-mail\n9.Phone Number\n0.back\nEnter a Number: ");
            while (true){
                editTypechoice = scanner.nextInt();
                if (editTypechoice == 0){ break; }
                else if(editTypechoice == 1){
                    tourLeaders.add(tourLeaderChoice-1 , getTourLeader(1 ,countries, tourLeaders.get(tourLeaderChoice-1)));
                    tourLeaders.remove(tourLeaderChoice);
                    System.out.println("\nfirst name edited");
                    break;
                }
                else if(editTypechoice == 2){
                    tourLeaders.add(tourLeaderChoice-1 , getTourLeader(2 ,countries, tourLeaders.get(tourLeaderChoice-1)));
                    tourLeaders.remove(tourLeaderChoice);
                    System.out.println("\nlast name edited");
                    break;
                }
                else if(editTypechoice == 3){
                    tourLeaders.add(tourLeaderChoice-1 , getTourLeader(3 ,countries, tourLeaders.get(tourLeaderChoice-1)));
                    tourLeaders.remove(tourLeaderChoice);
                    System.out.println("\nnational code edited");
                    break;
                }
                else if(editTypechoice == 4){
                    tourLeaders.add(tourLeaderChoice-1 , getTourLeader(4 ,countries , tourLeaders.get(tourLeaderChoice-1)));
                    tourLeaders.remove(tourLeaderChoice);
                    System.out.println("\nidentity number edited.\n");
                    break;
                }
                else if(editTypechoice == 5){
                    tourLeaders.add(tourLeaderChoice-1 , getTourLeader(5 ,countries, tourLeaders.get(tourLeaderChoice-1)));
                    tourLeaders.remove(tourLeaderChoice);
                    System.out.println("\nBirthDay Date edited.\n");
                    break;
                }
                else if(editTypechoice == 6){
                    tourLeaders.add(tourLeaderChoice-1 , getTourLeader(6 ,countries,tourLeaders.get(tourLeaderChoice-1)));
                    tourLeaders.remove(tourLeaderChoice);
                    System.out.println("\nmarriage edited.\n");
                    break;
                }
                else if(editTypechoice == 7){
                    tourLeaders.add(tourLeaderChoice-1 , getTourLeader(7,countries , tourLeaders.get(tourLeaderChoice-1)));
                    tourLeaders.remove(tourLeaderChoice);
                    System.out.println("\nLocations edited.\n");
                    break;
                }
                else if(editTypechoice == 8){
                    tourLeaders.add(tourLeaderChoice-1 , getTourLeader(8 ,countries, tourLeaders.get(tourLeaderChoice-1)));
                    tourLeaders.remove(tourLeaderChoice);
                    System.out.println("\nE-mail edited");
                    break;
                }
                else if(editTypechoice == 9){
                    tourLeaders.add(tourLeaderChoice-1 , getTourLeader(9 ,countries, tourLeaders.get(tourLeaderChoice-1)));
                    tourLeaders.remove(tourLeaderChoice);
                    System.out.println("\nPhone Number edited");
                    break;
                }
            }
        }
        else if (tourLeaderChoice != 0) {
            System.out.println("not found.");
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void searchTourLeader(List<TourLeader> tourLeaders,List<Country> countries ){
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("\nchoose the way of the search:\n1.First Name\n2.LastName\n3.Locations Know\n4.Age\n5.back\nyour choice: ");
            choice = scanner.nextInt();
            if (choice == 1){ searchTourLeaderByName(tourLeaders , countries , 1);  }
            else if (choice == 2){ searchTourLeaderByName(tourLeaders, countries , 2);  }
            else if (choice == 3){ searchTourLeaderByLocations(tourLeaders, countries);  }
            else if (choice == 4){
                int type;
                while (true){
                    System.out.println("\nwhich type?\n1.certain age\n2.older than\n3.younger than\n4.various between\n5.back\nEnter a number: ");
                    type = scanner.nextInt();
                    if (type>=1 && type<=4) searchTourLeaderByAge(tourLeaders, countries ,type );
                    else if (type == 5){break;}
                }
            }
            else if (choice == 5){ break; }

        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void searchTourLeaderByName(List<TourLeader> tourLeaders ,  List<Country> countries , int type){
        Scanner scanner = new Scanner(System.in);
        int choice ;
        List<TourLeader> searchedTourLeaders = new ArrayList<>() ;
        String searchName ;
        while (true){
            System.out.println("Enter the name you want to search:(back->'0')");
            searchName = scanner.nextLine();
            if (searchName.contains("0")){ break; }
            else if (searchName.equals("") || searchName.equals(" ")){
                System.out.println("nothing entered.");
                continue;
            }
            for (TourLeader tourLeader : tourLeaders){
                if (type == 1 && tourLeader.getFirstName().contains(searchName)){
                    searchedTourLeaders.add(tourLeader);
                }
                else if (type == 2 && tourLeader.getLastName().contains(searchName)){
                    searchedTourLeaders.add(tourLeader);
                }
            }
            if (searchedTourLeaders.size() == 0){
                System.out.println("no tour leader found.");
                break;
            }
            else {
                System.out.println(searchedTourLeaders.size()+"tour leader(s) found.");
                showTourLeaders(searchedTourLeaders);
                System.out.println("0.Back\nEnter a number:");
                choice = scanner.nextInt();
                int choice2;
                if (choice>0 && choice<=searchedTourLeaders.size()){
                    System.out.println("tour leader: " + searchedTourLeaders.get(choice-1).toString());
                    System.out.println("\n1.edit\n2.delete\n3.back\nEnter a number: ");
                    while (true){
                        choice2 = scanner.nextInt();
                        if (choice2 == 1){
                            editTourLeader(tourLeaders,countries,1+tourLeaders.indexOf(searchedTourLeaders.get(choice-1)));
                        }
                        else if (choice2 == 2){
                            deleteTourLeader(tourLeaders,1+tourLeaders.indexOf(searchedTourLeaders.get(choice-1)));
                        }
                        else if (choice2 == 3){ break; }
                    }
                }
                else if (choice !=0 ){
                    System.out.println("not available.");
                }
                else {break;}
            }
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void searchTourLeaderByLocations(List<TourLeader> tourLeaders ,  List<Country> countries){

    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void searchTourLeaderByAge(List<TourLeader> tourLeaders , List<Country> countries , int type){
        Scanner scanner = new Scanner(System.in);
        List<TourLeader> searchedTourLeaders = new ArrayList<>() ;
        int searchingAge=0 , fromAge = 0 , toAge = 0 ,choice , choice2 ;
        while (true){
            if (type == 4){
                System.out.println("from: ");
                fromAge = scanner.nextInt();
                System.out.println("to: ");
                toAge = scanner.nextInt();
            }
            else {
                System.out.println("age to be searched: ");
                searchingAge = scanner.nextInt();
            }
            if ((fromAge <= 0 || toAge <= 0) && searchingAge <= 0){
                System.out.println("wrong age.");
            }
            else {
                for (TourLeader tourLeader : tourLeaders){
                    if (((tourLeader.getAge() == searchingAge) && (type == 1)) || ((tourLeader.getAge() > searchingAge) && (type == 2))
                            || ((tourLeader.getAge() < searchingAge) && (type == 3))
                            || ((tourLeader.getAge() > fromAge) && (tourLeader.getAge() < toAge) && (type == 4))){
                        searchedTourLeaders.add(tourLeader);
                    }
                }
                if (searchedTourLeaders.size() == 0){
                    System.out.println("nothing found.");
                    continue;
                }
                System.out.println(searchedTourLeaders.size()+"tour leader(s) found.");
                showTourLeaders(searchedTourLeaders);
                System.out.println("0.Back\nEnter a number:");
                choice = scanner.nextInt();
                if (choice>0 && choice<=searchedTourLeaders.size()){
                    System.out.println("\ntour leader: " + searchedTourLeaders.get(choice-1).toString());
                    System.out.println("1.edit\n2.delete\n3.back\nEnter a number: ");
                    while (true){
                        choice2 = scanner.nextInt();
                        if (choice2 == 1){
                            editTourLeader(tourLeaders,countries,1+tourLeaders.indexOf(searchedTourLeaders.get(choice-1)));
                        }
                        else if (choice2 == 2){
                            deleteTourLeader(tourLeaders,1+tourLeaders.indexOf(searchedTourLeaders.get(choice-1)));
                        }
                        else if (choice2 == 3){ break; }
                    }
                }
                else if (choice !=0 ){
                    System.out.println("not available.");
                }
                break;
            }
        }

    }
}

