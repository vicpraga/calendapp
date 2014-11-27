package presentacion;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import dominio.GestorIssues;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class EnviarIssue extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfIssue;
    private final JLabel lblHora = new JLabel("Hora:");
    private JFormattedTextField tfDuracion;
    private JComboBox<String> tfHora;
    private JComboBox<String> tfMes;
    private JComboBox<String> tfDia;

    /**
     * Create the frame.
     */
    public EnviarIssue() {
        
        setTitle("Enviar Issue");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 484, 228);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel lblIssue = new JLabel("Issue:");
        lblIssue.setBounds(10, 93, 69, 16);
        contentPane.add(lblIssue);

        tfIssue = new JTextField();
        tfIssue.setBounds(61, 87, 254, 28);
        contentPane.add(tfIssue);
        tfIssue.setColumns(10);



        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String issue = tfIssue.getText();
                String duracion = tfDuracion.getText();
                String fecha="Dia: "+tfDia.getSelectedItem().toString()+" Mes: "+tfMes.getSelectedItem().toString()+" Hora: "+tfHora.getSelectedItem().toString();
                boolean i = false;
                 try {
                        i = GestorIssues.send(issue,fecha,duracion);
                    } catch (Exception e) {
                        System.out.println("Excepcion");
                        System.out.println(e.getMessage());
                    }
                    if (i == true) {
                        System.out.println("Enviada");
                    } else {
                        System.out.println("No Enviada");
                    }
                }

            
        });
        btnEnviar.setBounds(325, 149, 117, 29);
        contentPane.add(btnEnviar);
        {
        	lblHora.setBounds(325, 27, 69, 16);
        	contentPane.add(lblHora);
        }
        
        tfDuracion = new JFormattedTextField();
        tfDuracion.setColumns(10);
        tfDuracion.setBounds(375, 87, 54, 28);
        contentPane.add(tfDuracion);
        
        JLabel lblDuracion = new JLabel("Duracion:");
        lblDuracion.setBounds(325, 93, 69, 16);
        contentPane.add(lblDuracion);

        ArrayList horas = new ArrayList();
        for (int i = 1; i <= 24; ++i) {
        	horas.add(i);
        }
        tfHora = new JComboBox(horas.toArray());
        tfHora.setBounds(360, 21, 69, 28);
        contentPane.add(tfHora);
        
        
        ArrayList meses = new ArrayList();
        for (int i = 1; i <= 12; ++i) {
        	meses.add(i);
        }
        tfMes = new JComboBox(meses.toArray());
        tfMes.setBounds(211, 21, 69, 28);
        contentPane.add(tfMes);
        
        
        ArrayList dias = new ArrayList();
        for (int i = 1; i <= 31; ++i) {
        	dias.add(i);
        }
        JLabel lblMes = new JLabel("Mes:");
        lblMes.setBounds(176, 27, 69, 16);
        contentPane.add(lblMes);
        
        tfDia = new JComboBox(dias.toArray());
        tfDia.setBounds(70, 21, 69, 28);
        contentPane.add(tfDia);
        
        JLabel lblDia = new JLabel("Dia:");
        lblDia.setBounds(35, 27, 69, 16);
        contentPane.add(lblDia);
        
    }
}
