package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.JDBCUtilities;
import model.vo.ProyectoRankeadoCompras;

public class ProyectoRankeadoComprasDao {
    
        //Obtener los 10 proyectos rankeados según las compras
        public ArrayList<ProyectoRankeadoCompras> rankingProyectosComprasDescendente10() throws SQLException {
  
            ArrayList<ProyectoRankeadoCompras> retorno;
            Connection cConn;
            String sCnn;
    
            //Contenedor de la respuesta -> Colección de líderes
            retorno = new ArrayList<ProyectoRankeadoCompras>();
            cConn = null;
            sCnn = "";
    
            try{
                cConn = JDBCUtilities.getConnection();
    
                sCnn = "SELECT";
                sCnn += " p.ID_Proyecto,";
                sCnn += " p.Clasificacion,";
                sCnn += " SUM(c.Cantidad * m.Precio_Unidad) as Gasto_Compras,";
                sCnn += " p.Serial";
                sCnn += " FROM";
                sCnn += " Proyecto as p";
                sCnn += " INNER JOIN Compra as c";
                sCnn += " ON p.ID_Proyecto = c.ID_Proyecto";
                sCnn += " INNER JOIN MaterialConstruccion as m";
                sCnn += " ON c.ID_MaterialConstruccion = m.ID_MaterialConstruccion";
                sCnn += " GROUP BY p.ID_Proyecto";
                sCnn += " ORDER BY Gasto_Compras DESC";
                sCnn += " LIMIT 10";
    
                PreparedStatement statement = cConn.prepareStatement(sCnn);
                ResultSet resultSet = statement.executeQuery();
    
                //Moviendo apuntador por cada registro, cuando no hay más, retorna falso y se sale
                while(resultSet.next()){
                    //Cargar el registro actual en un Value Object
                    ProyectoRankeadoCompras obResult = new ProyectoRankeadoCompras();
                    obResult.setClasificacion(resultSet.getString("clasificacion"));
                    obResult.setGasto_Comoras(resultSet.getInt("Gasto_Compras"));
                    obResult.setID_Proyecto(resultSet.getInt("ID_Proyecto"));
                    obResult.setSerial(resultSet.getString("Serial"));
                    retorno.add(obResult);
                }

                resultSet.close();
                statement.close();

            }catch(SQLException e){
                System.err.println("Error consultando proyecto rankeado compras: "+e);
            }finally{
                if(cConn != null){
                    cConn.close();
                }
            }
    
            //Retornamos la colección de VO's obtenida de la BD (Vacía, con un VO o muchos)
            return retorno;
        }

        
}
