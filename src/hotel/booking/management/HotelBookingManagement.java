package hotel.booking.management;

<<<<<<< HEAD
=======
import Controller.LoginController;
import Database.Database;
import Database.MySqlConnection;
import View.UserLogin;

>>>>>>> 946d894fa06868d62d28ac927c851e731749b88a
/**
 *
 * @author Dell
 */
public class HotelBookingManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Database db = new MySqlConnection();
        if (db.openConnection() != null) {
            System.out.println("Database connection successful");
        } else {
            System.out.println("Database connection failed");
        }

        UserLogin loginform = new UserLogin();
        LoginController logcontroller = new LoginController(loginform);
        logcontroller.open();
    }
}
<<<<<<< HEAD
=======

>>>>>>> 946d894fa06868d62d28ac927c851e731749b88a
