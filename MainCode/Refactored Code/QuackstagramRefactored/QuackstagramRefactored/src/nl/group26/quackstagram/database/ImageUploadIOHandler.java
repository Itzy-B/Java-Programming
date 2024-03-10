package nl.group26.quackstagram.database;

import nl.group26.quackstagram.Quackstagram;
import nl.group26.quackstagram.user.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ImageUploadIOHandler extends IOHandler {

    public Path destPath;

    public boolean uploadProfilePicture(File file, String username) {
        try {
            BufferedImage image = ImageIO.read(file);
            File outputFile = new File(Quackstagram.PROFILE_PHOTO_STORAGE_PATH + username + ".png");
            ImageIO.write(image, "png", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean uploadImage(File selectedFile, String bio) {
        try {
            User user = Quackstagram.getInstance().authenticationManager.loggedInUser;
            int imageId = getNextImageId(user);
            String fileExtension = getFileExtension(selectedFile);
            String newFileName = user.getUsername() + "_" + imageId + "." + fileExtension;

            destPath = Paths.get("img", "uploaded", newFileName);
            Files.copy(selectedFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);

            // Save the bio and image ID to a text file
            saveImageInfo(user.getUsername() + "_" + imageId, user.getUsername(), bio);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }


    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf + 1);
    }

    private void saveImageInfo(String imageId, String username, String bio) throws IOException {
        Path infoFilePath = Paths.get("img", "image_details.txt");
        if (!Files.exists(infoFilePath)) {
            Files.createFile(infoFilePath);
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try (BufferedWriter writer = Files.newBufferedWriter(infoFilePath, StandardOpenOption.APPEND)) {
            writer.write(String.format("ImageID: %s, Username: %s, Bio: %s, Timestamp: %s, Likes: 0", imageId, username, bio, timestamp));
            writer.newLine();
        }

    }

    private int getNextImageId(User user) throws IOException {
        Path storageDir = Paths.get("img", "uploaded"); // Ensure this is the directory where images are saved
        if (!Files.exists(storageDir)) {
            Files.createDirectories(storageDir);
        }

        int maxId = 0;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(storageDir, user.getUsername() + "_*")) {
            for (Path path : stream) {
                String fileName = path.getFileName().toString();
                int idEndIndex = fileName.lastIndexOf('.');
                if (idEndIndex != -1) {
                    String idStr = fileName.substring(user.getUsername().length() + 1, idEndIndex);
                    try {
                        int id = Integer.parseInt(idStr);
                        if (id > maxId) {
                            maxId = id;
                        }
                    } catch (NumberFormatException ex) {
                        // Ignore filenames that do not have a valid numeric ID
                    }
                }
            }
        }
        return maxId + 1; // Return the next available ID
    }
}
