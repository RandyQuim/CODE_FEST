import java.util.ArrayList;

public class Student {

	private int score;
	private ArrayList<Step> incorrectSteps;
	private String name;
	//private String pass;
	
	public Student(String aName/*, String aPass*/) {
		
		this.name = aName;
		//this.pass = aPass;
		this.incorrectSteps = new ArrayList<Step>();
		
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
	
	public void addIncorrectStep(Step step) {
		incorrectSteps.add(step);
	}
	
	public ArrayList<Step> getIncorrectSteps(){
		return incorrectSteps;
	}
}
