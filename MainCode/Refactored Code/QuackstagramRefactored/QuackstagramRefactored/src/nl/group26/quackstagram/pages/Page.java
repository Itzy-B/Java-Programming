package nl.group26.quackstagram.pages;

import javax.swing.*;

public class Page extends JPanel {

    private String title;

    public Page(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
