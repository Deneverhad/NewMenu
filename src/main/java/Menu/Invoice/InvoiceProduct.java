package Menu.Invoice;

import Menu.Find.FindProduct;
import Menu.Guide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class InvoiceProduct extends FindProduct {
	
	protected ArrayList<String> chosenProduct = new ArrayList<>();
	private JLabel data = new JLabel("Ilosc: ");
	private JTextField many = new JTextField();
	private JPanel jPanel;
	private JFrame jFrame;
	public InvoiceProduct() {
		setter();
		done();
	}
	void setter(){
		jFrame=new JFrame();
		jPanel = new JPanel(new GridLayout(1,2));
		jPanel.add(data, BorderLayout.EAST);
		jPanel.add(many, BorderLayout.WEST);
		jFrame.add(jPanel);
	}

	void done()
	{
		jTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				
				if (mouseEvent.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
					
					JOptionPane.showMessageDialog(jFrame,jPanel,"Logowanie", JOptionPane.PLAIN_MESSAGE );
					if(!(many.getText().isEmpty())){
						chosenProduct.add((String) jTable.getValueAt(jTable.getSelectedRow(),0));
						chosenProduct.add(many.getText());
					}
					//chosenProduct.add(Arrays.toString(dataInside[jTable.getSelectedRow()]));
					//JOptionPane.showMessageDialog(jFrame,jPanel,"Logowanie", JOptionPane.PLAIN_MESSAGE );
					//System.out.println(Arrays.toString(dataInside[jTable.getSelectedRow()]));
					//Guide.getInstance().changeValuves(0,1); //next
				}
				if(SwingUtilities.isRightMouseButton(mouseEvent)) {
					for(int i=0;i<chosenProduct.size();i++){
						System.out.println(chosenProduct.get(i));
					}
					Guide.getInstance().changeValuves(0,1);
				}
			}
		});
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Guide.getInstance().changeValuves(0,1);
	}
}
