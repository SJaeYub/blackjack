package Blackjack3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;


public class Controller extends JFrame {
	private Card[] card;
	private CardDeck deck;
	private CardPlayer player;
	private Dealer dealer;
	private static final String WindowConstatns = null;
	private JLabel label = new JLabel("BLACKJACK");
	private Board writer;
//	private JPanel writer;
	 
	/**constructor - ���� ���� ����
	 * 
	 * @param d - ī�� ��
	 * @param p - �÷��̾�
	 * @param dl - ����
	 * @param v - outputview
	 */
	public Controller(CardDeck d, CardPlayer p, Dealer dl, Board v) {
		deck = d;
		player = p;
		dealer = dl;
		writer = v;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel p1 = new JPanel(new FlowLayout()); //yes ��ư
		JPanel p2 = new JPanel(new FlowLayout()); //no ��ư
//		button.addActionListener(new CounterController(count, this));
		p1.add(label);
		p2.add(new YesButton("HIT", this));
		p2.add(new NoButton("STAY", this));
		
		cp.add(p1, BorderLayout.NORTH);
		cp.add(writer, BorderLayout.CENTER);
		cp.add(p2, BorderLayout.SOUTH);
		
		setTitle("Blackjack");
		setSize(500, 500);
		setVisible(true);
	}
		
	/** distributor - ���
	 * 
	 */
	public void distributor() {
//		writer.paintComponent(getGraphics());
		
		for(int i =0; i < 2; i++) {
			player.receiveCard(deck.newCard());
			dealer.receiveCard(deck.newCard());
		}
		Card [] pcards = player.showCards();
		Card [] dcards = dealer.showCards();
		
		for(int i = 0; i < pcards.length; i++) {
			
			if(pcards[i].getRank() == 1 || pcards[i].getRank() == 11 ||
					pcards[i].getRank() == 12 || pcards[i].getRank() == 13) {
				if(pcards[i].getRank() == 1) {	
			
//					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), i *10);
					System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "ACE");
				}
				else if(pcards[i].getRank() == 11) {
//					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), i *10);
					System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "JACK");
				}
				else if(pcards[i].getRank() == 12) {
//					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), i *10);
					System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "QUEEN");
				}
				else if(pcards[i].getRank() == 13) {
//					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), i *10);
					System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "KING");
				}
			}
			else {
//				writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), i *10);
				System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + pcards[i].getRank());
			}			
		}
		
