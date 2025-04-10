package Services;

import Models.Student;

public abstract class ExamProcessor {
    protected final String[] subjects;

    public ExamProcessor(String[] subjects) {
        this.subjects = subjects;
    }

    public abstract void processResults(Student[] students);

    protected double calculateAverage(int[] marks) {
        int sum = 0;
        for(int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }
}
