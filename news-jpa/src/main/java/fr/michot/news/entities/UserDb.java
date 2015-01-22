package fr.michot.news.entities;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.Set;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class UserDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long userId;

    @Email
    String email;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<UserGroupDb> userGroupDbs;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<UserRoleDb> userRoleDbs;

    @OneToMany(mappedBy = "userDb")
    Set<VoteDb> voteDbs;

    String pass;

    String name;

    String firstName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long email) {
        this.userId = email;
    }

    public Set<UserGroupDb> getUserGroupDbs() {
        return userGroupDbs;
    }

    public void setUserGroupDbs(Set<UserGroupDb> userGroupDbs) {
        this.userGroupDbs = userGroupDbs;
    }

    public Set<VoteDb> getVoteDbs() {
        return voteDbs;
    }

    public void setVoteDbs(Set<VoteDb> voteDbs) {
        this.voteDbs = voteDbs;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    @Override
    public String toString() {
        return "UserDb{" +
                "email='" + userId + '\'' +
                ", userGroupDbs=" + userGroupDbs +
                ", userRoleDbs=" + userRoleDbs +
                ", voteDbs=" + voteDbs +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDb userDb = (UserDb) o;

        if (email != null ? !email.equals(userDb.email) : userDb.email != null) return false;
        if (firstName != null ? !firstName.equals(userDb.firstName) : userDb.firstName != null) return false;
        if (name != null ? !name.equals(userDb.name) : userDb.name != null) return false;
        if (pass != null ? !pass.equals(userDb.pass) : userDb.pass != null) return false;
        if (userId != null ? !userId.equals(userDb.userId) : userDb.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserRoleDb> getUserRoleDbs() {

        return userRoleDbs;
    }

    public void setUserRoleDbs(Set<UserRoleDb> userRoleDbs) {
        this.userRoleDbs = userRoleDbs;
    }

}
