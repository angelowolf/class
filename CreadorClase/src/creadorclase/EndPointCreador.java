/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creadorclase;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 *
 * @author ang_2
 */
class EndPointCreador {

    private String nombre;
    private String paquete;

    /**
     * Crea la interface y el dao.
     *
     * @param nombreClase
     */
    public void crear(String nombre, String paquete) throws Exception {
        this.nombre = nombre;
        this.paquete = paquete;
        crearRest();
    }

    public void crearRest() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator");
        Path file = Paths.get("src/creadorclase/template/endpoint.txt");
        Scanner scanner = new Scanner(new FileInputStream(file.toFile()));
        try {
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine() + lineSeparator);
            }
        } finally {
            //Cerramos el FileInputStream y el Scanner.
            scanner.close();
        }

        String template = stringBuilder.toString();
        template = template.replaceAll("##paquete##", paquete);
        template = template.replaceAll("##clase##", nombre);

        Path fileNuevo = Paths.get("src/rest/com/aw/api/resources/endpoint/" + nombre + "Resource.java");
        if (!Files.exists(fileNuevo.getParent())) {
            Files.createDirectories(fileNuevo.getParent());
        }

        Files.write(fileNuevo, template.getBytes(), StandardOpenOption.CREATE);
    }
}
