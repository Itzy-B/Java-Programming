package nl.group26.quackstagram.database;

import nl.group26.quackstagram.Quackstagram;
import nl.group26.quackstagram.user.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProfileIOHandler extends IOHandler {

    User user;

    public ProfileIOHandler(User user) {
        this.user = user;
    }

    public int countImages() {
        int imageCount = 0;
        // Step 1: Read image_details.txt to count the number of images posted by the user
        Path imageDetailsFilePath = Paths.get("img", "image_details.txt");
        try (BufferedReader imageDetailsReader = Files.newBufferedReader(imageDetailsFilePath)) {
            String line;
            while ((line = imageDetailsReader.readLine()) != null) {
                if (line.contains("Username: " + user.getUsername())) {
                    imageCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageCount;
    }


    //following count = index 0, followers count = index 1
    public int[] getFollowersAndFollowing() {
        int followingCount = 0;
        int followersCount = 0;
        // Step 2: Read following.txt to calculate followers and following
        Path followingFilePath = Paths.get("data", "following.txt");
        try (BufferedReader followingReader = Files.newBufferedReader(followingFilePath)) {
            String line;
            while ((line = followingReader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String username = parts[0].trim();
                    String[] followingUsers = parts[1].split(";");
                    if (username.equals(user.getUsername())) {
                        followingCount = followingUsers.length;
                    } else {
                        for (String followingUser : followingUsers) {
                            if (followingUser.trim().equals(user.getUsername())) {
                                followersCount++;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[]{followingCount, followersCount};
    }

    public String getBio() {
        String bio = "";

        Path bioDetailsFilePath = Paths.get("data", "credentials.txt");
        try (BufferedReader bioDetailsReader = Files.newBufferedReader(bioDetailsFilePath)) {
            String line;
            while ((line = bioDetailsReader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(user.getUsername()) && parts.length >= 3) {
                    bio = parts[2];
                    break; // Exit the loop once the matching bio is found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bio;
    }


    // Check if the current user is already being followed by the logged-in user
    public boolean checkFollowed(User user) {
        Path followingFilePath = Paths.get("data", "following.txt");
        String loggedInUsername = Quackstagram.getInstance().authenticationManager.loggedInUser.getUsername();

        try (BufferedReader reader = Files.newBufferedReader(followingFilePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].trim().equals(loggedInUsername)) {
                    String[] followedUsers = parts[1].split(";");
                    for (String followedUser : followedUsers) {
                        if (followedUser.trim().equals(user.getUsername())) {
                           return true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void followUser() {
        Path followingFilePath = Paths.get("data", "following.txt");
        String usernameToFollow = user.getUsername();
        String currentUserUsername = Quackstagram.getInstance().authenticationManager.loggedInUser.getUsername();

        try {
            System.out.println("Real user is "+currentUserUsername);
            // If currentUserUsername is not empty, process following.txt
            if (!currentUserUsername.isEmpty()) {
                boolean found = false;
                StringBuilder newContent = new StringBuilder();

                // Read and process following.txt
                if (Files.exists(followingFilePath)) {
                    try (BufferedReader reader = Files.newBufferedReader(followingFilePath)) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(":");
                            if (parts[0].trim().equals(currentUserUsername)) {
                                found = true;
                                if (!line.contains(usernameToFollow)) {
                                    line = line.concat(line.endsWith(":") ? "" : "; ").concat(usernameToFollow);
                                }
                            }
                            newContent.append(line).append("\n");
                        }
                    }
                }

                // If the current user was not found in following.txt, add them
                if (!found) {
                    newContent.append(currentUserUsername).append(": ").append(usernameToFollow).append("\n");
                }

                // Write the updated content back to following.txt
                try (BufferedWriter writer = Files.newBufferedWriter(followingFilePath)) {
                    writer.write(newContent.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
