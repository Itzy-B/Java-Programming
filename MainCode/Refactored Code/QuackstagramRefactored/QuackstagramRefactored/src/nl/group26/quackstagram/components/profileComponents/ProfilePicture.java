package nl.group26.quackstagram.components.profileComponents;

import nl.group26.quackstagram.user.User;

import javax.swing.*;
import java.awt.*;

public class ProfilePicture {

    private User user;
    private JLabel profileImage;
    private static final int PROFILE_IMAGE_SIZE = 80; // Adjusted size for the profile image to match UI


    public ProfilePicture(String username) {
        // Profile image
        ImageIcon profileIcon = new ImageIcon(new ImageIcon("img/storage/profile/" + username + ".png").getImage().getScaledInstance(PROFILE_IMAGE_SIZE, PROFILE_IMAGE_SIZE, Image.SCALE_SMOOTH));
        profileImage = new JLabel(profileIcon);
        profileImage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public JLabel getProfileImage () {
        return profileImage;
    }

}
