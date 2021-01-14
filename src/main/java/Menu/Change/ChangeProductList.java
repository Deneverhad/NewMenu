package Menu.Change;


import Menu.Guide;

import java.awt.event.ActionEvent;

public class ChangeProductList extends ChangeProduct {
	private String Invoice;
	public ChangeProductList(){
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
				
		};
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
			Guide.getInstance().changeValuves(6,0);
		}
	}
}
