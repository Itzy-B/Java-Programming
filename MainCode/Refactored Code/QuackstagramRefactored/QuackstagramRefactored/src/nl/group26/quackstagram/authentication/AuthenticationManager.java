package nl.group26.quackstagram.authentication;

import nl.group26.quackstagram.Quackstagram;
import nl.group26.quackstagram.database.AuthIOHandler;
import nl.group26.quackstagram.user.User;

import javax.swing.*;

public class AuthenticationManager {

    public User loggedInUser;


    public boolean logIn(String username, String password) {
        AuthIOHandler io = new AuthIOHandler();

        if(io.verifyCredentials(username, password)) {
            loggedInUser = new User(username);
            return true;
        }

        return false;
    }

    public boolean logOut() {
        return false;
    }

    public boolean signUp(String username, String password, String bio) {
        AuthIOHandler io = new AuthIOHandler();
        if (io.checkExistingUsername(username)) {
            JOptionPane.showMessageDialog(Quackstagram.getInstance(), "Username already exists, Please choose a different username.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        io.saveCredentials(username, password, bio);
        return true;
    }

    public boolean isLoggedIn() {
        return this.loggedInUser != null;
    }



}
