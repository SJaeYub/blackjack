package Blackjack3;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class NoButton extends JButton implements ActionListener {
	
	private Card model;
	private Controller controller;
	
	/**constructor - staybutton
	 * 
	 * @param label - -��ư �۱�
	 * @param cnt - ��Ʈ�ѷ�
	 */
	public NoButton(String label, Controller cnt) {
		super(label);
		controller = cnt;
		addActionListener(this);		
		
	}
	
	/**actionPerformed - finishGame ����
	 * 
	 */
	public void actionPerformed(ActionEvent e) {		
		controller.finishGame();
	}

}
