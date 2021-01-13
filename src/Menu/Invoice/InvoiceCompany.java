package Menu.Invoice;

import Menu.Find.FindOurCompany;
import Menu.Guide;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class InvoiceCompany extends FindOurCompany {
	protected String chosenCompany;
	public InvoiceCompany() {
		done();
     }
     
	protected void done()
	{
		jTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				
				if (mouseEvent.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
					chosenCompany=Arrays.toString(dataInside[jTable.getSelectedRow()]);
					System.out.println(chosenCompany);
					Guide.getInstance().changeValuves(2,1); //next
				}
			}
		});
	}
}
