package nl.group26.quackstagram.user;

import nl.group26.quackstagram.components.mainComponents.Post;

public class Like {

    private Post post;
    private User user;

    public Like(Post post, User user) {
        this.post = post;
        this.user = user;
    }

    public boolean saveLike() {
        return false;
    }

}
