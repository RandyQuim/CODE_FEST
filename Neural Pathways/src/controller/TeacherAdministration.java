package controller;
import java.util.ArrayList;
import database.DatabaseOperations;
import database.StudentTable;

public class TeacherAdministration {

	private ArrayList<Student> students;
	private ArrayList<Trivia> quizzes;
	StudentTable studentTable;
	
	public TeacherAdministration() {
		this.students = new ArrayList<Student>();
		this.quizzes = new ArrayList<Trivia>();
		studentTable = new StudentTable();
		pullFromDatabase();
		
	}
	
	public void pullFromDatabase() {
		String row[];
		String listofmistakes[];
		ArrayList<String> mistakes = new ArrayList<String>();
		int count = 0;
		new DatabaseOperations();
		DatabaseOperations.connectToDB();
		for(int i = 1; i <= 5; i++) {
			row = studentTable.retrieveTableRow("StudentTable", i).split("\\r?\\n");
			for (String line : row) {
	            System.out.println("line " + count++ + " : " + line);
	        }
			listofmistakes = row[3].split("~");
			for(String a : listofmistakes) {
				mistakes.add(a);
			}
			addStudent(row[0],mistakes,Integer.parseInt(row[3]));
			mistakes.clear();
		}
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
	
	public void addStudent(String name, ArrayList<String> mistakes, int score) {
		Student newStudent = new Student(name);
		for(String a : mistakes) {
			newStudent.addIncorrectStep(a);
		}
		newStudent.setScore(score);
		students.add(newStudent);
	}
	
	public void calculateStudentScore(int student) {
		
	}
}
