/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

// คลาส Student ใช้เก็บข้อมูลนักเรียน เช่น ชื่อ และรหัสนักเรียน
class Student {
    String name;        // ชื่อของนักเรียน (Student's name)
    String studentId;   // รหัสนักเรียน (Student ID)

    // Constructor สำหรับกำหนดค่าเริ่มต้นให้กับ name และ studentId
    public Student(String name, String studentId){
        this.name = name;
        this.studentId = studentId;
    }

    // เมธอดสำหรับแสดงชื่อและรหัสของนักเรียน (Display student info)
    public void showNameStudent(){
        System.out.println("name: " + name + " Student ID: " + studentId);
    }

    // เมธอดสำหรับดึงเลข 4 หลักสุดท้ายจากรหัสนักเรียน และแปลงเป็นตัวเลข
    public int getLast4Id(){
        // studentId.length() คือความยาวทั้งหมดของข้อความ เช่น "0000000009223" มีความยาว 13
        // studentId.length() - 4 คือการเริ่มนับที่ตัวอักษรตำแหน่งที่ 9 (ตำแหน่ง index เริ่มจาก 0)
        // substring(...) จะตัดเอาตั้งแต่ index นั้นไปจนถึงตัวสุดท้าย เช่น "9223"
        String last4 = studentId.substring(studentId.length() - 4); // ดึง 4 ตัวท้ายของรหัสนักเรียน
        
        // แปลง String เป็นตัวเลขจำนวนเต็ม เช่น "9223" → 9223
        return Integer.parseInt(last4);
    }
}

// คลาสหลักของโปรแกรม (Main class)
public class JavaApplication1 {

    public static void main(String[] args) {
        // สร้างอาร์เรย์ของนักเรียน 5 คน โดยกำหนดชื่อและรหัสนักเรียนแต่ละคน
        Student[] members = {
            new Student("Student1", "0000000009223"),
            new Student("Student2", "0000000001030"),
            new Student("Student3", "0000000002244"),
            new Student("Student4", "0000000001212"),
            new Student("Student5", "0000000002034"),
        };

        System.out.println("List of group members:"); // แสดงข้อความเริ่มต้นรายการ

        int sum = 0; // ตัวแปรเก็บผลรวมของเลข 4 ตัวท้ายทั้งหมด

        // วนลูปทุกคนในกลุ่ม
        for (int i = 0; i < members.length; i++) {
            Student member = members[i];         // ดึงนักเรียนคนที่ i
            member.showNameStudent();            // แสดงชื่อและรหัสนักเรียนออกหน้าจอ

            int last4 = member.getLast4Id();     // ดึงเลข 4 ตัวท้ายจาก studentId (เช่น "9223" → 9223)
            sum += last4;                        // บวกเลข 4 ตัวท้ายเข้าไปในผลรวม
        }

        // คำนวณค่าเฉลี่ยโดยแปลง sum ให้เป็น double ก่อนหาร เพื่อให้ผลลัพธ์มีทศนิยม
        // เช่น ถ้า sum = 15932 และมีนักเรียน 5 คน → average = 15932 / 5 = 3186.4
        double average = (double) sum / members.length;

        System.out.println("Average = " + average); // แสดงค่าเฉลี่ยเลข 4 ตัวท้าย
    }
    
}
