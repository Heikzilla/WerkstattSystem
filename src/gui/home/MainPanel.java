package gui.home;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {



    public MainPanel(int width, int height){

    	setPreferredSize(new Dimension(width,height));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1/5;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.EAST;
        add(new ControlPanel(),c);
        
        c.gridx = 1;
        c.weightx = 5/5;
        
        
        add(new AuftragPanel(width, height),c);

    }


}
