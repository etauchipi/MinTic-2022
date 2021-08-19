package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.vo.MaterialRankeadoCompras;
import util.JDBCUtilities;

public class MaterialRankeadoComprasDao {

    //Obtener los importados más comprados
    public ArrayList<MaterialRankeadoCompras> rankingMaterialesComprasDescendente() throws SQLException {

        //.
        ArrayList<MaterialRankeadoCompras> retorno;
        Connection cConn;
        String sCnn;

        //Contenedor de la respuesta -> Colección de líderes
        retorno = new ArrayList<MaterialRankeadoCompras>();
        cConn = null;
        sCnn = "";

        try{
            cConn = JDBCUtilities.getConnection();

            sCnn = "SELECT";
            sCnn += " m.Nombre_Material, m.Importado,";
            sCnn += " COUNT(m.ID_MaterialConstruccion) as No_Compras";
            sCnn += " FROM";
            sCnn += " MaterialConstruccion as m";
            sCnn += " INNER JOIN Compra as c";
            sCnn += " ON c.ID_MaterialConstruccion = m.ID_MaterialConstruccion";
            sCnn += " WHERE";
            sCnn += " m.Importado = 'Si'";
            sCnn += " GROUP BY m.Nombre_Material";
            sCnn += " ORDER BY No_Compras DESC, Nombre_Material ASC";

            PreparedStatement statement = cConn.prepareStatement(sCnn);
            ResultSet resultSet = statement.executeQuery();

            //Moviendo apuntador por cada registro, cuando no hay más, retorna falso y se sale
            while(resultSet.next()){
                //Cargar el registro actual en un Value Object
                MaterialRankeadoCompras obResult = new MaterialRankeadoCompras();
                obResult.setImportado(resultSet.getString("Importado"));
                obResult.setNombre_Material(resultSet.getString("Nombre_Material"));
                obResult.setNo_Compras(resultSet.getInt("No_Compras"));
                retorno.add(obResult);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando material rankeado compras: "+e);
        }finally{
            if(cConn != null){
                cConn.close();
            }
        }

        //Retornamos la colección de VO's obtenida de la BD (Vacía, con un VO o muchos)
        return retorno;
    }
        
}