package com.ddlab.rnd.hibernate;
import java.util.List;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "UNIVERSITY1")
public class University {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "UNIVERSITY_ID")
    private long id;
 
    @Column(name = "NAME")
    private String name;
 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "university")
    private List<Student> students;
 
    public University() { }
  
    public University(String name) {
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
 
    public List<Student> getStudents() {
        return students;
    }
 
    public void setStudents(List<Student> students) {
        this.students = students;
    }
 
}
