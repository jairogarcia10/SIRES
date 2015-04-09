/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * 
 */
public class MatriculaFinalizada {
    private Estudiante est;
    private ArrayList<Curso> curso;

    public MatriculaFinalizada(Estudiante est, ArrayList<Curso> curso) {
        this.est = est;
        this.curso = curso;
    }
     

    public Estudiante getEst() {
        return est;
    }

    public void setEst(Estudiante est) {
        this.est = est;
    }

    public ArrayList<Curso> getCurso() {
        return curso;
    }

    public void setCurso(ArrayList<Curso> curso) {
        this.curso = curso;
    }
    
}
