package gui.home;

import gui.Colorscheme;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.c_kunde;

public class KundenAnlegen extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private JTextField textField;
	private JTextField txtFldVorname;
	private JTextField txtFldNachname;
	private JTextField txtFldOrt;
	private JTextField txtFldStrasse;
	private JTextField txtFldHausnummer;
	private JTextField txtFldPLZ;
	private static KundenAnlegen frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new KundenAnlegen();
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
	public KundenAnlegen() {
		setTitle("Kunden anlegen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 279, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Colorscheme.controlLightGray);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setBounds(10, 11, 58, 14);
		contentPane.add(lblVorname);

		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setBounds(10, 36, 68, 14);
		contentPane.add(lblNachname);

		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setBounds(10, 61, 58, 14);
		contentPane.add(lblOrt);

		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setBounds(10, 86, 58, 14);
		contentPane.add(lblPlz);

		JLabel lblStrasse = new JLabel("Strasse:");
		lblStrasse.setBounds(10, 111, 58, 14);
		contentPane.add(lblStrasse);

		JLabel lblHausnummer = new JLabel("Hausnummer:");
		lblHausnummer.setBounds(10, 136, 86, 14);
		contentPane.add(lblHausnummer);

		txtFldVorname = new JTextField();
		txtFldVorname.setBounds(138, 8, 86, 20);
		contentPane.add(txtFldVorname);
		txtFldVorname.setColumns(10);

		txtFldNachname = new JTextField();
		txtFldNachname.setBounds(138, 33, 86, 20);
		contentPane.add(txtFldNachname);
		txtFldNachname.setColumns(10);

		txtFldOrt = new JTextField();
		txtFldOrt.setBounds(138, 58, 86, 20);
		contentPane.add(txtFldOrt);
		txtFldOrt.setColumns(10);

		txtFldPLZ = new JTextField();
		txtFldPLZ.setColumns(10);
		txtFldPLZ.setBounds(138, 83, 86, 20);
		contentPane.add(txtFldPLZ);

		txtFldStrasse = new JTextField();
		txtFldStrasse.setBounds(138, 108, 86, 20);
		contentPane.add(txtFldStrasse);
		txtFldStrasse.setColumns(10);

		txtFldHausnummer = new JTextField();
		txtFldHausnummer.setBounds(138, 133, 86, 20);
		contentPane.add(txtFldHausnummer);
		txtFldHausnummer.setColumns(10);

		JButton btnKundeAnlegen = new JButton("Kunde anlegen");
		btnKundeAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				general.Kunde neuerKunde = new general.Kunde();
				neuerKunde.setVorname(txtFldVorname.getText());
				neuerKunde.setNachname(txtFldNachname.getText());
				neuerKunde.setOrt(txtFldOrt.getText());
				neuerKunde.setPlz(Integer.parseInt(txtFldPLZ.getText()));
				neuerKunde.setStrasse(txtFldVorname.getText());
				neuerKunde.setHausnummer(txtFldHausnummer.getText());

				// neuerKunde in Datenbank speichern

				c_kunde.getInstance().addKundeToDB(neuerKunde);
				frame.dispose();
			}
		});
		btnKundeAnlegen.setBounds(99, 164, 125, 23);
		contentPane.add(btnKundeAnlegen);

	}
}