//		for(int i = 0; i < pcards.length; i++) {
//			writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), i *10);
//		}
		System.out.println();
		for(int i = 0; i < dcards.length; i++) {
			if(i == 0) {
//				writer.unknownMark(getGraphics(), 0);
				System.out.println("Dealer�� �� : " + "******** **");
			}
			else {
				if(dcards[i].getRank() == 1 || dcards[i].getRank() == 11 ||
						dcards[i].getRank() == 12 || dcards[i].getRank() == 13) {
					if(dcards[i].getRank() == 1) {					
//						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), i *10);
						System.out.println("Dealer�� �� : " + dcards[i].getSuit() + " " + "ACE");
					}
					else if(dcards[i].getRank() == 11) {
//						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), i *10);
						System.out.println("Dealer�� �� : " + dcards[i].getSuit() + " " + "JACK");
					}
					else if(dcards[i].getRank() == 12) {
//						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), i *10);
						System.out.println("Dealer�� �� : " + dcards[i].getSuit() + " " + "QUEEN");
					}
					else if(dcards[i].getRank() == 13) {
//						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), i *10);
						System.out.println("Dealer�� �� : " + dcards[i].getSuit() + " " + "KING");
					}
				}
				else {
//					writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), i *10);
					System.out.println("Dealer�� �� : " + dcards[i].getSuit() + " " + dcards[i].getRank());
				}			
			}
		}
		ruler();
	}
	
	/**ruler - ī�� �й� ���� ����Ʈ ���� ��
	 * 
	 */		
	public void ruler() {
		Card [] pcards = player.showCards();
		Card [] dcards = dealer.showCards();
		for(int i = 0; i < pcards.length; i++) {
			if(pcards[i].getRank() == 1 || pcards[i].getRank() == 11 ||
					pcards[i].getRank() == 12 || pcards[i].getRank() == 13) {
				if(pcards[i].getRank() == 1) {
					int ace = Integer.parseInt(JOptionPane.showInputDialog("ACE�Դϴ�! 1 or 11 �� �����ϼ���."));
					player.playerSum(ace);
				}
				else if(pcards[i].getRank() == 11) {
					int ace = 10;
					player.playerSum(ace);
				}
				else if(pcards[i].getRank() == 12) {
					int ace = 10;
					player.playerSum(ace);
				}
				else if(pcards[i].getRank() == 13) {
					int ace = 10;
					player.playerSum(ace);
				}
			}
			else {
				int a = pcards[i].getRank();
				player.playerSum(a);
			}
		}
		System.out.println();

		for(int i = 0; i < dcards.length; i++) {
			if(dcards[i].getRank() == 1 || dcards[i].getRank() == 11 ||
					dcards[i].getRank() == 12 || dcards[i].getRank() == 13) {
				if(dcards[i].getRank() == 1) {
					Random rnd = new Random();
					int q = rnd.nextInt(2);
					if(q == 0) {
						int ace = 1;				
						dealer.dealerSum(ace);
					}
					else {
						int ace = 11;
						dealer.dealerSum(ace);
					}
				}
				else if(dcards[i].getRank() == 11) {
					int ace = 10;
					dealer.dealerSum(ace);
				}
				else if(dcards[i].getRank() == 12) {
					int ace = 10;
					dealer.dealerSum(ace);
				}
				else if(dcards[i].getRank() == 13) {
					int ace = 10;
					dealer.dealerSum(ace);
				}
			}
			else {
				int a = dcards[i].getRank();
				dealer.dealerSum(a);
			}
		}
		
		for(int i = 0; i < 2; i++) {
			if(pcards[i].getRank() == 1 || pcards[i].getRank() == 10 || pcards[i].getRank() == 11 ||
				pcards[i].getRank() == 12 || pcards[i].getRank() == 13) {
				if(player.pp_value() == 21) {
					writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
					System.out.println();
					System.out.println("player �� : " +  player.pp_value());
					System.out.println("dealer �� : " +  dealer.dp_value());
					System.out.println("player win!");
				}
			}
		}
		
		if(player.pp_value() > 21 || dealer.dp_value() > 21) {
			if(dealer.dp_value() > 21) {
				writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
				System.out.println();
				System.out.println("player �� : " +  player.pp_value());
				System.out.println("dealer �� : " +  dealer.dp_value());
				System.out.println("Burst! Player win!");
			}
			else if(player.pp_value() > 21) {
				writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
				System.out.println();
				System.out.println("player �� : " +  player.pp_value());
				System.out.println("dealer �� : " +  dealer.dp_value());
				System.out.println("Burst! Dealer win!");
			}
		}
		if(dealer.dp_value() <= 16) {
			hitDealer();
		}
		if(player.pp_value() < 21) {
			System.out.println();
			System.out.println("more card?");	
		}
		
	}
	
	/**marginalCard - �÷��̾� hit ����
	 * 
	 */
	public void marginalCard() {
		player.receiveCard(deck.newCard());
		Card [] pcards = player.showCards();		
		
		for(int i = pcards.length - 1; i < pcards.length; i++) {
			if(pcards[i].getRank() == 1 || pcards[i].getRank() == 11 ||
					pcards[i].getRank() == 12 || pcards[i].getRank() == 13) {
				if(pcards[i].getRank() == 1) {
					int ace = Integer.parseInt(JOptionPane.showInputDialog("ACE�Դϴ�! 1 or 11 �� �����ϼ���."));
					player.playerSum(ace);
					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), (i *10) + 80); // i * 10
					System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "ACE");
				}
				else if(pcards[i].getRank() == 11) {
					int ace = 10;
					player.playerSum(ace);
					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), (i *10) + 80);
					System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "JACK");
				}
				else if(pcards[i].getRank() == 12) {
					int ace = 10;
					player.playerSum(ace);
					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), (i *10) + 80);
					System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "QUEEN");
				}
				else if(pcards[i].getRank() == 13) {
					int ace = 10;
					player.playerSum(ace);
					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), (i *10) + 80);
					System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "KING");
				}
			}
			else {
				int a = pcards[pcards.length - 1].getRank();
				player.playerSum(a);
				writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), (i *10) + 80);
				System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + pcards[i].getRank());
			}
		}
		System.out.println();		
	}
	
	/**hitDealer - ���� �� 16 ������ ��� �ڵ����� ī�� �� ����
	 * 
	 */
	public void hitDealer() {		
		while(dealer.dp_value() <= 16) {
			dealer.receiveCard(deck.newCard());
			Card [] dcards = dealer.showCards();	
			writer.informationString(getGraphics());
			for(int i = dcards.length - 1; i < dcards.length; i++) {
				if(dcards[i].getRank() == 1 || dcards[i].getRank() == 11 ||
						dcards[i].getRank() == 12 || dcards[i].getRank() == 13) {
					if(dcards[i].getRank() == 1) {	
						Random rnd = new Random();
						int q = rnd.nextInt(2);
						if(q == 0) {
							int ace = 1;				
							dealer.dealerSum(ace);
						}
						else {
							int ace = 11;
							dealer.dealerSum(ace);
						}
						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), (i *10) + 65); // 25
						System.out.println("���� 16 �����Դϴ�. �߰� �и� �޽��ϴ�\n" +" Dealer�� �� : " + dcards[i].getSuit() + " " + "ACE");
					}
					else if(dcards[i].getRank() == 11) {
						int a = 10;
						dealer.dealerSum(a);
						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), (i *10) + 65);
						System.out.println("���� 16 �����Դϴ�. �߰� �и� �޽��ϴ�\n" +" Dealer�� �� : " + dcards[i].getSuit() + " " + "JACK");
					}
					else if(dcards[i].getRank() == 12) {
						int a = 10;
						dealer.dealerSum(a);
						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), (i *10) + 65);
						System.out.println("���� 16 �����Դϴ�. �߰� �и� �޽��ϴ�\n" +" Dealer�� �� : " + dcards[i].getSuit() + " " + "QUEEN");
					}
					else if(dcards[i].getRank() == 13) {
						int a = 10;
						dealer.dealerSum(a);
						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), (i *10) + 65);
						System.out.println("���� 16 �����Դϴ�. �߰� �и� �޽��ϴ�\n" +" Dealer�� �� : " + dcards[i].getSuit() + " " + "KING");
					}
				}
				else {
					int a = dcards[dcards.length - 1].getRank();
					dealer.dealerSum(a);
					writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), (i *10) + 65);
					System.out.println();					
					System.out.println("���� 16 �����Դϴ�. �߰� �и� �޽��ϴ�\n" +" Dealer�� �� : " + dcards[i].getSuit() + " " + dcards[i].getRank());
				}		
			}
		}
	}
	
	/**finishGame - �÷��̾�� ���� ����Ʈ �޾Ƽ� ���� ��� ����
	 * 
	 */
	public void finishGame() {
		
		if(player.pp_value() > 21 || dealer.dp_value() > 21) {
			if(player.pp_value() > 21 && dealer.dp_value() > 21) {
				writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
				System.out.println();
				System.out.println("player �� : " +  player.pp_value());
				System.out.println("dealer �� : " +  dealer.dp_value());
				System.out.println("Draw!");
				
			}
			else if( player.pp_value() > 21 && dealer.dp_value() < 21) {
				writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
				System.out.println();
				System.out.println("player �� : " +  player.pp_value());
				System.out.println("dealer �� : " +  dealer.dp_value());
				System.out.println("Burst! Dealer win!");
				
			}
			else if(player.pp_value() < 21 && dealer.dp_value() > 21) {
				writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
				System.out.println();
				System.out.println("player �� : " +  player.pp_value());
				System.out.println("dealer �� : " +  dealer.dp_value());
				System.out.println("Burst! Player win!");
				
			}
		}
		else {
			if(player.pp_value() > dealer.dp_value()) {
				writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
				System.out.println();
				System.out.println("player �� : " +  player.pp_value());
				System.out.println("dealer �� : " +  dealer.dp_value());
				System.out.println("Player win!");
				
			}
			else if(player.pp_value() < dealer.dp_value()) {
				writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
				System.out.println();
				System.out.println("player �� : " +  player.pp_value());
				System.out.println("dealer �� : " +  dealer.dp_value());
				System.out.println("Dealer win!");
			}
				
		}
		
	}
	
}
