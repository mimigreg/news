package fr.michot.news.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */
@Entity
public class NewsDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long newsId;
    @ManyToOne
    CategoryDb categoryDb;
    @OneToMany(mappedBy = "newsDb")
    Set<PollDb> pollDbs;
    String title;
    String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsDb newsDb = (NewsDb) o;

        if (categoryDb != null ? !categoryDb.equals(newsDb.categoryDb) : newsDb.categoryDb != null) return false;
        if (content != null ? !content.equals(newsDb.content) : newsDb.content != null) return false;
        if (newsId != null ? !newsId.equals(newsDb.newsId) : newsDb.newsId != null) return false;
        if (pollDbs != null ? !pollDbs.equals(newsDb.pollDbs) : newsDb.pollDbs != null) return false;
        if (title != null ? !title.equals(newsDb.title) : newsDb.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = newsId != null ? newsId.hashCode() : 0;
        result = 31 * result + (categoryDb != null ? categoryDb.hashCode() : 0);
        result = 31 * result + (pollDbs != null ? pollDbs.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public CategoryDb getCategoryDb() {
        return categoryDb;
    }

    public void setCategoryDb(CategoryDb categoryDb) {
        this.categoryDb = categoryDb;
    }

    public Set<PollDb> getPollDbs() {
        return pollDbs;
    }

    public void setPollDbs(Set<PollDb> pollDbs) {
        this.pollDbs = pollDbs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", category=" + categoryDb +
                ", polls=" + pollDbs +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
