package gui.home;

import javax.swing.*;

public class MainPanel extends JPanel {



    public MainPanel(){

        setLayout(new BoxLayout(this,2));
        add(new AuftragPanel());

    }


}
