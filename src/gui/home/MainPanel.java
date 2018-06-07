package gui.home;

import gui.Window;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;

	public MainPanel() {

		int width = Window.getInstance().getPreferredSize().width;
		int height = Window.getInstance().getPreferredSize().height;

		width -= Window.getInstance().getInsets().left;
		width -= Window.getInstance().getInsets().right;
		height -= Window.getInstance().getInsets().top;
		height -= Window.getInstance().getInsets().bottom;

		setPreferredSize(new Dimension(width, height));
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 2.0 / 5.0;
		c.weighty = 1.0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.EAST;
		add(new ControlPanel(), c);

		c.gridx = 1;
		c.weightx = 1.0;
		c.gridwidth = 4;

				
		add(new AuftragPanel(width * 3 / 5, height * 9 / 10), c);
		revalidate();
		
	}

}
