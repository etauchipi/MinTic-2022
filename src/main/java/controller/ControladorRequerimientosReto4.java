package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.BancoRankeadoAreaPromedioDao;
import model.dao.MaterialRankeadoComprasDao;
import model.dao.ProyectoRankeadoComprasDao;
import model.vo.BancoRankeadoAreaPromedio;
import model.vo.MaterialRankeadoCompras;
import model.vo.ProyectoRankeadoCompras;

public class ControladorRequerimientosReto4 {
    
    //.
    private final BancoRankeadoAreaPromedioDao bancoRankeadoAreaPromedioDao;
    private final MaterialRankeadoComprasDao MaterialRankeadoComprasDao;
    private final ProyectoRankeadoComprasDao proyectoRankeadoComprasDao;
    
    //.
    //.
    public ControladorRequerimientosReto4(){
        //.
        this.proyectoRankeadoComprasDao = new ProyectoRankeadoComprasDao();
        this.bancoRankeadoAreaPromedioDao = new BancoRankeadoAreaPromedioDao();
        this.MaterialRankeadoComprasDao = new MaterialRankeadoComprasDao();
        //.
        //.
    }

    public ArrayList<ProyectoRankeadoCompras> consultarProyectosCompras10() throws SQLException {
        //.
        return this.proyectoRankeadoComprasDao.rankingProyectosComprasDescendente10(); 
        
        //.
        //.
    }
    
    public ArrayList<BancoRankeadoAreaPromedio> consultarBancosRankeadosAreaPromedio() throws SQLException {
        //.
        return this.bancoRankeadoAreaPromedioDao.rankingBancosAreaPromedioDescendente();
        //.
        //.
    }

    public ArrayList<MaterialRankeadoCompras> consultarMaterialesRankeadosCompras() throws SQLException {
        //.
        return this.MaterialRankeadoComprasDao.rankingMaterialesComprasDescendente();
        //.
        //.
    }
   
}
