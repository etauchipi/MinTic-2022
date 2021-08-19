package util;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class JDBCUtilities {
    
    // Ruta a la bd
    private static final String BD_UBICACION = "C:/Edgar/Mis Documentos/Mintic UTP/Mintic2022/Retos C2/Reto 4/mvc_proyectos_construccion/db/ProyectosConstruccion.db";

    // 
    public static Connection getConnection() throws SQLException {

        Connection retorno;
        String url;

        url = "jdbc:sqlite:" + JDBCUtilities.BD_UBICACION;
        retorno = DriverManager.getConnection(url);

        return retorno;

    }

    public static boolean dbVacia() {

        boolean retorno;
        
        retorno = false;

        File archivo = new File(JDBCUtilities.BD_UBICACION);
        retorno = archivo.length() == 0;

        return retorno;

    }

    
}
