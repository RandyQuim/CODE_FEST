
public class Authentication {

	public boolean authentication(String userName, String password) {
		String userData = "";
		String[] splitRow;
		for (int i = 1; i <= 3; /* (database.retrieveNumberOfRowsInTable() */ i++) {
			userData = "Mikey\npassword\n50"; // database.retrieveTableRow(database.TableName,
												// i);
			splitRow = userData.split("\n");
			if (splitRow[0].equals(userName) && splitRow[1].equals(password)) {
				Student student = new Student(userName, password);
				TriviaManager tM =  new TriviaManager();
				tM.setStudent(student);
				student.setScore(Integer.parseInt(splitRow[2]));
				return true;
			}
		}

		return false;
	}

}
