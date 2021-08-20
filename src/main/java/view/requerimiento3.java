package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import controller.ControladorRequerimientosReto4;
import java.awt.*;
import java.awt.GridLayout;
import model.vo.MaterialRankeadoCompras;
import java.util.ArrayList;


public class requerimiento3 extends JFrame {
    
        // Botones del menú
        private JTable frmData;
    
        // Men´{u principal}
        public requerimiento3(ArrayList<MaterialRankeadoCompras> dataset,  ControladorRequerimientosReto4 controlador) {
    
            super.setSize(1200, 600);
            super.setTitle("-----Ranking Descendente Materiales Importados (Compras)-------");
            super.setBackground(Color.CYAN);
            super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            super.setResizable(true);
            super.setDefaultLookAndFeelDecorated(true);

            String[] header = {"Nombre_Material", "Importado", "No_Compras"};
            String [][] regs = cadenaRegs(dataset, header.length);
            this.frmData = new JTable(regs, header);

            JScrollPane sPane = new JScrollPane(this.frmData);
            JPanel panelMain = new JPanel();
            panelMain.setBorder(new TitledBorder("MAteriales tipo ordenados por compras"));
            panelMain.setLayout(new GridLayout());
            panelMain.add(sPane);
            
            // Carga el contenido del panel
            getContentPane().add(panelMain);

            // Configura tamaño y posición
            setSize(600,600);
            setLocationRelativeTo(null);
            setVisible(true);

        }
    

        private String [][] cadenaRegs (ArrayList<MaterialRankeadoCompras> registros, int encabezados){

            // retorno
            String [][] retorno = new String [registros.size()][encabezados];
            
            
            for (int i = 0; i < registros.size(); i++){

                retorno[i][0] = registros.get(i).getNombre_Material();
                retorno[i][1] = registros.get(i).getImportado();
                retorno[i][2] = String.valueOf(registros.get(i).getNo_Compras());

            }

            return retorno;

        }
}
