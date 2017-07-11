/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementapplication_usingarraylists;

import java.util.logging.Level;
import java.util.logging.Logger;
import studentmanagementapplication_usingarraylists.MyArrayList.GenericType;

/**
 *
 * @author LottricGeneric
 */

public class Student implements GenericType {
    private int studentNumber = 0;
    private String studentName = "defaultStudentName";
    private String studentSex = "m";
    private int studentAge = 0;
    
    public Student() {
        this.studentNumber = 0;
        this.studentName = "defaultStudentName";
        this.studentSex = "m";
        this.studentAge = 0;
    }
    
    /**
     * 
     * @param studentNumberConstructor
     * @param studentNameConstructor
     * @param studentSexConstructor
     * @param studentAgeConstructor 
     */
    public Student(int studentNumberConstructor, String studentNameConstructor, String studentSexConstructor, int studentAgeConstructor) {
        this.studentNumber = studentNumberConstructor;
        this.studentName = studentNameConstructor;
        this.studentSex = studentSexConstructor;
        this.studentAge = studentAgeConstructor;
    }
    
    /**
     *
     * @param studentConstructor
     */
    public Student(Student studentConstructor) {
        this.studentNumber = studentConstructor.studentNumber;
        this.studentName = studentConstructor.studentName;
        this.studentSex = studentConstructor.studentSex;
        this.studentAge = studentConstructor.studentAge;
    }

    /**
     *
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        try {
            this.studentNumber = 0;
            this.studentName = null;
            this.studentSex = "m";
            this.studentAge = 0;
        } catch (Throwable ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            super.finalize();
        }
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int getStudentNumber() {
        return studentNumber;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String getStudentName() {
        return studentName;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String getStudentSex() {
        return studentSex;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int getStudentAge() {
        return studentAge;
    }
    
    /**
     * 
     * @param studentNumberStandard 
     */
    @Override
    public void setStudentNumber(int studentNumberStandard) {
        studentNumber = studentNumberStandard;
    }
    
    /**
     * 
     * @param studentNameStandard 
     */
    @Override
    public void setStudentName(String studentNameStandard) {
        studentName = studentNameStandard;
    }
    
    /**
     * 
     * @param studentSexStandard 
     */
    @Override
    public void setStudentSex(String studentSexStandard) {
        studentSex = studentSexStandard;
    }
    
    /**
     * 
     * @param studentAgeStandard 
     */
    @Override
    public void setStudentAge(int studentAgeStandard) {
        studentAge = studentAgeStandard;
    }
}
