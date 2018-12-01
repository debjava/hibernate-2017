package com.ddlab.rnd.hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "STUDENT1")
public class Student {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private long id;
 
    @Column(name = "FIRST_NAME")
    private String firstName;
 
    @ManyToOne(optional = false) // you may or may not provide (optional = false)
    @JoinColumn(name="UNIVERSITY_ID")
    private University university;
 
 
    public Student() {
    }
 
    public Student(String firstName) {
        this.firstName = firstName;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public University getUniversity() {
        return university;
    }
 
    public void setUniversity(University university) {
        this.university = university;
    }
 
}