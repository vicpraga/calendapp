package presentacion;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import dominio.knowledge.Issue;
import dominio.managers.GestorIssues;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFormattedTextField;

import com.toedter.calendar.JDateChooser;

public class EnviarIssue extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfIssue;
    private JFormattedTextField tfDuracion;
    private JDateChooser calendario;

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
        lblIssue.setBounds(12, 92, 69, 16);
        contentPane.add(lblIssue);

        tfIssue = new JTextField();
        tfIssue.setBounds(61, 87, 254, 28);
        contentPane.add(tfIssue);
        tfIssue.setColumns(10);

        

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	Calendar c = Calendar.getInstance();
            	c.setTime(calendario.getDate());
                String fecha = c.get(Calendar.DATE)+"-"+c.get(Calendar.MONTH)+"-"+c.get(Calendar.YEAR);
                 try {
                        GestorIssues.send(new Issue(tfIssue.getText(), fecha, Integer.getInteger(tfDuracion.getText())));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        });
        btnEnviar.setBounds(325, 149, 117, 29);
        contentPane.add(btnEnviar);
        
        tfDuracion = new JFormattedTextField();
        tfDuracion.setColumns(10);
        tfDuracion.setBounds(399, 88, 54, 28);
        contentPane.add(tfDuracion);
        
        JLabel lblDuracion = new JLabel("Duracion:");
        lblDuracion.setBounds(325, 93, 69, 16);
        contentPane.add(lblDuracion);

        ArrayList<Integer> horas = new ArrayList<Integer>();
        for (int i = 1; i <= 24; ++i) {
        	horas.add(i);
        }
        
        
        ArrayList<Integer> meses = new ArrayList<Integer>();
        for (int i = 1; i <= 12; ++i) {
        	meses.add(i);
        }
        
        
        ArrayList<Integer> dias = new ArrayList<Integer>();
        for (int i = 1; i <= 31; ++i) {
        	dias.add(i);
        }
        
        JLabel lblDia = new JLabel("Dia:");
        lblDia.setBounds(47, 27, 69, 28);
        contentPane.add(lblDia);
        
    	calendario = new JDateChooser();
    	calendario.setBounds(97, 27, 117, 28);
    	contentPane.add(calendario);
        
    }
}
