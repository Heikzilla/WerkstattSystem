package gui.home;

import general.Auftrag;
import gui.Colorscheme;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.AbstractBorder;
import javax.swing.table.TableCellRenderer;

public class AuftragListRender extends JPanel implements TableCellRenderer {

    private JLabel l_Nr;
    private JLabel l_Name;

    private AuftragListRender(Auftrag value, boolean isSelected){

        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        setLayout(layout);


        l_Nr = new JLabel(String.valueOf(value.getAuftrag_ID()));
        l_Name = new JLabel(value.getArbeiten());
        Color c_BG = isSelected ? Colorscheme.lightgray : Color.WHITE;

        setBackground(c_BG);
        setBorder(getCellBorder(value.isErledigt()));

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(l_Nr)
                                .addComponent(l_Name))
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(l_Nr)
                        .addComponent(l_Name)
        );

    }

    AuftragListRender(){}

    



    private AbstractBorder getCellBorder(boolean isDone) {

        AbstractBorder border = new AbstractBorder() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                super.paintBorder(c, g, x, y, width, height);

                Graphics2D g2d = (Graphics2D) g;

                g2d.setStroke(new BasicStroke(3));
                g2d.setPaint(Colorscheme.gray);
                g2d.drawLine(0,height,width,height);


                g2d.setStroke(new BasicStroke(5));
                Color c_BG = isDone ? Color.GREEN : Color.ORANGE;
                g2d.setPaint(c_BG);
                g2d.drawLine(0,0,0,height);

            }
        };

        return border;
    }

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

		return new AuftragListRender((Auftrag) value,isSelected);
	}






}
