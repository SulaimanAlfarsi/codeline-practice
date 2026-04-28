package team.fromabdullahhosni.sprint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CilErp {
    public static void main(String[] args) {
//  Implemeting a scanner
        Scanner scannerBuffer = new Scanner(System.in);

//Input Storing
        ArrayList<Integer> complains = new ArrayList<Integer>();
        ArrayList<String> descriptions = new ArrayList<String>();
        ArrayList<String> complainsProiorty = new ArrayList<String>();
        HashMap<Integer, String> complainStatus = new HashMap<>();
        //hash map
        HashMap<Integer, String> staffComplains = new HashMap<>();
        //task 5
        ArrayList<String> staff = new ArrayList<>();
        ArrayList<Integer> complainAssined = new ArrayList<>();
        ArrayList<String> comment = new ArrayList<>();

        String[] proiorty = {"Low", "Medium", "High"};
//  Looping Menu
        boolean menuIsRunning = true;
        while (menuIsRunning == true) {
//  Menu
            System.out.println("============ Wellcome - Main Menu =============");
            System.out.println("Please choose an option");
            System.out.println("1. Customer");
            System.out.println("2. Admin");
            System.out.println("3. Support Staff");
            System.out.println("4. Exit");
            System.out.println("*==================================*      ");


//  menu Options
//==========================================================================================================
            //handling Crash program
            if (scannerBuffer.hasNextInt()) {
                int IndexOption = Integer.parseInt(scannerBuffer.nextLine());


                if (IndexOption == 1) {
                    System.out.println("Customer module");
                    System.out.println("Enter an option :\n1: create a Complain\n2: Exit to main menu");


                    //handling Crash program
                    if (scannerBuffer.hasNextInt()) {
                        int customerIndex = Integer.parseInt(scannerBuffer.nextLine());


                        if (customerIndex == 1) {
                            System.out.println("Enter the complain ID..>");


                            //handling Crash program
                            if (scannerBuffer.hasNextInt()) {
                                //taking Input
                                int complainIndex = Integer.parseInt(scannerBuffer.nextLine());
