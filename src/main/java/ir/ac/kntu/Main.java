package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;
import org.checkerframework.checker.units.qual.C;


import java.util.*;

/**
 * @author Seyed Ali Toliat
 */
public class Main {
    public static void main(String[] args) {
//        //Good for showing one location
//        MapUtil.showMap("Shiraz");
//        MapUtil.showMap("@29.6257966,52.5563165,17z");
//        //Good for showing two locations
//        MapUtil.showMap("Tehran","Dubai");
        List<Tour> tours= new ArrayList<>();
        List<TourType> tourTypes= new ArrayList<>();
        List<TourLeader> tourLeaders = new ArrayList<>();
        List<Country> countries = new ArrayList<>();

        String citiesofIran ="Tehran\tRazavi Khorasan\tMashhad\tNishapur\tSabzevar\tTorbat-e Heydarieh\t" +
                "East Azerbaijan\tTabriz\tMaragheh\tMarand\tAhar\t" +
                "Alborz\tKaraj\tIsfahan\tKashan\tKhomeyni Shahr\tNajafabad\t" +
                "Fars\tShiraz\tMarvdasht\tJahrom\tFasa\t" +
                "Khuzestan\tAhvaz\tDezful\tAbadan\tMahshahr\t" +
                "Mazandaran\tSari\tBabol\tAmol\tQa'em Shahr\t" +
                "West Azerbaijan\tUrmia\tKhoy\tBukan\tMahabad\t" +
                "Kerman\tSirjan\tRafsanjan\tJiroft\t" +
                "Gilan\tRasht\tBandar-e Anzali\tLahijan\t" +
                "Sistan and Baluchistan\tZahedan\tZabol\tIran Shahr\tChabahar\t" +
                "Kermanshah\tEslamabad-e Gharb\tJavanrud\tKangavar\t" +
                "Lorestan\tKhorramabad\tBorujerd\tDorud\tAligudarz\t" +
                "Hamadan\tMalayer\tNahavand\tAsadabad\t" +
                "Golestan\tGorgan\tGonbad-e Kavus\tBandar Torkaman\tAli Abad\t" +
                "Sanandaj\tSaghez\tMarivan\tBaneh\t" +
                "Bandar Abbas\tMinab\tQeshm\tKish\t" +
                "Arak\tSaveh\tKhomein\tMahallat\t" +
                "Ardabil\tParsabad\tMeshkinshahr\tKhalkhal\t" +
                "Qazvin\tAlvand\tMohammadiyeh\tTakestan\t" +
                "Qom\tQanavat\tJafariyeh\tKahak\t" +
                "Yazd\tMeybod\tArdakan\tBafq\tZanjan\t" +
                "Bushehr\tBandar Ganaveh\tBandar Kangan\t" +
                "Chahar Mahaal and Bakhtiari\tShahr-e Kord\tBorujen\tLordegan\tFarrokhshahr\t" +
                "North Khorasan\tBojnurd\tShirvan\tAshkhaneh" +
                "Kohgiluyeh and Boyer-Ahmad\tYasuj\tDehdasht\tLikak\t" +
                "Birjand\tGhayen\tTabas\tFerdows\t" +
                "Semnan\tDamghan\tGarmsar\t" +
                "Ilam\tDehloran\tEyvan\t";
        String[] citiesofIran2 ;
        citiesofIran2 = citiesofIran.split("\t");
        Country iran = new Country();
        iran.setName("iran");
        for (int i=0 ; i<citiesofIran2.length ; i++){
            citiesofIran2[i] = citiesofIran2[i].trim().toLowerCase();
            City iranCityAdder = new City();
            iranCityAdder.setCountryName("iran");
            iranCityAdder.setName(citiesofIran2[i]);
            iran.addCity(iranCityAdder);
        }
        countries.add(iran);

        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("\nWelcome\n<<Main Menu>>\n1.Tour Leaders\n2.Tours\n3.locations\n4.Map\n5.Exit\nchoose a number :");
            choice = scanner.nextInt();
            if (choice == 1){
                TourLeader.tourLeaderMenu(tourLeaders,countries);
            }
            else if (choice == 2){
                Tour.tourMenu(tours , countries , tourTypes , tourLeaders);
            }
            else if (choice == 3){
                Place.LocationsMenu(countries );
            }
            else if (choice == 4){
                mapMenu();
            }
            else if (choice == 5){ break; }
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

    public static void mapMenu(){

    }
    /*-----------------------------------------------------------------------------------------------*/

}
