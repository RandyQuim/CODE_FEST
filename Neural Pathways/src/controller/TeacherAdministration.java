package controller;
import java.util.ArrayList;


public class TeacherAdministration {

	private ArrayList<Student> students;
	private ArrayList<Trivia> quizzes;
	
	public TeacherAdministration() {
		this.students = new ArrayList<Student>();
		this.quizzes = new ArrayList<Trivia>();
		addStudent("Louis");
		students.get(0).addIncorrectStep("Question 1 Step 2");
		addStudent("Chris");
		students.get(1).addIncorrectStep("Question 1 Step 4");
		addStudent("Tim");
		students.get(2).addIncorrectStep("Question 2 Step 1");
		addStudent("Daniel");
		students.get(3).addIncorrectStep("Question 2 Step 3");
		addStudent("Randy");
	}
	
	public Student getStudent(int index){
		return students.get(index);
	}
	
	public ArrayList<String> getStudentsNames(){
		ArrayList<String> temp = new ArrayList<String>();
    	for (Student s : students) {
    		temp.add(s.getName());
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
	
	public ArrayList<String> getMistakes(int student) {
		return students.get(student).getIncorrectSteps();
	}
	
	public void addStudent(String name) {
		Student newStudent = new Student(name);
		students.add(newStudent);
	}
	
	public void calculateStudentScore(int student) {
		
	}
}
