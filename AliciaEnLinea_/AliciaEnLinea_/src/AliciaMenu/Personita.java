package AliciaMenu;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelo.copy.Persona;
import javax.swing.JLabel;

public class Personita extends JFrame {

	public Persona p;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personita frame = new Personita();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Personita() {
		setTitle("Alicia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(74, 65, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEmbellecer = new JButton("Embellecer");
		btnEmbellecer.setBounds(101, 268, 106, 23);
		contentPane.add(btnEmbellecer);
		
		JButton btnEsLindo = new JButton("Es lindo");
		btnEsLindo.setBounds(284, 268, 89, 23);
		contentPane.add(btnEsLindo);
		
		JButton btnEstaEnMaravillas = new JButton("Está en maravillas");
		btnEstaEnMaravillas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEstaEnMaravillas.setBounds(445, 268, 149, 23);
		contentPane.add(btnEstaEnMaravillas);
		
		JButton btnEsNormal = new JButton("Es Normal");
		btnEsNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEsNormal.setBounds(644, 268, 106, 23);
		contentPane.add(btnEsNormal);
		
	
		JLabel lblEmbellecer = new JLabel(" ");
		lblEmbellecer.setBounds(144, 393, 46, 14);
		contentPane.add(lblEmbellecer);
		
		// -------- Funcionalidades --------
		
		btnEmbellecer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblEmbellecer.setText("Fue embellecido");
				lblEmbellecer.setForeground(new Color(255, 255, 255));
				lblEmbellecer.setBounds(100, 300, 164, 28);
			}
		});
		
			
	}
}
