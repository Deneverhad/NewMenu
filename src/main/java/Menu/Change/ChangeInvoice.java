package Menu.Change;

import Menu.Guide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangeInvoice extends ChangeProduct {
	ChangeProductList changeProductList = new ChangeProductList();
	
	public ChangeInvoice() {
		setter();
	}
	@Override
	protected void setColumns() {
		this.columnNames = new String[]{"Produkt", "Nazwa", "Il", "Jedn", "Po"};
	}
	
	@Override
	protected void setData() {
		dataInside = new Object[][]{
				{"USA", "Waon DC", 280, true, "8%"},
				{"Canada", "Otwa", 32, true, "8%"},
				{"United Kingdm", "London", 60, true, "8%"},
		};
	}
	private void setter(){
		jTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				if(SwingUtilities.isRightMouseButton(mouseEvent)) {
					changeProductList.InvoiceSeter((String) jTable.getValueAt(jTable.getSelectedRow(), 0));
					Guide.getInstance().changeValuves(6,5);
				}
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Actions.Change.name())){
			for (int i = 0; i < Y.size(); i++) {
				String data = jTable.getValueAt(Y.get(i), 0)+";"+columnNames[X.get(i)]+";"+jTable.getValueAt(Y.get(i), X.get(i));
				System.out.println(data);
			}
			X.clear();
			Y.clear();
			names.clear();
		}
		else{
			Guide.getInstance().changeValuves(0,6);
		}
	}
}
