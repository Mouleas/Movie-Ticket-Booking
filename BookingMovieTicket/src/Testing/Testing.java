package Testing;
import Service.AdminPanel;
import Service.UserPanel;;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Testing {
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<String,String> details = new HashMap<>();
        UserPanel user = new UserPanel();
        AdminPanel admin = new AdminPanel();
        int ind = 1;
        while (true) {
            System.out.println("x----------------------x");
            System.out.println("1.Admin | 2.User");
            System.out.print("Enter your choice: ");
            int num = input.nextInt();
            System.out.println("x----------------------x");

            if (num == 1) {
                System.out.println("WELCOME ADMIN");
                while (true) {
                    System.out.println("\n1.Add Movie");
                    System.out.println("2.Add theatre");
                    System.out.println("3.View Booking");
                    System.out.println("4.Exit");
                    System.out.print("Enter your operation: ");
                    int op = input.nextInt();
                    System.out.println();
                    String dummy = input.nextLine();
                    if (op == 1) {
                        System.out.print("Enter movie name: ");
                        String name = input.nextLine();
                        admin.addMovie(name, ind);
                        ind++;
                    } else if (op == 2) {
                        System.out.print("Enter theatre name: ");
                        String name = input.nextLine();
                        admin.addTheatre(name, ind);
                    } else if (op == 3){
                        admin.viewBooking();
                    }
                    else {
                        break;
                    }
                }
            } else if (num == 2) {
                System.out.println("WELCOME USER");
                while (true) {
                    System.out.println();
                    System.out.println("1.Login | 2.Signup | 3.Exit");
                    System.out.print("Enter your choice: ");
                    num = input.nextInt();
                    if (num == 1) {
                        boolean ok = false;
                        System.out.print("Enter email: ");
                        String email = input.next();
                        if (isValid(email)) {
                            System.out.println();
                            System.out.print("Enter password: ");
                            String pass = input.next();
                            for (String i : details.keySet()) {
                                if (i.equals(email) && details.get(i).equals(pass)) {
                                    ok = true;
                                    break;
                                }
                            }
                            if (!ok) {
                                System.out.println("Unable to find your account!");
                            }
                            if (ok) {
                                System.out.println("x--------x--------x");
                                System.out.println("Movies available Now");
                                admin.viewBooking();
                                System.out.println("x--------x--------x");
                                System.out.println();
                                System.out.println("Enter movie name: ");
                                String name = input.next();
                                user.bookTicket(name, admin.getTheatreVacancy(), admin.getMoviekey());
                            }
                        }
                        else {
                            System.out.println("Please Enter valid EmailId");
                            break;
                        }
                    } else if (num == 2){
                        System.out.print("Enter email: ");
                        String email = input.next();
                        if (isValid(email)) {
                            System.out.print("Enter password: ");
                            String pass = input.next();
                            details.put(email, pass);
                            System.out.println("Movies available Now");
                            admin.viewBooking();
                            System.out.println("Enter movie name: ");
                            String name = input.next();
                            user.bookTicket(name, admin.getTheatreVacancy(), admin.getMoviekey());
                        }
                        else {
                            System.out.println("Please Enter valid EmailId");
                            break;
                        }
                    }
                    else {
                        break;
                    }

                }
            }
        }

    }
}
