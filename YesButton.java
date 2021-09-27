package Blackjack3;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class YesButton extends JButton implements ActionListener {
	private Board view;
	private Controller controller;
	
	/**constructor - hitbutton
	 * 
	 * @param label - -��ư �۱�
	 * @param cnt - ��Ʈ�ѷ�
	 */
	public YesButton(String label, Controller cnt) {
		super(label);
		controller = cnt;
		addActionListener(this);
	}
	
	/**actionPerformed - finishGame ����
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		controller.marginalCard();
	}

}
