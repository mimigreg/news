package fr.michot.news.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
@Entity
public class VoteDb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long voteId;
    @ManyToOne
    UserDb userDb;
    @ManyToOne
    PollChoiceDb pollChoiceDb;

    Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoteDb voteDb = (VoteDb) o;

        if (date != null ? !date.equals(voteDb.date) : voteDb.date != null) return false;
        if (pollChoiceDb != null ? !pollChoiceDb.equals(voteDb.pollChoiceDb) : voteDb.pollChoiceDb != null)
            return false;
        if (userDb != null ? !userDb.equals(voteDb.userDb) : voteDb.userDb != null) return false;
        if (voteId != null ? !voteId.equals(voteDb.voteId) : voteDb.voteId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = voteId != null ? voteId.hashCode() : 0;
        result = 31 * result + (userDb != null ? userDb.hashCode() : 0);
        result = 31 * result + (pollChoiceDb != null ? pollChoiceDb.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public UserDb getUserDb() {
        return userDb;
    }

    public void setUserDb(UserDb userDb) {
        this.userDb = userDb;
    }

    public PollChoiceDb getPollChoiceDb() {
        return pollChoiceDb;
    }

    public void setPollChoiceDb(PollChoiceDb pollChoiceDb) {
        this.pollChoiceDb = pollChoiceDb;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "voteId=" + voteId +
                ", user=" + userDb +
                ", pollChoice=" + pollChoiceDb +
                ", date=" + date +
                '}';
    }
}
