package nl.group26.quackstagram.pages;

import nl.group26.quackstagram.components.mainComponents.Header;
import nl.group26.quackstagram.components.mainComponents.NavBar;
import nl.group26.quackstagram.pages.Page;

import javax.swing.*;
import java.awt.*;

public class QuackstagramPage extends Page {

    private int width;
    private int height;
    private NavBar navBar;
    private Header header;


    public QuackstagramPage(String title) {
        super("\uD83D\uDC25 " + title + " \uD83D\uDC25");

        setLayout(new BorderLayout()); // Reset the layout manager

        JPanel headerPanel = new Header("\uD83D\uDC25 " + title + " \uD83D\uDC25");
        JPanel navigationPanel = new NavBar();

        add(headerPanel, BorderLayout.NORTH);
        add(navigationPanel, BorderLayout.SOUTH);
    }

}
