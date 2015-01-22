package fr.michot.news.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */
@Entity
public class UserGroupDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long userGroupId;
    String groupName;
    @ManyToMany(mappedBy = "userGroupDbs")
    Set<UserDb> userDbs;
    @ManyToMany(fetch = FetchType.EAGER)
    Set<UserRoleDb> userRoleDbs;

    public Long getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<UserDb> getUserDbs() {
        return userDbs;
    }

    public void setUserDbs(Set<UserDb> userDbs) {
        this.userDbs = userDbs;
    }

    public Set<UserRoleDb> getUserRoleDbs() {
        return userRoleDbs;
    }

    public void setUserRoleDbs(Set<UserRoleDb> userRoleDbs) {
        this.userRoleDbs = userRoleDbs;
    }

    @Override
    public String toString() {
        return "UserGroupDb{" +
                "userGroupId=" + userGroupId +
                ", groupName='" + groupName + '\'' +
                ", userDbs=" + userDbs +
                ", userRoleDbs=" + userRoleDbs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGroupDb that = (UserGroupDb) o;

        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (userGroupId != null ? !userGroupId.equals(that.userGroupId) : that.userGroupId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userGroupId != null ? userGroupId.hashCode() : 0;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        return result;
    }
}
