import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;

public class Win extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Win(String answer) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel icecreamPanel = new JPanel();
		icecreamPanel.setBackground(new Color(255, 255, 255));
		icecreamPanel.setBounds(587, 28, 580, 523);
		getContentPane().add(icecreamPanel);
		
		JLabel lose = new JLabel();
		
		try {
			lose.setIcon(new ImageIcon(ImageIO.read(new File("image/행맨_win.jpg")).getScaledInstance(580, 520, Image.SCALE_AREA_AVERAGING)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		icecreamPanel.add(lose);
		
		JButton btnNewButton = new JButton("다시하기");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 128, 192));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 90));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(46, 272, 502, 210);
		btnNewButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				HangMenMain hangmen = new HangMenMain();
				hangmen.setVisible(true);
				setVisible(false); // 기존 창 안보이게 하기				
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("성공!!");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(178, 28, 218, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(answer);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		lblNewLabel_1.setBounds(58, 104, 467, 119);
		contentPane.add(lblNewLabel_1);

	}
}
