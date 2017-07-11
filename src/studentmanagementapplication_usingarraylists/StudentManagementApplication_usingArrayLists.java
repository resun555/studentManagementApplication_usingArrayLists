/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementapplication_usingarraylists;

import java.util.*;
import java.util.EmptyStackException;
/**
 *
 * @author LottricGeneric
 */
public class StudentManagementApplication_usingArrayLists {

    private static int initialCapacity = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Please enter DEFAULT_INITIAL_CAPACITY (<100):");
        initialCapacity = new Scanner(System.in).nextInt();
        MyArrayList<Student> sourceMyArrayList = new MyArrayList<>(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            sourceMyArrayList.getElement()[i] = new Student();
        }
        MyArrayList<Student> destinationMyArrayList = new MyArrayList<>(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            destinationMyArrayList.getElement()[i] = new Student();
        }
        MyArrayList<Student> defaultMyArrayList = new MyArrayList<>(destinationMyArrayList);
        for (int i = 0; i < defaultMyArrayList.getInitialCapacity(); i++) {
            defaultMyArrayList.getElement()[i] = new Student(destinationMyArrayList.getElement()[i]);
        }
        int userOption = 9;
        int predStudentIndex = 0;
        int currentStudentIndex = 0;
        Student oldStudent = null;
        Student newStudent = null;
        int studentNumberSearchSyntax = 0;
        String studentNameSearchSyntax = "defaultStudentName";
        String studentSexSearchSyntax = "m";
        int studentAgeSearchSyntax = 0;
        while (true) {
            async(sourceMyArrayList, destinationMyArrayList);
            System.out.println("Please choose an option:");
            System.out.println("1. Add a new student to the database;");
            System.out.println("2. Remove an existing student from the database;");
            System.out.println("3. Edit a student's profile;");
            System.out.println("4. Search by student number;");
            System.out.println("5. Search by student name;");
            System.out.println("6. Search by student sex;");
            System.out.println("7. Search by student age;");
            System.out.println("8. Get the average age;");
            System.out.println("9. Exit.");
            System.out.print("Please enter your option here:");
            userOption = new Scanner(System.in).nextInt();
            switch (userOption) {
                case 1:
                    System.out.print("Please enter the index of the last student next to which you add a new student:");
                    predStudentIndex = new Scanner(System.in).nextInt();
                    System.out.println("Please enter the new student's profile:");
                    newStudent = new Student();
                    System.out.println("<StudentNumber>");
                    System.out.print("\t");
                    newStudent.setStudentNumber(new Scanner(System.in).nextInt());
                    System.out.println("</StudentNumber>");
                    System.out.println("<StudentName>");
                    System.out.print("\t");
                    newStudent.setStudentName(new Scanner(System.in).nextLine());
                    System.out.println("</StudentName>");
                    System.out.println("<StudentSex>");
                    System.out.print("\t");
                    newStudent.setStudentSex(new Scanner(System.in).nextLine());
                    System.out.println("</StudentSex>");
                    System.out.println("<StudentAge>");
                    System.out.print("\t");
                    newStudent.setStudentAge(new Scanner(System.in).nextInt());
                    System.out.println("</StudentAge>");
                    try {
                        destinationMyArrayList.addNewStudent(destinationMyArrayList, sourceMyArrayList, newStudent, predStudentIndex);
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Adding a new student to the database encountered error: " + ex);
                        throw ex;
                    }
                    break;
                case 2:
                    System.out.print("Please enter the index of the current student who you remove:");
                    currentStudentIndex = new Scanner(System.in).nextInt();
                    try {
                        destinationMyArrayList.deleteExistingStudent(destinationMyArrayList, sourceMyArrayList, oldStudent, currentStudentIndex);
                    } catch (EmptyStackException ex) {
                        System.out.println("Removing an existing student from the database encountered error: " + ex);
                        throw ex;
                    }
                    break;
                case 3:
                    System.out.print("Please enter the index of the current student who you edit:");
                    currentStudentIndex = new Scanner(System.in).nextInt();
                    System.out.println("Please update the current student's profile:");
                    newStudent = new Student();
                    System.out.println("<StudentNumber>");
                    System.out.print("\t");
                    newStudent.setStudentNumber(new Scanner(System.in).nextInt());
                    System.out.println("</StudentNumber>");
                    System.out.println("<StudentName>");
                    System.out.print("\t");
                    newStudent.setStudentName(new Scanner(System.in).nextLine());
                    System.out.println("</StudentName>");
                    System.out.println("<StudentSex>");
                    System.out.print("\t");
                    newStudent.setStudentSex(new Scanner(System.in).nextLine());
                    System.out.println("</StudentSex>");
                    System.out.println("<StudentAge>");
                    System.out.print("\t");
                    newStudent.setStudentAge(new Scanner(System.in).nextInt());
                    System.out.println("</StudentAge>");
                    try {
                        if (sourceMyArrayList.getSize() == 0) {
                            throw new EmptyStackException();
                        }
                        else {
                            destinationMyArrayList.modifyExistingStudent(destinationMyArrayList, sourceMyArrayList, newStudent, oldStudent, currentStudentIndex);
                        }
                    } catch (EmptyStackException ex) {
                        System.out.println("Editing a student's profile encountered error: " + ex);
                        throw ex;
                    }
                    break;
                case 4:
                    async(destinationMyArrayList, defaultMyArrayList);
                    System.out.println("Please enter your student number search syntax:");
                    studentNumberSearchSyntax = new Scanner(System.in).nextInt();
                    destinationMyArrayList.searchByStudentNumber(destinationMyArrayList, sourceMyArrayList, studentNumberSearchSyntax);
                    break;
                case 5:
                    async(destinationMyArrayList, defaultMyArrayList);
                    System.out.println("Please enter your student name search syntax:");
                    studentNameSearchSyntax = new Scanner(System.in).nextLine();
                    destinationMyArrayList.searchByStudentName(destinationMyArrayList, sourceMyArrayList, studentNameSearchSyntax);
                    break;
                case 6:
                    async(destinationMyArrayList, defaultMyArrayList);
                    System.out.println("Please enter your student sex search syntax:");
                    studentSexSearchSyntax = new Scanner(System.in).nextLine();
                    destinationMyArrayList.searchByStudentSex(destinationMyArrayList, sourceMyArrayList, studentSexSearchSyntax);
                    break;
                case 7:
                    async(destinationMyArrayList, defaultMyArrayList);
                    System.out.println("Please enter your student age search syntax:");
                    studentAgeSearchSyntax = new Scanner(System.in).nextInt();
                    destinationMyArrayList.searchByStudentAge(destinationMyArrayList, sourceMyArrayList, studentAgeSearchSyntax);
                    break;
                case 8:
                    try {
                        if (sourceMyArrayList.getSize() == 0) {
                            throw new EmptyStackException();
                        }
                    } catch (EmptyStackException ex) {
                        System.out.println("Getting the average age encountered error: " + ex);
                        throw ex;
                    }
                    break;
                default:
                    break;
            }
            for (int i = 0; i < destinationMyArrayList.getSize(); i++) {
                System.out.println("<StudentNumber>");
                System.out.println("\t" + destinationMyArrayList.getElement()[i].getStudentNumber());
                System.out.println("</StudentNumber>");
                System.out.println("<StudentName>");
                System.out.println("\t" + destinationMyArrayList.getElement()[i].getStudentName());
                System.out.println("</StudentName>");
                System.out.println("<StudentSex>");
                System.out.println("\t" + destinationMyArrayList.getElement()[i].getStudentSex());
                System.out.println("</StudentSex>");
                System.out.println("<StudentAge>");
                System.out.println("\t" + destinationMyArrayList.getElement()[i].getStudentAge());
                System.out.println("</StudentAge>");
                System.out.println("");
            }
            if (userOption == 8) {
                System.out.println("<AverageStudentAge>");
                System.out.print("\t");
                System.out.printf("%.0f\n", sourceMyArrayList.getAverageStudentAge());
                System.out.println("</AverageStudentAge>");
                System.out.println("");
            }
            else if (userOption == 9) {
                break;
            }
        }
        System.out.println("The program has exited successfully.");
    }
    
    public static void async(MyArrayList<Student> sourceMyArrayList, MyArrayList<Student> destinationMyArrayList) {
        System.arraycopy(destinationMyArrayList.getElement(), 0, sourceMyArrayList.getElement(), 0, destinationMyArrayList.getSize());
        sourceMyArrayList.setSize(destinationMyArrayList.getSize());
        sourceMyArrayList.setInitialCapacity(destinationMyArrayList.getInitialCapacity());
    }
    
}
