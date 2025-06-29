/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

// class Student ใช้เก็บข้อมูล เช่น ชื่อ และรหัสนักศึกษา
class Student {
    String name;        // ชื่อของนักศึกษา (Student's name)
    String studentId;   // รหัสนักเรียน (Student ID)

    // Constructor สำหรับกำหนดค่าเริ่มต้นให้กับ name และ studentId
    public Student(String name, String studentId){
        this.name = name;
        this.studentId = studentId;
    }

    // Method สำหรับแสดงชื่อและรหัสของนักศึกษา (Display student info)
    public void showNameStudent(){
        System.out.println("name: " + name + " Student ID: " + studentId);
    }

    // Method สำหรับดึงเลข 4 หลักสุดท้ายจากรหัสนักศึกษา และแปลงเป็นตัวเลข
    public int getLast4Id(){
        // studentId.length() คือ หาความยาว  เช่น "0000000009223" มีความยาว 13
        // studentId.length() - 4 คือ 13 - 4 = 9 ( index เริ่มจาก 0)
        // substring(...) จะตัดเอาตั้งแต่ 9 นั้นไปจนถึงตัวสุดท้าย เช่น "9223"
        String last4 = studentId.substring(studentId.length() - 4); // ดึง 4 ตัวท้ายของรหัสนักศึกษา
        
        // แปลง String เป็นตัวเลขจำนวนเต็ม เช่น "9223" → 9223
        return Integer.parseInt(last4);
    }
}

// Main class
public class JavaApplication1 {

    public static void main(String[] args) {
        // สร้างอาร์เรย์ของนักศึกษา 5 คน โดยกำหนดชื่อและรหัสนักศึกษาแต่ละคน
        Student[] members = {
            new Student("Student1", "0000000009223"),
            new Student("Student2", "0000000001030"),
            new Student("Student3", "0000000002244"),
            new Student("Student4", "0000000001212"),
            new Student("Student5", "0000000002034"),
        };

        System.out.println("List of group members:"); // แสดงข้อความเริ่มต้นรายการ

        int sum = 0; // สร้างตัวแปรเก็บผลรวม

        // Loop ทุกคนในกลุ่ม
        for (int i = 0; i < members.length; i++) {
            Student member = members[i];         // ดึงนักศึกษาคนที่ i
            member.showNameStudent();            // แสดงชื่อและรหัสนักศึกษาออกหน้าจอ

            int last4 = member.getLast4Id();     // ดึงเลข 4 ตัวท้ายจาก studentId (เช่น "9223" → 9223)
            sum += last4;                        // บวกเลข 4 ตัวท้ายเข้าไปในผลรวม
        }

        // คำนวณค่าเฉลี่ยโดยแปลง sum ให้เป็น double ก่อนหาร เพื่อให้ผลลัพธ์มีทศนิยม
        // เช่น ถ้า sum = 15932 และมีนักเรียน 5 คน → average = 15932 / 5 = 3186.4
        double average = (double) sum / members.length;

        System.out.println("Average = " + average); // แสดงค่าเฉลี่ยเลข 4 ตัวท้าย
    }
    
}
