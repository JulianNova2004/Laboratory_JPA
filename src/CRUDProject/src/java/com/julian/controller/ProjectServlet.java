/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.controller;

import com.julian.dao.ProjectDAOLocal;
import com.julian.model.Project;
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
@WebServlet(name = "ProjectServlet", urlPatterns = {"/ProjectServlet"})
public class ProjectServlet extends HttpServlet {
    @EJB
    private ProjectDAOLocal projectDao;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String idProjectStr = request.getParameter("idProject");
        int idProject = 0;
        if(idProjectStr!=null && !idProjectStr.equals(""))
            idProject = Integer.parseInt(idProjectStr);
        
        String name = request.getParameter("name");
        String descripcion = request.getParameter("descripcion");
        String localidad = request.getParameter("localidad");
        String presupuestoStr = request.getParameter("presupuesto");
        
        int presupuesto = 0;
        if(presupuestoStr!=null && !presupuestoStr.equals(""))
            presupuesto = Integer.parseInt(presupuestoStr);
        
        String habitantesStr = request.getParameter("habitantes");
        
        int habitantes = 0;
        if(habitantesStr!=null && !habitantesStr.equals(""))
            habitantes = Integer.parseInt(habitantesStr);
        
        Project project = new Project(idProject, name, descripcion, localidad, presupuesto, habitantes);
        
        if("Add".equalsIgnoreCase(action)){
            projectDao.addProject(project);
        
        }else if("Edit".equalsIgnoreCase(action)){
            projectDao.editProject(project);
            
        }else if("Delete".equalsIgnoreCase(action)){
            projectDao.deleteProject(idProject);
            
        }else if("Search".equalsIgnoreCase(action)){
            project = projectDao.getProject(idProject);
            
        }
        
        request.setAttribute("project", project);
        request.setAttribute("allProject", projectDao.getAllProjects());
        request.getRequestDispatcher("projectinfo.jsp").forward(request, response);
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            processRequest(request, response);
    }

    



}
