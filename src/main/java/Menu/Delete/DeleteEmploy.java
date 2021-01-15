package Menu.Delete;

import Menu.Find.FindEmploy;
import Menu.Guide;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class DeleteEmploy extends FindEmploy {
	public DeleteEmploy(){
	done();
	}
	private void done()
	{
		jTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
					System.out.println(Arrays.toString(dataInside[jTable.getSelectedRow()]));
				}
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Guide.getInstance().changeValuves(0,5);
	}
}
