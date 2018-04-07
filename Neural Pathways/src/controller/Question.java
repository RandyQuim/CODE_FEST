package controller;
import java.util.ArrayList;

public class Question {
	private ArrayList<Step> steps;
	private ArrayList<Answer> answers;
	private String question;
	private String iD;  // Do I need an ID????????????????

	public Question() {
		this.steps = new ArrayList<Step>();
		this.answers = new ArrayList<Answer>();
		this.question = "";
		this.iD = "";
	}

	public ArrayList<Step> getSteps() {
		return steps;
	}

	public void addStep(String step) {
		Step tmp = new Step();
		tmp.setStep(step);
		steps.add(tmp);
	}

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public void addAnswer(String answer) {
		Answer tmp = new Answer();
		tmp.setAnswer(answer);
		answers.add(tmp);
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getID() {
		return iD;
	}

	public void setID(String iD) {
		this.iD = iD;
	}

}
