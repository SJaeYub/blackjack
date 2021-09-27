package Blackjack3;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class NoButton extends JButton implements ActionListener {
	
	private Card model;
	private Controller controller;
	
	/**constructor - staybutton
	 * 
	 * @param label - -버튼 글귀
	 * @param cnt - 컨트롤러
	 */
	public NoButton(String label, Controller cnt) {
		super(label);
		controller = cnt;
		addActionListener(this);		
		
	}
	
	/**actionPerformed - finishGame 실행
	 * 
	 */
	public void actionPerformed(ActionEvent e) {		
		controller.finishGame();
	}

}
