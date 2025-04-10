package Models;  // Changed to lowercase 'm' to match conventional naming

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportCard extends Student {
    private String recommendation;
    private final String reportDate;

    public ReportCard(Student student) {
        // Make sure Student class has this exact constructor
        super(student.getName(), student.getId(), student.getMarks().length);

        // Initialize fields after calling super()
        this.recommendation = generateRecommendation(student.getGrade());
        this.reportDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        // Copy marks from student to this object
        System.arraycopy(student.getMarks(), 0, this.getMarks(), 0, student.getMarks().length);
        this.setAverage(student.getAverage());
        this.setGrade(student.getGrade());
    }

    // Traditional switch statement for broader Java compatibility
    private String generateRecommendation(char grade) {
        switch (grade) {
            case 'A': return "Excellent performance!";
            case 'B': return "Good work!";
            case 'C': return "Satisfactory";
            case 'D': return "Needs improvement";
            default: return "Fail - Retake required";
        }
    }

    public String getFormattedReport() {
        return String.format(
                "REPORT CARD - %s\n" +
                        "Student: %s (%s)\n" +
                        "Average: %.1f\n" +
                        "Grade: %c\n" +
                        "Recommendation: %s\n" +
                        "Date: %s\n",
                getName(), getName(), getId(), getAverage(), getGrade(), recommendation, reportDate
        );
    }
}
