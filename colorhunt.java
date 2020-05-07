import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class colorhunt extends WindowAdapter implements ActionListener
{
	JFrame intro=new JFrame ("Color Hunt");
	Random r=new Random ();
	JFrame f=new JFrame ("Color Hunt");
	Button b[]=new Button[9];
	Button start=new Button ("Start");
	int score=0;
	//String sco = Integer.toString(score);
	JLabel l=new JLabel (""),sc=new JLabel ("Score : "+score);
	int ran[]=new int[7],mv=-1;
	int delay=700;
	Color c,tc;
	String lose="Opps, You made lost the game. Better luck next time...";
	public void seq ()
	{
		//b[4].setVisible (false);
		for (int i=0;i<7;i++)
		{
			c=b[ran[i]].getBackground ();
			try
			{
			b[ran[i]].setBackground(Color.white);
			Thread.sleep (100);
			b[ran[i]].setBackground(Color.black);
			Thread.sleep (delay-100);
			}
			catch (Exception e) {}
			b[ran[i]].setBackground (c);
		}
	}
	
	public void win ()
	{
		if (mv==6)
		{
			l.setText ("Hurray, You made it...");
			mv=-1;
			score+=50;
			sc.setText ("Score : "+score);
			//b[4].setEnabled (true);
		}
	}
	
	colorhunt ()
	{
		//Graphics g = f.getGraphics();
		//Frame 1 background
		JLabel background=new JLabel(new ImageIcon("background.jpg"));
		background.setBounds(0,0,1366,768);
		background.setLayout(new FlowLayout());
		
		
		//Frame 2 background
		JLabel background2=new JLabel(new ImageIcon("background.jpg"));
		background2.setBounds(0,0,1366,768);
		background2.setLayout(new FlowLayout());
		
		
		start.setBounds (640,500,100,50);
		intro.add (start);
		Font fo = new Font("TimesRoman", Font.BOLD, 72);
		JLabel il=new JLabel ("Color Hunt");
		il.setFont (fo);
		il.setBounds (500,200,600,100);
		il.setForeground (Color.white);
		intro.add (il);
		for (int i=0;i<9;i++) 
		{
			if (i==4) {}
			else
			{
				b[i]=new Button ();
				f.add (b[i]);
				b[i].addActionListener (this);
			}
		}
		
		b[4]=new Button ("Play");
		b[4].setBounds (600,500,100,35);
		b[4].addActionListener (this);
		f.add (b[4]);
		
      l.setForeground (Color.white);
		l.setBounds (550,550,300,20);
		f.add (l);
		
		b[0].setBounds(550,250,100,100);
		b[1].setBounds(650,250,100,100);
		b[2].setBounds(550,350,100,100);
		b[3].setBounds(650,350,100,100);
		
		c=new Color(255,0,0);
		b[0].setBackground (c);
		//c=b[0].getBackground ();
		c=new Color(0,0,255);
		b[1].setBackground (c);
		c=new Color(0,255,51);
		b[2].setBackground (c);
		c=new Color(255,255,0);
		b[3].setBackground (c);
		//f.setSize (1000,500);
		
		sc.setForeground (Color.white);
		sc.setBounds (900,100,100,20);
		f.add (sc);
		
		start.addActionListener (this);
		
		f.add(background2);
		f.setLayout (null);
		f.setVisible (true);
		f.setExtendedState(f.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		intro.add(background);
		intro.setLayout (null);
		intro.setVisible (true);
		intro.setExtendedState(intro.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	public void actionPerformed (ActionEvent e)
	{
		if (e.getSource ()==b[4]) //play button
		{
			for (int i=0;i<7;i++)
			{
				ran[i]=r.nextInt ()%4;
				if (ran[i]<0) ran[i]=-ran[i];
				System.out.print (ran[i]+" ");
				
			}
			System.out.print ("\n");
			seq ();
			//b[4].setEnabled (false);
			//b[4].setDisabledIcon(button.getIcon());
			l.setText ("");
			mv=-1;
		}
		
		if (e.getSource ()==b[0])
		{
			if (ran[++mv]!=0) {l.setText (lose);mv=-1;}
			win ();
		}
		if (e.getSource ()==b[1])
		{
			if (ran[++mv]!=1) {l.setText (lose);mv=-1;}
			win ();
		}
		if (e.getSource ()==b[2])
		{
			if (ran[++mv]!=2) {l.setText (lose);mv=-1;}
			win ();
		}
		if (e.getSource ()==b[3])
		{
			if (ran[++mv]!=3) {l.setText (lose);mv=-1;}
			win ();
		}
		
		if (e.getSource ()==start)
		{
			intro.dispose ();
		}
		
	}
	/*
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
	*/
	public static void main (String args[])
	{
		new colorhunt ();
	}
}