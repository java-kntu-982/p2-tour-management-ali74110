package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Country extends Place {
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
}
