/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



import view.StageHintsPanel;
import view.StageTwoHint;

/**
 * @author muhammet
 *
 */
public class StageTwoHintController implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
private StageTwoHint sth;
	
	public StageTwoHintController(StageTwoHint sth) {
		this.sth = sth;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		sth.setVisible(false);
		JButton btn =(JButton) e.getSource();
		String str = btn.getText();
		JFrame frame = (JFrame) btn.getTopLevelAncestor();
		if (str.equals("BACK")){
			frame.add(new StageHintsPanel());
			frame.remove(sth);
		}
	
		
	}

}
