package com.hyeran;

import com.hyeran.model.Student;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //제네릭을 사용해 학생 타입 ArrayList 생성
        final ArrayList<Student> studentList = new ArrayList<>();

        //3개의 학생 객체 생성
        final Student student1 = new Student();
        final Student student2 = new Student();
        final Student student3 = new Student();

        //ArrayList에 객체 Add
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        //ArrayList를 돌면서 각 객체의 toString 메소드 실행
        for(final Student s : studentList) {
            System.out.println(s.toString());
        }
    }
}
