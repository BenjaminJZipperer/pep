package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import info.clearthought.layout.TableLayout;

public class LogFenster extends JFrame implements ActionListener{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private static JLabel lbl1 = new JLabel("  Username:");
private static JLabel lbl2 = new JLabel("  Pssswort:");
private static JTextField tf1 = new JTextField();
private static JTextField tf2 = new JTextField();
private static JButton save = new JButton(" Sign-In");
private static JButton log  = new JButton(" Log-In");
private static JPanel panel  = new JPanel();int counter = 0;
public LogFenster()
{
	// handle Layout
	
    this.setLayout(new BorderLayout());

    double size[][] =
        {{0.41, 0.6 },
         {33, 33,30}};
    // set Table Layout with parameter size (2-dimensional)
    panel.setLayout (new TableLayout(size));
	System.out.println("   Starte Anwendungsfenster in Queue");
	this.setLocation(300,120);
	this.setSize(290, 230);
	this.setTitle("   Anmelden");
	
	panel.add(lbl1,"0,0");
	panel.add(lbl2,"0,1");
	panel.add(tf1,"1,0");
	panel.add(tf2,"1,1");
	panel.add(save,"1,0");
	
	save.addActionListener(this);
    log.addActionListener(this);
    JPanel south = new JPanel();
    south.add(save,BorderLayout.SOUTH);
    south.add(log,BorderLayout.SOUTH);
    this.add(panel,BorderLayout.CENTER);
    this.add(south,BorderLayout.SOUTH);
}
@Override
public void actionPerformed(ActionEvent arg0) 
{

	System.out.println("catch Mouse Event (LM)");
	if(arg0.getSource()==save)
	{
		if(!(tf1.getText().equals("")) && !(tf2.getText().equals("")))
		{
		Hauptapp.benutzer[counter] = new User(tf1.getText(),tf2.getText());
	    counter++;
		Repository.fillRepository();
		Repository.saveRepository();
		this.dispose();
		
		}else
		{
			if(tf1.getText().equals(""))
			{
				tf1.setBackground(Color.RED);
			}
			if(tf2.getText().equals(""))
			{
				tf2.setBackground(Color.RED);
			}
			
			Object[] options = { "OK", "CANCEL" };
			JOptionPane.showOptionDialog(null, "Es sind leere Felder oder ein leeres Feld vorhanden.", "Warnung",
			JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			null, options, options[0]);
			tf1.setBackground(Color.WHITE);
			tf2.setBackground(Color.WHITE);
		}
		
	}
	else
	{
		Repository.retrieveFromRepository(tf1.getText(),tf2.getText());
	}
}


}
