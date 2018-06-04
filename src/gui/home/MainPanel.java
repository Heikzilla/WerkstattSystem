package gui.home;

import javax.swing.*;

public class MainPanel extends JPanel {



    public MainPanel(){

        setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
        add(new AuftragPanel());

    }


}
