package Menu.Invoice;

import Menu.Find.FindClient;
import Menu.Guide;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class InvoiceClient extends FindClient {
	protected String chosenClient;
	
	public InvoiceClient() {
		done();
	}
	
	void done()
	{
		jTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				
				if (mouseEvent.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
					chosenClient= Arrays.toString(dataInside[jTable.getSelectedRow()]);
					System.out.println(chosenClient);
					Guide.getInstance().changeValuves(2,2); //next
				}
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Guide.getInstance().changeValuves(0,1);
	}

}
