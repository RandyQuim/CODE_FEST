import java.util.ArrayList;


public class TeacherAdministration {

	private ArrayList<Student> students;
	private ArrayList<Trivia> quizzes;
	
	public TeacherAdministration() {
		this.students = new ArrayList<Student>();
		this.quizzes = new ArrayList<Trivia>();
	}
	
	public ArrayList<Student> getStudents(){
		return students;
	}
	
	public ArrayList<Trivia> getQuizzes(){
		return quizzes;
	}
	
	
	public ArrayList<Step> getMistakes(int student) {
		return students.get(student).getIncorrectSteps();
	}
	
	public void addStudent(String name) {
		//Student newStudent = new Student(name);
		//students.add(newStudent);
	}
	
	public void calculateStudentScore(int student) {
		
	}
}
