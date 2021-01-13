package Menu.Delete;

import Menu.Find.FindClient;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteClient extends FindClient {
	public DeleteClient(){
		done();
	}
	void done()
	{
		jTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				
				if (mouseEvent.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
					System.out.println(jTable.getSelectedRow());
				}
				if(SwingUtilities.isRightMouseButton(mouseEvent)) System.out.println("dziala");
			}
		});
	}
}
