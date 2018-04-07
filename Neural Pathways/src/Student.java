import java.util.ArrayList;

public class Student {

	private int score;
	private ArrayList<Step> incorrectSteps;
	private String name;
	private String pass;

	public Student(String aName, String aPass) {

		this.name = aName;
		this.pass = aPass;
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

	/*
	 * public String getPass() { return pass; }
	 */

	public void addIncorrectStep(Step step) {
		incorrectSteps.add(step);
	}

	public ArrayList<Step> getIncorrectSteps() {
		return incorrectSteps;
	}

	public boolean authentication(String userName, String password) {
		String userData = "";
		String[] splitRow;
		for (int i = 1; i <= 3; /* (database.retrieveNumberOfRowsInTable() */ i++) {
			userData = "Mikey\npassword\n50"; // database.retrieveTableRow(database.TableName,
												// i);
			splitRow = userData.split("\n");
			if (splitRow[1].equals(userName) && splitRow[2].equals(password)) {
				name = splitRow[1];
				pass = splitRow[2];
				score = Integer.parseInt(splitRow[3]);
				return true;
			}
		}

		return false;
	}

}
