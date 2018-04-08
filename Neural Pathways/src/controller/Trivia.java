package controller;
import java.util.ArrayList;
import java.util.Random;

public class Trivia {
	private final int NUMBER_OF_QUESTIONS = 2;
	private ArrayList<Question> questions;
	private Question question;
	private Random rand;
	private String[] split;
//	private Database database;

	public Trivia() {
		this.questions = new ArrayList<Question>();
		this.question = new Question();
		this.rand = new Random();
//		this.database = new Database();
	}

	private int randomGenerator() {
		int randomNum = rand.nextInt(1) + 1;  // (database.retrieveNumberOfRowsInStepTable()) + 1;
        return randomNum;
	}

	public ArrayList<Question> getRandomQuestions() {
		int n = randomGenerator();
		getStepRowFields(n);
		// fillQuestionData(split[0]);  // this is ID in table
		return questions;
	}

	public void fillQuestionData(String iD) {
		int identification = Integer.parseInt(iD);
		getStepRowFields(identification);
		for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
			//question.setQuestion(database.RetrieveQuestionTableRow("Question Table", identification));
			fillStepData(identification);
		}

		questions.add(question);
	}

	private void fillStepData(int identification) {
		for (int i = 0; i < split.length; i++) {
			identification = 1;
			question.addAnswer(split[i]);
			i++;
			question.addStep(split[i]);
		}
	}

	private void getStepRowFields(int rowNumber) {
		// String retrieveRow = database.RetrieveStepTableRow(database.TableName, rowNumber);  // grabs the row of steps and answers
		// split = retrieveRow.split("\n");
	}

}
