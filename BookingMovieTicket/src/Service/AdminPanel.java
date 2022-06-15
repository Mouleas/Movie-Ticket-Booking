package Service;

import java.util.ArrayList;
import java.util.HashMap;

public class AdminPanel {

    private HashMap<String, ArrayList<Integer>> theatreVacancy;
    private HashMap<String, Integer> moviekey;
    public AdminPanel() {
        theatreVacancy = new HashMap<>();
        theatreVacancy.put("rockNdrop",new ArrayList<Integer>());
        theatreVacancy.put("monster",new ArrayList<Integer>());
        theatreVacancy.put("duplex",new ArrayList<Integer>());
        moviekey = new HashMap<>();
    }

    public void addMovie(String movie,int ind) {
        moviekey.put(movie,ind);
        for (String i: theatreVacancy.keySet()) {
            ArrayList<Integer> tmp = theatreVacancy.get(i);
            tmp.add(60);
        }
    }

    public void addTheatre(String theatre,int ind) {
        ArrayList<Integer> movielist = new ArrayList<>();
        for (int i = 0; i < ind; i++) {
            movielist.add(60);
        }
        theatreVacancy.put(theatre,movielist);
    }
    public void viewBooking(){
        System.out.println("x--------x--------x\n");
        System.out.println("Vacancy in all Theatres:");
        for (String i:theatreVacancy.keySet()){
            System.out.println("Theatre name: "+i+"  Vacancy count: "+theatreVacancy.get(i));
        }
        System.out.println("\nx--------x--------x");

    }

    public HashMap<String, ArrayList<Integer>> getTheatreVacancy() {
        return this.theatreVacancy;
    }

    public HashMap<String,Integer> getMoviekey() {
        return this.moviekey;
    }
}
