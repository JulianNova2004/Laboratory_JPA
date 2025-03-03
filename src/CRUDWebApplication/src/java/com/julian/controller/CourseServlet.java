/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.controller;

import com.julian.dao.CourseDAOLocal;
import com.julian.model.Course;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 57300
 */
@WebServlet(name = "CourseServlet", urlPatterns = {"/CourseServlet"})
public class CourseServlet extends HttpServlet {
    @EJB
    private CourseDAOLocal courseDao;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String courseIdStr = request.getParameter("courseId");
        int courseId = 0;
        if(courseIdStr!=null && !courseIdStr.equals(""))
            courseId = Integer.parseInt(courseIdStr);
        
        String name = request.getParameter("name");
        
        String creditsNumberStr = request.getParameter("creditsNumber");
        int creditsNumber = 0;
        if(creditsNumberStr!=null && !creditsNumberStr.equals(""))
            creditsNumber = Integer.parseInt(creditsNumberStr);
        
        String semesterStr = request.getParameter("semester");
        int semester = 0;
        if(semesterStr!=null && !semesterStr.equals(""))
            semester = Integer.parseInt(semesterStr);
        
        String admitedStudentsStr = request.getParameter("admitedStudents");
        int admitedStudents = 0;
        if(admitedStudentsStr!=null && !admitedStudentsStr.equals(""))
            admitedStudents = Integer.parseInt(admitedStudentsStr);
        
        Course course = new Course(courseId, name, creditsNumber, semester, admitedStudents);
        
        
        if("AddCourse".equalsIgnoreCase(action)){
            courseDao.addCourse(course);
        
        }else if("EditCourse".equalsIgnoreCase(action)){
            courseDao.editCourse(course);
            
        }else if("DeleteCourse".equalsIgnoreCase(action)){
            courseDao.deleteCourse(courseId);
            
        }else if("SearchCourse".equalsIgnoreCase(action)){
            course = courseDao.getCourse(courseId);
            
        }
        
        request.setAttribute("course", course);
        request.setAttribute("allCourse", courseDao.getAllCourses());
        request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
