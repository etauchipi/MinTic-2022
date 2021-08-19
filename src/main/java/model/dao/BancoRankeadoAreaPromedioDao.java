package model.dao;

import model.vo.BancoRankeadoAreaPromedio;
import java.util.ArrayList;
import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.SQLException;
//Clase para construir objetos de consulta
import java.sql.PreparedStatement;
//Clase para manejar la respuesta de la BD -> Contenedor (iterador)
import java.sql.ResultSet;

public class BancoRankeadoAreaPromedioDao {

    //Operaciones CRUD -> Create Read Update Delete

    //Consultar todos los líderes (READ)
    public ArrayList<BancoRankeadoAreaPromedio> rankingBancosAreaPromedioDescendente() throws SQLException {

        ArrayList<BancoRankeadoAreaPromedio> retorno;
        Connection cConn;
        String sCnn;

        //Contenedor de la respuesta -> Colección de líderes
        retorno = new ArrayList<BancoRankeadoAreaPromedio>();
        cConn = null;
        sCnn = "";

        try{
            cConn = JDBCUtilities.getConnection();
            //SELECT * FROM Lider;

            sCnn = "SELECT  p.Banco_Vinculado,";
            sCnn += " AVG(t.Area_Max) as Area_Promedio";
            sCnn += " FROM Proyecto p ";
            sCnn += " JOIN Tipo t ON ";
            sCnn += " p.ID_Tipo = t.ID_Tipo";
            sCnn += " GROUP BY p.Banco_Vinculado";
            sCnn += " ORDER BY Area_Promedio DESC";

            PreparedStatement statement = cConn.prepareStatement(sCnn);
            ResultSet resultSet = statement.executeQuery();

            //Moviendo apuntador por cada registro, cuando no hay más, retorna falso y se sale
            while(resultSet.next()){
                //Cargar el registro actual en un Value Object
                BancoRankeadoAreaPromedio obResult = new BancoRankeadoAreaPromedio();
                obResult.setAreaPromedio(resultSet.getDouble("Area_Promedio"));
                obResult.setBancoVinculado(resultSet.getString("Banco_Vinculado"));
                retorno.add(obResult);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando bancos rankeados areaMax promedio: "+e);
        }finally{
            if(cConn != null){
                cConn.close();
            }
        }

        //Retornamos la colección de VO's obtenida de la BD (Vacía, con un VO o muchos)
        return retorno;
    }
                            
    
}
