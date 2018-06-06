package gui.home;

import gui.Colorscheme;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.c_auftrag;

class AuftragPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private static JTable list;
	private int width;
	private int height;
	private static DefaultTableModel tblModel;

	AuftragPanel(int width, int height) {

		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));
		setMinimumSize(getPreferredSize());
		initComp();
		setLayout(new GridLayout(1, 1));
		

	}

	private void initComp() {

		tblModel = c_auftrag.getInstance().getAuftragListAsTable();

		list = new JTable(tblModel) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		list.getTableHeader().setOpaque(false);
		list.getTableHeader().setBackground(Color.WHITE);
		list.getTableHeader().setFont(new Font("default", Font.BOLD, 12));
		list.getTableHeader().setForeground(Colorscheme.controlGray);
		list.setForeground(Colorscheme.controlLightGray);
		list.setBorder(BorderFactory.createEmptyBorder());
		list.getTableHeader().setBorder(list.getBorder());
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		addSelectionListener();

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBorder(list.getBorder());
		scrollPane.setMinimumSize(getPreferredSize());
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		add(scrollPane);

		list.setPreferredScrollableViewportSize(new Dimension(width, height));
		list.setFillsViewportHeight(true);

	}

	public static JTable getTable() {
		return list;
	}

	public static void update() {

		tblModel = c_auftrag.getInstance().getAuftragListAsTable();
		list.setModel(tblModel);
		tblModel.fireTableDataChanged();

	}

	public void addSelectionListener() {

		list.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {

						if (list.getSelectedRow() > -1) {
							ControlPanel.enableDoneButton();
						}

					}
				});
	}

}
