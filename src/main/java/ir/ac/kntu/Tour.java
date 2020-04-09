package ir.ac.kntu;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tour extends TourType {


    private int no;
    private Date beginningDate ;
    private Date endingDate ;
    private int wayOfTraveling;
    private TourLeader whoGotTour;
    /*-------------------------------------------------------------------------------------------------------------------*/

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public int getWayOfTraveling() {
        return wayOfTraveling;
    }

    public void setWayOfTraveling(int wayOfTraveling) {
        this.wayOfTraveling = wayOfTraveling;
    }

    public TourLeader getWhoGotTour() {
        return whoGotTour;
    }

    public void setWhoGotTour(TourLeader whoGotTour) {
        this.whoGotTour = whoGotTour;
    }

    public String toString(){
        return getName()+no+" : from "+beginningDate.toString()+" until "+endingDate.toString()+", "+getDuration() +" days, cost= " + getCost()+", held by:"+whoGotTour.getFirstName()+" "+whoGotTour.getLastName();
    }
    /*-------------------------------------------------------------------------------------------------------------------*/
    public static void tourMenu(List<Tour> tours , List<Country> countries , List<TourType> tourTypes , List<TourLeader> tourLeaders){
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("\n<<Tour Menu>>\n1.show Tour types\n2.show Tours\n3.add a tour type\n4.add a tour\n5.edit a tour type\n6.edit a tour\n7.delete a tour\n8.search tour type\n9.search tour\n0.back\nEnter a number: ");
            choice = scanner.nextInt();
            if (choice == 1){
                TourType.showTourTypes(tourTypes);Main.takeMeBack();
            }
            else if (choice == 2){
                showTours(tours);Main.takeMeBack();
            }
            else if (choice == 3){
                TourType.addTourType(tourTypes,countries);
            }
            else if (choice == 4){
                addTour(tours ,countries, tourTypes ,tourLeaders);
            }
            else if (choice == 5){
                TourType.editTourType(tourTypes,countries);
            }
            else if (choice == 6){
                //editTour(tours , tourLeaders);
            }
            else if (choice == 7){
                deleteTour(tours);
            }
            else if (choice == 8){
//
            }
            else if (choice == 9){
//
            }
            else if (choice == 0){break;}
        }
    }
    /*-------------------------------------------------------------------------------------------------------------------*/
    public static void addTour(List<Tour> tours , List<Country> countries , List<TourType> tourTypes , List<TourLeader> tourLeaders){
        while (true){
            Tour tourAdder = new Tour();
            Scanner scanner = new Scanner(System.in);
            int choice , choice3 , choice4;
            if (tourTypes.size() == 0){
                System.out.println("you should first add tour types.(to add enter '1')");
                int choice2=scanner.nextInt();
                if (choice2 == 1){
                    TourType.addTourType(tourTypes,countries);
                    continue;
                }
            }
            while (true){
                System.out.println("choose a tour type:");
                TourType.showTourTypes(tourTypes);
                choice = scanner.nextInt();
                if (choice>0 && choice<=tourTypes.size()){
                    tourAdder.setCost(tourTypes.get(choice-1).getCost());
                    tourAdder.setDuration(tourTypes.get(choice-1).getDuration());
                    tourAdder.setInternational(tourTypes.get(choice-1).isInternational());
                    tourAdder.setMaximumParticipants(tourTypes.get(choice-1).getMaximumParticipants());
                    tourAdder.setMinimumParticipants(tourTypes.get(choice-1).getMinimumParticipants());
                    tourAdder.setName(tourTypes.get(choice-1).getName());
                    tourAdder.setNo(tourTypes.get(choice-1).getTourNum());
                    tourTypes.get(choice-1).setTourNum(tourTypes.get(choice-1).getTourNum()+1);
                    if (tourTypes.get(choice-1).isInternational()){
                        tourAdder.setBeginningCity(tourTypes.get(choice-1).getBeginningCity());
                        tourAdder.setEndingCity(tourTypes.get(choice-1).getEndingCity());
                        tourAdder.setCitiesToSee(tourTypes.get(choice-1).getCitiesToSee());
                    }
                    else {
                        tourAdder.setBeginningPlace(tourTypes.get(choice-1).getBeginningPlace());
                        tourAdder.setEndingPlace(tourTypes.get(choice-1).getEndingPlace());
                        tourAdder.setPlacesToSee(tourTypes.get(choice-1).getPlacesToSee());
                    }
                    break;
                }
            }
            while (true){
                System.out.println("the way of traveling:\n1.by air\n2.by ground\nEnter a number:");
                choice3 = scanner.nextInt();
                if (choice3 == 1 || choice3 == 2){
                    tourAdder.setWayOfTraveling(choice3);
                    break;
                }
            }
            int day , month ,year ;
            Date beginningDate = new Date();
            Date endingDate = new Date();
            while (true){
                System.out.println("\nBeginning day Date: day->");
                day = scanner.nextInt();
                System.out.println("\nmonth->");
                month = scanner.nextInt();
                System.out.println("\nyear->");
                year = scanner.nextInt();
                beginningDate.setDate(year,month,day);
                if (beginningDate.getDay() == 0 && beginningDate.getMonth() == 0 && beginningDate.getYear() == 0 ){
                    System.out.println("\n wrong path !!!");
                    continue;
                }
                tourAdder.setBeginningDate(beginningDate);
                break;
            }
            while (true){
                System.out.println("\nending day Date: day->");
                day = scanner.nextInt();
                System.out.println("\nmonth->");
                month = scanner.nextInt();
                System.out.println("\nyear->");
                year = scanner.nextInt();
                endingDate.setDate(year,month,day);
                if (endingDate.getDay() == 0 && endingDate.getMonth() == 0 && endingDate.getYear() == 0 ){
                    System.out.println("\n wrong path !!!");
                    continue;
                }
                tourAdder.setEndingDate(endingDate);
                break;
            }
            int[] a = new int[100];
            int n =numsOfSuitableTourLeaders(a,tourLeaders,beginningDate,endingDate);
            if (n==0){
                System.out.println("No suitable tour leader exist.");
                break;
            }
            System.out.println("suitable tour leaders:");
            for (int j=1 ; j<=n ;j++){
                System.out.println(j+". "+tourLeaders.get(a[j-1]).toString());
            }
            while (true){
                System.out.println("Enter a number: ");
                choice4 = scanner.nextInt();
                if (choice4>0 && choice4<=n){
                    tourAdder.setWhoGotTour(tourLeaders.get(a[choice4-1]));
                    tourLeaders.get(a[choice4-1]).addTourInHand(tourAdder);
                    break;
                }
            }
            tours.add(tourAdder);
            break;
        }
    }
    /*-------------------------------------------------------------------------------------------------------------------*/
    public static int numsOfSuitableTourLeaders(int[] a , List<TourLeader> tourLeaders , Date beginningDate , Date endingDate ) {
        int num=0 , flag = 0 ;
        for (int j=0 ; j<tourLeaders.size() ;j++){
            if (tourLeaders.get(j).getBusyDates().size() == 0){
                a[num] = j;
                num++;
            }
            else {
                for (int i=0 ; i<tourLeaders.get(j).getBusyDates().size() ;i+=2  ){
                    if (checkCoveringDates(beginningDate,endingDate,tourLeaders.get(j).getBusyDates().get(i),tourLeaders.get(j).getBusyDates().get(i+1))){
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0){
                    a[num] = j;
                    num++;
                }
            }
        }
        return num;
    }
    /*-------------------------------------------------------------------------------------------------------------------*/
    public static boolean checkCoveringDates(Date sdate1 , Date edate1 , Date sdate2, Date edate2 ){
        int sd1 = sdate1.getDay() + sdate1.getMonth()*31 + sdate1.getYear()*365;
        int sd2 = sdate2.getDay() + sdate2.getMonth()*31 + sdate2.getYear()*365;
        int ed1 = edate1.getDay() + edate1.getMonth()*31 + edate1.getYear()*365;
        int ed2 = edate2.getDay() + edate2.getMonth()*31 + edate2.getYear()*365;
        if ((ed1>sd2 && ed1<ed2) || (ed2>sd1 && ed2<ed1)){
            return true ;
        }
        else return false;
    }
    /*-------------------------------------------------------------------------------------------------------------------*/
    public static void editTour(List<Tour> tours ,List<TourLeader> tourLeaders){
        while (true){
            System.out.println("which part do you want to edit:\n");
        }
    }
    /*-------------------------------------------------------------------------------------------------------------------*/
    public static void deleteTour(List<Tour> tours){
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true){
            showTours(tours);
            System.out.println("0.back\nEnter a number");
            choice = scanner.nextInt();
            if (choice==0){break;}
            else if (choice>0 && choice<=tours.size()){
                tours.remove(choice-1);
                System.out.println("tour deleted.");
                break;
            }
        }
    }
    /*-------------------------------------------------------------------------------------------------------------------*/
    public static void showTours(List<Tour> tours){
        int num =1 ;
        System.out.println("<< tours >>");
        for (Tour tour : tours){
            System.out.println(num+". "+tour.toString());
            num++;
        }
    }
    /*-------------------------------------------------------------------------------------------------------------------*/
}
