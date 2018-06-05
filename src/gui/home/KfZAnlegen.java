package gui.home;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class KfZAnlegen extends JFrame {

	private JPanel contentPane;
	private JTextField txtFldMarke;
	private JTextField txtFldModell;
	private JTextField txtFldKennzeichen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KfZAnlegen frame = new KfZAnlegen();
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
	public KfZAnlegen() {
		setTitle("KfZ anlegen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 217, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMarke = new JLabel("Marke:");
		lblMarke.setBounds(10, 11, 46, 14);
		contentPane.add(lblMarke);
		
		JLabel lblModell = new JLabel("Modell:");
		lblModell.setBounds(10, 36, 46, 14);
		contentPane.add(lblModell);
		
		JLabel lblKennzeichen = new JLabel("Kennzeichen:");
		lblKennzeichen.setBounds(10, 61, 68, 14);
		contentPane.add(lblKennzeichen);
		
		txtFldMarke = new JTextField();
		txtFldMarke.setBounds(81, 8, 86, 20);
		contentPane.add(txtFldMarke);
		txtFldMarke.setColumns(10);
		
		txtFldModell = new JTextField();
		txtFldModell.setBounds(81, 33, 86, 20);
		contentPane.add(txtFldModell);
		txtFldModell.setColumns(10);
		
		txtFldKennzeichen = new JTextField();
		txtFldKennzeichen.setText("");
		txtFldKennzeichen.setBounds(81, 58, 86, 20);
		contentPane.add(txtFldKennzeichen);
		txtFldKennzeichen.setColumns(10);
		
		JLabel lblKunde = new JLabel("Kunde:");
		lblKunde.setBounds(10, 103, 46, 14);
		contentPane.add(lblKunde);
		
		JComboBox cmbBxKunde = new JComboBox();
		cmbBxKunde.setMaximumRowCount(24);
		cmbBxKunde.setBounds(139, 100, 28, 20);
		contentPane.add(cmbBxKunde);
		
		JButton btnKfzAnlegen = new JButton("KfZ anlegen");
		btnKfzAnlegen.setBounds(81, 131, 89, 23);
		contentPane.add(btnKfzAnlegen);
	}
}
