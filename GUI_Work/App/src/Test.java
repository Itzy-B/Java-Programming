import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test extends Application {
    private MediaPlayer currentMediaPlayer;
    private List<MediaPlayer> players = new ArrayList<>();
    final String musicFile2 = "App/Sound/Hotlanta - Track Tribe.mp3";
    final Media sound2 = new Media(new File(musicFile2).toURI().toString());
    final String musicFile = "App/Sound/Main_Game.mp3";
    final Media sound = new Media(new File(musicFile).toURI().toString());
    final MediaPlayer music1 = new MediaPlayer(sound);
    final MediaPlayer music2 = new MediaPlayer(sound2);
    public static void main(String[] args) {
        launch(args);
    }

    private void stopCurrentMusic() {
        if (currentMediaPlayer != null) {
            currentMediaPlayer.stop();
            music1.stop();
            music2.stop();
        }
    }

    private void playRandomMusic(MediaPlayer... mediaPlayers) {
        for (MediaPlayer player : mediaPlayers) {
            if (player.getStatus() == MediaPlayer.Status.PLAYING) {
                player.stop();
            }
            players.add(player);
        }

        Random random = new Random();
        currentMediaPlayer = players.get(random.nextInt(players.size()));
        currentMediaPlayer.play();
    }

    @Override
    public void start(Stage primaryStage) {
        // Set the window title
        primaryStage.setTitle("Tetris");
        primaryStage.setResizable(false);

        // Images
        String imagePath = "C:/Users/gamef/Desktop/Project11/GUI_Work/App/Images/mr1.jpg";
        Image bckgroundb1 = new Image("file:" + imagePath);

        // Main game sound
        
        music1.setVolume(0.2);

        // High Score
        music2.setVolume(0.2);

        // Create an ImageView with the image and set its size
        ImageView imageView = new ImageView(bckgroundb1);
        imageView.setFitWidth(500);
        imageView.setFitHeight(400);

        // Create buttons
        Button strtgamebtn = new Button("Start the Game");
        Button highscorebtn = new Button("High Scores");
        Button Credits = new Button("Credits");

        // Positions
        strtgamebtn.setTranslateX(-1);
        strtgamebtn.setTranslateY(-100);
        highscorebtn.setTranslateX(-1);
        highscorebtn.setTranslateY(0);
        Credits.setTranslateX(-1);
        Credits.setTranslateY(100);

        // Measurements
        highscorebtn.setPrefWidth(100);
        highscorebtn.setPrefHeight(40);
        strtgamebtn.setPrefWidth(100);
        strtgamebtn.setPrefHeight(40);
        Credits.setPrefWidth(100);
        Credits.setPrefHeight(40);

        // Layout for the first scene
        StackPane root = new StackPane();
        root.getChildren().addAll(imageView, strtgamebtn, highscorebtn, Credits);

        // First Scene
        Scene scene1 = new Scene(root, 500, 400);

        // New Button to go back to menu and randomize music.
        strtgamebtn.setOnAction(e -> {
            playRandomMusic();//music1, music2
            // Create a new layout for the second scene
            StackPane root2 = new StackPane();
            Button backButton = new Button("Go back to menu");
            Button randomButton = new Button("Random");
            backButton.setTranslateX(-190);
            backButton.setTranslateY(-330);
            randomButton.setTranslateX(190);
            randomButton.setTranslateY(-330);
            root2.getChildren().addAll(backButton, randomButton);

            // Create the second scene
            Scene scene2 = new Scene(root2, 500, 700);

            // Set an action for the "Go back to menu" button to switch back to the first scene
            backButton.setOnAction(event -> {
                primaryStage.setScene(scene1);
                primaryStage.setResizable(false);
                stopCurrentMusic();
            });

            randomButton.setOnAction(event -> {
            stopCurrentMusic();
            playRandomMusic();
            });
            // Disable resizing of the second scene
            primaryStage.setResizable(false);

            // Switch to the second scene
            primaryStage.setScene(scene2);
            playRandomMusic();
            primaryStage.setResizable(false);
        });

        // New Button to go back to menu and randomize music.
        highscorebtn.setOnAction(e -> {
            playRandomMusic();
            // Create a new layout for the second scene
            StackPane root3 = new StackPane();
            Button backmenu2Button = new Button("Go back to menu");
            Button randomButton = new Button("Random");
            backmenu2Button.setTranslateX(-140);
            backmenu2Button.setTranslateY(-250);
            randomButton.setTranslateX(140);
            randomButton.setTranslateY(-250);
            root3.getChildren().addAll(backmenu2Button, randomButton);

            // Create the third scene
            Scene scene3 = new Scene(root3, 400, 550);

            // Switch to the second scene
            primaryStage.setScene(scene3);
            primaryStage.setResizable(false);

            // Set an action for the "Go back to menu" button to switch back to the first scene
            backmenu2Button.setOnAction(event -> {
                primaryStage.setScene(scene1);
                primaryStage.setResizable(false);
                stopCurrentMusic();
            });

            
        });

        // New Button to go back to menu.
        Credits.setOnAction(e -> {
            // Create a new layout for the second scene
            StackPane root4 = new StackPane();
            Button backmenu2Button = new Button("Go back to menu");
            backmenu2Button.setTranslateX(-140);
            backmenu2Button.setTranslateY(-250);
            root4.getChildren().add(backmenu2Button);

            // Create the third scene
            Scene scene3 = new Scene(root4, 400, 550);

            // Switch to the second scene
            primaryStage.setScene(scene3);
            primaryStage.setResizable(false);

            // Set an action for the "Go back to menu" button to switch back to the first scene
            backmenu2Button.setOnAction(event -> {
                primaryStage.setScene(scene1);
                primaryStage.setResizable(false);
            });
        });

        // Set the initial scene and show the stage
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    
}