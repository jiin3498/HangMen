

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HangMenMain extends JFrame {
	
	AnswerWord answerWord = new AnswerWord();
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangMenMain frame = new HangMenMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HangMenMain() {		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mainNameLabel = new JLabel("단어 맞추기 게임");
		mainNameLabel.setBounds(197, 384, 795, 68);
		mainNameLabel.setVerticalAlignment(SwingConstants.TOP);
		mainNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		mainNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(mainNameLabel);
		
		JButton startButton = new JButton("게임 시작");
		startButton.setBounds(354, 500, 473, 136);
		startButton.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		startButton.setBackground(new Color(255, 128, 192));
		startButton.setForeground(new Color(255, 255, 255));
		startButton.setBorderPainted(false);
		startButton.setFocusPainted(false);
		contentPane.add(startButton);
		
		startButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Game game = new Game();
				game.setVisible(true);
				setVisible(false); // 창 안보이게 하기
			}
		});
		
		JLabel mainimageLabel = new JLabel();
		try {
			mainimageLabel.setIcon(new ImageIcon(ImageIO.read(new File("image/행맨1.jpg")).getScaledInstance(430, 290, Image.SCALE_AREA_AVERAGING)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		mainimageLabel.setBounds(369, 69, 430, 290);
		contentPane.add(mainimageLabel);
	}
}
