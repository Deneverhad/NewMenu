package Menu.Delete;

import Menu.Find.FindInvoice;
import Menu.Guide;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteInvoice extends FindInvoice {
	DeleteProductList productList = new DeleteProductList();
	public DeleteInvoice(){
		done();
	}
	void done()
	{
		jTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				
				if (mouseEvent.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
					System.out.println(jTable.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Logowanie");
				}
				if(SwingUtilities.isRightMouseButton(mouseEvent)) {
					productList.InvoiceSeter((String) jTable.getValueAt(jTable.getSelectedRow(), 0));
					Guide.getInstance().changeValuves(6,5);
				}
			}
		});
	}
}
