package com.accumenta.Knowledge_Hub_Portal.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Browseurls")

public class BrowseUrls {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private  String title;
    private  String url;
    private String description;
    private String postedby;

    public BrowseUrls(long id, String title, String url, String description, String postedby) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.description = description;
        this.postedby = postedby;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostedby() {
        return postedby;
    }

    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }

    @Override
    public String toString() {
        return "BrowseUrls{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", postedby='" + postedby + '\'' +
                '}';
    }
}
