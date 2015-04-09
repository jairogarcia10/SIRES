/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * 
 */
public class Curso {
    private String nombreCurso;
    private String carnet;
    private String cantidadCreditos;
    private String siglasCurso;
     private static String[] etiqueta = {"Carnet", "nombre Curso","siglas Curso","Creditos"};
   public Curso(String nombreCurso, String carnet, String cantidadCreditos, String siglasCurso ){
   this.nombreCurso=nombreCurso;
   this.carnet=carnet;
   this.cantidadCreditos=cantidadCreditos;
   this.siglasCurso=siglasCurso;
   } 

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getCantidadCreditos() {
        return cantidadCreditos;
    }

    public void setCantidadCreditos(String cantidadCreditos) {
        this.cantidadCreditos = cantidadCreditos;
    }

    public String getSiglasCurso() {
        return siglasCurso;
    }

    public void setSiglasCurso(String siglasCurso) {
        this.siglasCurso = siglasCurso;
    }
    public static String[] getEtiquetaCurso() {
        return etiqueta;
    }
      public static int getNumeroAtributos() {
        return etiqueta.length;
    }
        public String getAtributo(int numeroAtributo) {
        switch (numeroAtributo) {
            case 0:
                return carnet;
            case 1:
                return nombreCurso;
            case 2:
                return siglasCurso;
            case 3:
                return cantidadCreditos;
            default:
                return null;

        }

    }
}
