import de.srh.beck.dao.User;
import de.srh.beck.database.IDatabaseConnection;
import de.srh.beck.database.MySQLConnection;
import de.srh.beck.logic.UserManagement;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.JUnit4;

import java.sql.Date;
import java.util.Random;

public class UserManagementTest {

    @Test
    public void testAddUser() {
        Random r = new Random();
        // Test user
        User user = new User();
        user.setGender(User.Gender.MR);
        user.setFirstname("Johnny");
        user.setLastname("Depp");
        user.setEmail("johnny" + r.nextInt() + "@depp.com");
        user.setPassword("test");
        user.setBirthdate(Date.valueOf("1986-11-13"));
        //add new user
        IDatabaseConnection mysql = new MySQLConnection();
        boolean result = mysql.addUser(user);
        //validate result
        Assert.assertTrue(result);
    }

    @Test
    public void testAuthenticateUser() {
        String email = "social@solovyov.de";
        String password = "test";

        IDatabaseConnection mysql = new MySQLConnection();
        User user = mysql.getUserByEmail(email);

        Assert.assertNotNull(user);
        Assert.assertEquals(email, user.getEmail());
    }

    @Test
    public void testAuthenticateUser1() {
        String email = "social@solovyov.de";
        String password = "test";

        UserManagement um = new UserManagement();
        User user = um.authenticateUser(email,password);

        Assert.assertNotNull(user);
        Assert.assertEquals(email, user.getEmail());

        System.out.println(user.getLastname());
        System.out.println(user.getPassword());
    }

    @Test
    public void testAuthenticateUser2() {
        String email = "social@solovyov.de";
        String password = "test";

        UserManagement um = new UserManagement();
        User user = um.authenticateUser2(email, password);

        System.out.println(user.getFirstname());

        //Test #2
        String email1 = "socialFALSCH@solovyov.de";
        String password1 = "test";

        User user1 = um.authenticateUser2(email1, password1);
        if (user1 != null) {
            System.out.println(user1.getFirstname());
        } else {
            System.out.println("User not found!");
        }
    }
}
