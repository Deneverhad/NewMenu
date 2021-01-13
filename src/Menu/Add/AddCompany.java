package Menu.Add;
import Menu.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompany extends JPanel implements ActionListener {
	
	private enum Actions{
		Add, Back
	}
	
	JButton Add = new JButton("Dodaj");
	JButton Back = new JButton("Powrot");
	
	JLabel Name = new JLabel("Nazwa firmy: ");
	JLabel Address = new JLabel("Adress: ");
	JLabel NIP = new JLabel("NIP :");
	JLabel Phone = new JLabel("Telefon:");
	
	
	JTextField NameFirm = new JTextField();
	JTextField AddressFirm = new JTextField();
	JTextField NIPFirm = new JTextField();
	JTextField PhoneFirm = new JTextField();
	
	public AddCompany(){
		setLayout(new GridLayout(5,2));
		add(Address,BorderLayout.WEST);
		add(NameFirm,BorderLayout.EAST);
		add(NIP,BorderLayout.WEST);
		add(AddressFirm,BorderLayout.EAST);
		add(Name,BorderLayout.WEST);
		add(NIPFirm,BorderLayout.EAST);
		add(Phone,BorderLayout.WEST);
		add(PhoneFirm,BorderLayout.EAST);
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
			String data = NameFirm.getText()+";"+AddressFirm.getText()+";"+NIPFirm.getText()+";"+PhoneFirm.getText();
			System.out.println(data);
		}
		else{
			Guide.getInstance().changeValuves(0,4);
		}
	}
}
