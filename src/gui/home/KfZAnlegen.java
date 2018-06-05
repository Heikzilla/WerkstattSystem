package gui.home;

import general.Kunde;
import gui.Colorscheme;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.c_kfz;
import controller.c_kunde;

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
		contentPane.setBackground(Colorscheme.controlLightGray);
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
		
		
		
		
		JComboBox<Kunde> cmbBxKunde = new JComboBox<>();
		
		for(Kunde k : c_kunde.getInstance().getKundeList()){
			cmbBxKunde.addItem(k);
		}
		
		
		cmbBxKunde.setMaximumRowCount(24);
		cmbBxKunde.setBounds(52, 100, 139, 20);
		contentPane.add(cmbBxKunde);
		
		JButton btnKfzAnlegen = new JButton("KfZ anlegen");
		btnKfzAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				general.Kfz neuesKfz = new general.Kfz();
				neuesKfz.setMarke(txtFldMarke.getText());
				neuesKfz.setModell(txtFldModell.getText());
				neuesKfz.setKennzeichen(txtFldKennzeichen.getText());
				neuesKfz.setKunde_ID(((Kunde)cmbBxKunde.getSelectedItem()).getKunde_ID());
				c_kfz.getInstance().addKfzToDB(neuesKfz);
			}
		});
		btnKfzAnlegen.setBounds(81, 131, 89, 23);
		contentPane.add(btnKfzAnlegen);
	}
}
