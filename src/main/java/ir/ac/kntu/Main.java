package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Seyed Ali Toliat
 */
public class Main {
    public static void main(String[] args) {

//        String csvFile = "F:\\ALI\\university\\Java\\project 2\\simplemaps_worldcities_basicv1.6\\worldcities.csv";
//        String line = "";
//        String cvsSplitBy = ",";
//
//        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//
//            while ((line = br.readLine()) != null) {
//
//                // use comma as separator
//                String[] country = line.split(cvsSplitBy);
//
//                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    Tour[] tours = new Tour[100];int tourFlag;
    TourLeader[] tourLeaders = new TourLeader[100];
    Scanner scanner = new Scanner(System.in);
    int choice;
    while (true){
        System.out.println("\nWelcome\n<<Main Menu>>\n1.Tour Leaders\n2.Tours\n3.Places\n4.Map\nchoose a number :");
        choice = scanner.nextInt();

    }




//        Good for showing one location
//        MapUtil.showMap("Shiraz");
//        MapUtil.showMap("@29.6257966,52.5563165,17z");
//        Good for showing two locations
//        MapUtil.showMap("Tehran","Dubai");
    }
}
