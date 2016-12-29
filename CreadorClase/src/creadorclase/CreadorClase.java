/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creadorclase;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Angelo Wolf angelowolf21@gmail.com
 */
public class CreadorClase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        PersistenciaCreador pc = new PersistenciaCreador();
        ServicioCreador sc = new ServicioCreador();
        ValidacionCreador vc = new ValidacionCreador();
        EndPointCreador dc = new EndPointCreador();
        Set<String> clases = new HashSet<>();
        clases.add("TipoHabitacion");
        String paquete = "com.aw.hotel";
        for (String nombreClase : clases) {
            pc.crear(nombreClase, paquete);
            sc.crear(nombreClase, paquete);
            vc.crear(nombreClase, paquete);
            dc.crear(nombreClase, paquete);
        }
    }

}
