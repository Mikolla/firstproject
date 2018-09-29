package ru.firstproject.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 -- we don't know how to generate schema db_example (class Schema) :(
 create table if not exists books
 (
 id bigint auto_increment
 primary key,
 name varchar(255) null,
 author varchar(255) null,
 year int(10) null
 )
 ;

 create table if not exists users
 (
 id bigint auto_increment
 primary key,
 name varchar(255) null,
 constraint UK_3g1j96g94xpk3lpxl2qbl985x
 unique (name)
 )
 ;

 */
@Entity
@Table(name = "books")
public class BookDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true, updatable = true)
    private String name;

    @Column(name = "author", unique = false, updatable = true)
    private String author;

    @Column(name = "year", unique = false, updatable = true)
    private int year;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public BookDataSet() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public BookDataSet(long id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public BookDataSet(String name) {
        this.setId(-1);
        this.setName(name);
    }

    public BookDataSet( String name, String author, int year) {
        this.setAuthor(author);
        this.setYear(year);
        this.setId(-1);
        this.setName(name);
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "bookDataSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}