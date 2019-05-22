package com.fsd.assignment.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "book")

public class Book implements Serializable {

    private static final long serialVersionUID = 523047852091722630L;

    @Id
    @Column(name = "book_id")
    private long bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name = "volume")
    private int volume;

    @Column(name = "pub_date")
    private LocalDate publishDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="subject_id", nullable=false)
    private Subject subject;

    public Book() {
    }

    public Book(long id) {
        bookId=id;

    }
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", publishDate=" + publishDate +

                '}';
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
