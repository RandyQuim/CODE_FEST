package controller;
import java.util.ArrayList;

import database.StudentTable;

public class Authentication {

	public boolean authentication(String userName, String password) {
		StudentTable ST = new StudentTable();
		String userData = "";
		String[] splitRow;

		for (int i = 1; i <= ST.retrieveNumberOfRowsInTable(); i++) {
			userData = ST.retrieveTableRow(ST.getTableName(), i);
			splitRow = userData.split("\\r?\\n");

			if (splitRow[1].equals(userName) && splitRow[2].equals(password)) {
				Student student = new Student(userName);
				student.setPass(password);
				TriviaManager tM =  new TriviaManager();
				tM.setStudent(student);
				student.setScore(Integer.parseInt(splitRow[4]));
				return true;
			}
		}

		return false;
	}

}
