package fr.michot.news.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
@Entity
public class UserRoleDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long userRoleId;
    String roleName;

    @ManyToMany(mappedBy = "userRoleDbs")
    Set<UserDb> userDbs;

    @ManyToMany(mappedBy = "userRoleDbs")
    Set<UserGroupDb> userGroupDbs;

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserDb> getUserDbs() {
        return userDbs;
    }

    public void setUserDbs(Set<UserDb> userDbs) {
        this.userDbs = userDbs;
    }

    public Set<UserGroupDb> getUserGroupDbs() {
        return userGroupDbs;
    }

    public void setUserGroupDbs(Set<UserGroupDb> userRoleDbs) {
        this.userGroupDbs = userRoleDbs;
    }

    @Override
    public String toString() {
        return "UserRoleDb{" +
                "userRoleId=" + userRoleId +
                ", roleName='" + roleName + '\'' +
                ", userDbs=" + userDbs +
                ", userGroupDbs=" + userGroupDbs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoleDb that = (UserRoleDb) o;

        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;
        if (userRoleId != null ? !userRoleId.equals(that.userRoleId) : that.userRoleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userRoleId != null ? userRoleId.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
