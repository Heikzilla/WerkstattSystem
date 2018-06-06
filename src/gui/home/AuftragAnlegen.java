package gui.home;

import general.Kfz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.c_auftrag;
import controller.c_kfz;

public class AuftragAnlegen extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static AuftragAnlegen frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AuftragAnlegen();

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 251, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblZuErledigendeArbeiten = new JLabel("Zu erledigende Arbeiten:");
		lblZuErledigendeArbeiten.setBounds(10, 11, 138, 14);
		contentPane.add(lblZuErledigendeArbeiten);

		JTextArea txtAreaArbeiten = new JTextArea();
		txtAreaArbeiten.setBounds(10, 36, 211, 125);
		contentPane.add(txtAreaArbeiten);

		JComboBox<Kfz> cmbBxKennzeichen = new JComboBox<Kfz>();

		for (Kfz k : c_kfz.getInstance().getKfzList("")) {
			cmbBxKennzeichen.addItem(k);
		}
		cmbBxKennzeichen.setBounds(100, 172, 121, 20);
		contentPane.add(cmbBxKennzeichen);

		JButton btnAuftragAnlegen = new JButton("Auftrag anlegen");
		btnAuftragAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				general.Auftrag neuerAuftrag = new general.Auftrag();
				neuerAuftrag.setArbeiten(txtAreaArbeiten.getText());
				neuerAuftrag.setKfz_ID(((Kfz) cmbBxKennzeichen
						.getSelectedItem()).getKfz_ID());
				c_auftrag.getInstance().addAuftragToDB(neuerAuftrag);
				AuftragPanel.update();
				frame.dispose();

			}
		});
		btnAuftragAnlegen.setBounds(69, 203, 152, 23);
		contentPane.add(btnAuftragAnlegen);

		JLabel lblKennzeichen = new JLabel("Kennzeichen:");
		lblKennzeichen.setBounds(10, 175, 91, 14);
		contentPane.add(lblKennzeichen);
	}
}
