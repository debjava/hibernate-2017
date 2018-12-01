package com.ddlab.rnd.hibernate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "STUDENT")
public class Student {
 
    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    private long id;
 
    @Column(name = "FIRST_NAME")
    private String firstName;
 
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_SUBJECT", 
             joinColumns = { @JoinColumn(name = "STUDENT_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "SUBJECT_ID") })
    private List<Subject> subjects = new ArrayList<Subject>();
 
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
 
    public List<Subject> getSubjects() {
        return subjects;
    }
 
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
 
}
