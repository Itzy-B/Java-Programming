package nl.group26.quackstagram.authPages;

import nl.group26.quackstagram.Quackstagram;
import nl.group26.quackstagram.database.AuthIOHandler;
import nl.group26.quackstagram.database.ImageUploadIOHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RegisterPage extends AuthPage {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField bioField;

    private JButton uploadButton;
    private JButton registerButton;
    private JButton signInButton;

    public RegisterPage() {
        super("Quackstagram - Register");

        // Profile picture placeholder without border
        JLabel lblPhoto = new JLabel();
        lblPhoto.setPreferredSize(new Dimension(80, 80));
        lblPhoto.setHorizontalAlignment(JLabel.CENTER);
        lblPhoto.setVerticalAlignment(JLabel.CENTER);
        lblPhoto.setIcon(new ImageIcon(new ImageIcon("img/logos/DACS.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        JPanel photoPanel = new JPanel(); // Use a panel to center the photo label
        photoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        photoPanel.add(lblPhoto);

        // Text fields panel
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));
        fieldsPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

        usernameField = new JTextField("Username");
        passwordField = new JPasswordField("Password");
        bioField = new JTextField("Bio");
        bioField.setForeground(Color.GRAY);
        usernameField.setForeground(Color.GRAY);
        passwordField.setForeground(Color.GRAY);

        fieldsPanel.add(Box.createVerticalStrut(10));
        fieldsPanel.add(photoPanel);
        fieldsPanel.add(Box.createVerticalStrut(10));
        fieldsPanel.add(usernameField);
        fieldsPanel.add(Box.createVerticalStrut(10));
        fieldsPanel.add(passwordField);
        fieldsPanel.add(Box.createVerticalStrut(10));
        fieldsPanel.add(bioField);
        JButton btnUploadPhoto = new JButton("Upload Photo");

        btnUploadPhoto.addActionListener(this::uploadImage);
        JPanel photoUploadPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        photoUploadPanel.add(btnUploadPhoto);
        fieldsPanel.add(photoUploadPanel);

        // Register button with black text
        registerButton = new JButton("Register");
        registerButton.addActionListener(this::onRegisterClicked);
        registerButton.setBackground(new Color(255, 90, 95)); // Use a red color that matches the mockup
        registerButton.setForeground(Color.BLACK); // Set the text color to black
        registerButton.setFocusPainted(false);
        registerButton.setBorderPainted(false);
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel registerPanel = new JPanel(new BorderLayout()); // Panel to contain the register button
        registerPanel.setBackground(Color.WHITE); // Background for the panel
        registerPanel.add(registerButton, BorderLayout.CENTER);


        // Adding components to the frame
        add(fieldsPanel, BorderLayout.CENTER);
        add(registerPanel, BorderLayout.SOUTH);
        // Adding the sign in button to the register panel or another suitable panel
        signInButton = new JButton("Already have an account? Sign In");
        signInButton.addActionListener(this::onSignInClicked);
        registerPanel.add(signInButton, BorderLayout.SOUTH);
    }


    private boolean onRegisterClicked(ActionEvent event) {

        String username = usernameField.getText();
        String password = passwordField.getText();
        String bio = bioField.getText();
        uploadImage(null);
        Quackstagram.getInstance().authenticationManager.signUp(username, password, bio);

        Quackstagram.getInstance().redirectManager.redirect(new LogInPage());
        return true;
    }

    private void onSignInClicked(ActionEvent event) {
        Quackstagram.getInstance().redirectManager.redirect(new LogInPage());
    }


    private void uploadImage(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        fileChooser.setFileFilter(filter);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            //TODO save this file AFTER user clicks on register, not immediately
            File selectedFile = fileChooser.getSelectedFile();
            ImageUploadIOHandler io = new ImageUploadIOHandler();
            io.uploadProfilePicture(selectedFile, usernameField.getText());
            //saveProfilePicture(selectedFile, txtUsername.getText());
        }
    }

    private boolean uploadBio() {
        return false;
    }


}
