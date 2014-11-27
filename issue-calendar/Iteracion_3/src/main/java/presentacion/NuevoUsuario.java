package presentacion;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import dominio.GestorUsuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoUsuario extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldLogin;
    private JTextField textFieldPassword;
    private JTextPane textPane;


    /**
     * Create the frame.
     */
    public NuevoUsuario() {
        
        setTitle("Dar de alta a un nuevo usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 420, 285);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogin = new JLabel("Password:");
        lblLogin.setBounds(6, 81, 69, 16);
        contentPane.add(lblLogin);

        JLabel label = new JLabel("Login:");
        label.setBounds(6, 37, 69, 16);
        contentPane.add(label);

        textFieldLogin = new JTextField();
        textFieldLogin.setBounds(87, 31, 134, 28);
        contentPane.add(textFieldLogin);
        textFieldLogin.setColumns(10);

        textFieldPassword = new JTextField();
        textFieldPassword.setColumns(10);
        textFieldPassword.setBounds(87, 75, 134, 28);
        contentPane.add(textFieldPassword);

        JButton btnAltaUsuario = new JButton("Alta usuario");
        btnAltaUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String log = textFieldLogin.getText();
                String pass = textFieldPassword.getText();
                boolean i = false;

                try {
                    i = GestorUsuario.autenticar(log, pass);
                } catch (Exception e) {
                    System.out.println("Excepcion");
                    textPane.setText("Excepcion");
                }
                if (i == true) {
                    System.out.println("Autenticado");
                    textPane.setText("El Usuario Ya Existe");
                } else {

                    try {
                        i = GestorUsuario.nuevoUsuario(log, pass);
                    } catch (Exception e) {
                        System.out.println("Excepcion");
                        textPane.setText("Excepcion");
                    }
                    if (i == true) {
                        System.out.println("Insertado");
                        textPane.setText("Insertado");
                    } else {
                        System.out.println("No Insertado");
                        textPane.setText("No Insertado");
                    }

                }

            }
        });
        btnAltaUsuario.setBounds(253, 76, 117, 29);
        contentPane.add(btnAltaUsuario);

        JLabel label_1 = new JLabel("Estado");
        label_1.setForeground(Color.RED);
        label_1.setBounds(6, 126, 61, 16);
        contentPane.add(label_1);

        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBounds(6, 154, 407, 102);
        contentPane.add(textPane);
        
    }
}

