package gui.home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import controller.c_auftrag;

class AuftragPanel extends JPanel {

    private JTable list;
    private int width;
    private int height;

    AuftragPanel(int width, int height){

    	this.width = width;
    	this.height = height;
    	setPreferredSize(new Dimension(width,height));
        initComp();
        setBackground(Color.RED);
        
        
        
        
    }


    private void initComp(){

        list = new JTable(c_auftrag.getInstance().getAuftragListAsTable());
        
        
        add(new JScrollPane(list),BorderLayout.EAST);
        list.setPreferredScrollableViewportSize(new Dimension(width,height));
        list.setFillsViewportHeight(true);
        
        

    }

}
