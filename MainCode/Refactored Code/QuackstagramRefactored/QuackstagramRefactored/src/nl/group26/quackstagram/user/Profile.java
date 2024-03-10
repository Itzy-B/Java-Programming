package nl.group26.quackstagram.user;

import nl.group26.quackstagram.components.mainComponents.Post;
import nl.group26.quackstagram.components.profileComponents.ProfilePicture;

public class Profile {

    private User user;
    private Post[] posts;
    private User[] following;
    private User[] followers;
    private ProfilePicture profilePicture;

    public Profile(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Post[] getPosts() {
        return posts;
    }

    public User[] getFollowing() {
        return following;
    }

    public User[] getFollowers() {
        return followers;
    }

    public ProfilePicture getProfilePicture() {
        return profilePicture;
    }
}
