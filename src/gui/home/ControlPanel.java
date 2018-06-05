package gui.home;

import gui.Colorscheme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ControlPanel extends JPanel{
	
	private JLabel l_header;
	private JButton b_newKunde;
	private JButton b_newKfz;
	private JButton b_newAuftrag;
	private JButton b_setDone;
	
	public ControlPanel(){
		
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
	
	
	private void initComp(){
		
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
		
	}
	
	
	private void addActionListeners(){
		//TBD
	}
	
	
	private JPanel generateControlGroup(){
		
		JPanel ret = new JPanel();
		
		ret.setBackground(Colorscheme.controlGray);
		ret.setLayout(new GridLayout(4,0));
		
		
		return ret;
		
	}
	
	private Border generateButtonBorder(){
		
		Border ret = new JButton().getBorder();
		
		
		
		return ret;
		
	}
	
	

}
