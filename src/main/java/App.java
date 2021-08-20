

import java.sql.Connection;
import java.sql.SQLException;
import controller.ControladorRequerimientosReto4;
import util.JDBCUtilities;
import view.VistaRequerimientosReto4;

/**
 * Aplicación Proyectos de construcción
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        ControladorRequerimientosReto4 controlador;

        //Requerimiento 1 - Reto3
        //VistaRequerimientosReto4.requerimiento1();
        //System.out.println();

        //Requerimiento 3 - Reto3
        //VistaRequerimientosReto4.requerimiento3();
        //System.out.println();

        //Requerimiento 5 - Reto3
        //VistaRequerimientosReto4.requerimiento5();
        //System.out.println();    
        
        // Iniciar desde el controlador
        controlador = new ControladorRequerimientosReto4();
        controlador.appIniciar();

    }

}
