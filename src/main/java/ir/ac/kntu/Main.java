package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;
import org.checkerframework.checker.units.qual.C;


import java.util.*;

/**
 * @author Seyed Ali Toliat
 */
public class Main {
    public static void main(String[] args) {
        List<Tour> tours= new ArrayList<>();
        List<TourType> tourTypes= new ArrayList<>();
        List<TourLeader> tourLeaders = new ArrayList<>();
        List<Country> countries = new ArrayList<>();
        List<User> acceptedUsers = new ArrayList<>();

        User adminUser = new User("admin","123","admin@yahoo.com","09191234567",AccessLevel.Admin);

        acceptedUsers.add(adminUser);

        entrance(tours,tourTypes,tourLeaders,countries,acceptedUsers);

    }

    public static void entrance(List<Tour> tours , List<TourType> tourTypes , List<TourLeader> tourLeaders , List<Country> countries , List<User> acceptedUsers){
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            int choice;
            System.out.println("<< tour management >>\n1.sign in\n2.exit\nEnter a number: ");
            choice = scanner.nextInt();
            if (choice == 1){
                Country.addIranCities(countries);
                User userSignedIn = User.signIn(acceptedUsers);
                mainMenu(tours,tourTypes,tourLeaders,countries,acceptedUsers,userSignedIn,userSignedIn.getAccessLevel());
            }
            else if (choice == 2) break;
        }
    }

    /*-----------------------------------------------------------------------------------------------*/
    public static void takeMeBack(){
        Scanner scanner = new Scanner(System.in);
        int choice ;
        System.out.println("\n1.Back\nEnter '1' : ");
        do {
            choice = scanner.nextInt();
        } while (choice != 1);
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void mainMenu(List<Tour> tours , List<TourType> tourTypes , List<TourLeader> tourLeaders , List<Country> countries ,
                                List<User> acceptedUsers,User signedInUser , AccessLevel accessLevel){
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("\nWelcome "+signedInUser.getUserName()+"\n<<Main Menu>>\n1.Tour Leaders\n2.Tours\n3.locations\n4.Map\n5.User setting\n6.Exit\nchoose a number :");
            choice = scanner.nextInt();
            if (choice == 1){
                TourLeader.tourLeaderMenu(tourLeaders,countries,accessLevel);
            }
            else if (choice == 2){
                Tour.tourMenu(tours , countries , tourTypes , tourLeaders,accessLevel);
            }
            else if (choice == 3){
                Location.LocationsMenu(countries ,accessLevel);
            }
            else if (choice == 4){
                mapMenu(tours);
            }
            else if (choice == 5){
                User.userMenu(acceptedUsers,signedInUser,accessLevel);
            }
            else if (choice == 6){ break; }
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------*/
    public static void mapMenu(List<Tour> tours){
        int choice;
        while (true){
            Scanner scanner3 = new Scanner(System.in);
            System.out.println("<< Map Menu >>\n1.in a tours\n2.show a country or a City in map\n3.show two cities in map\n4.Back\nEnter a number");
            choice = scanner3.nextInt();
            if (choice == 1){
                mapInTours(tours);
            } else if (choice == 2){
                Scanner scanner = new Scanner(System.in);
                String name;
                System.out.println("\nCity or Country Name:");
                name = scanner.nextLine();
                MapUtil.showMap(name);
            } else if (choice == 3){
                Scanner scanner = new Scanner(System.in);
                Scanner scanner2 = new Scanner(System.in);
                String city1 , city2 ;
                System.out.println("\nFirst city:");
                city1 = scanner.nextLine();
                System.out.println("Second city:");
                city2 = scanner2.nextLine();
                MapUtil.showMap(city1,city2);
            } else if (choice == 4){break; }
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void mapInTours(List<Tour> tours){
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("choose a tour:");
            Tour.showTours(tours);
            System.out.println("0.Back");
            choice = scanner.nextInt();
            if (choice == 0) break;
            else if (choice > 0 && choice <= tours.size()){
                mapInTour(tours.get(choice-1));
            }
        }
    }
    public static void mapInTour(Tour tour){
        while (true){
            Scanner scanner = new Scanner(System.in);
            int choice;
            System.out.println("\ntour : "+tour.toString());
            System.out.println("1.show beginning City\n2.show Destination City\n3.show beginning and Destination City together");
            if (tour.isInternational()){
                System.out.println("4.City now tour is in\n5.all Cities exist in tour ");
            }
            System.out.println("0.Back\nEnter a number:");
            choice = scanner.nextInt();
            if (choice == 1){
                if (!tour.isInternational()) {
                    MapUtil.showMap(tour.getToGo().getName());
                } else {
                    MapUtil.showMap(tour.getBeginningCity().getName());
                }
            } else if (choice == 2){
                if (tour.isInternational()){
                    MapUtil.showMap(tour.getEndingCity().getName());
                }
                else {
                    MapUtil.showMap(tour.getToGo().getName());
                }
            }else if (choice == 3){
                if (tour.isInternational()){
                    MapUtil.showMap(tour.getEndingCity().getName(),tour.getBeginningCity().getName());
                }
                else {
                    MapUtil.showMap(tour.getToGo().getName());
                }
            }else if (choice == 4 && tour.isInternational()){
                MapUtil.showMap(tour.getNowInCity().getName());
            }else if (choice == 5 && tour.isInternational()){
                for (City city : tour.getCitiesToSee())
                    MapUtil.showMap(city.getName());
            }else if (choice == 0){
                break;
            }
        }
    }
}
