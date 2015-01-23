package fr.michot.news.ui;

import fr.michot.news.entities.UserDb;
import org.hibernate.validator.constraints.Email;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
public class UserUI {
    Long id;
    String name;
    String firstName;
    @Email
    String email;

    public UserUI() {
    }

    public UserUI(Long id, String name, String firstName, String email) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
    }

    public static UserUI fromUserDb(UserDb userDb) {
        return new UserUI(userDb.getUserId(), userDb.getName(), userDb.getFirstName(), userDb.getEmail());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserUI userUI = (UserUI) o;

        if (email != null ? !email.equals(userUI.email) : userUI.email != null) return false;
        if (firstName != null ? !firstName.equals(userUI.firstName) : userUI.firstName != null) return false;
        if (id != null ? !id.equals(userUI.id) : userUI.id != null) return false;
        if (name != null ? !name.equals(userUI.name) : userUI.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserUI{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public UserDb toUserDb() {
        return this.toUserDb(null);
    }

    public UserDb toUserDb(UserDb userDb) {
        UserDb completedUserDb;
        if (userDb == null) {
            completedUserDb = new UserDb();
        } else {
            completedUserDb = userDb;
        }
        if (this.id != null) completedUserDb.setUserId(this.id);
        if (this.email != null) completedUserDb.setEmail(this.email);
        if (this.firstName != null) completedUserDb.setFirstName(this.firstName);
        if (this.name != null) completedUserDb.setName(this.name);
        return completedUserDb;
    }

    public UserDb smashWithUserDb(UserDb userDb) {
        UserDb completedUserDb;
        if (userDb == null) {
            completedUserDb = new UserDb();
        } else {
            completedUserDb = userDb;
        }
        completedUserDb.setUserId(this.id);
        completedUserDb.setEmail(this.email);
        completedUserDb.setFirstName(this.firstName);
        completedUserDb.setName(this.name);
        return completedUserDb;
    }
}
