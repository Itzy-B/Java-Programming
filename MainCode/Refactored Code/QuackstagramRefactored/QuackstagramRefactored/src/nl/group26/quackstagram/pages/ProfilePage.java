package nl.group26.quackstagram.pages;

import nl.group26.quackstagram.components.PostsOverview;
import nl.group26.quackstagram.components.profileComponents.ProfileHeaderPanel;
import nl.group26.quackstagram.user.User;

import javax.swing.*;
import java.awt.*;

public class ProfilePage extends QuackstagramPage {

    private ProfileHeaderPanel profileHeaderPanel;
    private PostsOverview postsOverview;
    private String username;



    public ProfilePage(String username) {
        super("Profile");
        User user = new User(username);
        this.username = username;

        add(new ProfileHeaderPanel(user), BorderLayout.NORTH);
        add(new PostsOverview(user));
    }




    private JLabel createStatLabel(String number, String text) {
        JLabel label = new JLabel("<html><div style='text-align: center;'>" + number + "<br/>" + text + "</div></html>", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setForeground(Color.BLACK);
        return label;
    }

}
