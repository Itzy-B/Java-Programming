package nl.group26.quackstagram.database;

import nl.group26.quackstagram.Quackstagram;
import nl.group26.quackstagram.components.mainComponents.Post;
import nl.group26.quackstagram.user.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Stream;

public class PostsIOHandler extends IOHandler{

    public PostsIOHandler() {

    }

    public ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();

        // Load images from the uploaded folder
        File imageDir = new File("img/uploaded");
        if (imageDir.exists() && imageDir.isDirectory()) {
            File[] imageFiles = imageDir.listFiles((dir, name) -> name.matches(".*\\.(png|jpg|jpeg)"));
            if (imageFiles != null) {
                for (File imageFile : imageFiles) {
                    Post post = new Post(imageFile.getPath());
                    post.setImageLabel(imageFile.getPath());
                    posts.add(post);
                }
            }
        }
        return posts;
    }

    public ArrayList<Post> getPostsFromUser(User user) {
        ArrayList<Post> posts = new ArrayList<>();

        Path imageDir = Paths.get("img", "uploaded");
        try (Stream<Path> paths = Files.list(imageDir)) {
            paths.filter(path -> path.getFileName().toString().startsWith(user.getUsername() + "_"))
                    .forEach(path -> {
                       Post post = new Post(path.toString());
                       post.setImageLabel(path.toString());
                       posts.add(post);
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return posts;
    }

    public String getPostID(String imagePath) {
        return new File(imagePath).getName().split("\\.")[0];
    }

    public void recieveImageMetadata(Post post) {
        String imageId = getPostID(post.getImagePath());
        post.setImageId(imageId);
        int likes = 0;

        Path detailsPath = Paths.get("img", "image_details.txt");
        try (Stream<String> lines = Files.lines(detailsPath)) {
            String details = lines.filter(line -> line.contains("ImageID: " + imageId)).findFirst().orElse("");
            if (!details.isEmpty()) {
                String[] parts = details.split(", ");
                post.setUsername(parts[1].split(": ")[1]);
                post.setBio(parts[2].split(": ")[1]);
                post.setTimestampString(parts[3].split(": ")[1]);
                post.setLikes(Integer.parseInt(parts[4].split(": ")[1]));
                likes = Integer.parseInt(parts[4].split(": ")[1]);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            // Handle exception
        }
    }

    public ArrayList<Post> getFeed(User user) {
        ArrayList<Post> posts = new ArrayList<>();

        String followedUsers = "";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("data", "following.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(user.getUsername() + ":")) {
                    followedUsers = line.split(":")[1].trim();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Temporary structure to hold the data
        int count = 0;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("img", "image_details.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(", ");
                String imagePoster = details[1].split(": ")[1];
                if (followedUsers.contains(imagePoster)) {
                    String imagePath = "img/uploaded/" + details[0].split(": ")[1] + ".png"; // Assuming PNG format
                    posts.add(new Post(imagePath));
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public void likePost(Post post) {
        User user = Quackstagram.getInstance().authenticationManager.loggedInUser;

        Path detailsPath = Paths.get("img", "image_details.txt");
        StringBuilder newContent = new StringBuilder();
        boolean updated = false;
        String currentUser = user.getUsername();
        String imageOwner = post.getUsername();
        String imageId = post.getImageId();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


        // Read and update image_details.txt
        try (BufferedReader reader = Files.newBufferedReader(detailsPath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("ImageID: " + post.getImageId())) {
                    String[] parts = line.split(", ");
                    imageOwner = parts[1].split(": ")[1];
                    int likes = Integer.parseInt(parts[4].split(": ")[1]);
                    likes++; // Increment the likes count
                    parts[4] = "Likes: " + likes;
                    line = String.join(", ", parts);
                    updated = true;
                }
                newContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write updated likes back to image_details.txt
        if (updated) {
            try (BufferedWriter writer = Files.newBufferedWriter(detailsPath)) {
                writer.write(newContent.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Record the like in notifications.txt
            String notification = String.format("%s; %s; %s; %s\n", imageOwner, currentUser, imageId, timestamp);
            try (BufferedWriter notificationWriter = Files.newBufferedWriter(Paths.get("data", "notifications.txt"), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                notificationWriter.write(notification);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
