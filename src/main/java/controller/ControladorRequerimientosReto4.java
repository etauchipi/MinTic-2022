package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import model.dao.BancoRankeadoAreaPromedioDao;
import model.dao.MaterialRankeadoComprasDao;
import model.dao.ProyectoRankeadoComprasDao;
import model.vo.BancoRankeadoAreaPromedio;
import model.vo.MaterialRankeadoCompras;
import model.vo.ProyectoRankeadoCompras;
import view.mainMenu;
import view.requerimiento1;
import view.requerimiento2;
import view.requerimiento3;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ControladorRequerimientosReto4 implements ActionListener {
    
    //.
    private final BancoRankeadoAreaPromedioDao bancoRankeadoAreaPromedioDao;
    private final MaterialRankeadoComprasDao MaterialRankeadoComprasDao;
    private final ProyectoRankeadoComprasDao proyectoRankeadoComprasDao;
    private final mainMenu menuMain;
    private requerimiento1 interface1;
    private requerimiento2 interface2;
    private requerimiento3 interface3;
    
    //.
    //.
    public ControladorRequerimientosReto4(){
        //.
        this.proyectoRankeadoComprasDao = new ProyectoRankeadoComprasDao();
        this.bancoRankeadoAreaPromedioDao = new BancoRankeadoAreaPromedioDao();
        this.MaterialRankeadoComprasDao = new MaterialRankeadoComprasDao();
        menuMain = new mainMenu();
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

    // Inicio en GM
    public void appIniciar(){

        this.menuMain.Inicializar(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        String comando;


        comando = ((JButton)e.getSource()).getActionCommand();

        switch(comando){

            case "Proyectos Gastos":

                try {
                    
                    ArrayList<ProyectoRankeadoCompras> dataset = new ArrayList<ProyectoRankeadoCompras>();
                    dataset = this.proyectoRankeadoComprasDao.rankingProyectosComprasDescendente10();
                    this.interface1 = new requerimiento1(dataset, this);

                } catch (SQLException eReq1) {
                    //TODO: handle exception
                    System.err.println("Error en frame 1: " + eReq1.getMessage());
                }

                break;

            case "Bancos":

            try {
                    
                ArrayList<BancoRankeadoAreaPromedio> dataset = new ArrayList<BancoRankeadoAreaPromedio>();
                dataset = this.bancoRankeadoAreaPromedioDao.rankingBancosAreaPromedioDescendente();
                this.interface2 = new requerimiento2(dataset, this);

                } catch (SQLException eReq2) {
                    //TODO: handle exception
                    System.err.println("Error en frame 2: " + eReq2.getMessage());
                }

            break;            

            case "Materiales Importados":

            try{
                ArrayList<MaterialRankeadoCompras> dataset = new ArrayList<MaterialRankeadoCompras>();
                dataset = this.MaterialRankeadoComprasDao.rankingMaterialesComprasDescendente();
                this.interface3 = new requerimiento3(dataset, this);

            } catch (SQLException eReq3) {
                 //TODO: handle exception
                System.err.println("Error en frame 3: " + eReq3.getMessage());
            }
            
            break;            

        }
        
    }



   
}
