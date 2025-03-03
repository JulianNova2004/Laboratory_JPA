/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.dao;

import com.julian.model.Project;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 57300
 */
@Local
public interface ProjectDAOLocal {

    void addProject(Project project);

    void editProject(Project project);

    void deleteProject(int projectId);

    Project getProject(int projectId);

    List<Project> getAllProjects();
    
}
