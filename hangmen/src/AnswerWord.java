

// 정답 배열을 저장하고, 생성하는 클래스
public class AnswerWord {
	
	private String[] answers = {"APPLE", "BANANA", "GRAPE", "ORANGE", "CHERRY", "AVOCADO"};
	
	public String getAnswer() {
		int ran = (int)(Math.random() * answers.length);
		
		return answers[ran];
	}

}
