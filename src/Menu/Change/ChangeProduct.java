package Menu.Change;

import Menu.*;
import Menu.Find.FindProduct;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ChangeProduct extends FindProduct {
	
	protected ArrayList<Integer> X = new ArrayList<>();
	protected ArrayList<Integer> Y = new ArrayList<>();
	protected ArrayList<String> names = new ArrayList<>();
	protected enum Actions{
		Change, Back
	}
	
	public ChangeProduct() {
	}
	
	@Override
	protected void setDiffrence() {
		JButton add = new JButton("Popraw");
		this.jTable= new JTable(defaultTableModel){
			@Override
			public boolean isCellEditable(int row, int col) {
				return col != 0;
			}
		};
		
		panel.setLayout(new GridLayout(0,4));
		panel.add(add, 0, 0);
		Back.setActionCommand(Actions.Back.name());
		add.setActionCommand(Actions.Change.name());
		add.addActionListener(this);
		set();
	}
	
	private void set() {
		jTable.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				X.add(jTable.getSelectedColumn());
				Y.add(jTable.getSelectedRow());
				names.add((String)jTable.getValueAt(Y.get(Y.size()-1), X.get(X.size()-1)));
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Actions.Change.name())){
				for (int i = 0; i < Y.size(); i++) {
			//String valueInCell = (String)jTable.getValueAt(Y.get(i), X.get(i));
			//System.out.println(dataInside[Y.get(i)][X.get(i)]);
			//System.out.println(names.get(i));
			//int g = names.get(i).compareTo(valueInCell);
			//System.out.println(g);
			//if(true){
				String data = jTable.getValueAt(Y.get(i), 0)+";"+columnNames[X.get(i)]+";"+jTable.getValueAt(Y.get(i), X.get(i));
				System.out.println(data);
				//System.out.println(dataInside[Y.get(i)][X.get(i)]);
				//System.out.println(names.get(i));
				//System.out.println(valueInCell);
				//System.out.println((dataInside[Y.get(i)][X.get(i)]).e(jTable.getValueAt(Y.get(i), X.get(i))));
			//}
		}
		X.clear();
		Y.clear();
		names.clear();
		}
		else{
			Guide.getInstance().changeValuves(0,6);
		}
	}
}
	

