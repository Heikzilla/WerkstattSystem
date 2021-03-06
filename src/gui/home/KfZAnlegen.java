package gui.home;

import general.Kunde;
import gui.Colorscheme;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFldMarke;
	private JTextField txtFldModell;
	private JTextField txtFldKennzeichen;
	private static KfZAnlegen frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new KfZAnlegen();
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 252, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Colorscheme.controlLightGray);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMarke = new JLabel("Marke:");
		lblMarke.setBounds(10, 11, 68, 14);
		contentPane.add(lblMarke);

		JLabel lblModell = new JLabel("Modell:");
		lblModell.setBounds(10, 36, 68, 14);
		contentPane.add(lblModell);

		JLabel lblKennzeichen = new JLabel("Kennzeichen:");
		lblKennzeichen.setBounds(10, 61, 86, 14);
		contentPane.add(lblKennzeichen);

		txtFldMarke = new JTextField();
		txtFldMarke.setBounds(140, 8, 86, 20);
		contentPane.add(txtFldMarke);
		txtFldMarke.setColumns(10);

		txtFldModell = new JTextField();
		txtFldModell.setBounds(140, 33, 86, 20);
		contentPane.add(txtFldModell);
		txtFldModell.setColumns(10);

		txtFldKennzeichen = new JTextField();
		txtFldKennzeichen.setText("");
		txtFldKennzeichen.setBounds(140, 58, 86, 20);
		contentPane.add(txtFldKennzeichen);
		txtFldKennzeichen.setColumns(10);

		JLabel lblKunde = new JLabel("Kunde:");
		lblKunde.setBounds(10, 103, 68, 14);
		contentPane.add(lblKunde);

		JComboBox<Kunde> cmbBxKunde = new JComboBox<>();

		for (Kunde k : c_kunde.getInstance().getKundeList("")) {
			cmbBxKunde.addItem(k);
		}

		cmbBxKunde.setMaximumRowCount(24);
		cmbBxKunde.setBounds(87, 100, 139, 20);
		contentPane.add(cmbBxKunde);

		JButton btnKfzAnlegen = new JButton("KfZ anlegen");
		btnKfzAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				general.Kfz neuesKfz = new general.Kfz();
				neuesKfz.setMarke(txtFldMarke.getText());
				neuesKfz.setModell(txtFldModell.getText());
				neuesKfz.setKennzeichen(txtFldKennzeichen.getText());
				neuesKfz.setKunde_ID(((Kunde) cmbBxKunde.getSelectedItem())
						.getKunde_ID());
				c_kfz.getInstance().addKfzToDB(neuesKfz);
				frame.dispose();
			}
		});
		btnKfzAnlegen.setBounds(81, 131, 110, 34);
		contentPane.add(btnKfzAnlegen);
	}
}
