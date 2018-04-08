package controller;
import java.util.ArrayList;

public class Student {

	private int score;
	private ArrayList<String> incorrectSteps;
	private String name;
	private String pass;

	public Student(String aName) {

		this.name = aName;
		this.incorrectSteps = new ArrayList<String>();
		this.score = 0;
		this.pass = "";

	}

	public int getScore() {
		return score;
	}

	public void setScore(int aScore) {
		this.score = aScore;
	}

	public String getName() {
		return name;
	}

	/*public String getPass() {
		return pass;
	}*/

	public void addIncorrectStep(String step) {
		incorrectSteps.add(step);
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public ArrayList<String> getIncorrectSteps(){
		return incorrectSteps;
	}

}
