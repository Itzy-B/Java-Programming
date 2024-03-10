package nl.group26.quackstagram.components.mainComponents;

import nl.group26.quackstagram.Quackstagram;
import nl.group26.quackstagram.pages.*;

import javax.swing.*;
import java.awt.*;

import static nl.group26.quackstagram.Quackstagram.NAV_ICON_SIZE;

public class NavBar extends JPanel {

    public NavBar() {
        setBackground(new Color(249, 249, 249));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        add(createIconButton("img/icons/home.png", "home"));
        add(Box.createHorizontalGlue());
        add(createIconButton("img/icons/search.png","explore"));
        add(Box.createHorizontalGlue());
        add(createIconButton("img/icons/add.png","add"));
        add(Box.createHorizontalGlue());
        add(createIconButton("img/icons/heart.png","notification"));
        add(Box.createHorizontalGlue());
        add(createIconButton("img/icons/profile.png", "profile"));
    }

    private JButton createIconButton(String iconPath, String buttonType) {
        ImageIcon iconOriginal = new ImageIcon(iconPath);
        Image iconScaled = iconOriginal.getImage().getScaledInstance(NAV_ICON_SIZE, NAV_ICON_SIZE, Image.SCALE_SMOOTH);
        JButton button = new JButton(new ImageIcon(iconScaled));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);

        //username of logged in user
        String loggedInUsername = Quackstagram.getInstance().authenticationManager.loggedInUser.getUsername();

        // Define actions based on button type
        if ("home".equals(buttonType)) {
            button.addActionListener(e -> Quackstagram.getInstance().redirectManager.redirect(new HomePage()));
        } else if ("profile".equals(buttonType)) {
            button.addActionListener(e ->  Quackstagram.getInstance().redirectManager.redirect(new ProfilePage(loggedInUsername)));
        } else if ("notification".equals(buttonType)) {
            button.addActionListener(e ->  Quackstagram.getInstance().redirectManager.redirect(new NotificationPage()));
        } else if ("explore".equals(buttonType)) {
            button.addActionListener(e ->  Quackstagram.getInstance().redirectManager.redirect(new ExplorePage()));
        } else if ("add".equals(buttonType)) {
            button.addActionListener(e ->  Quackstagram.getInstance().redirectManager.redirect(new ImageUploadPage()));
        }
        return button;


    }


}
