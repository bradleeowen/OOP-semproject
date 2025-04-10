import Models.IGradeCalculator;
import Models.ReportCard;
import Models.Student;
import Services.ExamProcessor;
import Services.StrathmoreGradeCalculator;
import Services.UniversityExamProcessor;
import java.util.Scanner;

public class Main {
    private static final String[] SUBJECTS = {
            "Integral Calculus", "Differential Calculus", "OOP",
            "Advanced OOP", "Computer Networks", "Operations Research"
    };

    public static void main(String[] args) {

        IGradeCalculator gradeCalculator = new StrathmoreGradeCalculator();
        ExamProcessor examProcessor = new UniversityExamProcessor(SUBJECTS, gradeCalculator);

        Student[] students = createStudents();

        enterStudentMarks(students);

        examProcessor.processResults(students);

        displayReportCards(students);
    }

    private static Student[] createStudents() {
        String[] names = {
                "Joseph Kamau", "Bernard Kiprop", "Andy Mwangi", "Onesmus Achieng",
                "James Atieno", "John Nyambura", "Jake Omondi", "Harry Kipchoge",
                "Ethan Odhiambo", "Kelvin Muthoni"
        };

        Student[] students = new Student[10];
        for(int i = 0; i < students.length; i++) {
            students[i] = new Student(names[i], "15014" + i, SUBJECTS.length);
        }
        return students;
    }

    private static void enterStudentMarks(Student[] students) {
        Scanner scanner = new Scanner(System.in);

        for(Student student : students) {
            System.out.println("\nEntering marks for " + student.getName());

            for(int i = 0; i < SUBJECTS.length; i++) {
                System.out.print(SUBJECTS[i] + ": ");
                int mark = scanner.nextInt();
                student.setMark(i, mark);
            }
        }
    }

    private static void displayReportCards(Student[] students) {
        System.out.println("\n\n=== EXAMINATION RESULTS ===");
        for(Student student : students) {
            ReportCard report = new ReportCard(student);
            System.out.println(report.getFormattedReport());
            System.out.println("--------------------------");
        }
    }
}