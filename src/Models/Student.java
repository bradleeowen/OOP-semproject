package Models;

public class Student {
    private String name;
    private String id;
    private int[] marks;
    private double average;
    private char grade;

    public Student(String name, String id, int subjectCount) {
        this.name = name;
        this.id = id;
        this.marks = new int[subjectCount];
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public int[] getMarks() { return marks; }
    public double getAverage() { return average; }
    public char getGrade() { return grade; }

    public void setMark(int subjectIndex, int mark) {
        if(subjectIndex >= 0 && subjectIndex < marks.length) {
            marks[subjectIndex] = mark;
        }
    }

    public void setAverage(double average) { this.average = average; }
    public void setGrade(char grade) { this.grade = grade; }
}