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
