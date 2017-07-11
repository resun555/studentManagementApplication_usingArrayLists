/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementapplication_usingarraylists;

import java.util.EmptyStackException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LottricGeneric
 * @param <GenericType>
 */
public class MyArrayList<GenericType> {
    
    private Student[] element;
    private int size = 0;
    private int initialCapacity = 100;
    
    public interface GenericType {
        /**
         * 
         * @return 
         */
        public abstract int getStudentNumber();
        /**
         * 
         * @return 
         */
        public abstract String getStudentName();
        /**
         * 
         * @return 
         */
        public abstract String getStudentSex();
        /**
         * 
         * @return 
         */
        public abstract int getStudentAge();
        /**
         * 
         * @param genericTypeNumberStandard 
         */
        public abstract void setStudentNumber(int genericTypeNumberStandard);
        /**
         * 
         * @param genericTypeNameStandard 
         */
        public abstract void setStudentName(String genericTypeNameStandard);
        /**
         * 
         * @param genericTypeSexStandard 
         */
        public abstract void setStudentSex(String genericTypeSexStandard);
        /**
         * 
         * @param generictypeAgeStandard 
         */
        public abstract void setStudentAge(int generictypeAgeStandard);
    }
    
    /**
     * 
     * @param initialCapacityConstructor 
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacityConstructor) {
        this.element = new Student[initialCapacityConstructor];
        this.size = 0;
        this.initialCapacity = initialCapacityConstructor;
    }
    
    /**
     * 
     * @param elementConstructor 
     * @param sizeConstructor 
     * @param initialCapacityConstructor 
     */
    public MyArrayList(Student[] elementConstructor, int sizeConstructor, int initialCapacityConstructor) {
        this.element = new Student[initialCapacityConstructor];
        System.arraycopy(elementConstructor, 0, this.element, 0, initialCapacityConstructor);
        this.size = sizeConstructor;
        this.initialCapacity = initialCapacityConstructor;
    }   
    /**
     * 
     * @param myArrayListConstructor 
     */
    public MyArrayList(MyArrayList<Student> myArrayListConstructor) {
        this.element = new Student[myArrayListConstructor.initialCapacity];
        System.arraycopy(myArrayListConstructor.element, 0, this.element, 0, myArrayListConstructor.initialCapacity);
        this.size = myArrayListConstructor.size;
        this.initialCapacity = myArrayListConstructor.initialCapacity;
    }
    
    /**
     * 
     * @throws Throwable 
     */
    @Override
    protected void finalize() throws Throwable {
        try {
            this.element = null;
            this.size = 0;
            this.initialCapacity = 0;
        } catch (Throwable ex) {
            Logger.getLogger(MyArrayList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            super.finalize();
        }
    }
    
    /**
     * 
     * @return 
     */
    public Student[] getElement() {
        return this.element;
    }
    
    /**
     * 
     * @return 
     */
    public int getSize() {
        return this.size;
    }
    
    /**
     * 
     * @return 
     */
    public int getInitialCapacity() {
        return this.initialCapacity;
    }
    
    /**
     * 
     * @param elementStandard 
     */
    public void setElement(Student[] elementStandard) {
        System.arraycopy(elementStandard, 0, this.element, 0, initialCapacity);
    }
    
    /**
     * 
     * @param sizeStandard 
     */
    public void setSize(int sizeStandard) {
        this.size = sizeStandard;
    }
    
    /**
     * 
     * @param initialCapacityStandard 
     */
    public void setInitialCapacity(int initialCapacityStandard) {
        this.initialCapacity = initialCapacityStandard;
    }
    
    /**
     * 
     * @param origin 
     */
    public void push(Student origin) {
        if (size == initialCapacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        element[size++] = origin;
    }
    
    /**
     * 
     * @return 
     */
    public Student pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Student result = element[--size];
        element[size] = null;
        return result;
    }
    
    /**
     * 
     * @param origin 
     */
    public void unshift(Student origin) {
        if (size == initialCapacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 0; i < size; i++) {
            element[size - i] = element[size - 1 - i];
        }
        element[0] = origin;
        size++;
    }
    
    /**
     * 
     * @return 
     */
    public Student shift() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Student result = element[0];
        for (int i = 0; i < size - 1; i++) {
            element[i] = element[i + 1];
        }
        element[--size] = null;
        return result;
    }
    
    /**
     * 
     * @param destinationMyArrayList
     * @param sourceMyArrayList
     * @param newStudent
     * @param predStudentIndex 
     */
    public void addNewStudent(MyArrayList<Student> destinationMyArrayList, MyArrayList<Student> sourceMyArrayList, Student newStudent, int predStudentIndex) {
        System.arraycopy(sourceMyArrayList.element, 0, destinationMyArrayList.element, 0, sourceMyArrayList.size);
        destinationMyArrayList.size = sourceMyArrayList.size;
        destinationMyArrayList.initialCapacity = sourceMyArrayList.initialCapacity;
        destinationMyArrayList.unshift(newStudent);
        MyArrayList.GenericType tempStudent = (MyArrayList.GenericType) destinationMyArrayList.element[0];
        for (int i = 0; i < predStudentIndex + 1; i++) {
            destinationMyArrayList.element[i] = destinationMyArrayList.element[i + 1];
        }
        destinationMyArrayList.element[predStudentIndex + 1] = (Student) tempStudent;
    }
    
