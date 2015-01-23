package fr.michot.news.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
@Entity
public class CategoryDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long categoryId;

    @OneToMany(mappedBy = "categoryDb")
    Set<NewsDb> newsDbSet;

    String name;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Set<NewsDb> getNewsDbSet() {
        return newsDbSet;
    }

    public void setNewsDbSet(Set<NewsDb> newsDbSet) {
        this.newsDbSet = newsDbSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryDb that = (CategoryDb) o;

        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (newsDbSet != null ? !newsDbSet.equals(that.newsDbSet) : that.newsDbSet != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId != null ? categoryId.hashCode() : 0;
        result = 31 * result + (newsDbSet != null ? newsDbSet.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", newsSet=" + newsDbSet +
                ", name='" + name + '\'' +
                '}';
    }
}
