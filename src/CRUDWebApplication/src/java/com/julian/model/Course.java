/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author 57300
 */

@Entity
@Table
@NamedQueries(@NamedQuery(name="Course.getAll", query="SELECT e FROM Course e"))
public class Course implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int courseId;
    @Column
    private String name;
    @Column
    private int creditsNumber;
    @Column
    private int semester;
    @Column
    private int admitedStudents;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
    
    public Course(int courseId, String name, int creditsNumber, int semester, int admitedStudents) {
        this.courseId = courseId;
        this.name = name;
        this.creditsNumber = creditsNumber;
        this.semester = semester;
        this.admitedStudents = admitedStudents;
    }
    
    public Course(){
        
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditsNumber() {
        return creditsNumber;
    }

    public void setCreditsNumber(int creditsNumber) {
        this.creditsNumber = creditsNumber;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getAdmitedStudents() {
        return admitedStudents;
    }

    public void setAdmitedStudents(int admitedStudents) {
        this.admitedStudents = admitedStudents;
    }
    
}
