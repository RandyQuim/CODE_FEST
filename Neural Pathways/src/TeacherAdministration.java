import java.util.ArrayList;

import controller.TriviaManager;


public class TeacherAdministration {

	private ArrayList<Student> students;
	private ArrayList<TriviaManager> quizzes;
	//private Database database;

	public TeacherAdministration() {
		this.students = new ArrayList<Student>();
		this.quizzes = new ArrayList<TriviaManager>();
	}

	public ArrayList<Student> getStudents(){
		return students;
	}

	public ArrayList<TriviaManager> getQuizzes(){
		return quizzes;
	}

	public ArrayList<Step> getMistakes(int student) {
		return storeMistakes(students.get(student).getIncorrectSteps()); // how connect students to mistakes and what is this doing?
	}

	private ArrayList<Step> storeMistakes(ArrayList<Step> mistakes) {
	// database.insertRowIntoTable(mistakes);
		return mistakes;
	}

	public void addStudent(Student student) {
		/////////////  DEFINATELY NEED student here from previous!!!
		students.add(student);
	}

	public void calculateStudentScore(int student) {

	}
}
