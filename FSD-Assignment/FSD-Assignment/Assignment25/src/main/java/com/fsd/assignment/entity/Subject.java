package com.fsd.assignment.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

    private static final long serialVersionUID = 5230549922091722630L;
    @Id
    @Column(name = "subject_id")
    private long subjectId;
    @Column(name = "sub_title")
    private String subtitle;
    @Column(name = "duration_in_hrs")
    private int durationInHours;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="subject")
    private Set<Book> books;

    public Subject() {
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subtitle='" + subtitle + '\'' +
                ", durationInHours=" + durationInHours +
                '}';
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
