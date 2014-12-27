package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;

import dominio.*;
import dominio.knowledge.Issue;
import dominio.managers.GestorIssues;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JTextPane;
import javax.swing.JTextField;

public class SiguienteIssue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextPane textPaneEstado;
    private final JTextField tfIssue = new JTextField();

    public SiguienteIssue() {
    	tfIssue.setBounds(26, 109, 177, 29);
    	tfIssue.setColumns(10);
        setTitle("AutoIssues");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 419, 329);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnConsultar = new JButton("Consultar Issue");
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	 Vector<Issue> siguiente=null;
                try {
                	String issue = tfIssue.getText();
                    siguiente = GestorIssues.retrieve(new Issue(issue));
                } catch (Exception e) {
                    textPaneEstado.setText("Excepcion");
                }
                if (siguiente != null) {
                    for(int index=0;index<siguiente.size();index++){
                    	Issue i = siguiente.elementAt(index);
                    	textPaneEstado.setText("Issue: "+i.getissue()+"\nRealizada el "+i.getfecha()  +"       Durante: "+i.getduracion()+" horas");
                    }
                } else {
                    textPaneEstado.setText("No hay siguiente");
                }
            }
        });
        btnConsultar.setBounds(245, 109, 147, 29);
        contentPane.add(btnConsultar);

        JLabel lblEstado = new JLabel("Siguiente Issue");
        lblEstado.setForeground(Color.GREEN);
        lblEstado.setBounds(6, 171, 100, 16);
        contentPane.add(lblEstado);

        textPaneEstado = new JTextPane();
        textPaneEstado.setEditable(false);
        textPaneEstado.setBounds(6, 199, 407, 102);
        contentPane.add(textPaneEstado);



        JButton btnNuevaIssue = new JButton("Nueva Issue");
        btnNuevaIssue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                EnviarIssue frame = new EnviarIssue();
                frame.setVisible(true);
            }
        });
        btnNuevaIssue.setBounds(246, 11, 147, 29);
        contentPane.add(btnNuevaIssue);
        {
        	contentPane.add(tfIssue);
        }

    }
}
