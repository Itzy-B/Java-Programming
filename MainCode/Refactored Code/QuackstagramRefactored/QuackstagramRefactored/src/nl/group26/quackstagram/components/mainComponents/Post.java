package nl.group26.quackstagram.components.mainComponents;

import nl.group26.quackstagram.Quackstagram;
import nl.group26.quackstagram.pages.DetailedPostPage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static nl.group26.quackstagram.Quackstagram.IMAGE_SIZE;

public class Post {

    private String username;
    private String imageId;
    private String bio;
    private String timestampString;
    private int likes;
    private String imagePath;

    private JLabel imageLabel;

    public Post (String imagePath) {
        this.imagePath = imagePath;
    }

    public void displayDetailed() {
        Quackstagram.getInstance().redirectManager.redirect(new DetailedPostPage(this));
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public void setImageLabel(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(imageIcon);
        this.imageLabel = imageLabel;
    }

    public boolean likePost() {
        return false;
    }



    public boolean unlikePost() {
        return false;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTimestampString() {
        return timestampString;
    }

    public void setTimestampString(String timestampString) {
        this.timestampString = timestampString;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTimeSincePosting() {
        // Calculate time since posting
        String timeSincePosting = "Unknown";
        if (!timestampString.isEmpty()) {
            LocalDateTime timestamp = LocalDateTime.parse(timestampString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime now = LocalDateTime.now();
            long days = ChronoUnit.DAYS.between(timestamp, now);
            timeSincePosting = days + " day" + (days != 1 ? "s" : "") + " ago";
        }
        return timeSincePosting;
    }


    public JLabel getCroppedImageLabel(int imageWidth, int imageHeight) {
        JLabel imageLabel = new JLabel();
        try {
            BufferedImage originalImage = ImageIO.read(new File(getImagePath()));
            BufferedImage croppedImage = originalImage.getSubimage(0, 0, Math.min(originalImage.getWidth(), imageWidth), Math.min(originalImage.getHeight(), imageHeight));
            ImageIcon imageIcon = new ImageIcon(croppedImage);
            imageLabel.setIcon(imageIcon);
        } catch (IOException ex) {
            // Handle exception: Image file not found or reading error
            imageLabel.setText("Image not found");
        }
        return imageLabel;
    }
}
