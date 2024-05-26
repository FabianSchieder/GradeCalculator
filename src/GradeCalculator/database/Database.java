package GradeCalculator.database;

import java.util.Vector;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class Database
{
    private static String path;
    private static Vector<String> m_subjects;
    private static Vector<Float> m_grades;

    public Database(String inputPath)
    {
        m_subjects = new Vector<>();
        m_grades = new Vector<>();
        path = inputPath;
    }

    public static void addSubject(String name, Float grade)
    {
        m_subjects.add(name);
        m_grades.add(grade);
    }

    public static void writeFile() throws IOException
    {
        FileWriter writer = new FileWriter(path, false); // false to overwrite the file

        for (int i = 0; i < m_subjects.size(); i++)
        {
            writer.write(m_subjects.get(i) + "\n");
            writer.write(m_grades.get(i) + "\n");
        }

        writer.close();
    }

    public static void readFile(String filename) throws IOException
    {
        FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        boolean isSubject = true;

        while((line = bufferedReader.readLine()) != null)
        {
            if (isSubject)
            {
                m_subjects.add(line);
                isSubject = false;
            }
            else
            {
                m_grades.add(Float.parseFloat(line));
                isSubject = true;
            }
        }

        reader.close();
    }

    public static void printVector()
    {
        for(int i = 0; i < m_grades.size(); i++)
        {
            System.out.println(m_subjects.get(i) + ": " + m_grades.get(i));
        }
    }

    public static void setGrade(String subject, float grade)
    {
        for (int i = 0; i < m_subjects.size(); i++)
        {
            if (m_subjects.get(i).equals(subject))
            {
                m_grades.set(i, grade);
            }
        }
    }

    public static float calculateAverage()
    {
        float total = 0;
        for(int i = 0; i < m_subjects.size(); i++)
        {
            total += m_grades.get(i);
        }

        return total / (float)m_subjects.size();
    }

    public static boolean isPositive()
    {
        for (int i = 0; i < m_grades.size(); i++)
        {
            if (m_grades.get(i) < 4.0)
            {
                return false;
            }
        }

        return true;
    }

    public static void setPath(String path)
    {
        Database.path = path;
    }
}