package Menu.Invoice;

import Menu.Find.FindProduct;
import Menu.Guide;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class InvoiceProduct extends FindProduct {
	
	protected ArrayList<String> chosenProduct = new ArrayList<>();
	public InvoiceProduct() {
		done();
	}
	
	void done()
	{
		jTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				
				if (mouseEvent.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
					chosenProduct.add(Arrays.toString(dataInside[jTable.getSelectedRow()]));
					System.out.println(Arrays.toString(dataInside[jTable.getSelectedRow()]));
					Guide.getInstance().changeValuves(0,1); //next
				}
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Guide.getInstance().changeValuves(0,1);
	}
}
