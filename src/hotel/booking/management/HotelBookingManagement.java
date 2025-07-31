package hotel.booking.management;

<<<<<<< HEAD
  

<<<<<<< HEAD
=======
>>>>>>> Samirr
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
            System.out.println("Database connection successfull");
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
>>>>>>> master
=======
>>>>>>> Samirr
