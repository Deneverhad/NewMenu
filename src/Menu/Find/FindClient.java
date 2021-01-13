package Menu.Find;

public class FindClient extends FindProduct{
	
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
}
