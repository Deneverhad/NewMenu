package Menu.Find;

import Menu.Guide;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FindProduct extends JPanel implements ActionListener {
	
	protected  String[] columnNames;
	protected  Object[][] dataInside;
	protected  JPanel panel;
	protected  DefaultTableModel defaultTableModel;
	protected  JTable jTable;
	protected  TableRowSorter<TableModel> rowSorter;
	protected  JTextField jTextField = new JTextField();
	protected JButton Back = new JButton("Powrot");
	
	public FindProduct() {
		finish();
	}
	
	protected void paintComponent(Graphics g) {
		setData();
		super.paintComponent(g);
	}
	
	protected void finish(){
		setColumns();
		setData();
		this.panel = new JPanel();
		this.defaultTableModel = new DefaultTableModel(dataInside, columnNames);
		setDiffrence();
		
		rowSorter = new TableRowSorter<>(jTable.getModel());
		jTable.setRowSorter(rowSorter);
		
		Back.addActionListener(this);
		
		panel.add(new JLabel("Wyszukaj: "), 0,0);
		panel.add(jTextField,0,1);
		panel.add(Back,0,2);
		
		setLayout(new BorderLayout());
		add(panel, BorderLayout.SOUTH);
		add(new JScrollPane(jTable), BorderLayout.CENTER);
		setListner();
	}
	
	protected void setDiffrence(){
		this.jTable= new JTable(defaultTableModel);
		this.panel.setLayout(new GridLayout(0,3));
		jTable.setDefaultEditor(Object.class, null);
	}
	
	 void setListner() {
		jTextField.getDocument().addDocumentListener(new DocumentListener(){
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = jTextField.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = jTextField.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
			}
		});
	}
	
	protected void setColumns(){
		this.columnNames= new String[]{"ProduktID", "NazwaProduktu", "Ilosc", "Jednostka", "Podatek"};
	}
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
		
		//for(int i=0; i<porn.length;i++){
			//for(int j=0;j<porn[0].length;j++){
			//	defaultTableModel.setValueAt(porn[i][j],i,j);
		//	}
		//}
		//defaultTableModel.setValueAt();
		//this.dataInside=data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Guide.getInstance().changeValuves(0,3);
	}
	
}


