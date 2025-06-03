package Consultar;

import Frames.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.table.*;

public class ConsLider extends JFrame implements ActionListener {

    private JLabel lblBuscar;
    private JTextField txtUser;
    private JButton btnBuscar;
    private JTable resultadoTable;

    public ConsLider() {
        // Configuración de la ventana
        setTitle("Consulta de Líderes de Grupo");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Instancia de la clase MenuPrincipal
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        
        // Crea una instancia de JMenuBar
        JMenuBar menuBar = new JMenuBar();
        
        // Agrega la instancia de MenuPrincipal al JMenuBar
        menuBar.add(menuPrincipal);

        // Establece el JMenuBar como la barra de menú de la ventana
        setJMenuBar(menuBar);

        // Panel gris
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        getContentPane().add(panel);

        // Panel para el título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Nombre del sistema
        JLabel lblTitulo = new JLabel("CONSULTA DE LÍDERES");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        panelTitulo.add(lblTitulo);

        // Agregar panelTitulo al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(-110, 0, 0, 0);
        panel.add(panelTitulo, gbc);

        // Rectangulo naranja para campo de búsqueda
        JPanel rectangulo = new JPanel();
        rectangulo.setBackground(Color.ORANGE);
        rectangulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rectangulo.setLayout(new GridBagLayout());

        // Componentes dentro del rectángulo
        lblBuscar = new JLabel("Ingresa el ID del líder: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 0, 10);
        rectangulo.add(lblBuscar, gbc);

        txtUser = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 0, 10);
        rectangulo.add(txtUser, gbc);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        rectangulo.add(btnBuscar, gbc);

        // Agregar rectángulo al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(-40, 0, 0, 0);
        panel.add(rectangulo, gbc);

        // Componente de tabla para resultado de la consulta
        resultadoTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(resultadoTable);
        scrollPane.setPreferredSize(new Dimension(420, 100));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(50, 0, 0, 0);
        panel.add(scrollPane, gbc);
        
        // Modificar tipo, tamaño y color de fuente del encabezado de la tabla
        JTableHeader tableHeader = resultadoTable.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14));
        tableHeader.setForeground(Color.BLACK);

        // Mostrar ventana
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String idLider = txtUser.getText();

        try {
            // Conexión a la base de datos
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/entretenimientovacaciones","root","");
                Statement stmt = conn.createStatement();
                // Consulta a la tabla coloniavacacional
                ResultSet rs = stmt.executeQuery("SELECT CI_Lider, Nombre_Lider, Telefono_Lider, Correo_Lider FROM liderdegrupo WHERE ID_Lider = '" + idLider +"'"))
                {
                if (rs.next()) {
                    // Obtener los datos de la consulta
                    String ci = rs.getString("CI_Lider");
                    String nombre = rs.getString("Nombre_Lider");
                    String telefono = rs.getString("Telefono_Lider");
                    String correo = rs.getString("Correo_Lider");
                    
                    // Crear el modelo de tabla y añadir los datos
                    DefaultTableModel tableModel = new DefaultTableModel();
                    tableModel.addColumn("DATOS DEL LIDER: ID "+idLider);
                    tableModel.addRow(new Object[]{"C.I: "+ ci});
                    tableModel.addRow(new Object[]{"NOMBRE: "+ nombre});
                    tableModel.addRow(new Object[]{"TELÉFONO: "+ telefono});
                    tableModel.addRow(new Object[]{"EMAIL: "+ correo});
                    // Asignar el modelo de tabla al JTable
                    resultadoTable.setModel(tableModel);
                }
                else {
                    JOptionPane.showMessageDialog(this, "Este líder no existe. Revisa los datos ingresados.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos: " + ex
                .getMessage());
            } finally {
            // Cierra la conexión aquí
            }
            } finally {
            // Cierra la conexión aquí
            }
            }
        /*     public static void main(String[] args) {
                ConsLider prueba = new ConsLider();
            }*/
}