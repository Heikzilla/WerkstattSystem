package gui.home;

import controller.c_auftrag;

import javax.swing.*;

class AuftragPanel extends JPanel {

    private JList<Object> list;

    AuftragPanel(){

        initComp();

    }


    private void initComp(){

        list = new JList<>(c_auftrag.getInstance().getAuftragList().toArray());
        list.setCellRenderer(new AuftragListRender());
        add(new JScrollPane(list));

    }

}
