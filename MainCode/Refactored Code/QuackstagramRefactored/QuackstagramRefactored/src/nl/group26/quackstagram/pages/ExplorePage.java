package nl.group26.quackstagram.pages;

import nl.group26.quackstagram.components.PostsOverview;
import nl.group26.quackstagram.components.exploreComponents.SearchPanel;

import javax.swing.*;
import java.awt.*;

public class ExplorePage extends QuackstagramPage {

    public ExplorePage() {
        super("Explore");
        JPanel content = new JPanel();

        content.add(new SearchPanel(), BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(new PostsOverview());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        content.add(scrollPane, BorderLayout.CENTER);
        add(content, BorderLayout.CENTER);
    }

}
