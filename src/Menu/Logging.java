package Menu;

import javax.swing.*;
import java.awt.*;

public class Logging extends JFrame {
	
	JPanel jPanel = new JPanel(new GridLayout(2, 1));
	JLabel labelLogin = new JLabel("Login: ");
	JLabel labelPassword = new JLabel("Haslo: ");
	JTextField login = new JTextField();
	JPasswordField password = new JPasswordField();
	
	int ID=2;
	String userName,pass;
	
	public Logging(){
		
		jPanel.add(labelLogin);
		jPanel.add(login);
		jPanel.add(labelPassword);
		jPanel.add(password);
		JOptionPane.showMessageDialog(this, jPanel, "Logowanie", JOptionPane.PLAIN_MESSAGE );
		Checklogin();
	}
	
	/**
	 * pracownik = 1
	 * kiero = 2
	 * admin = 3
	 */
	private void Checklogin(){
		userName = login.getText();
		pass = String.valueOf(password.getPassword());
		//ask data base
		//WHILE (METODA DO BAZY DANCYH  == false ( W SENSIE dobre dane)
		// {
		//JOptionPane.showMessageDialog(this, jPanel, "Logowanie", JOptionPane.PLAIN_MESSAGE );
		//userName = login.getText();
		//pass = password.getText();
		//}
		System.out.println(userName+" "+pass);
		Guide.getInstance().EmployID="USA";
		Guide.getInstance().Id=this.ID;
		Guide.getInstance().changeValuves(0,1);
		Guide.getInstance().vision=true;
	}
}
