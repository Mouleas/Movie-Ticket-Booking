package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserPanel {
    static Scanner input = new Scanner(System.in);
    public void bookTicket(String movie,HashMap<String,ArrayList<Integer>> theatreVacancy,HashMap<String,Integer> moviekey){

        int key = moviekey.get(movie);
        System.out.println("x--------x--------x\n");

        System.out.println("Available tickets in all theaters:");
        for (String i: theatreVacancy.keySet()) {
            if (theatreVacancy.get(i).get(key-1) > 0){
                System.out.println(i+"--->"+theatreVacancy.get(i).get(key-1));
            }
        }
        System.out.println("\nx--------x--------x");

        System.out.print("Enter theatre name to book your ticket: ");
        String theatre = input.nextLine();
        if (theatreVacancy.get(theatre).get(key-1) > 0){
            int val = theatreVacancy.get(theatre).get(key-1);
            val --;
            theatreVacancy.get(theatre).set(key-1,val);
        }
        else {
            System.out.println("!Enter valid theatre");
        }

    }
}
