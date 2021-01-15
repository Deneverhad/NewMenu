package Menu.Delete;

import Menu.Find.FindInvoice;
import Menu.Guide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteInvoice extends FindInvoice {
	DeleteProductList productList = new DeleteProductList();
	
	public DeleteInvoice(){
	}
	
	@Override
	protected void seter(){
		jTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				
				if (mouseEvent.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
					System.out.println(jTable.getSelectedRow());
				}
				if(SwingUtilities.isRightMouseButton(mouseEvent)) {
					productList.InvoiceSeter((String) jTable.getValueAt(jTable.getSelectedRow(), 0));
					Guide.getInstance().changeValuves(5,5);
				}
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Guide.getInstance().changeValuves(0,5);
	}
}
