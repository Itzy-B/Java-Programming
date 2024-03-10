package nl.group26.quackstagram.components.profileComponents;

import nl.group26.quackstagram.Quackstagram;
import nl.group26.quackstagram.database.ProfileIOHandler;
import nl.group26.quackstagram.user.User;

import javax.swing.*;
import java.awt.*;

public class StatsFollowPanel extends JPanel {

    public StatsFollowPanel(User user) {
        ProfileIOHandler io = new ProfileIOHandler(user);
        String bio = io.getBio();
        int postsCount = io.countImages();
        int followingCount = io.getFollowersAndFollowing()[0];
        int followersCount = io.getFollowersAndFollowing()[1];


        // Follow Button
        // Follow or Edit Profile Button
        // followButton.addActionListener(e -> handleFollowAction(currentUser.getUsername()));
        FollowButton followButton;
        if (Quackstagram.getInstance().authenticationManager.loggedInUser.getUsername().equals(user.getUsername())) {
            followButton = new FollowButton("Edit Profile");
        } else {
            followButton = new FollowButton("Follow");

            if (io.checkFollowed(user))
                followButton.setText("Following");

            followButton.addActionListener(e -> {
                io.followUser();
                followButton.setText("Following");
            });
        }


        // Add Stats and Follow Button to a combined Panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new StatsPanel(postsCount, followersCount, followingCount));
        add(followButton);
    }



}
