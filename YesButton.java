package Blackjack3;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class YesButton extends JButton implements ActionListener {
	private Board view;
	private Controller controller;
	
	/**constructor - hitbutton
	 * 
	 * @param label - -버튼 글귀
	 * @param cnt - 컨트롤러
	 */
	public YesButton(String label, Controller cnt) {
		super(label);
		controller = cnt;
		addActionListener(this);
	}
	
	/**actionPerformed - finishGame 실행
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		controller.marginalCard();
	}

}
