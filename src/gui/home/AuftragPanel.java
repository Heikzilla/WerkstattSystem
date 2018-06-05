package gui.home;

import controller.c_auftrag;

import javax.swing.*;

class AuftragPanel extends JPanel {

    private JTable list;

    AuftragPanel(){

        initComp();

    }


    private void initComp(){

        list = new JTable(c_auftrag.getInstance().getAuftragListAsTable());
        //list.setDefaultRenderer(null, new AuftragListRender());
        add(new JScrollPane(list));

    }

}
