package view;

import controller.ControladorRequerimientosReto4;
import model.vo.BancoRankeadoAreaPromedio;
import model.vo.MaterialRankeadoCompras;
import model.vo.ProyectoRankeadoCompras;
import java.sql.SQLException;
import java.util.ArrayList;

public class VistaRequerimientosReto4 {

    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    public static void requerimiento1(){

       System.out.println("-----10 Proyectos Mayor Gasto-------");       

       try{

           ArrayList<ProyectoRankeadoCompras> ds = controlador.consultarProyectosCompras10();

           //Encabezado del resultado
           System.out.println("ID_Proyecto Clasificación Gasto_Compras Serial");
           
           //.
           for (ProyectoRankeadoCompras rReg : ds) {
                
                System.out.printf("%d %s %d %s %n", 
                    rReg.getID_Proyecto(),
                    rReg.getClasificacion(),
                    rReg.getGasto_Comoras(),
                    rReg.getSerial()
                );
            };

        }

       catch(SQLException e){
           System.err.println("Ha ocurrido un error!"+e.getMessage());
       }

   }

   public static void requerimiento3(){

       System.out.println("-----Ranking Descendente Bancos (Área Proyectos)-------");       

       try{

           ArrayList<BancoRankeadoAreaPromedio> ds1 = controlador.consultarBancosRankeadosAreaPromedio();

           //Encabezado del resultado
           System.out.println("Banco_Vinculado Area_Promedio");

           //.
           for (BancoRankeadoAreaPromedio rReg : ds1) {
                
                System.out.printf("t%s\t%f\t %n", 
                rReg.getBancoVinculado(),
                rReg.getAreaPromedio()

                );
            };

       }
       catch(SQLException e){
           System.err.println("Ha ocurrido un error!"+e.getMessage());
       }

   }

   public static void requerimiento5(){

       System.out.println("-----Ranking Descendente Materiales Importados (Compras)-------");       

       try{

           ArrayList<MaterialRankeadoCompras> ds2 = controlador.consultarMaterialesRankeadosCompras();

           //Encabezado del resultado
           System.out.println("Nombre_Material Importado No_Compras");

           //.
           for (MaterialRankeadoCompras rReg : ds2) {
                
                System.out.printf("%s\t%s\t%d\t %n", 
                rReg.getNombre_Material(),
                rReg.getImportado(),
                rReg.getNo_Compras()

                );
            };

       }catch(SQLException e){
           System.err.println("Ha ocurrido un error!"+e.getMessage());
       }

   }

       
}
