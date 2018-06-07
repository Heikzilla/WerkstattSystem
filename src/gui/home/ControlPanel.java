package gui.home;

import general.Auftrag;
import gui.Colorscheme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.c_auftrag;

public class ControlPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private JLabel l_header;
	private JButton b_newKunde;
	private JButton b_newKfz;
	private JButton b_newAuftrag;
	private static JButton b_setDone;

	public ControlPanel() {

		setBackground(Colorscheme.controlGray);
		initComp();
		JPanel topGroup = generateControlGroup();
		topGroup.add(l_header);
		topGroup.add(b_newKunde);
		topGroup.add(b_newKfz);
		topGroup.add(b_newAuftrag);

		setLayout(new BorderLayout());

		add(topGroup, BorderLayout.NORTH);
		add(b_setDone, BorderLayout.SOUTH);

	}

	private void initComp() {

		l_header = new JLabel("Werkstattverwaltung");
		l_header.setForeground(Color.WHITE);
		l_header.setHorizontalAlignment(JLabel.CENTER);

		
		Border buttonBorder = generateButtonBorder();

		b_newKunde = new JButton("Kunde anlegen");
		b_newKunde.setForeground(Color.WHITE);
		b_newKunde.setBackground(Colorscheme.controlLightGray);
		b_newKunde.setBorder(buttonBorder);
		

		b_newKfz = new JButton("Kfz anlegen");
		b_newKfz.setForeground(Color.WHITE);
		b_newKfz.setBackground(Colorscheme.controlLightGray);
		b_newKfz.setBorder(buttonBorder);

		b_newAuftrag = new JButton("Auftrag anlegen");
		b_newAuftrag.setForeground(Color.WHITE);
		b_newAuftrag.setBackground(Colorscheme.controlLightGray);
		b_newAuftrag.setBorder(buttonBorder);

		b_setDone = new JButton("Als erledigt markieren");
		b_setDone.setForeground(Color.WHITE);
		b_setDone.setBackground(Colorscheme.controlLightGray);
		b_setDone.setBorder(buttonBorder);
		b_setDone.setEnabled(false);

		addActionListeners();

	}

	private void addActionListeners() {
		b_newKunde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				KundenAnlegen.main(new String[0]);

			}
		});
		b_newAuftrag.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AuftragAnlegen.main(new String[0]);

			}
		});
		b_newKfz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				KfZAnlegen.main(new String[0]);

			}
		});
		b_setDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = AuftragPanel.getTable().getSelectedRow();
				long auftrag_ID = (long) AuftragPanel.getTable().getValueAt(row,
						0);
				String filter = " WHERE Auftrag_ID = "
						+ String.valueOf(auftrag_ID);
				Auftrag selectedAuftrag = c_auftrag.getInstance()
						.getAuftragList(filter).get(0);
				c_auftrag.getInstance().setAsErledigt(selectedAuftrag);
				AuftragPanel.update();
			}
		});

	}

	private JPanel generateControlGroup() {

		JPanel ret = new JPanel();

		ret.setBackground(Colorscheme.controlGray);
		ret.setLayout(new GridLayout(4, 0));

		return ret;

	}

	private Border generateButtonBorder() {

		Border ret = new JButton().getBorder();

		return ret;

	}

	public static void enableDoneButton() {

		b_setDone.setEnabled(true);

	}

}
