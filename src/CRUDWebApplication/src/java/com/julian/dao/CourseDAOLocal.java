/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.dao;

import com.julian.model.Course;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 57300
 */
@Local
public interface CourseDAOLocal {

    void addCourse(Course course);

    void editCourse(Course course);

    void deleteCourse(int course);

    Course getCourse(int courseId);

    List<Course> getAllCourses();
    
}
