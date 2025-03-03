/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.dao;

import com.julian.model.Project;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 57300
 */
@Stateless
public class ProjectDAO implements ProjectDAOLocal {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addProject(Project project) {
        em.persist(project);
    }
    
    @Override
    public void editProject(Project project) {
        em.merge(project);
    }

    @Override
    public void deleteProject(int idProject) {
        em.remove(getProject(idProject));
    }

    @Override
    public Project getProject(int idProject) {
        return em.find(Project.class, idProject);
    }

    @Override
    public List<Project> getAllProjects() {
        return em.createNamedQuery("Project.getAll").getResultList();
    }
    
      
    
}
