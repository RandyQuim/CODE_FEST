import java.util.ArrayList;
import java.util.Random;

public class TriviaManager {
	private Question question;
	private Random rand;
	private String[] split;
	//private Database database;
	private int counter;
	private Student student;

	public TriviaManager() {
		this.question = new Question();
		this.rand = new Random();
		//this.database = new Database();
		this.counter = 0;
	}

	private int randomGenerator() {
		int randomNum = rand.nextInt(1) + 1;  // (database.retrieveNumberOfRowsInTable()) + 1;
        return randomNum;
	}

	public Question getRandomQuestion() {
		int n = randomGenerator();
		setStepRowFields(n); // sets the string SpliTarray of row
		fillQuestionData();  // sets question string and then fills step and answer arrays
		return question; // returns question object with all the above data now (gunna use it NOT for answer array though)
	}

	public void fillQuestionData() {
		//question.setQuestion(database.RetrieveQuestionTableRow("Question Table", identification));
		fillStepData();
	}

	private void fillStepData() {
		for (int i = 1; i < split.length; i++) {
			question.addStep(split[i]);
			i++;
			question.addAnswer(split[i]);
		}
	}

	private void setStepRowFields(int rowNumber) {
		// String retrieveRow = database.RetrieveStepTableRow(database.TableName, rowNumber);  // grabs the row of steps and answers
		// split = retrieveRow.split("\n");

	}

	public boolean evaluateAnswer(String answer) {
		if (question.getAnswers().get(counter).getAnswer().equals(answer)) {
			return true;
		} else {
			student.addIncorrectStep(question.getSteps().get(counter));
			return false;
		}
	}

	public void setStudent(Student student) {  /////////////////////////////////////////
		this.student = student;
	}

	public void insertQuestion() {
		question.setID(String.valueOf(counter));
		ArrayList<String> dataEntry = new ArrayList<String>();
		dataEntry.add(question.getID());
		dataEntry.add(question.getQuestion());
		dataEntry.add("Find the X Value in the following equation.");
		for (int i = 0; i < 5; i++) {
			dataEntry.add(question.getSteps().get(i).getStep());
			dataEntry.add(question.getAnswers().get(i).getAnswer());
		}

		dataEntry.add("X = 53/3");

	//	QuestionTable QT = new QuestionTable();
	//	insertRowIntoTable(Qt.TableName, dataEntry);
	}

}
