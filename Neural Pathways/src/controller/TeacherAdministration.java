package controller;
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
	public ArrayList<String> getStudentsNames(){
		ArrayList<String> temp = new ArrayList<String>();
    	for (int i = 0; i < 3; i++) {
    		temp.add("Johnney");
    	}
		return temp;
	}	
	public ArrayList<Trivia> getQuizzes(){
		return quizzes;
	}
	public ArrayList<Integer> getQuizID(){
		ArrayList<Integer> temp = new ArrayList<Integer>();
    	for (int i = 0; i < 3; i++) {
    		temp.add(i);
    	}
		return temp;
	}	
	
	public ArrayList<Step> getMistakes(int student) {
		return students.get(student).getIncorrectSteps();
	}
	
	public void addStudent(String name) {
		Student newStudent = new Student(name);
		students.add(newStudent);
	}
	
	public void calculateStudentScore(int student) {
		
	}
}
