package Menu.Find;

import Menu.Guide;

import java.awt.event.ActionEvent;

public class ProductList extends FindProduct{
	private String Invoice;
	public ProductList(){
	}
	
	protected void InvoiceSeter(String invoice){
		this.Invoice = invoice;
	}
	@Override
	protected void setColumns(){
		//Przeslij id faktury
		this.columnNames= new String[]{"ProduktID", "NazwaProduktu", "Ilosc", "Jednostka", "Podatek"};
	}
	@Override
	protected void setData(){
		this.dataInside = new Object[][]{
				{"USA", "Washington DC", 280, true, "8%"},
				{"Canada", "Ottawa", 32, true, "8%"},
				{"United Kingdom", "London", 60, true, "8%"},
				{"Germany", "Berlin", 83, true, "8%"},
		};
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Guide.getInstance().changeValuves(3,0);
	}
}
