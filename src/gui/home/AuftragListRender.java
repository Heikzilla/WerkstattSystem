package gui.home;

import general.Auftrag;
import gui.Colorscheme;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;

public class AuftragListRender extends JPanel implements ListCellRenderer<Object> {

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

    public AuftragListRender(){};

    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        return new AuftragListRender((Auftrag) value,isSelected);
    }



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






}
