package Menu.Add;
import Menu.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmploy extends JPanel implements ActionListener {
	private enum Actions{
		Add, Back
	}

	JButton Add = new JButton("Dodaj");
	JButton Back = new JButton("Powrot");
	
	
	JLabel Login = new JLabel("Podaj login: ");
	JLabel Password = new JLabel("Haslo: ");
	JLabel Name = new JLabel("Imie: ");
	JLabel Surrname = new JLabel("Nazwisko: ");
	JLabel Privliage = new JLabel("Uprawnienia: ");
	JLabel Company = new JLabel("NIPFirmy: ");
	
	
	JTextField LoginEmploy = new JTextField();
	JTextField PasswordEmploy = new JTextField();
	JTextField NameEmploy = new JTextField();
	JTextField SurrnameEmploy = new JTextField();
	JTextField PrivliageEmploy = new JTextField();
	JTextField CompanyEmploy = new JTextField();
	
	public AddEmploy(){
		setLayout(new GridLayout(7,2));
		add(Login,BorderLayout.WEST);
		add(LoginEmploy,BorderLayout.EAST);
		add(Password,BorderLayout.WEST);
		add(PasswordEmploy,BorderLayout.EAST);
		add(Name,BorderLayout.WEST);
		add(NameEmploy,BorderLayout.EAST);
		add(Surrname,BorderLayout.WEST);
		add(SurrnameEmploy,BorderLayout.EAST);
		add(Privliage,BorderLayout.WEST);
		add(PrivliageEmploy,BorderLayout.EAST);
		add(Company,BorderLayout.EAST);
		add(CompanyEmploy,BorderLayout.EAST);
		add(Back,BorderLayout.EAST);
		add(Add,BorderLayout.WEST);
		
		Add.setActionCommand(Actions.Add.name());
		Add.addActionListener(this);
		Back.setActionCommand(Actions.Back.name());
		Back.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(Actions.Add.name())){
		String data = LoginEmploy.getText()+";"+PasswordEmploy.getText()+";"+NameEmploy.getText()+";"+SurrnameEmploy.getText()+";"+PrivliageEmploy.getText()+";"+CompanyEmploy.getText();
			System.out.println(data);
		}
		else{
			Guide.getInstance().changeValuves(0,4);
		}
	}
}
