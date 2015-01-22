package fr.michot.news.entities;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */

import javax.persistence.*;
import java.util.Set;

@Entity
public class PollDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long pollId;
    @ManyToOne
    NewsDb newsDb;
    @OneToMany(mappedBy = "pollDb")
    Set<PollChoiceDb> pollChoiceDbs;
    String question;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PollDb pollDb = (PollDb) o;

        if (newsDb != null ? !newsDb.equals(pollDb.newsDb) : pollDb.newsDb != null) return false;
        if (pollChoiceDbs != null ? !pollChoiceDbs.equals(pollDb.pollChoiceDbs) : pollDb.pollChoiceDbs != null)
            return false;
        if (pollId != null ? !pollId.equals(pollDb.pollId) : pollDb.pollId != null) return false;
        if (question != null ? !question.equals(pollDb.question) : pollDb.question != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pollId != null ? pollId.hashCode() : 0;
        result = 31 * result + (newsDb != null ? newsDb.hashCode() : 0);
        result = 31 * result + (pollChoiceDbs != null ? pollChoiceDbs.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        return result;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public NewsDb getNewsDb() {
        return newsDb;
    }

    public void setNewsDb(NewsDb newsDb) {
        this.newsDb = newsDb;
    }

    public Set<PollChoiceDb> getPollChoiceDbs() {
        return pollChoiceDbs;
    }

    public void setPollChoiceDbs(Set<PollChoiceDb> pollChoiceDbs) {
        this.pollChoiceDbs = pollChoiceDbs;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "pollId=" + pollId +
                ", news=" + newsDb +
                ", pollChoices=" + pollChoiceDbs +
                ", question='" + question + '\'' +
                '}';
    }
}
