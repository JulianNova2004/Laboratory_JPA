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
@Table
@NamedQueries({
    @NamedQuery(name="Project.getAll", query="SELECT p FROM Project p")
})
@Entity
public class Project implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int idProject;
    @Column
    private String name;
    @Column
    private String descripcion;
    @Column
    private String localidad;
    @Column
    private int presupuesto;
    @Column
    private int habitantes;

    public Project() {
    }

    public Project(int idProject, String name, String descripcion, String localidad, int presupuesto, int habitantes) {
        this.idProject = idProject;
        this.name = name;
        this.descripcion = descripcion;
        this.localidad = localidad;
        this.presupuesto = presupuesto;
        this.habitantes = habitantes;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }
    
    
    
}
