package GradeCalculator.application;


import GradeCalculator.database.Database;
import GradeCalculator.menu.Menu;

import java.io.IOException;

public class Application
{
    public static void main(String[] args) throws IOException
    {
        var app = new Application();
        Database db = new Database("grades.txt");
        db.readFile("grades.txt");
        db.printVector();
        System.out.println("Durchschnitt: " + db.calculateAverage());
        System.out.println("Positiv: " + db.isPositive());
    }

    public Application()
    {
        Database db = new Database("grades.txt");
        var window = new Menu();
    }
}