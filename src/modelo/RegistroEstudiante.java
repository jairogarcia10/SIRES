/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 
 */
public class RegistroEstudiante {

    ArrayList<Estudiante> listaEstudiante;

    

    public RegistroEstudiante() {
        listaEstudiante = new ArrayList<Estudiante>();

    }

    public String addEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            if (verificarCarnet(estudiante.getCarnet())) {
                listaEstudiante.add(estudiante);
                return "El estudiante fue agregado correctamente";
            } else {
                return "El estudiante se encuentra registrado!";
            }
        }
        return "El objeto es null!";
    }

    public boolean verificarCarnet(String carnet) {
        if (!carnet.equalsIgnoreCase("")) {
            if (listaEstudiante.size() != 0) {
                for (int index = 0; index < listaEstudiante.size(); index++) {
                    if (listaEstudiante.get(index).getCarnet().equals(carnet)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Estudiante consultar(String carnet) {

        for (Estudiante estudiante : listaEstudiante) {
            if (estudiante.getCarnet().equalsIgnoreCase(carnet)) {

                return estudiante;
            }
        }

        return null;
    }

    public String consultarAll() {
        String salida = "Carnet\t" + "Nombre\t\t" + "Edad\n";
        for (Estudiante estudiante : listaEstudiante) {
            salida += estudiante.getInformacion() + "\n";
        }
        return salida;
    }//

    public String deleteEstudiante(Estudiante estudiante) {
        for (int i = 0; i < listaEstudiante.size(); i++) {
            if (estudiante.getCarnet().equalsIgnoreCase(estudiante.getCarnet())) {
                listaEstudiante.remove(i);
                return "el estudiante fue eliminado correctamente!";
            }
        }

        return "El proceso de elminar no fue realizado correctamente";
    }

    public String[][] getMarizEstudiante() {
        String matriz[][] = new String[listaEstudiante.size()][Estudiante.getNumeroAtributos()];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {

                matriz[fila][columna] = listaEstudiante.get(fila).getAtributo(columna);
            }

        }
        return matriz;
    }

    public String[][] getMatrizBuscar(String busca, int filtro) {
        
        ArrayList<Estudiante> listaE = new ArrayList<Estudiante>();
        for (Estudiante estudiante : listaEstudiante) {
            if (filtro == 1) {
                if (estudiante.getNombre().equalsIgnoreCase(busca)) {
                    listaE.add(estudiante);
                }
            } else if (filtro == 2) {
                if (estudiante.getCarnet().equalsIgnoreCase(busca)) {
                    listaE.add(estudiante);
                }
            }
        }
        String matriz[][] = new String[listaE.size()][Estudiante.getNumeroAtributos()];
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = listaE.get(fila).getAtributo(columna);
            }
        }
        return matriz;
    }
}