    /**
     * 
     * @param destinationMyArrayList
     * @param sourceMyArrayList
     * @param oldStudent
     * @param currentStudentIndex 
     */
    public void deleteExistingStudent(MyArrayList<Student> destinationMyArrayList, MyArrayList<Student> sourceMyArrayList, Student oldStudent, int currentStudentIndex) {
        System.arraycopy(sourceMyArrayList.element, 0, destinationMyArrayList.element, 0, sourceMyArrayList.size);
        destinationMyArrayList.size = sourceMyArrayList.size;
        destinationMyArrayList.initialCapacity = sourceMyArrayList.initialCapacity;
        MyArrayList.GenericType tempStudent = (MyArrayList.GenericType) destinationMyArrayList.element[currentStudentIndex];
        for (int i = 0; i < currentStudentIndex; i++) {
            destinationMyArrayList.element[currentStudentIndex - i] = destinationMyArrayList.element[currentStudentIndex - i - 1];
        }
        destinationMyArrayList.element[0] = (Student) tempStudent;
        oldStudent = destinationMyArrayList.shift();
    }
    
    /**
     * 
     * @param destinationMyArrayList
     * @param sourceMyArrayList
     * @param newStudent
     * @param oldStudent
     * @param currentStudentIndex 
     */
    public void modifyExistingStudent(MyArrayList<Student> destinationMyArrayList, MyArrayList<Student> sourceMyArrayList, Student newStudent, Student oldStudent, int currentStudentIndex) {
        System.arraycopy(sourceMyArrayList.element, 0, destinationMyArrayList.element, 0, sourceMyArrayList.size);
        destinationMyArrayList.size = sourceMyArrayList.size;
        destinationMyArrayList.initialCapacity = sourceMyArrayList.initialCapacity;
        oldStudent = destinationMyArrayList.element[currentStudentIndex];
        destinationMyArrayList.element[currentStudentIndex] = newStudent;
    }
    
    /**
     * 
     * @param destinationMyArrayList
     * @param sourceMyArrayList
     * @param elementNumberSearchSyntax 
     */
    public void searchByStudentNumber(MyArrayList<Student> destinationMyArrayList, MyArrayList<Student> sourceMyArrayList, int elementNumberSearchSyntax) {
       int destinationStudentIndex = 0;
       destinationMyArrayList.size = 0;
        for (int i = 0; i < sourceMyArrayList.size; i++) {
            if (elementNumberSearchSyntax == sourceMyArrayList.element[i].getStudentNumber()) {
                destinationMyArrayList.element[destinationStudentIndex++] = sourceMyArrayList.element[i];
                destinationMyArrayList.size++;
            }
        }
    }
        
    /**
     * 
     * @param destinationMyArrayList
     * @param sourceMyArrayList
     * @param elementNameSearchSyntax 
     */
    public void searchByStudentName(MyArrayList<Student> destinationMyArrayList, MyArrayList<Student> sourceMyArrayList, String elementNameSearchSyntax) {
        int destinationStudentIndex = 0;
        destinationMyArrayList.size = 0;
        for (int i = 0; i < sourceMyArrayList.size; i++) {
            if (elementNameSearchSyntax.equals(sourceMyArrayList.element[i].getStudentName())) {
                destinationMyArrayList.element[destinationStudentIndex++] = sourceMyArrayList.element[i];
                destinationMyArrayList.size++;
            }
        }
    }
        
    /**
     * 
     * @param destinationMyArrayList
     * @param sourceMyArrayList
     * @param elementSexSearchSyntax 
     */
    public void searchByStudentSex(MyArrayList<Student> destinationMyArrayList, MyArrayList<Student> sourceMyArrayList, String elementSexSearchSyntax) {
        int destinationStudentIndex = 0;
        destinationMyArrayList.size = 0;
        for (int i = 0; i < sourceMyArrayList.size; i++) {
            if (elementSexSearchSyntax.equals(sourceMyArrayList.element[i].getStudentSex())) {
                destinationMyArrayList.element[destinationStudentIndex++] = sourceMyArrayList.element[i];
                destinationMyArrayList.size++;
            }
        }
    }
        
    /**
     * 
     * @param destinationMyArrayList
     * @param sourceMyArrayList
     * @param elementAgeSearchSyntax 
     */
    public void searchByStudentAge(MyArrayList<Student> destinationMyArrayList, MyArrayList<Student> sourceMyArrayList, int elementAgeSearchSyntax) {
        int destinationStudentIndex = 0;
        destinationMyArrayList.size = 0;
        for (int i = 0; i < sourceMyArrayList.size; i++) {
            if (elementAgeSearchSyntax == sourceMyArrayList.element[i].getStudentAge()) {
                destinationMyArrayList.element[destinationStudentIndex++] = sourceMyArrayList.element[i];
                destinationMyArrayList.size++;
            }
        }
    }
    
    /**
     * 
     * @return 
     */
    public double getAverageStudentAge() {
        double averageStudentAge = 0.0;
        for (int i = 0; i < size; i++) {
            averageStudentAge += this.element[i].getStudentAge();
        }
        try {
            averageStudentAge /= size;
        } catch (ArithmeticException ex) {
            System.out.println(ex);
            averageStudentAge = Double.NaN;
            throw ex;
        }
        return averageStudentAge;
    }
}
