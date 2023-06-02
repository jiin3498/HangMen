import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class Game extends JFrame {
	
	public static boolean isanswer = false;
	public static String answer;
	
	private JPanel contentPane;
	private JTextField usertextField;
	
	private JToggleButton[] words = new JToggleButton[27];
	private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
								 "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
								 "U", "V", "W", "X", "Y", "Z"};
	
	CardLayout cards = new CardLayout();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Game() {
		// 게임을 새로 시작할 때 마다 새로운 정답이 생성됨
		AnswerWord word = new AnswerWord();
		answer = word.getAnswer();
		
		// 기본 셋팅
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		// 메인 패널
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		// 맨 위 찬스
		JLabel chanceLabel = new JLabel("Chance");
		chanceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		chanceLabel.setBounds(23, 10, 78, 26);
		contentPane.add(chanceLabel);	
		
		// 오른쪽 - 아이스크림 사진 패널
		JPanel icecreamPanel = new JPanel();
		icecreamPanel.setBackground(new Color(255, 255, 255));
		icecreamPanel.setBounds(587, 92, 580, 590);
		icecreamPanel.setLayout(cards);
		contentPane.add(icecreamPanel);
		
		JPanel first_icecream = new JPanel();
		first_icecream.setBackground(Color.white);
		JPanel second_icecream = new JPanel();
		second_icecream.setBackground(Color.white);
		JPanel third_icecream = new JPanel();
		third_icecream.setBackground(Color.white);
		JPanel fourth_icecream = new JPanel();
		fourth_icecream.setBackground(Color.white);
		JPanel fifth_icecream = new JPanel();
		fifth_icecream.setBackground(Color.white);
		JPanel sixth_icecream = new JPanel();
		sixth_icecream.setBackground(Color.white);
		JPanel seventh_icecream = new JPanel();
		seventh_icecream.setBackground(Color.white);
		JPanel eighth_icecream = new JPanel();
		eighth_icecream.setBackground(Color.white);
		
		JLabel icecream_1 = new JLabel();
		JLabel icecream_2 = new JLabel();
		JLabel icecream_3 = new JLabel();
		JLabel icecream_4 = new JLabel();
		JLabel icecream_5 = new JLabel();
		JLabel icecream_6 = new JLabel();
		JLabel icecream_7 = new JLabel();
		JLabel icecream_8 = new JLabel();
		
		try {
			icecream_1.setIcon(new ImageIcon(ImageIO.read(new File("image/행맨1.jpg")).getScaledInstance(580, 600, Image.SCALE_AREA_AVERAGING)));
			icecream_2.setIcon(new ImageIcon(ImageIO.read(new File("image/행맨2.jpg")).getScaledInstance(580, 600, Image.SCALE_AREA_AVERAGING)));
			icecream_3.setIcon(new ImageIcon(ImageIO.read(new File("image/행맨3.jpg")).getScaledInstance(580, 600, Image.SCALE_AREA_AVERAGING)));
			icecream_4.setIcon(new ImageIcon(ImageIO.read(new File("image/행맨4.jpg")).getScaledInstance(580, 600, Image.SCALE_AREA_AVERAGING)));
			icecream_5.setIcon(new ImageIcon(ImageIO.read(new File("image/행맨5.jpg")).getScaledInstance(580, 600, Image.SCALE_AREA_AVERAGING)));
			icecream_6.setIcon(new ImageIcon(ImageIO.read(new File("image/행맨6.jpg")).getScaledInstance(580, 600, Image.SCALE_AREA_AVERAGING)));
			icecream_7.setIcon(new ImageIcon(ImageIO.read(new File("image/승리.jpg")).getScaledInstance(580, 600, Image.SCALE_AREA_AVERAGING)));
			icecream_8.setIcon(new ImageIcon(ImageIO.read(new File("image/패배.jpg")).getScaledInstance(580, 600, Image.SCALE_AREA_AVERAGING)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		first_icecream.add(icecream_1);
		second_icecream.add(icecream_2);
		third_icecream.add(icecream_3);
		fourth_icecream.add(icecream_4);
		fifth_icecream.add(icecream_5);
		sixth_icecream.add(icecream_6);
		seventh_icecream.add(icecream_7);
		eighth_icecream.add(icecream_8);
				
		icecreamPanel.add(first_icecream, "1");
		icecreamPanel.add(second_icecream, "2");
		icecreamPanel.add(third_icecream, "3");
		icecreamPanel.add(fourth_icecream, "4");
		icecreamPanel.add(fifth_icecream, "5");
		icecreamPanel.add(sixth_icecream, "6");
		icecreamPanel.add(seventh_icecream, "7");
		icecreamPanel.add(eighth_icecream, "8");		
		
		// 왼쪽 아래 - 키보드 패널
		JPanel wordpanel = new JPanel();
		wordpanel.setBackground(new Color(255, 255, 255));
		wordpanel.setBounds(12, 498, 563, 238);
		wordpanel.setLayout(new GridLayout(3, 9, 10, 10));
		contentPane.add(wordpanel);
		
		for (int i = 0; i < words.length - 1; ++i) {
			words[i] = new WordToggleBtn(alphabet[i]);
			wordpanel.add(words[i]);
		}
		
		JLabel usertextLabel = new JLabel("정답");
		usertextLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		usertextLabel.setBounds(17, 432, 99, 48);
		contentPane.add(usertextLabel);
		
		usertextField = new JTextField();
		usertextField.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		usertextField.setBounds(124, 434, 260, 48);
		contentPane.add(usertextField);
		usertextField.setColumns(10);
		
		JButton chkButton = new JButton("확인");
		chkButton.setForeground(new Color(255, 255, 255));
		chkButton.setBackground(new Color(255, 128, 192));
		chkButton.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		chkButton.setBounds(396, 435, 118, 48);
		contentPane.add(chkButton);
		
		// 왼쪽 중앙 - 정답 출력되는 패널
		JLabel notionLabel = new JLabel("영단어를 맞춰보세요!");
		notionLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		notionLabel.setBounds(23, 155, 234, 35);
		contentPane.add(notionLabel);
		
		JPanel answerPanel = new JPanel();
		answerPanel.setBackground(new Color(255, 255, 255));
		answerPanel.setBounds(23, 200, 545, 200);
		answerPanel.setLayout(new FlowLayout());
		contentPane.add(answerPanel);		
		// 정답 수에 맞춰서 버튼이 출력됨
		JButton[] answerChar = new JButton[answer.length()];
		for (int i = 0; i < answer.length(); ++i) {
			answerChar[i] = new JButton("             ");
			answerChar[i].setSize(100, 300);
			answerChar[i].setEnabled(false);
			answerPanel.add(answerChar[i]);
		}	
		
	}
}
