package Frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.ImageIcon;

public class Login extends JFrame implements ActionListener {
    // Componentes
    private JLabel lblUser, lblPass;
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin;

    public Login() {
        // Configuración de la ventana
        setTitle("Pantalla de inicio");
        setSize(650, 650);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel gris
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240,240,240));
        panel.setLayout(null);

        //Nombre del sistema
        JLabel lblTitulo = new JLabel("SISTEMA DE ENTRETENIMIENTO Y VACACIONES");
        lblTitulo.setBounds(15, 40, 620, 100);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(lblTitulo);
        
        // Rectangulo naranja para formulario
        JPanel rectangulo = new JPanel();
        rectangulo.setBackground(Color.ORANGE);
        rectangulo.setBounds(15, 150, 300, 300);
        rectangulo.setLayout(null);
        rectangulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Componentes dentro del rectángulo
        lblUser = new JLabel("Usuario");
        lblUser.setBounds(50, 50, 100, 25);
        rectangulo.add(lblUser);

        txtUser = new JTextField();
        txtUser.setBounds(50, 75, 200, 25);
        rectangulo.add(txtUser);

        lblPass = new JLabel("Contraseña");
        lblPass.setBounds(50, 125, 100, 25);
        rectangulo.add(lblPass);

        txtPass = new JPasswordField();
        txtPass.setBounds(50, 150, 200, 25);
        rectangulo.add(txtPass);

        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setBounds(50, 200, 200, 25);
        btnLogin.addActionListener(this);
        rectangulo.add(btnLogin);

        // Agregar rectángulo al panel blanco
        panel.add(rectangulo);

        // Agregar imagen al lado del rectángulo
        ImageIcon imageIcon = new ImageIcon("img/pantalla_principal.jpg"); // Reemplaza "ruta_de_la_imagen.jpg" con la ruta de tu imagen
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(310, 150, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        panel.add(imageLabel);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Agregar panel a la ventana
        add(panel);
        // Mostrar ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
public void actionPerformed(ActionEvent e) {
    String user = txtUser.getText();
    String pass = new String(txtPass.getPassword());
    try {
        // Conexión a la base de datos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/entretenimientovacaciones","root","");
            Statement stmt = conn.createStatement();
            // Consulta a la tabla usuariosacceso
            ResultSet rs = stmt.executeQuery("SELECT Nombres_Usuario FROM usuariosacceso WHERE ID_Usuario = '" + user + "' AND Password_Usuario = '" + pass + "'")) {
            if (rs.next()) {
                // Ejecutar la clase MenuPrincipal
                PantallaPrincipal pantalla1 = new PantallaPrincipal(user);
                pantalla1.setVisible(true);
                dispose(); // Cerrar la ventana actual de login
            } else {
                JOptionPane.showMessageDialog(this, "Usuario y/o contraseña incorrectos");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos: " + ex.getMessage());
        } finally {
            // Cierra la conexión aquí
        }
    }finally {
        // Cierra la conexión aquí
    }
}}