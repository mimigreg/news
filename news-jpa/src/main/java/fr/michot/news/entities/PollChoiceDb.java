package fr.michot.news.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
@Entity
public class PollChoiceDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long pollChoiceId;
    @ManyToOne
    PollDb pollDb;
    @OneToMany(mappedBy = "pollChoiceDb")
    Set<VoteDb> voteDbs;
    String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PollChoiceDb that = (PollChoiceDb) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (pollChoiceId != null ? !pollChoiceId.equals(that.pollChoiceId) : that.pollChoiceId != null) return false;
        if (pollDb != null ? !pollDb.equals(that.pollDb) : that.pollDb != null) return false;
        if (voteDbs != null ? !voteDbs.equals(that.voteDbs) : that.voteDbs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pollChoiceId != null ? pollChoiceId.hashCode() : 0;
        result = 31 * result + (pollDb != null ? pollDb.hashCode() : 0);
        result = 31 * result + (voteDbs != null ? voteDbs.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Long getPollChoiceId() {
        return pollChoiceId;
    }

    public void setPollChoiceId(Long pollChoiceId) {
        this.pollChoiceId = pollChoiceId;
    }

    public PollDb getPollDb() {
        return pollDb;
    }

    public void setPollDb(PollDb pollDb) {
        this.pollDb = pollDb;
    }

    public Set<VoteDb> getVoteDbs() {
        return voteDbs;
    }

    public void setVoteDbs(Set<VoteDb> voteDbs) {
        this.voteDbs = voteDbs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PollChoice{" +
                "pollChoiceId=" + pollChoiceId +
                ", poll=" + pollDb +
                ", votes=" + voteDbs +
                ", description='" + description + '\'' +
                '}';
    }
}
