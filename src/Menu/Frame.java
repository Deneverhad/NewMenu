package Menu;

import Menu.Add.AddClient;
import Menu.Add.AddCompany;
import Menu.Add.AddEmploy;
import Menu.Add.AddProduct;
import Menu.Change.*;
import Menu.Find.*;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Frame  {
	
	private final JFrame frame = new JFrame();
	private final JPanel[][] panels = new JPanel[17][13];

	public Frame() throws InterruptedException {
		addMenu();
		frame.setVisible(true);
		frame.setSize(600,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start();
	}
	private void start() throws InterruptedException {
		System.out.println(Guide.getInstance().Id);
		while(true) {
			TimeUnit.SECONDS.sleep(1);
			if (Guide.getInstance().changer) {
				clearFrame();
				if(Guide.getInstance().x==0 && Guide.getInstance().y==0) {
					frame.setVisible(false);
					new Logging();
					Guide.getInstance().changer=true;
					frame.setVisible(true);
				}
				else {
					Guide.getInstance().changer = false;
					frame.add(panels[Guide.getInstance().x][Guide.getInstance().y]);
				}
				frame.revalidate();
			}
		}
	}
	private void addMenu()  {
		
		panels[0][1]= new MainMenu();
		panels[0][2]= new NewInvoice();
		panels[0][3]= new FindMenu();
		panels[0][4]= new AddMenu();
		panels[0][5]= new DeleteMenu();
		panels[0][6]= new ChangeMenu();
		//panels[0][7]= new Backup();
		
		panels[3][0]= new FindInvoice();
		panels[3][1]= new FindProduct();
		panels[3][2]= new FindClient();
		panels[3][3]= new FindEmploy();
		panels[3][4]= new FindOurCompany();
		
		panels[4][0]= new AddProduct();
		panels[4][1]= new AddClient();
		panels[4][2]= new AddEmploy();
		panels[4][3]= new AddCompany();
		
		panels[6][0]= new ChangeInvoice();
		panels[6][1]= new ChangeProduct();
		panels[6][2]= new ChangeClient();
		panels[6][3]= new ChangeEmploy();
		panels[6][4]= new ChangeOurCompany();
		
		
	}
	public void clearFrame() {
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.repaint();
	}
	
	public void visible(boolean type) {
		frame.setVisible(type);
	}
}
