package Frames;

import javax.swing.*;
import java.awt.event.*;

public class MenuPrincipal extends JMenuBar implements ActionListener {
    private JMenu consultarMenu, actualizarMenu, altaMenu, bajaMenu;
    private JMenuItem cerrarSesionItem;

    public MenuPrincipal() {
        // Crea los menús y los elementos de menú
        consultarMenu = new JMenu("Consultar");
        actualizarMenu = new JMenu("Actualizar");
        altaMenu = new JMenu("Alta");
        bajaMenu = new JMenu("Baja");
        cerrarSesionItem = new JMenuItem("Cerrar Sesión");

        // Item para cerrar sesión
        cerrarSesionItem.addActionListener(this);

        // Agrega los elementos de menú a los menús correspondientes
        consultarMenu.add(new JMenuItem("Consultar Clientes"));
        
        JMenuItem consultarAsociacionesItem = new JMenuItem("Consultar Asociaciones");
        consultarAsociacionesItem.addActionListener(this);
        consultarMenu.add(consultarAsociacionesItem);

        JMenuItem consultarLideresItem = new JMenuItem("Consultar Líderes de Grupo");
        consultarLideresItem.addActionListener(this);
        consultarMenu.add(consultarLideresItem);

        consultarMenu.add(new JMenuItem("Consultar Deportes"));

        JMenuItem consultarColoniasItem = new JMenuItem("Consultar Colonias Vacacionales");
        consultarColoniasItem.addActionListener(this);
        consultarMenu.add(consultarColoniasItem);

        consultarMenu.add(new JMenuItem("Consultar Juegos"));

        actualizarMenu.add(new JMenuItem("Actualizar Clientes"));
        actualizarMenu.add(new JMenuItem("Actualizar Asociaciones"));
        actualizarMenu.add(new JMenuItem("Actualizar Líderes de Grupo"));
        actualizarMenu.add(new JMenuItem("Actualizar Deportes"));
        actualizarMenu.add(new JMenuItem("Actualizar Colonias Vacacionales"));
        actualizarMenu.add(new JMenuItem("Actualizar Juegos"));

        altaMenu.add(new JMenuItem("Alta de Clientes"));
        altaMenu.add(new JMenuItem("Alta de Asociaciones"));
        altaMenu.add(new JMenuItem("Alta de Líderes de Grupo"));
        altaMenu.add(new JMenuItem("Alta de Deportes"));
        altaMenu.add(new JMenuItem("Alta de Colonias Vacacionales"));
        altaMenu.add(new JMenuItem("Alta de Juegos"));

        bajaMenu.add(new JMenuItem("Baja de Clientes"));
        bajaMenu.add(new JMenuItem("Baja de Asociaciones"));
        bajaMenu.add(new JMenuItem("Baja de Líderes de Grupo"));
        bajaMenu.add(new JMenuItem("Baja de Deportes"));
        bajaMenu.add(new JMenuItem("Baja de Colonias Vacacionales"));
        bajaMenu.add(new JMenuItem("Baja de Juegos"));

        // Agrega los menús a la barra de menú
        add(consultarMenu);
        add(actualizarMenu);
        add(altaMenu);
        add(bajaMenu);
        add(cerrarSesionItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cerrarSesionItem) {
            // Cerrar sesión y volver a la página de inicio de sesión
            Login login = new Login();
            login.setVisible(true);
            SwingUtilities.getWindowAncestor(this).dispose();
        } else if (e.getSource() == consultarMenu.getItem(1)) {
            // Verificar si se ha clickeado la opción "Consultar Asociaciones"
            Consultar.ConsAsoc consAsoc = new Consultar.ConsAsoc();
            consAsoc.setVisible(true);
            SwingUtilities.getWindowAncestor(this).dispose();
        } else if (e.getSource() == consultarMenu.getItem(2)) {
            // Verificar si se ha clickeado la opción "Consultar Líderes"
            Consultar.ConsLider consLider = new Consultar.ConsLider();
            consLider.setVisible(true);
            SwingUtilities.getWindowAncestor(this).dispose();
        } else if (e.getSource() == consultarMenu.getItem(4)) {
            // Verificar si se ha clickeado la opción "Consultar Colonias"
            Consultar.ConsCol conscol = new Consultar.ConsCol();
            conscol.setVisible(true);
            SwingUtilities.getWindowAncestor(this).dispose();
        }
    }
/*    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        JFrame frame = new JFrame("Menu Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menuPrincipal);
        frame.pack();
        frame.setVisible(true);
    }*/
}