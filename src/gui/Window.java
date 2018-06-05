package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Window extends JFrame {


    private static Window INSTANCE;
    private static int HEIGHT;
    private static int WIDTH;
    private static int SCREEN_WIDTH;
    private static int SCREEN_HEIGHT;
    private static Point LOCATION;


    private Window(){

    	initScreenVars();
        setWindowSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        centerWindow();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //pack();

    }

    public static Window getInstance(){

        if(INSTANCE == null){

            INSTANCE = new Window();

        }

        return INSTANCE;

    }

    public void setWindowSize(int width, int height){

    	
    	
        WIDTH = width;
        HEIGHT = height;

        setSize(new Dimension(WIDTH,HEIGHT));

    }


    public void centerWindow(){

        
    	initScreenVars();

        LOCATION = new Point(SCREEN_WIDTH/2-WIDTH/2,SCREEN_HEIGHT/2-HEIGHT/2);
        setLocation(LOCATION);

    }


    private void initScreenVars(){

    	GraphicsEnvironment defTK = GraphicsEnvironment.getLocalGraphicsEnvironment();
        SCREEN_WIDTH = defTK.getMaximumWindowBounds().width;
        SCREEN_HEIGHT = defTK.getMaximumWindowBounds().height;


    }

    public void toggleVisible(){

        setVisible(!isVisible());

    }


    public void loadView(JPanel pane){

        getContentPane().removeAll();
        getContentPane().add(pane, BorderLayout.LINE_START);

    }


}
