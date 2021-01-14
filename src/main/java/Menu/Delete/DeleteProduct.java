package Menu.Delete;

import Menu.Find.FindProduct;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class DeleteProduct extends FindProduct {
	public DeleteProduct(){
		done();
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
