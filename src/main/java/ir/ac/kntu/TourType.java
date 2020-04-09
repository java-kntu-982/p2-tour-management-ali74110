package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TourType {

    private String name;
    private int minimumParticipants;
    private int maximumParticipants;
    private int duration;
    private int cost;
    private boolean international;
    private int tourNum = 1 ;
    private Country toGoCountry;
    private City beginningCity;
    private City endingCity;
    private List<City> citiesToSee; //= new ArrayList<>();

    private City toGo;
    private Place beginningPlace ;
    private Place endingPlace;
    private List<Place> placesToSee;// = new ArrayList<>();
    /*-------------------------------------------------------------------------------------------------------------------*/

    public int getTourNum() {
        return tourNum;
    }

    public void setTourNum(int tourNum) {
        this.tourNum = tourNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinimumParticipants() {
        return minimumParticipants;
    }

    public void setMinimumParticipants(int minimumParticipants) {
        this.minimumParticipants = minimumParticipants;
    }

    public int getMaximumParticipants() {
        return maximumParticipants;
    }

    public void setMaximumParticipants(int maximumParticipants) {
        this.maximumParticipants = maximumParticipants;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isInternational() {
        return international;
    }

    public void setInternational(boolean international) {
        this.international = international;
    }

    public City getBeginningCity() {
        return beginningCity;
    }

    public void setBeginningCity(City beginningCity) {
        this.beginningCity = beginningCity;
    }

    public City getEndingCity() {
        return endingCity;
    }

    public void setEndingCity(City endingCity) {
        this.endingCity = endingCity;
    }

    public List<City> getCitiesToSee() {
        return citiesToSee;
    }

    public void setCitiesToSee(List<City> citiesToSee) {
        this.citiesToSee = citiesToSee;
    }

    public City getToGo() {
        return toGo;
    }

    public void setToGo(City toGo) {
        this.toGo = toGo;
    }

    public Place getBeginningPlace() {
        return beginningPlace;
    }

    public void setBeginningPlace(Place beginningPlace) {
        this.beginningPlace = beginningPlace;
    }

    public Place getEndingPlace() {
        return endingPlace;
    }

    public void setEndingPlace(Place endingPlace) {
        this.endingPlace = endingPlace;
    }

    public List<Place> getPlacesToSee() {
        return placesToSee;
    }

    public void setPlacesToSee(List<Place> placesToSee) {
        this.placesToSee = placesToSee;
    }

    public Country getToGoCountry() {
        return toGoCountry;
    }

    public void setToGoCountry(Country toGoCountry) {
        this.toGoCountry = toGoCountry;
    }

    public String toString(){
        return name + ": " + duration +" days, cost= " + cost ;
    }
    /*-------------------------------------------------------------------------------------------------------------------*/
    public static void addTourType (List<TourType> tourTypes , List<Country> countries){
            while (true){
                Scanner scanner = new Scanner(System.in);
                int choice;
                int minimumParticipants;
                int maximumParticipants;
                int duration;
                int cost;
                boolean international;
                System.out.println("\n<<tour type adder>>\n1.international tour\n2.Iran tour\n3.back");
                choice = scanner.nextInt();
                if (choice == 1){
                    addInternationalTourType(tourTypes , countries);
                }
                else if (choice == 2){
                    addIranTourType(tourTypes , countries);
                }
                else if (choice == 3){break;}
            }
        }

        public static void addInternationalTourType (List<TourType> tourTypes , List<Country> countries){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int choice, choice3, minimumParticipants, maximumParticipants, duration, cost;
            boolean international;
            Country toGoCountry;
            City beginningCity, endingCity;
            List<City> citiesToSee = new ArrayList<>();
            if (countries.size() == 1) {
                System.out.println("\nfirst add country.(want to? ->'1'): ");
                int choice2 = scanner.nextInt();
                if (choice2 == 1) {
                    Place.addCountry(countries);
                    continue;
                }
                else { break; }
            }
            while (true) {
                System.out.println("choose a country for tour:");
                for (int i = 1; i < countries.size(); i++) {
                    System.out.println(i + ". " + countries.get(i).getName());
                }
                choice = scanner.nextInt();
                if (choice > 0 && choice < countries.size()) {
                    toGoCountry = countries.get(choice);
                    break;
                } else {
                    System.out.println("country does not exist.");
                }
            }
            while (true) {
                System.out.println("\nhow many days: ");
                duration = scanner.nextInt();
                if (duration > toGoCountry.getCities().size()) {
                    System.out.println("Enter less .(less cities from this country is saved.) or add city?->'1': ");
                    int choice2 = scanner.nextInt();
                    if (choice2 == 1) {
                        Place.addCity(toGoCountry);
                    }
                } else if (duration > 0) {
                    break;
                }
            }
            do {
                System.out.println("\nhow much does it cost: ");
                cost = scanner.nextInt();
            } while (cost <= 0);
            international = true;
            do {
                System.out.println("\nminimum participants: ");
                minimumParticipants = scanner.nextInt();
            } while (minimumParticipants <= 0);
            do {
                System.out.println("\nmaximum participants: ");
                maximumParticipants = scanner.nextInt();
            } while (maximumParticipants <= 0 || maximumParticipants < minimumParticipants);
            System.out.println("choose cities want to visit during tour:");
            for (int i = 0; i < duration; i++) {
                while (true) {
                    Place.showCities(toGoCountry, 2);
                    System.out.println("Enter a number: ");
                    choice3 = scanner.nextInt();
                    if (choice3 > 0 && choice3 <= toGoCountry.getCities().size()) {
                        citiesToSee.add(toGoCountry.getCities().get(choice3 - 1));
                        break;
                    } else {
                        System.out.println("wrong number.");
                    }
                }
            }
            beginningCity = citiesToSee.get(0);
            endingCity = citiesToSee.get(duration - 1);

            TourType tourTypeAdder = new TourType();
            tourTypeAdder.setName(toGoCountry.getName());
            tourTypeAdder.setBeginningCity(beginningCity);
            tourTypeAdder.setCitiesToSee(citiesToSee);
            tourTypeAdder.setEndingCity(endingCity);
            tourTypeAdder.setToGoCountry(toGoCountry);
            tourTypeAdder.setCost(cost);
            tourTypeAdder.setDuration(duration);
            tourTypeAdder.setInternational(international);
            tourTypeAdder.setMinimumParticipants(minimumParticipants);
            tourTypeAdder.setMaximumParticipants(maximumParticipants);
            tourTypes.add(tourTypeAdder);
            System.out.println("tour type added.");
            break;
        }
    }
    /*-------------------------------------------------------------------------------------------------------------------*/
    public static void addIranTourType (List<TourType> tourTypes , List<Country> countries){
        Scanner scanner = new Scanner(System.in);
        int choice , minimumParticipants ,maximumParticipants , duration , cost;
        boolean international;
        City toGo ;
        Place beginningPlace = new Place() , endingPlace = new Place();
        List<Place> placesToSee = new ArrayList<>();
        Place.showCities(countries.get(0),2);
        while (true){
            System.out.println("\nchoose the city tour want to visit:");
            choice = scanner.nextInt();
            if (choice > 0 && choice <= countries.get(0).getCities().size()){
                toGo = countries.get(0).getCities().get(choice-1);
                break;
            }
            else {
                System.out.println("city do not exist.");
            }
        }
        do {
            System.out.println("how many days: ");
            duration = scanner.nextInt();
        } while (duration <= 0);
        do {
            System.out.println("how much does it cost: ");
            cost = scanner.nextInt();
        } while (cost <= 0);
        do {
            System.out.println("minimum participants: ");
            minimumParticipants = scanner.nextInt();
        } while (minimumParticipants <= 0);
        do {
            System.out.println("maximum participants: ");
            maximumParticipants = scanner.nextInt();
        } while (maximumParticipants <= 0 || maximumParticipants < minimumParticipants);
        international = false ;
        String placeName;
        Place placeAdder = new Place();
        for (int i=0 ; i<duration ; i++ ){
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("places to see:");
            placeName = scanner2.nextLine();
            placeName = placeName.trim().toLowerCase();
            placeAdder.setName(placeName);
            placesToSee.add(placeAdder);
        }
        if (duration==1){
            beginningPlace = placeAdder;
            endingPlace = placeAdder ;
        }
        else {
            beginningPlace=placesToSee.get(0);
            endingPlace = placesToSee.get(duration-1);
        }
        System.out.println("tour type added.");

        TourType tourTypeAdder = new TourType();
        tourTypeAdder.setToGo(toGo);
        tourTypeAdder.setName(toGo.getName());
        tourTypeAdder.setEndingPlace(endingPlace);
        tourTypeAdder.setBeginningPlace(beginningPlace);
        tourTypeAdder.setCost(cost);
        tourTypeAdder.setDuration(duration);
        tourTypeAdder.setInternational(international);
        tourTypeAdder.setMinimumParticipants(minimumParticipants);
        tourTypeAdder.setMaximumParticipants(maximumParticipants);
        tourTypeAdder.setPlacesToSee(placesToSee);
        tourTypes.add(tourTypeAdder);
    }


    /*-------------------------------------------------------------------------------------------------------------------*/
    public static void showTourTypes(List<TourType> tourTypes){
        int num =1 ;
        System.out.println("<<tour types>>");
        for (TourType tourType : tourTypes){
            System.out.println(num+". "+tourType.toString());
            num++;
        }
    }
    /*-------------------------------------------------------------------------------------------------------------------*/
    public static void editTourType(List<TourType> tourTypes,List<Country> countries){
        Scanner scanner = new Scanner(System.in);
        int choice , tourTypeChoice;
        int duration;

        while (true){
            System.out.println("which tour type you want to edit? (back->'0')");
            showTourTypes(tourTypes);
            tourTypeChoice = scanner.nextInt();
            if (tourTypeChoice>0 || tourTypeChoice<=tourTypes.size()){
                System.out.println("\nwhich part you want to edit?\n1.duration and Area of tour type\n2.min and max of participants\n3.back\nEnter an number: ");
                choice = scanner.nextInt();
                if (choice == 1){
                    while (true){
                        if (tourTypes.get(tourTypeChoice-1).isInternational()){
                            Country toGoCountry;
                            City beginningCity, endingCity;
                            List<City> citiesToSee = new ArrayList<>();
                            while (true) {
                                System.out.println("choose a country for tour:");
                                for (int i = 1; i < countries.size(); i++) {
                                    System.out.println(i + ". " + countries.get(i).getName());
                                }
                                int choice2 = scanner.nextInt();
                                if (choice2 > 0 && choice2 < countries.size()) {
                                    toGoCountry = countries.get(choice2);
                                    break;
                                } else {
                                    System.out.println("country does not exist.");
                                }
                            }
                            while (true) {
                                System.out.println("\nhow many days: ");
                                duration = scanner.nextInt();
                                if (duration > toGoCountry.getCities().size()) {
                                    System.out.println("Enter less .(less cities from this country is saved.) or add city?->'1': ");
                                    int choice2 = scanner.nextInt();
                                    if (choice2 == 1) {
                                        Place.addCity(toGoCountry);
                                    }
                                } else if (duration > 0) {
                                    break;
                                }
                            }
                            if (countries.size() == 1) {
                                System.out.println("\nfirst add country.(want to? ->'1'): ");
                                int choice2 = scanner.nextInt();
                                if (choice2 == 1) {
                                    Place.addCountry(countries);
                                    continue;
                                }
                                else { break; }
                            }
                            System.out.println("choose cities want to visit during tour:");
                            for (int i = 0; i < duration; i++) {
                                while (true) {
                                    Place.showCities(toGoCountry, 2);
                                    System.out.println("Enter a number: ");
                                    int choice3 = scanner.nextInt();
                                    if (choice3 > 0 && choice3 <= toGoCountry.getCities().size()) {
                                        citiesToSee.add(toGoCountry.getCities().get(choice3 - 1));
                                        break;
                                    } else {
                                        System.out.println("wrong number.");
                                    }
                                }
                            }
                            if (duration==1){
                                beginningCity = endingCity = citiesToSee.get(0);
                            }
                            else {
                                beginningCity = citiesToSee.get(0);
                                endingCity = citiesToSee.get(duration-1);
                            }
                            tourTypes.get(tourTypeChoice-1).setDuration(duration);
                            tourTypes.get(tourTypeChoice-1).setName(toGoCountry.getName());
                            tourTypes.get(tourTypeChoice-1).setCitiesToSee(citiesToSee);
                            tourTypes.get(tourTypeChoice-1).setBeginningCity(beginningCity);
                            tourTypes.get(tourTypeChoice-1).setEndingCity(endingCity);
                            tourTypes.get(tourTypeChoice-1).setTourNum(1);
                            tourTypes.get(tourTypeChoice-1).setToGoCountry(toGoCountry);
                            break;
                        }

                        else {
                            Place beginningPlace  , endingPlace ;
                            List<Place> placesToSee = new ArrayList<>();
                            City toGoCity;
                            do {
                                System.out.println("how many days: ");
                                duration = scanner.nextInt();
                            } while (duration <= 0);
                            tourTypes.get(tourTypeChoice-1).setDuration(duration);
                            Place.showCities(countries.get(0),2);
                            while (true){
                                System.out.println("\nchoose the city tour want to visit:");
                                int choice2 = scanner.nextInt();
                                if (choice2 > 0 && choice2 <= countries.get(0).getCities().size()){
                                    toGoCity = countries.get(0).getCities().get(choice2-1);
                                    break;
                                }
                                else {
                                    System.out.println("city do not exist.");
                                }
                            }
                            tourTypes.get(tourTypeChoice-1).setToGo(toGoCity);
                            String placeName;
                            Place placeAdder = new Place();
                            for (int i=0 ; i<duration ; i++ ){
                                Scanner scanner2 = new Scanner(System.in);
                                System.out.println("places to see:");
                                placeName = scanner2.nextLine();
                                placeName = placeName.trim().toLowerCase();
                                placeAdder.setName(placeName);
                                placesToSee.add(placeAdder);
                            }
                            tourTypes.get(tourTypeChoice-1).setPlacesToSee(placesToSee);
                            tourTypes.get(tourTypeChoice-1).setName(toGoCity.getName());
                            if (duration==1){
                                beginningPlace = placeAdder;
                                endingPlace = placeAdder ;
                            }
                            else {
                                beginningPlace=placesToSee.get(0);
                                endingPlace = placesToSee.get(duration-1);
                            }
                            tourTypes.get(tourTypeChoice-1).setBeginningPlace(beginningPlace);
                            tourTypes.get(tourTypeChoice-1).setEndingPlace(endingPlace);
                            tourTypes.get(tourTypeChoice-1).setTourNum(1);
                            break;
                        }
                    }
                }
                else if (choice == 2){
                    int minimumParticipants ,maximumParticipants ;
                    do {
                        System.out.println("minimum participants: ");
                        minimumParticipants = scanner.nextInt();
                    } while (minimumParticipants <= 0);
                    do {
                        System.out.println("maximum participants: ");
                        maximumParticipants = scanner.nextInt();
                    } while (maximumParticipants <= 0 || maximumParticipants < minimumParticipants);
                    tourTypes.get(tourTypeChoice-1).setMinimumParticipants(minimumParticipants);
                    tourTypes.get(tourTypeChoice-1).setMaximumParticipants(maximumParticipants);
                }
                else if (choice == 3){
                }
                else if (choice == 4){
                    break;
                }
            }
            else if(tourTypeChoice == 0){
                break;
            }
            else {
                System.out.println("not found.");
            }
        }

    }
    /*-------------------------------------------------------------------------------------------------------------------*/
}
