package Menu.Change;

import Menu.Find.FindOurCompany;
import Menu.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ChangeOurCompany extends FindOurCompany {
	
	ArrayList<Integer> X = new ArrayList<>();
	ArrayList<Integer> Y = new ArrayList<>();
	private enum Actions {
		Change, Back
	}
	protected JTable jTable;
	
	public ChangeOurCompany() {
	}
	
	@Override
	protected void finish() {
		JTable jTable = new JTable(defaultTableModel) {
			@Override
			public boolean isCellEditable(int row, int col) {
				return col != 0;
			}
		};
		
		this.jTable = jTable;
		jTable.setRowSorter(rowSorter);
		
		JPanel jPanel = new JPanel(new GridLayout(0, 4));
		JButton add = new JButton("Popraw");
		jPanel.add(new JLabel("Wyszukaj: "), 0, 0);
		jPanel.add(jTextField, 0, 1);
		jPanel.add(Back, 0, 2);
		jPanel.add(add, 0, 3);
		
		setLayout(new BorderLayout());
		add(jPanel, BorderLayout.SOUTH);
		add(new JScrollPane(jTable), BorderLayout.CENTER);
		
		setListener();
		add.setActionCommand(Actions.Change.name());
		add.addActionListener(this);
		Back.setActionCommand(Actions.Back.name());
		Back.addActionListener(this);
		set();
	}
	
	private void set() {
		jTable.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				X.add(jTable.getSelectedColumn());
				Y.add(jTable.getSelectedRow());
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(Actions.Change.name())) {
			for (int i = 0; i < Y.size(); i++) {
				String data = jTable.getValueAt(Y.get(i), 0) + ";" + columnNames[X.get(i)] + ";" + jTable.getValueAt(Y.get(i), X.get(i));
				System.out.println(data);
			}
			X.clear();
			Y.clear();
			//names.clear();
		} else {
			Guide.getInstance().changeValuves(0, 6);
		}
	}
}
