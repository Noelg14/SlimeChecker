import java.util.Random; 
import javax.swing.*;
import javax.swing.JOptionPane;
import java.lang.*;
import java.awt.event.*;
import java.awt.Color;

public class slime{ 
	public static void gui()
	{ 
	
		JFrame f=new JFrame("Slime Chunk Checker");
		final JTextField tf=new JTextField();  
		final JTextField tf1=new JTextField();  
		final JTextField tf2=new JTextField();  
		JLabel ans,t1,t2,t3;
		ans=new JLabel();
		t1=new JLabel();
		t2=new JLabel();
		t3=new JLabel();
		
		t1.setText("Seed");
		t2.setText("Enter X Co-ord:");
		t3.setText("Enter Z Co-ord:");

		
		tf.setBounds(150,50, 150,20);  t1.setBounds(50,50,150,20);
		tf1.setBounds(150,80, 150,20);  t2.setBounds(50,80,150,20);
		tf2.setBounds(150,110, 150,20); t3.setBounds(50,110,150,20);
		ans.setBounds(110,225,150,20);
		
		JButton b=new JButton("Check");//creating instance of JButton  
		JButton reset=new JButton("Reset");
		 
		b.setBounds(100,175,75, 40);//x axis, y axis, width, height  
		reset.setBounds(180,175,75, 40);//x axis, y axis, width, height  
          
		f.add(b);f.add(reset);f.add(tf);f.add(tf1); f.add(tf2); f.add(ans);
		f.add(t1);f.add(t2);f.add(t3);
		
		//adding button in JFrame  
          
		f.setSize(400,300);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
  
		b.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e)
			{  
				try{
					String f=tf.getText();
					String c=tf1.getText();
					String d=tf2.getText();
					long s = Long.parseLong(f);
					int x = Integer.parseInt(c);
					int z = Integer.parseInt(d);
					b.setText("Checking...");  
					
					String res = String.valueOf(check(s,x,z));
					if ( check(s,x,z) == true){
						ans.setForeground(Color.GREEN);
					}
					else{
						ans.setForeground(Color.RED);
					}
					
					ans.setText("Is a slime chunk:"+" "+res);
					b.setText("Check");  
			}
				catch (Exception g)
				{
					String error="OOPSIE WOOPSIE!!\nUwu We make a fucky wucky!! A wittle fucko boingo! \nThe code monkeys at our headquarters are working VEWY HAWD to fix this!";
					JOptionPane.showMessageDialog(new JFrame(),error,"OOPSIE WOOPSIE",JOptionPane.ERROR_MESSAGE);
					tf1.setText("");
					tf2.setText("");
				}
			}  
		}); 
		
		reset.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e)
			{  
				tf.setText("");
				tf1.setText("");
				tf2.setText("");
			}
		}); 
	}
	
	public static boolean check(long s,int x,int z){
		// the seed from /seed as a 64bit long literal
		long seed= s ;
		//long seed = new Long(s); //converts from int to Long. Some data loss may occur
		int xPosition = (int)Math.floor((x/16));
		int zPosition = (int) Math.floor((z/16)); 
			
		Random rnd = new Random(
				seed +
				(int) (xPosition * xPosition * 0x4c1906) +
				(int) (xPosition * 0x5ac0db) +
				(int) (zPosition * zPosition) * 0x4307a7L +
				(int) (zPosition * 0x5f24f) ^ 0x3ad8025fL
			);
			boolean tf = (rnd.nextInt(10) == 0);
			return tf;
	}


    public static void main(String args[]) 
    { 
		try{
			gui();	
		}
   
		catch (Exception e)
		{
			String error="OOPSIE WOOPSIE!! Uwu We make a fucky wucky!! A wittle fucko boingo! The code monkeys at our headquarters are working VEWY HAWD to fix this!";
			JOptionPane.showMessageDialog(new JFrame(),error);
		}
	}


}