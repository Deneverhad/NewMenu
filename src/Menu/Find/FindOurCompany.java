package Menu.Find;
import Menu.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class FindOurCompany extends JPanel implements ActionListener {
	
	protected String[] columnNames
			= {"ProduktID", "NazwaProduktu", "Ilosc", "Jednostka","Podatek"};
	
	protected Object[][] dataInside = {
			{"USA", "Washington DC", 280, true,"8%"},
			{"Canada", "Ottawa", 32, true,"8%"},
			{"United Kingdom", "London", 60, true,"8%"},
			{"Germany", "Berlin", 83, true,"8%"},
			{"France", "Paris", 60, true,"8%"},
			{"Norway", "Oslo", 4.5, true,"8%"},
			{"India", "New Delhi", 1046, true,"8%"}
	};
	
	private final JPanel panel = new JPanel(new GridLayout(0,3));
	protected DefaultTableModel defaultTableModel = new DefaultTableModel(dataInside, columnNames);
	protected JTable jTable = new JTable(defaultTableModel);
	protected final TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(jTable.getModel());
	protected final JTextField jTextField = new JTextField();
	protected JButton Back = new JButton("Powrot");
	
	public FindOurCompany() {
		finish();
	}
	
	protected void finish(){
		jTable.setRowSorter(rowSorter);
		jTable.setDefaultEditor(Object.class, null);
		
		Back.addActionListener(this);
		panel.add(new JLabel("Wyszukaj: "), 0,0);
		panel.add(jTextField,0,1);
		panel.add(Back,0,2);
		
		setLayout(new BorderLayout());
		add(panel, BorderLayout.SOUTH);
		add(new JScrollPane(jTable), BorderLayout.CENTER);
		setListener();
	}
	
	protected void paintComponent(Graphics g) {
		setColumns();
		setData();
		super.paintComponent(g);
	}
	
	protected void setListener() {
		FindProduct.setListner(jTextField, rowSorter);
	}
	
	protected void setColumns(){
		//this.columnNames=columnNames;
	}
	protected void setData(){
		Guide.getInstance().setFirm(dataInside);
		//this.dataInside=data;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Guide.getInstance().changeValuves(0,3);
	}
}
