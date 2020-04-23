package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Country extends Location {
    private List<City> cities = new ArrayList<>();

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
    public void addCity(City city) {
        this.cities.add(city);
    }

    public List<City> getCities() {
        return cities;
    }

    public static String citiesToString(List<City> cities){
        String returnStr ="" ;
        returnStr +="[";
        for (int i=0 ; i<cities.size() ; i++){
            if (i!=0){
                if (i%12==0){
                    returnStr+="\n";
                }
                returnStr += ",";
            }
            returnStr += cities.get(i).getName();
        }
        returnStr += "]";
        return returnStr ;
    }
    public static void addIranCities(List<Country> countries){
        String citiesofIran ="Tehran\tRazavi Khorasan\tMashhad\tNishapur\tSabzevar\tTorbat-e Heydarieh\tEast Azerbaijan\tTabriz\tMaragheh\tMarand\tAhar\t" +
                "Alborz\tKaraj\tIsfahan\tKashan\tKhomeyni Shahr\tNajafabad\tFars\tShiraz\tMarvdasht\tJahrom\tFasa\t" +
                "Khuzestan\tAhvaz\tDezful\tAbadan\tMahshahr\tMazandaran\tSari\tBabol\tAmol\tQa'em Shahr\t" +
                "West Azerbaijan\tUrmia\tKhoy\tBukan\tMahabad\tKerman\tSirjan\tRafsanjan\tJiroft\t" +
                "Gilan\tRasht\tBandar-e Anzali\tLahijan\tSistan and Baluchistan\tZahedan\tZabol\tIran Shahr\tChabahar\t" +
                "Kermanshah\tEslamabad-e Gharb\tJavanrud\tKangavar\tLorestan\tKhorramabad\tBorujerd\tDorud\tAligudarz\t" +
                "Hamadan\tMalayer\tNahavand\tAsadabad\tGolestan\tGorgan\tGonbad-e Kavus\tBandar Torkaman\tAli Abad\t" +
                "Sanandaj\tSaghez\tMarivan\tBaneh\tBandar Abbas\tMinab\tQeshm\tKish\tArak\tSaveh\tKhomein\tMahallat\tArdabil\tParsabad\tMeshkinshahr\tKhalkhal\t" +
                "Qazvin\tAlvand\tMohammadiyeh\tTakestan\tQom\tQanavat\tJafariyeh\tKahak\tYazd\tMeybod\tArdakan\tBafq\tZanjan\tBushehr\tBandar Ganaveh\tBandar Kangan\t" +
                "Chahar Mahaal and Bakhtiari\tShahr-e Kord\tBorujen\tLordegan\tFarrokhshahr\tNorth Khorasan\tBojnurd\tShirvan\tAshkhaneh" +
                "Kohgiluyeh and Boyer-Ahmad\tYasuj\tDehdasht\tLikak\tBirjand\tGhayen\tTabas\tFerdows\tSemnan\tDamghan\tGarmsar\tIlam\tDehloran\tEyvan\t";
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

    }
}
