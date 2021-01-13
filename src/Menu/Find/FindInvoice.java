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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class FindInvoice extends JPanel implements ActionListener {
	
	protected String[] columnNames
			= {"IndeksFaktury", "NazwaFirmy", "AdresFirmy", "NIPFirmy", "PracownikID",
			"Nazwa", "NIP", "Adres", "Email", "Telefon",
		
	};
	protected Object[][] dataInside = {
			{"USA", "Washington DC", 280, true, "8%"},
			{"Canada", "Ottawa", 32, true, "8%"},
			{"United Kingdom", "London", 60, true, "8%"},
			{"Germany", "Berlin", 83, true, "8%"},
			{"France", "Paris", 60, true, "8%"},
			{"Norway", "Oslo", 4.5, true, "8%"},
			{"India", "New Delhi", 1046, true, "8%"}
	};
	
	private final JPanel panel = new JPanel(new GridLayout(0,3));
	protected final DefaultTableModel model = new DefaultTableModel(dataInside, columnNames);
	protected ProductList productList = new ProductList();
	protected final JTable jTable = new JTable(model);
	protected final TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(jTable.getModel());
	protected final JTextField jTextField = new JTextField();
	protected JButton Back = new JButton("Powrot");
	
	public FindInvoice() {
		setColumns();
		finish();
	}
	
	protected void paintComponent(Graphics g) {
		setData();
		productList.setColumnNames();
		productList.setProduct();
		super.paintComponent(g);
	}
	
	void setListener() {
		FindProduct.setListner(jTextField, rowSorter);
		jTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				Point point = mouseEvent.getPoint();
				int row = jTable.rowAtPoint(point);
				if (mouseEvent.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
					String data = (String) jTable.getValueAt(row, 0);
					System.out.println(data);
				}
			}
		});
	}
	
	protected void finish() {
		jTable.setRowSorter(rowSorter);
		jTable.setDefaultEditor(Object.class, null);
		
		Back.addActionListener(this);
		panel.add(new JLabel("Wyszukaj: "), 0, 0);
		panel.add(jTextField, 0, 1);
		panel.add(Back, 0, 2);
		
		setLayout(new BorderLayout());
		add(panel, BorderLayout.SOUTH);
		add(new JScrollPane(jTable), BorderLayout.CENTER);
		setListener();
	}
	
	protected void setColumns() {
	
	}
	
	protected void setData() {
		//this.dataInside=data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Guide.getInstance().changeValuves(0, 3);
	}
}
