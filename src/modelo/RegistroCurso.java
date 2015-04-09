/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;
/**
 *
 * @author JAIRO
 */
public class RegistroCurso {
    
     ArrayList<Curso> listaCursos;
      ArrayList<MatriculaFinalizada> listaMatriculados; 
     
     public RegistroCurso() {
        listaCursos = new ArrayList<Curso>();
listaMatriculados=new ArrayList<MatriculaFinalizada>();
                
        }
     
   
      public String addCurso(Curso curso,String carnet,String siglasCurso) {
        if (curso != null) {
            if (comprobarSiglas(carnet,siglasCurso)) {
                listaCursos.add(curso);
                return "El curso fue agregado correctamente";
            } else {
                return "El curso se encuentra registrado!";
            }
        }
        return "El objeto es null!";
    }//Fin de addCurso
       public boolean comprobarSiglas(String carnet,String siglaCurso) {
        if (!carnet.equalsIgnoreCase("")) {
            if (listaCursos.size() != 0) {
                for (int index = 0; index < listaCursos.size(); index++) {
                    if (listaCursos.get(index).getCarnet().equalsIgnoreCase(carnet)){
                        if(listaCursos.get(index).getSiglasCurso().equalsIgnoreCase(siglaCurso)){ 
                        return false;}
                    }return true;
                }
            }
        }
        return true;
    }//Fin del metodo verificar
public String deleteCurso(Curso curso) {
        for (int i = 0; i < listaCursos.size(); i++) {
            if (curso.getCarnet().equalsIgnoreCase(curso.getCarnet())) {
                listaCursos.remove(i);
              return "el curso fue eliminado correctamente!";
            }
        }

        return "El proceso de elminar curso  no fue realizado correctamente";
    }//Fin del metodo eliminar curso
 public Curso consultarCurso(String carnet) {

        for (Curso curso : listaCursos) {
            if (curso.getCarnet().equalsIgnoreCase(carnet)) {

                return curso;
            }
        }

        return null;
    }//Fin del consultar
 public String[][] getMatrizCurso() {

        String matriz[][] = new String[listaCursos.size()][Curso.getNumeroAtributos()];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = listaCursos.get(fila).getAtributo(columna);
            }
        }
        return matriz;
    }

   public String[][] getMatrizBuscar(String busca, int filtro) {
        ArrayList<Curso> listaE = new ArrayList<Curso>();

        for (Curso curso : listaCursos) {
            if (filtro == 1) {
                if (curso.getSiglasCurso().equalsIgnoreCase(busca)) {
                    listaE.add(curso);
                }
            } else if (filtro == 2) {
                if (curso.getNombreCurso().equalsIgnoreCase(busca)) {
                    listaE.add(curso);
                }
            } else {
                if (curso.getCantidadCreditos().equalsIgnoreCase(busca)) {
                    listaE.add(curso);
                }
            }
        }//fin del ciclo

        String matriz[][] = new String[listaE.size()][Curso.getNumeroAtributos()];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = listaE.get(fila).getAtributo(columna);
            }
        }
        return matriz;
    }
     
    public ArrayList llenarConCurso(String carnet)
    {
    ArrayList<Curso>llenarArray = new ArrayList<Curso>();
    for(Curso curso:listaCursos)
    {
    if(curso.getCarnet().equalsIgnoreCase(carnet))
    {
    llenarArray.add(curso);
   
    }   
    } 
    return llenarArray;
    }
    
    public String matriculaCurso(String carnet,Estudiante est)
    {
MatriculaFinalizada cursoM= new MatriculaFinalizada(est, llenarConCurso(carnet));
                listaMatriculados.add(cursoM); 
                return "Matricula Finalizda";
    }//fin matriculaCurso
   }

