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
                                System.out.println("Enter the complain Description..>");
                                String complainDescription = scannerBuffer.nextLine();

                                //error handling
                                if (complainDescription.isEmpty() || complainIndex == 0) {
                                    System.out.println("please fill all options, try again!");
                                } else {
                                    //processing - Adding complains
                                    complains.add(complainIndex);
                                    descriptions.add(complainDescription);
                                    complainsProiorty.add(proiorty[1]);
                                    //adding complain status
                                    complainStatus.put(complainIndex, "Open");
                                    System.out.println("Successfully added");

                                    //Displaying complains
                                    int currentComplain = complains.indexOf(complainIndex);
                                    System.out.printf("Complain ID: #[%s]\n", complains.get(currentComplain));
                                    System.out.printf("Description: %s\n", descriptions.get(currentComplain));

                                    //changeing proiorty
                                    System.out.println("proiorty : Set to [Medium]Default , do you wat to change it (Y/n)?");
                                    String changeProiorty = scannerBuffer.nextLine();

                                    if (changeProiorty.equals("y") || changeProiorty.equals("Y") || changeProiorty.equals("yes") || changeProiorty.equals("YES")) {
                                        System.out.printf("ComplainID\t\t %s\n", complains.get(currentComplain));
                                        System.out.printf("Current status : [%s]\n", complainsProiorty.get(currentComplain));
                                        //removing old one
                                        complainsProiorty.remove(currentComplain);

                                        System.out.print("choose the new status \"Low\" \"High\" \"Medium\" .....>\t");
                                        String chooseProiorty = scannerBuffer.nextLine();

                                        //choosing priorty
                                        if (chooseProiorty.equals("low") || chooseProiorty.equals("LOW")) {
                                            complainsProiorty.add(proiorty[0]);
                                        } else if (chooseProiorty.equals("High") || chooseProiorty.equals("HIGH")) {
                                            complainsProiorty.add(proiorty[2]);
                                        } else if (chooseProiorty.equals("medium") || chooseProiorty.equals("Medium")) {
                                            complainsProiorty.add(proiorty[1]);
                                        } else {
                                            System.out.println("Something Went Wrong, please choose the right option or try again!");
                                        }
                                        System.out.println("Successfully ");
                                    } else {
                                        System.out.println("try again, please these options  y/yes : n/no\n");
                                    }
                                }
                            }
                        }
                    }

                    //error handling
                    else {
                        System.out.println(" Try again ,\n please input vaild option ex: 1,2,...,4");
                        System.out.println("Going back to Main Menu");

                    }
                }
//==========================================================================================================
                else if (IndexOption == 2) {
                    //!!!!!!!!
                    // Top Secret- Please Keep this Safe
                    //++++++++++++++++++++++
                    int adminPIN = 12345678;
                    //++++++++++++++++++++++
