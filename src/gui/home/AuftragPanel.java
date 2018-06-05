package gui.home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.c_auftrag;

class AuftragPanel extends JPanel {

    private JTable list;

    AuftragPanel(int width, int height){

    	setPreferredSize(new Dimension(width,height));
        initComp();
        setBackground(Color.RED);
        //setLayout(new BorderLayout());
    }


    private void initComp(){

        list = new JTable(c_auftrag.getInstance().getAuftragListAsTable());
        list.setSize(getPreferredSize());
        //list.setDefaultRenderer(null, new AuftragListRender());
        add(new JScrollPane(list));

    }

}
