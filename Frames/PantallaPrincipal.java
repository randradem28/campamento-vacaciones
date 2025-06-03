package Frames;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class PantallaPrincipal extends JFrame {

    public PantallaPrincipal(String user) {
        // Configuración de la ventana
        setTitle("Pantalla Principal");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel blanco
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240));
        panel.setLayout(null);

        // Instancia de la clase MenuPrincipal
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        
        // Crea una instancia de JMenuBar
        JMenuBar menuBar = new JMenuBar();
        
        // Agrega la instancia de MenuPrincipal al JMenuBar
        menuBar.add(menuPrincipal);

        // Establece el JMenuBar como la barra de menú de la ventana
        setJMenuBar(menuBar);

        //Mensaje de bienvenida
        JLabel lblMsj = new JLabel("BIENVENIDO/A, ¿QUÉ DESEAS HACER HOY?");
        lblMsj.setBounds(10, 20, 600, 100);
        lblMsj.setHorizontalAlignment(SwingConstants.CENTER);
        lblMsj.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblMsj);

        // Agregar imagen al centro de la pantalla
        ImageIcon imageIcon = new ImageIcon("img/welcome.jpg"); 
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 125, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        panel.add(imageLabel);

        // Agrega el panel a la ventana
        add(panel);

        // Muestra la ventana
        setVisible(true);
    }
}