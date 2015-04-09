/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.RegistroCurso;
import vista.PanelCurso;

/**
 *
 * @author JAIRO
 */
public class AsignarCurso implements ActionListener{
    ArrayList<Curso> listaCursos=new ArrayList<Curso>();

    private String carnet;
    private RegistroCurso res;
    private int blockProgra=0,blockMani=0,blockHisto=0,blockBase=0;
  
    public AsignarCurso(String carnet,RegistroCurso res)
    {
    this.carnet=carnet;
    this.res=res;
    }
    
    public void actionPerformed(ActionEvent evento) {
       
        if(evento.getActionCommand().equalsIgnoreCase(PanelCurso.JC_PROGRAMACION))
        {
            if(blockProgra==0){
        Curso curso=new Curso("Programacion",this.carnet,"4","ITM-PRO");
        
        JOptionPane.showMessageDialog(null,res.addCurso(curso,this.carnet,"ITM-PRO") );
            blockProgra=1;
            }
        }//programacion
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelCurso.JC_MANIPULACION))
        {
            if(blockMani==0){
        Curso curso=new Curso("Manipulacion",this.carnet,"4","ITM-MANI");
      
        JOptionPane.showMessageDialog(null,res.addCurso(curso,this.carnet,"ITM-MANI")); 
            blockMani=1;
            }
            }
        if(evento.getActionCommand().equalsIgnoreCase(PanelCurso.JC_HISTORIA))
        {
            if(blockHisto==0){
        Curso curso=new Curso("Historia",this.carnet,"4","ITM-HISTO");
         JOptionPane.showMessageDialog(null,res.addCurso(curso,this.carnet,"ITM-HISTO")); 
            blockHisto=1;
            }
            }
        if(evento.getActionCommand().equalsIgnoreCase(PanelCurso.JC_BASES))
        {
            if(blockBase==0){
        Curso curso=new Curso("Base de Datos",this.carnet,"4","ITM-BASE");
         JOptionPane.showMessageDialog(null,res.addCurso(curso,this.carnet,"ITM-BASE")); 
            blockBase=1;
            }
            }
    }
    
    public ArrayList listaCurso()
    {
    return listaCursos;
    }
    
    
    
    
    
}
