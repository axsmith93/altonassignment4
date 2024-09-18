package altonassignment4;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) {

		File masterListFile = new File(
				"C:\\Users\\PhantomX\\Desktop\\bootcamp workspace\\eclipse\\altonassignment4\\student-master-list.csv");

		try (BufferedReader reader = new BufferedReader(new FileReader(masterListFile))) {
			String line;
			List<Student> students = new ArrayList<>();

			reader.readLine();

			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 4) {
					try {

						Student student = new Student(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
						students.add(student);
					} catch (NumberFormatException e) {

						System.err.println("Error parsing grade: " + e.getMessage() + " in line: " + line);
					}
				} else {

					System.err.println("Invalid line format: " + line);
				}
			}

			List<Student> course1Students = new ArrayList<>();
			List<Student> course2Students = new ArrayList<>();
			List<Student> course3Students = new ArrayList<>();

			for (Student student : students) {
				if (student.getCourse().startsWith("COMPSCI")) {
					course1Students.add(student);
				} else if (student.getCourse().startsWith("APMTH")) {
					course2Students.add(student);
				} else if (student.getCourse().startsWith("STAT")) {
					course3Students.add(student);
				}
			}

			Collections.sort(course1Students, new GradeComparator());
			Collections.sort(course2Students, new GradeComparator());
			Collections.sort(course3Students, new GradeComparator());

			System.out.println("course1.csv\n");
			printAndWriteStudents(course1Students, "course1.csv");

			System.out.println("\ncourse2.csv\n");
			printAndWriteStudents(course2Students, "course2.csv");

			System.out.println("\ncourse3.csv\n");
			printAndWriteStudents(course3Students, "course3.csv");

		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
		}
	}

	private static void printAndWriteStudents(List<Student> students, String filename) throws IOException {
		FileWriter writer = new FileWriter(filename);
		writer.write("Student ID,Student Name,Course,Grade\n");
		System.out.println("Student ID,Student Name,Course,Grade");

		for (Student student : students) {
			String line = student.getStudentID() + "," + student.getStudentName() + "," + student.getCourse() + ","
					+ student.getGrade();
			writer.write(line + "\n");
			System.out.println(line);
		}

		writer.close();
	}
}