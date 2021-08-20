package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.ControladorRequerimientosReto4;
import java.awt.*;;


public class mainMenu extends JFrame  {
    
        // Botones del menú
        private JButton btRequerimiento1;
        private JButton btRequerimiento2;
        private JButton btRequerimiento3;
    
        // Men´{u principal}
        public mainMenu() {
    
        }
    
        public boolean Inicializar(ControladorRequerimientosReto4 controlador) {
    
            // retorno
            boolean retorno;
            JPanel contenedor;

            retorno = false;
            contenedor = new JPanel();
    
            // Fija ventana
            super.setSize(1200, 500);
            super.setTitle("Misión TIC 2021 - G61C2R5");
            super.setBackground(Color.CYAN);
            super.setDefaultCloseOperation(EXIT_ON_CLOSE);
            super.setResizable(false);
            super.setDefaultLookAndFeelDecorated(true);

            // Cargar botones
            btRequerimiento1 = btInicializar("Proyectos Gastos");
            btRequerimiento1.addActionListener(controlador);
            btRequerimiento1.setActionCommand("Proyectos Gastos");
    
            btRequerimiento2 = btInicializar("Bancos");
            btRequerimiento2.addActionListener(controlador);
            btRequerimiento2.setActionCommand("Bancos");
    
            btRequerimiento3 = btInicializar("Materiales Importados");
            btRequerimiento3.addActionListener(controlador);
            btRequerimiento3.setActionCommand("Materiales Importados");
    
            // Organizar el frame
            contenedor.setLayout(new BorderLayout());
            contenedor.add(btRequerimiento1, BorderLayout.WEST);
            contenedor.add(btRequerimiento2, BorderLayout.CENTER);
            contenedor.add(btRequerimiento3, BorderLayout.EAST);
            getContentPane().add(contenedor);
    
            // Abre frame organizado
            this.add(contenedor);
            super.pack();
            super.setVisible(true);
    
            retorno = true;
    
            return retorno;
    
        }
    
        private JButton btInicializar(String rotulo) {
    
            JButton retorno;
    
            retorno = new JButton(rotulo);
            retorno.setSize(300, 200);
            retorno.setBackground(Color.BLUE);
            retorno.setForeground(Color.RED);
    
            return retorno;
    
        }

}
