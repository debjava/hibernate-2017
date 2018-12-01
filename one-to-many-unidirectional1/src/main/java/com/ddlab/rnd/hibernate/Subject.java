package com.ddlab.rnd.hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "SUBJECT")
public class Subject {
 
    @Id
    @GeneratedValue
    @Column(name = "SUBJECT_ID")
    private long id;
 
    @Column(name = "NAME")
    private String name;
     
    public Subject(){
         
    }
     
    public Subject(String name){
        this.name = name;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
}