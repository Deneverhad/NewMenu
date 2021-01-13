package Menu.Delete;

import Menu.Find.FindClient;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class DeleteClient extends FindClient {
	public DeleteClient(){
		done();
	}
	void done()
	{
		jTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				
				if (mouseEvent.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
					System.out.println(Arrays.toString(dataInside[jTable.getSelectedRow()]));
				}
			}
		});
	}
}
