package gui.home;

import controller.c_auftrag;
import general.Auftrag;

import javax.swing.*;
import java.awt.*;

public class AuftragPanel extends JPanel {

    private JList<Object> list;

    public AuftragPanel(){

        initComp();

    }


    private void initComp(){

        list = new JList<>(c_auftrag.getInstance().getAuftragList().toArray());
        list.setCellRenderer(new AuftragListRender());
        add(new JScrollPane(list));

    }

}
