package Menu.Delete;

import Menu.Find.ProductList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class DeleteProductList extends ProductList {
	private String Invoice;
	public DeleteProductList(){
		done();
	}
	@Override
	protected void InvoiceSeter(String invoice){
		this.Invoice = invoice;
	}
	void done()
	{
		jTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				
				if (mouseEvent.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
					System.out.println(Arrays.toString(dataInside[jTable.getSelectedRow()]));
				}
			}
		});
	}
}
