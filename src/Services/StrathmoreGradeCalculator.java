package Services;

import Models.IGradeCalculator;

public class StrathmoreGradeCalculator implements IGradeCalculator {
    @Override
    public char calculateGrade(double average) {
        if(average >= 70) return 'A';
        else if(average >= 60) return 'B';
        else if(average >= 50) return 'C';
        else if(average >= 40) return 'D';
        else return 'F';
    }
}
