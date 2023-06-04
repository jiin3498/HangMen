import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

public class Game extends JFrame implements ActionListener {
	
	private String answer; // 정답 단어
	private int chance = 6; // 기회는 6
	private JLabel notionLabel, userWordLabel;
	
	private JPanel contentPane, icecreamPanel, wordpanel, answerPanel;
	private JButton[] answerChar;
	
	private JToggleButton[] words = new JToggleButton[27];
	private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
								 "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
								 "U", "V", "W", "X", "Y", "Z"};
	
	private CardLayout cards = new CardLayout();
	
	private StringBuilder sb = new StringBuilder();

	public Game() {
		// 게임을 새로 시작할 때 마다 새로운 정답이 생성됨
		AnswerWord word = new AnswerWord();
		answer = word.getAnswer();
		
//		System.out.println(answer);
		
		// 기본 디자인 셋팅
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		
		// 메인 패널
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		// 왼쪽 중앙 - 정답 표출 패널
		answerPanel = new JPanel();
		answerPanel.setBackground(new Color(255, 255, 255));
		answerPanel.setBounds(12, 55, 563, 166);
		answerPanel.setLayout(new FlowLayout());
		contentPane.add(answerPanel);
		
		// 정답인지 아닌지에 따라 라벨 변경
		notionLabel = new JLabel("영단어를 맞춰보세요!");
		notionLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		notionLabel.setBounds(22, 10, 234, 35);
		contentPane.add(notionLabel);
		
		// 정답 수에 맞춰서 버튼이 출력됨
		answerChar = new JButton[answer.length()];
		for (int i = 0; i < answer.length(); ++i) {
			answerChar[i] = new JButton();
			answerChar[i].setFont(new Font("맑은 고딕", Font.PLAIN, 20));
			answerChar[i].setBackground(Color.LIGHT_GRAY);
			answerPanel.add(answerChar[i]);
		}
		
		
		// 오른쪽 - 아이스크림 사진 패널
		icecreamPanel = new JPanel();
		icecreamPanel.setBackground(new Color(255, 255, 255));
		icecreamPanel.setBounds(587, 60, 580, 480);
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
		
		JLabel icecream_1 = new JLabel();
		JLabel icecream_2 = new JLabel();
		JLabel icecream_3 = new JLabel();
		JLabel icecream_4 = new JLabel();
		JLabel icecream_5 = new JLabel();
		JLabel icecream_6 = new JLabel();
		
		try {
			icecream_1.setIcon(new ImageIcon(ImageIO.read(new File("image/행맨1.jpg")).getScaledInstance(800, 550, Image.SCALE_AREA_AVERAGING)));
			icecream_2.setIcon(new ImageIcon(ImageIO.read(new File("image/행맨2.jpg")).getScaledInstance(800, 550, Image.SCALE_AREA_AVERAGING)));
			icecream_3.setIcon(new ImageIcon(ImageIO.read(new File("image/행맨3.jpg")).getScaledInstance(800, 550, Image.SCALE_AREA_AVERAGING)));
			icecream_4.setIcon(new ImageIcon(ImageIO.read(new File("image/행맨4.jpg")).getScaledInstance(800, 550, Image.SCALE_AREA_AVERAGING)));
			icecream_5.setIcon(new ImageIcon(ImageIO.read(new File("image/행맨5.jpg")).getScaledInstance(800, 550, Image.SCALE_AREA_AVERAGING)));
			icecream_6.setIcon(new ImageIcon(ImageIO.read(new File("image/행맨6.jpg")).getScaledInstance(800, 550, Image.SCALE_AREA_AVERAGING)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		first_icecream.add(icecream_1);
		second_icecream.add(icecream_2);
		third_icecream.add(icecream_3);
		fourth_icecream.add(icecream_4);
		fifth_icecream.add(icecream_5);
		sixth_icecream.add(icecream_6);
				
		icecreamPanel.add(first_icecream, "1");
		icecreamPanel.add(second_icecream, "2");
		icecreamPanel.add(third_icecream, "3");
		icecreamPanel.add(fourth_icecream, "4");
		icecreamPanel.add(fifth_icecream, "5");
		icecreamPanel.add(sixth_icecream, "6");	
		
		// 왼쪽 아래 - 키보드 패널
		wordpanel = new JPanel();
		wordpanel.setBackground(new Color(255, 255, 255));
		wordpanel.setBounds(12, 313, 563, 238);
		wordpanel.setLayout(new GridLayout(3, 9, 10, 10));
		contentPane.add(wordpanel);
		
		userWordLabel = new JLabel();
		userWordLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		userWordLabel.setBounds(12, 253, 563, 50);
		contentPane.add(userWordLabel);
		
		JLabel lblNewLabel_1 = new JLabel("사용한 알파벳");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 231, 120, 15);
		contentPane.add(lblNewLabel_1);
		
		for (int i = 0; i < words.length - 1; ++i) {
			words[i] = new JToggleButton(alphabet[i]);
			words[i].setBackground(Color.LIGHT_GRAY);
			words[i].setSize(30, 30);
			words[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
			words[i].addActionListener(this);
			wordpanel.add(words[i]);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String choice = e.getActionCommand();
		
		if (userWordLabel.getText().contains(choice)) {
			JOptionPane.showMessageDialog(null, "이미 사용한 알파벳입니다.");
			return;
		}
		
		if (answer.contains(e.getActionCommand())) { // 정답에 있는 알파벳 입력 시
			for (int i = 0; i < answer.length(); ++i) {
				
				if (answer.contains(choice)) {
					int index = answer.indexOf(choice, answer.indexOf(choice) + i);
					
					if (index != -1) {						
						answerChar[index].setText(choice); // 값이 있으면 버튼 값 바꿈
					}
				}
			}			
			notionLabel.setText("조금만 더 힘을내요!");
			notionLabel.setForeground(Color.GREEN);
			
		} else { // 정답에 없는 알파벳 입력시			
			notionLabel.setText("틀렸습니다!");
			notionLabel.setForeground(Color.red);
			
			chance--; // 기회 -1
			cards.next(icecreamPanel); // 아이스크림 패널 next
		}
		
		sb.append(e.getActionCommand());
		userWordLabel.setText(sb.toString());
		
		if (chance == 0) { // 기회 0이면 게임 종료
			Lose lose = new Lose(answer);
			lose.setVisible(true);
			setVisible(false);
		} else {
			chkWord(); // 기회가 남아 있을 때는 정답인지 체크
		}
	}
	
	// 정답 버튼과 정답 비교하여 확인
	void chkWord() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < answerChar.length; ++i) {
			if (answerChar[i] != null) {
				sb.append(answerChar[i].getText());
			}
		}
		
		if (answer.equals(sb.toString().trim())) {
			Win win = new Win(answer);
			win.setVisible(true);	
		}
	}
}

