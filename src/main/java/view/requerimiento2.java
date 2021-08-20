package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import controller.ControladorRequerimientosReto4;
import java.awt.*;
import java.awt.GridLayout;

import model.vo.BancoRankeadoAreaPromedio;
import java.util.ArrayList;


public class requerimiento2 extends JFrame {
    
        // Botones del menú
        private JTable frmData;
    
        // Men´{u principal}
        public requerimiento2(ArrayList<BancoRankeadoAreaPromedio> dataset,  ControladorRequerimientosReto4 controlador) {
    
            super.setSize(1200, 600);
            super.setTitle("-----Ranking Descendente Bancos (Área Proyectos)-------");
            super.setBackground(Color.CYAN);
            super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            super.setResizable(true);
            super.setDefaultLookAndFeelDecorated(true);

            String[] header = {"Banco_Vinculado", "Area_Promedio"};
            String [][] regs = cadenaRegs(dataset, header.length);
            this.frmData = new JTable(regs, header);

            JScrollPane sPane = new JScrollPane(this.frmData);
            JPanel panelMain = new JPanel();
            panelMain.setBorder(new TitledBorder("Bancos ordenados por Areas promedio"));
            panelMain.setLayout(new GridLayout());
            panelMain.add(sPane);
            
            // Carga el contenido del panel
            getContentPane().add(panelMain);

            // Configura tamaño y posición
            setSize(600,600);
            setLocationRelativeTo(null);
            setVisible(true);

        }
    

        private String [][] cadenaRegs (ArrayList<BancoRankeadoAreaPromedio> registros, int encabezados){

            // retorno
            String [][] retorno = new String [registros.size()][encabezados];
            
            
            for (int i = 0; i < registros.size(); i++){

                retorno[i][0] = registros.get(i).getBancoVinculado();
                retorno[i][1] = String.valueOf(registros.get(i).getAreaPromedio());

            }

            return retorno;

        }
}
