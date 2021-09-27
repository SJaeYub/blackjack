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
	 
	/**constructor - 블랙잭 게임 구동
	 * 
	 * @param d - 카드 덱
	 * @param p - 플레이어
	 * @param dl - 딜러
	 * @param v - outputview
	 */
	public Controller(CardDeck d, CardPlayer p, Dealer dl, Board v) {
		deck = d;
		player = p;
		dealer = dl;
		writer = v;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel p1 = new JPanel(new FlowLayout()); //yes 버튼
		JPanel p2 = new JPanel(new FlowLayout()); //no 버튼
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
		
	/** distributor - 출력
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
					System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "ACE");
				}
				else if(pcards[i].getRank() == 11) {
//					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), i *10);
					System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "JACK");
				}
				else if(pcards[i].getRank() == 12) {
//					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), i *10);
					System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "QUEEN");
				}
				else if(pcards[i].getRank() == 13) {
//					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), i *10);
					System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "KING");
				}
			}
			else {
//				writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), i *10);
				System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + pcards[i].getRank());
			}			
		}
		
//		for(int i = 0; i < pcards.length; i++) {
//			writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), i *10);
//		}
		System.out.println();
		for(int i = 0; i < dcards.length; i++) {
			if(i == 0) {
//				writer.unknownMark(getGraphics(), 0);
				System.out.println("Dealer의 패 : " + "******** **");
			}
			else {
				if(dcards[i].getRank() == 1 || dcards[i].getRank() == 11 ||
						dcards[i].getRank() == 12 || dcards[i].getRank() == 13) {
					if(dcards[i].getRank() == 1) {					
//						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), i *10);
						System.out.println("Dealer의 패 : " + dcards[i].getSuit() + " " + "ACE");
					}
					else if(dcards[i].getRank() == 11) {
//						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), i *10);
						System.out.println("Dealer의 패 : " + dcards[i].getSuit() + " " + "JACK");
					}
					else if(dcards[i].getRank() == 12) {
//						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), i *10);
						System.out.println("Dealer의 패 : " + dcards[i].getSuit() + " " + "QUEEN");
					}
					else if(dcards[i].getRank() == 13) {
//						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), i *10);
						System.out.println("Dealer의 패 : " + dcards[i].getSuit() + " " + "KING");
					}
				}
				else {
//					writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), i *10);
					System.out.println("Dealer의 패 : " + dcards[i].getSuit() + " " + dcards[i].getRank());
				}			
			}
		}
		ruler();
	}
	
	/**ruler - 카드 분배 이후 버스트 여부 결
	 * 
	 */		
	public void ruler() {
		Card [] pcards = player.showCards();
		Card [] dcards = dealer.showCards();
		for(int i = 0; i < pcards.length; i++) {
			if(pcards[i].getRank() == 1 || pcards[i].getRank() == 11 ||
					pcards[i].getRank() == 12 || pcards[i].getRank() == 13) {
				if(pcards[i].getRank() == 1) {
					int ace = Integer.parseInt(JOptionPane.showInputDialog("ACE입니다! 1 or 11 중 선택하세요."));
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
					System.out.println("player 합 : " +  player.pp_value());
					System.out.println("dealer 합 : " +  dealer.dp_value());
					System.out.println("player win!");
				}
			}
		}
		
		if(player.pp_value() > 21 || dealer.dp_value() > 21) {
			if(dealer.dp_value() > 21) {
				writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
				System.out.println();
				System.out.println("player 합 : " +  player.pp_value());
				System.out.println("dealer 합 : " +  dealer.dp_value());
				System.out.println("Burst! Player win!");
			}
			else if(player.pp_value() > 21) {
				writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
				System.out.println();
				System.out.println("player 합 : " +  player.pp_value());
				System.out.println("dealer 합 : " +  dealer.dp_value());
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
	
	/**marginalCard - 플레이어 hit 실행
	 * 
	 */
	public void marginalCard() {
		player.receiveCard(deck.newCard());
		Card [] pcards = player.showCards();		
		
		for(int i = pcards.length - 1; i < pcards.length; i++) {
			if(pcards[i].getRank() == 1 || pcards[i].getRank() == 11 ||
					pcards[i].getRank() == 12 || pcards[i].getRank() == 13) {
				if(pcards[i].getRank() == 1) {
					int ace = Integer.parseInt(JOptionPane.showInputDialog("ACE입니다! 1 or 11 중 선택하세요."));
					player.playerSum(ace);
					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), (i *10) + 80); // i * 10
					System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "ACE");
				}
				else if(pcards[i].getRank() == 11) {
					int ace = 10;
					player.playerSum(ace);
					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), (i *10) + 80);
					System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "JACK");
				}
				else if(pcards[i].getRank() == 12) {
					int ace = 10;
					player.playerSum(ace);
					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), (i *10) + 80);
					System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "QUEEN");
				}
				else if(pcards[i].getRank() == 13) {
					int ace = 10;
					player.playerSum(ace);
					writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), (i *10) + 80);
					System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "KING");
				}
			}
			else {
				int a = pcards[pcards.length - 1].getRank();
				player.playerSum(a);
				writer.board_distributor(getGraphics(), pcards[i].getSuit(), pcards[i].getRank(), (i *10) + 80);
				System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + pcards[i].getRank());
			}
		}
		System.out.println();		
	}
	
	/**hitDealer - 딜러 합 16 이하일 경우 자동으로 카드 패 수령
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
						System.out.println("합이 16 이하입니다. 추가 패를 받습니다\n" +" Dealer의 패 : " + dcards[i].getSuit() + " " + "ACE");
					}
					else if(dcards[i].getRank() == 11) {
						int a = 10;
						dealer.dealerSum(a);
						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), (i *10) + 65);
						System.out.println("합이 16 이하입니다. 추가 패를 받습니다\n" +" Dealer의 패 : " + dcards[i].getSuit() + " " + "JACK");
					}
					else if(dcards[i].getRank() == 12) {
						int a = 10;
						dealer.dealerSum(a);
						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), (i *10) + 65);
						System.out.println("합이 16 이하입니다. 추가 패를 받습니다\n" +" Dealer의 패 : " + dcards[i].getSuit() + " " + "QUEEN");
					}
					else if(dcards[i].getRank() == 13) {
						int a = 10;
						dealer.dealerSum(a);
						writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), (i *10) + 65);
						System.out.println("합이 16 이하입니다. 추가 패를 받습니다\n" +" Dealer의 패 : " + dcards[i].getSuit() + " " + "KING");
					}
				}
				else {
					int a = dcards[dcards.length - 1].getRank();
					dealer.dealerSum(a);
					writer.board_distributor_dealer(getGraphics(), dcards[i].getSuit(), dcards[i].getRank(), (i *10) + 65);
					System.out.println();					
					System.out.println("합이 16 이하입니다. 추가 패를 받습니다\n" +" Dealer의 패 : " + dcards[i].getSuit() + " " + dcards[i].getRank());
				}		
			}
		}
	}
	
	/**finishGame - 플레이어와 딜러 포인트 받아서 게임 결과 결정
	 * 
	 */
	public void finishGame() {
		
		if(player.pp_value() > 21 || dealer.dp_value() > 21) {
			if(player.pp_value() > 21 && dealer.dp_value() > 21) {
				writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
				System.out.println();
				System.out.println("player 합 : " +  player.pp_value());
				System.out.println("dealer 합 : " +  dealer.dp_value());
				System.out.println("Draw!");
				
			}
			else if( player.pp_value() > 21 && dealer.dp_value() < 21) {
				writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
				System.out.println();
				System.out.println("player 합 : " +  player.pp_value());
				System.out.println("dealer 합 : " +  dealer.dp_value());
				System.out.println("Burst! Dealer win!");
				
			}
			else if(player.pp_value() < 21 && dealer.dp_value() > 21) {
				writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
				System.out.println();
				System.out.println("player 합 : " +  player.pp_value());
				System.out.println("dealer 합 : " +  dealer.dp_value());
				System.out.println("Burst! Player win!");
				
			}
		}
		else {
			if(player.pp_value() > dealer.dp_value()) {
				writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
				System.out.println();
				System.out.println("player 합 : " +  player.pp_value());
				System.out.println("dealer 합 : " +  dealer.dp_value());
				System.out.println("Player win!");
				
			}
			else if(player.pp_value() < dealer.dp_value()) {
				writer.board_finishPart(getGraphics(), player.pp_value(), dealer.dp_value());
				System.out.println();
				System.out.println("player 합 : " +  player.pp_value());
				System.out.println("dealer 합 : " +  dealer.dp_value());
				System.out.println("Dealer win!");
			}
				
		}
		
	}
	
}
