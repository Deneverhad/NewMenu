package Menu.Change;

import Menu.Guide;
import Menu.SQLConnector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangeInvoice extends ChangeProduct {
	ChangeProductList changeProductList = new ChangeProductList();
	
	public ChangeInvoice() {
		setter();
	}
	
	private void setter(){
		jTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				if(SwingUtilities.isRightMouseButton(mouseEvent)) {
					Guide.getInstance().changeValuves(6,5);
				}
			}
		});
	}
	@Override
	protected void setColumns(){
		this.columnNames= SQLConnector.getInstance().selectColumns("faktura");
	}
	
	@Override
	protected void setData() {
		if (dataInside == null) {
			dataInside = SQLConnector.getInstance().select("faktura");
		} else {
			dataInside = SQLConnector.getInstance().select("faktura");
			for (int i = 0; i < dataInside.length; i++) {
				for (int j = 0; j < dataInside[0].length; j++) {
					defaultTableModel.setValueAt(dataInside[i][j], i, j);
				}
			}
		}
	}
	
	@Override
	protected void setTabel(){
		this.jTable= new JTable(defaultTableModel){
			@Override
			public boolean isCellEditable(int row, int col) {
				return col == 5;
			}
		};
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Actions.Change.name())) {
			String[] data;
			for (int i = 0; i < X.size(); i++) {
				data=X.get(i);
				try{
					if(SQLConnector.getInstance().poprawFaktura(Integer.parseInt(data[0]),data[5]) ==0){
						JOptionPane.showMessageDialog(jFrame, "Operacja nie powiodla sie", "Ostrzezenie", JOptionPane.ERROR_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(jFrame, "Operacja powiodla sie");
					}
				}
				catch (Exception enn){
					JOptionPane.showMessageDialog(jFrame, "Operacja nie powiodla sie", "Ostrzezenie", JOptionPane.ERROR_MESSAGE);
				}
			}
			X.clear();
			Guide.getInstance().changeValuves(0,1);
		}
		else{
			X.clear();
			Guide.getInstance().changeValuves(0,6);
		}
	}
}
