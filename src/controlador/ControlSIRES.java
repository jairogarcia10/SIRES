/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.Estudiante;
import modelo.MatriculaFinalizada;
import modelo.RegistroCurso;
import modelo.RegistroEstudiante;
import vista.GUIBusquedad;
import vista.GUICurso;
import vista.GUIEstudiante;
import vista.GUIMatricula;
import vista.GUISIRES;
import vista.PanelBotones;
import vista.PanelCurso;
import vista.PanelTabla;

/**
 *
 *
 */
public class ControlSIRES implements ActionListener, ItemListener {

    private  AsignarCurso ac;
    private RegistroEstudiante registroEstudiante;
    private RegistroCurso registroCurso;
    private GUIBusquedad filtro;
    private int controlBusca = 0;
    private GUIMatricula guiMatricula;
    private GUIEstudiante guiEstudiante;
    private MatriculaFinalizada finalMatri;
    
private GUICurso guiCurso;
    public ControlSIRES() {
        registroEstudiante = new RegistroEstudiante();
        registroCurso = new RegistroCurso();

    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equalsIgnoreCase(GUISIRES.MNI_SALIR)) {
            System.exit(0);
        }
        if (evento.getActionCommand().equalsIgnoreCase(GUISIRES.MNI_REGISTRO_ESTUDIANTES)) {
            guiEstudiante = new GUIEstudiante(registroEstudiante);
            guiEstudiante.setVisible(true);
        }
        if (evento.getActionCommand().equalsIgnoreCase(GUISIRES.MNI_FILTRO)) {
            filtro = new GUIBusquedad(this, this);
            filtro.setVisible(true);
        }

        if (evento.getActionCommand().equalsIgnoreCase(PanelTabla.BTN_ATRAS)) {

            filtro.dispose();

        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelTabla.BTN_BUSCAR)) {
            if (controlBusca == 1) {

                filtro.setValores(
                        registroEstudiante.getMatrizBuscar(filtro.getConsulta(), 1),
                        Estudiante.getEtiquetas());
                //wfiltro.limpiar();
                 filtro.desbloquearMatricula(true);
            }
            if (controlBusca == 2) {
                filtro.setValores(
                        registroEstudiante.getMatrizBuscar(filtro.getConsulta(), 2),
                        Estudiante.getEtiquetas());
          
                filtro.desbloquearMatricula(true);
            }

        }
        if(evento.getActionCommand().equalsIgnoreCase(PanelTabla.BTN_MATRICULA)){
           ac= new AsignarCurso(filtro.getConsulta(),registroCurso);
            guiCurso=new GUICurso(this,ac);
        guiCurso.setVisible(true);
        }
      
        if (evento.getActionCommand().equalsIgnoreCase(PanelCurso.BTN_FINALIZAR)) {
        
        
        guiMatricula =new GUIMatricula();
        guiMatricula.setVisible(true);
        guiMatricula.setPrematricula(registroCurso.getMatrizCurso(),Curso.getEtiquetaCurso());
          guiMatricula.desbloquearMatricula(true);    
        }
        
       if(evento.getActionCommand().equalsIgnoreCase(PanelCurso.BTN_CANCELAR)){

       guiCurso.dispose();

       }
       if(evento.getActionCommand().equalsIgnoreCase(GUIMatricula.BTN_FINALIZARMATRICULA)){
 
           // JOptionPane.showMessageDialog(null,registroCurso.matriculaCurso(filtro.getConsulta(),registroCurso.));
            guiMatricula.setMatricula(registroCurso.getMatrizCurso(),Curso.getEtiquetaCurso());
            guiMatricula.limpiarPrematricula();
            
         //   MatriculaFinalizada matri = new MatriculaFinalizada(registroCurso.getMatrizCurso(filtro.getConsulta())),Curso.getEtiquetaCurso()));
            
           
guiMatricula.setMatricula(registroCurso.getMatrizCurso(),Curso.getEtiquetaCurso());
       }
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvento) {
        if (itemEvento.getStateChange() == ItemEvent.SELECTED) {

            if (itemEvento.getItem().toString().equalsIgnoreCase("All")) {

                filtro.editableCampoBuscar(false);

                filtro.setValores(registroEstudiante.getMarizEstudiante(), Estudiante.getEtiquetas());
            }

        }

        if (this.filtro.getCombo().equalsIgnoreCase("nombre")) {
            filtro.setEtiqueta("nombre:");
            filtro.editableCampoBuscar(true);
            controlBusca = 1;
        }
        if (this.filtro.getCombo().equalsIgnoreCase("carnet")) {
            filtro.setEtiqueta("carnet:");
            filtro.editableCampoBuscar(true);
            controlBusca = 2;
        }
    }
}
