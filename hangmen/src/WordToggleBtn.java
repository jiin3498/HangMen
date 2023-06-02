import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

public class WordToggleBtn extends JToggleButton {
	
	public WordToggleBtn(String name) {
		setText(name);
		setBackground(Color.LIGHT_GRAY);
		setSize(30, 30);
		setFont(new Font("맑은고딕", Font.BOLD, 20));
		addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand()); // 누른 버튼이 뭔지 출력됨
				setEnabled(false);
			}
		});
	}

}
