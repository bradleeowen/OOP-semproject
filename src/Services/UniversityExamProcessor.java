package Services;

import Models.Student;
import Models.IGradeCalculator;

public class UniversityExamProcessor extends ExamProcessor {
    private final IGradeCalculator gradeCalculator;

    public UniversityExamProcessor(String[] subjects, IGradeCalculator gradeCalculator) {
        super(subjects);
        this.gradeCalculator = gradeCalculator;
    }

    @Override
    public void processResults(Student[] students) {
        for(Student student : students) {
            double average = calculateAverage(student.getMarks());
            char grade = gradeCalculator.calculateGrade(average);

            student.setAverage(average);
            student.setGrade(grade);
        }
    }
}
