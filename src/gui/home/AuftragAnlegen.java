package gui.home;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuftragAnlegen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuftragAnlegen frame = new AuftragAnlegen();
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
	public AuftragAnlegen() {
		setTitle("Auftrag anlegen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 251, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZuErledigendeArbeiten = new JLabel("Zu erledigende Arbeiten:");
		lblZuErledigendeArbeiten.setBounds(10, 11, 119, 14);
		contentPane.add(lblZuErledigendeArbeiten);
		
		JTextArea txtAreaArbeiten = new JTextArea();
		txtAreaArbeiten.setBounds(10, 36, 211, 125);
		contentPane.add(txtAreaArbeiten);
		
		JComboBox cmbBxKennzeichen = new JComboBox();
		cmbBxKennzeichen.setBounds(193, 172, 28, 20);
		contentPane.add(cmbBxKennzeichen);
		
		JButton btnAuftragAnlegen = new JButton("Auftrag anlegen");
		btnAuftragAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//TODO: Funktionalität belegen
			}
		});
		btnAuftragAnlegen.setBounds(110, 203, 111, 23);
		contentPane.add(btnAuftragAnlegen);
		
		JLabel lblKennzeichen = new JLabel("Kennzeichen:");
		lblKennzeichen.setBounds(35, 175, 74, 14);
		contentPane.add(lblKennzeichen);
	}
}
