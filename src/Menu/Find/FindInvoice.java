package Menu.Find;

import Menu.Guide;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FindInvoice extends FindProduct {
	private final ProductList productList = new ProductList();
	
	public FindInvoice(){
	seter();
	}
	@Override
	protected void setColumns(){
		this.columnNames= new String[]{"ProduktID", "NazwaProduktu", "Ilosc", "Jednostka", "Podatek"};
	}
	@Override
	protected void setData(){
		dataInside = new Object[][]{
				{"USA", "Washington DC", 280, true, "8%"},
				{"Canada", "Ottawa", 32, true, "8%"},
				{"United Kingdom", "London", 60, true, "8%"},
				{"Germany", "Berlin", 83, true, "8%"},
				{"France", "Paris", 60, true, "8%"},
				{"Norway", "Oslo", 4.5, true, "8%"},
				{"India", "New Delhi", 1046, true, "8%"}
		};
	}
	public void seter(){
		jTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
					productList.InvoiceSeter((String) jTable.getValueAt(jTable.getSelectedRow(), 0));
					Guide.getInstance().changeValuves(3,5);
				}
			}
		});
	}
}
