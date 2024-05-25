package GradeCalculator.application;

import GradeCalculator.database.Database;
import GradeCalculator.menu.Menu;

import java.io.IOException;


public class Application
{
    public static void main(String[] args) throws IOException
    {
        var app = new Application();
    }

    public Application()
    {
        Database db = new Database();
        var window = new Menu();
    }
}