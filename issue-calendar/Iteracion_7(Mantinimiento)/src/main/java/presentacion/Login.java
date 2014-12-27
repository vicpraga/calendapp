package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;

import dominio.managers.GestorUsuario;
import dominio.knowledge.Usuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;



public class Login extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField textFieldLog;
    private JTextField textFieldPass;
    private JTextPane textPaneEstado;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frameLogin = new Login();
                    frameLogin.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {

    	
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 419, 286);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblIntroduzcaElLogin = new JLabel("Introduzca el login y el password para acceder al sistema");
        lblIntroduzcaElLogin.setBounds(6, 19, 386, 43);
        contentPane.add(lblIntroduzcaElLogin);

        textFieldLog = new JTextField();
        textFieldLog.setBounds(86, 68, 134, 28);
        contentPane.add(textFieldLog);
        textFieldLog.setColumns(10);

        JLabel lblLogin = new JLabel("Password:");
        lblLogin.setBounds(6, 122, 73, 16);
        contentPane.add(lblLogin);

        JLabel label = new JLabel("Login:");
        label.setBounds(6, 74, 61, 16);
        contentPane.add(label);

        textFieldPass = new JTextField();
        textFieldPass.setColumns(10);
        textFieldPass.setBounds(86, 116, 134, 28);
        contentPane.add(textFieldPass);

        JButton buttonAceptar = new JButton("Aceptar");
        buttonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String log = textFieldLog.getText();
                String pass = textFieldPass.getText();
                boolean i = false;
                try {
                    i = GestorUsuario.check(new Usuario(log, pass));
                } catch (Exception e) {
                    textPaneEstado.setText("Ha habido un error.");
                }
                if (i == true) {
                    textPaneEstado.setText("Autenticado");
                    try {
                        SiguienteIssue frame = new SiguienteIssue();
                        frame.setVisible(true);
                        dispose();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }              
                } else {
                    textPaneEstado.setText("No Autenticado");
                }
            }
        });
        buttonAceptar.setBounds(264, 69, 117, 29);
        contentPane.add(buttonAceptar);

        JLabel lblEstado = new JLabel("Estado");
        lblEstado.setForeground(Color.RED);
        lblEstado.setBounds(6, 171, 61, 16);
        contentPane.add(lblEstado);

        textPaneEstado = new JTextPane();
        textPaneEstado.setEditable(false);
        textPaneEstado.setBounds(6, 199, 407, 52);
        contentPane.add(textPaneEstado);

        JButton buttonLimpiar = new JButton("Limpiar");
        buttonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                textFieldLog.setText("");
                textFieldPass.setText("");
                textPaneEstado.setText("");

            }
        });
        buttonLimpiar.setBounds(264, 117, 117, 29);
        contentPane.add(buttonLimpiar);

        JButton btnNuevoUsuario = new JButton("Nuevo Usuario");
        btnNuevoUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                NuevoUsuario frame = new NuevoUsuario();
                frame.setVisible(true);
            }
        });
        btnNuevoUsuario.setBounds(264, 166, 117, 29);
        contentPane.add(btnNuevoUsuario);


    }
}
