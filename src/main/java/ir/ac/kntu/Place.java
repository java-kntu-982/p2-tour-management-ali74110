package ir.ac.kntu;

import java.util.List;
import java.util.Scanner;

public class Place {
    private String name ;
    private Double xCoordinate = 0.0 ;
    private Double yCoordinate = 0.0 ;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*-----------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------*/
    public static void LocationsMenu(List<Country> countries ){
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("\n<< Locations Menu >>\n1.show location\n2.add a location\n3.edit location\n4.delete a location\n5.Back\nEnter a number: ");
            choice = scanner.nextInt();
            if (choice == 1){ showCountries(countries , true); Main.takeMeBack(); }
            else if (choice == 2){addLocation(countries);}
            else if (choice == 3){editLocation(countries);}
            else if (choice == 4){deleteLocation(countries);}
            else if (choice == 5){ break; }
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void showCities(Country country , int type){
        int num = 1;
        if (country.getCities().size() == 0 && type!=2 ){
            int choice;
            Scanner scanner = new Scanner(System.in);
            System.out.println("no city exist.\nwant to add some?(Yes->'1' , No-> any number): ");
            choice = scanner.nextInt();
            if (choice == 1){
                addCity(country);
            }
        }
        System.out.println("cities of " + country.getName() + ":");
        for (City city : country.getCities()){
            System.out.println(num+ ". " + city.getName());
            num++;
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void showCountries(List<Country> countries , boolean showAll){
        int num = 1 ;
        if (countries.size() == 0){
            int choice;
            Scanner scanner = new Scanner(System.in);
            System.out.println("no country exist.\nwant to add some?(Yes->'1' , No-> any number): ");
            choice = scanner.nextInt();
            if (choice == 1){
                addCountry(countries);
            }
        }
        if (showAll){
            System.out.println("All Locations:("+countries.size()+" countries)");
            for (int i=0 ; i<countries.size() ; i++){
                //String cities = Country.citiesToString(countries.get(i).getCities());
                System.out.println(num+ ". " + countries.get(i).getName() + " : " + Country.citiesToString(countries.get(i).getCities()) );
                num++;
            }
        }
        else {
            System.out.println("countries:");
            for (int i=0 ; i<countries.size() ; i++){
                System.out.println(num+ ". " + countries.get(i).getName());
                num++;
            }
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void addLocation(List<Country> countries){
        Scanner scanner = new Scanner(System.in);
        int choice , countryChoice;
        while (true){
            System.out.println("\n1.add country\n2.add city\n3.Back\nEnter a number: ");
            choice = scanner.nextInt();
            if (choice == 1){
                addCountry(countries);
            }
            else if (choice == 2){
                while (true){
                    if (countries.size() == 0){
                        System.out.println("no country exist to add city to them.");
                        break;
                    }
                    showCountries(countries , false);
                    System.out.println("0.Back\nchoose a country: ");
                    countryChoice = scanner.nextInt();
                    if (countryChoice == 0){ break; }
                    else if (countryChoice > 0 && countryChoice <= countries.size()){
                        addCity(countries.get(countryChoice-1));
                    }
                    else {
                        System.out.println("do not exist");
                    }
                }
            }
            else if (choice == 3){ break; }
        }

    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void editLocation(List<Country> countries){
        Scanner scanner = new Scanner(System.in);
        int choice , countryChoice;
        while (true){
            System.out.println("\n1.edit country\n2.edit city\n3.Back\nEnter a number: ");
            choice = scanner.nextInt();
            if (choice == 1){
                editCountry(countries);
            }
            else if (choice == 2){
                while (true){
                    if (countries.size() == 0){
                        System.out.println("no country exist to edit city.");
                        break;
                    }
                    showCountries(countries ,false);
                    System.out.println("0.Back\nchoose a country: ");
                    countryChoice = scanner.nextInt();
                    if (countryChoice == 0){ break; }
                    else if (countryChoice > 0 && countryChoice <= countries.size()){
                        editCity(countries.get(countryChoice-1));
                    }
                    else {
                        System.out.println("do not exist.");
                    }
                }
            }
            else if (choice == 3){ break; }
        }

    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void deleteLocation(List<Country> countries){
        Scanner scanner = new Scanner(System.in);
        int choice , countryChoice;
        while (true){
            System.out.println("\n1.delete country\n2.delete city\n3.Back\nEnter a number: ");
            choice = scanner.nextInt();
            if (choice == 1){
                deleteCountry(countries);
            }
            else if (choice == 2){
                while (true){
                    if (countries.size() == 0){
                        System.out.println("no country exist to delete city.");
                        break;
                    }
                    showCountries(countries,false);
                    System.out.println("0.Back\nchoose a country: ");
                    countryChoice = scanner.nextInt();
                    if (countryChoice == 0){ break; }
                    else if (countryChoice > 0 && countryChoice <= countries.size()){
                        deleteCity(countries.get(countryChoice-1));
                    }
                    else {
                        System.out.println("do not exist.");
                    }
                }
            }
            else if (choice == 3){ break; }
        }

    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void addCity(Country country){
        Scanner scanner = new Scanner(System.in);
        String cityname ;
        while (true){
            System.out.println("\nadd a City: (don't want to add anymore -> '0') ");
            cityname = scanner.nextLine();
            if (cityname.contains("0")){ break; }
            if (cityname.equals("") || cityname.equals(" ")){
                System.out.println("nothing entered.");
                continue;
            }
            cityname = cityname.trim().toLowerCase();
            if (checkRepeatCity(country , cityname)){
                System.out.println("this Location is already saved.");
            }
            else {
                City cityAdder = new City();
                cityAdder.setName(cityname);
                cityAdder.setCountryName(country.getName());
                country.addCity(cityAdder);
            }
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void addCountry( List<Country> countries ){
        while (true){
            Scanner scanner = new Scanner(System.in);
            String countryname ;
            System.out.println("\nadd a country: (don't want to add anymore -> '0') ");
            countryname = scanner.nextLine();
            if (countryname.contains("0")){ break; }
            if (countryname.equals("") || countryname.equals(" ")){
                System.out.println("nothing entered.");
                continue;
            }
            countryname = countryname.trim().toLowerCase();
            if (checkRepeatCountry(countries , countryname)){
                System.out.println("this country is already saved.");
            }
            else {
                Country countryAdder = new Country();
                countryAdder.setName(countryname);
                countries.add(countryAdder);
                int choice;
                System.out.println("country added.\ndo you want to add some cities to this country?(Yes-> 1 , No-> any other number)");
                choice = scanner.nextInt();
                if (choice == 1){
                    addCity(countryAdder);
                }
                //break;
            }
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static boolean  checkRepeatCity(Country country , String cityName){
        boolean isRepeated = false;
        for (City city : country.getCities()){
            if (city.getName().equals(cityName)){
                isRepeated = true;
                break;
            }
        }
        return isRepeated ;
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static boolean   checkRepeatCountry(List<Country> countries , String countryName){
        boolean isRepeated = false;
        for (Country country : countries){
            if (country.getName().equals(countryName)){
                isRepeated = true;
                break;
            }
        }
        return isRepeated ;
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void editCity(Country country){
        Scanner scanner = new Scanner(System.in);
        int editChoice;
        String editedName;
        System.out.println("edit a city:");
        showCities(country,1);
        while (true){
            System.out.println("\n0. Back \nEnter a number: ");
            editChoice = scanner.nextInt();
            if (editChoice == 0){ break; }
            if (editChoice > country.getCities().size() || editChoice < 0 ){
                System.out.println("not available.");
                continue;
            }
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("\nchange to :");
            editedName = scanner2.nextLine();
            editedName = editedName.trim().toLowerCase();
            if (editedName.equals("") || editedName.equals(" ")){
                System.out.println("nothing entered.");
                continue;
            }
            if (checkRepeatCity(country , editedName)){
                System.out.println("this city is already saved.");
                continue;
            }
            City cityEditor = new City();
            country.getCities().remove(editChoice-1);
            cityEditor.setName(editedName);
            cityEditor.setCountryName(country.getName());
            country.getCities().add(editChoice-1,cityEditor);
            break;
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void editCountry(List<Country> countries){
        Scanner scanner = new Scanner(System.in);
        int editChoice;
        String editedName;
        System.out.println("edit a country:");
        showCountries(countries , false);
        while (true){
            System.out.println("\n0. Back \nEnter a number: ");
            editChoice = scanner.nextInt();
            if (editChoice == 0){ break; }
            if (editChoice > countries.size()){
                System.out.println("not available.");
                continue;
            }
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("\nchange to :");
            editedName = scanner2.nextLine();
            editedName = editedName.trim().toLowerCase();
            if (editedName.equals("") || editedName.equals(" ")){
                System.out.println("nothing entered.");
                continue;
            }
            if (checkRepeatCountry(countries , editedName)){
                System.out.println("this Location is already saved.");
                continue;
            }
            Country countryEditor = new Country();
            countries.remove(editChoice-1);
            countryEditor.setName(editedName);
            countries.add(editChoice-1,countryEditor);
            break;
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void deleteCountry(List<Country> countries){
        Scanner scanner = new Scanner(System.in);
        int deleteChoice;
        showCountries(countries , false);
        while (true){
            if (countries.size() == 0){
                System.out.println("no countries added to delete.");
                break;
            }
            System.out.println("\n0. Back \nEnter a number: ");
            deleteChoice = scanner.nextInt();
            if (deleteChoice == 0){ break; }
            if (deleteChoice > countries.size() || deleteChoice < 0){
                System.out.println("\ncountry not found.\n");
            }
            else{
                countries.remove(deleteChoice-1);
                System.out.println("country " + deleteChoice+" deleted." );
                break;
            }
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
    public static void deleteCity(Country country){
        Scanner scanner = new Scanner(System.in);
        int deleteChoice;
        showCities(country,1);
        while (true){
            if (country.getCities().size() == 0){
                System.out.println("no cities added to delete.");
                break;
            }
            System.out.println("\n0. Back \nEnter a number: ");
            deleteChoice = scanner.nextInt();
            if (deleteChoice == 0){ break; }
            if (deleteChoice > country.getCities().size() || deleteChoice < 0){
                System.out.println("\ncity not found.\n");
            }
            else{
                country.getCities().remove(deleteChoice-1);
                System.out.println("city " + deleteChoice+" deleted." );
                break;
            }
        }
    }
    /*-----------------------------------------------------------------------------------------------*/
}
