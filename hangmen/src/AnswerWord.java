

// 정답 배열을 저장하고, 생성하는 클래스
public class AnswerWord {
	
	private String[] answers = {"apple", "banana", "grape"};
	
	public String getAnswer() {
		int ran = (int)(Math.random() * answers.length);
		
		return answers[ran];
	}

}
