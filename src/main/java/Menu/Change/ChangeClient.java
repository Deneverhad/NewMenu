package Menu.Change;

public class ChangeClient extends ChangeProduct {
	
	public ChangeClient() {
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
				{"Germany", "Be", 83, true, "8%"},
				{"France", "Par", true, "8"},
				{"Norway", "Oso", 4.5, true, "8%"},
				{"India", "New Dhi", 1046, true, "8%"}
		};
	}
}
