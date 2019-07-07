package com.hyeran;

import com.hyeran.model.Department;
import com.hyeran.model.Professor;
import com.hyeran.model.Student;
import com.hyeran.model.University;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        /**학생**/
        //제네릭을 사용해 학생 타입 ArrayList 생성
        final ArrayList<Student> studentArrayList = new ArrayList<>();

        //3개의 학생 객체 생성
        final Student student1 = new Student(1L, "Sookmyung", "02-123-456", "서울",
                1L, "IT공학과", "02-345-678", "공과대학",
                1611821L, "신혜란", 4, "IT공학과", "hyeran9712@naver.com", "서울", 23, "휴학중");
        final Student student2 = new Student(1L, "Sookmyung", "02-123-456", "서울",
                1L, "IT공학과", "02-345-678", "공과대학",
                1611821L, "신혜란", 4, "IT공학과", "hyeran9712@naver.com", "서울", 23, "휴학중");
        final Student student3 = new Student(1L, "Sookmyung", "02-123-456", "서울",
                1L, "IT공학과", "02-345-678", "공과대학",
                1611821L, "신혜란", 4, "IT공학과", "hyeran9712@naver.com", "서울", 23, "휴학중");

        //ArrayList에 객체 Add
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);

        System.out.println("-----------학생-----------");

        //ArrayList를 돌면서 각 객체의 toString 메소드 실행
        for(final Student s : studentArrayList) {
            System.out.println(s.toString());
        }

        /**대학교**/
        final ArrayList<University> universityArrayList = new ArrayList<>();

        final University university1 = new University(1L, "Sookmyung", "02-123-456", "서울");
        final University university2 = new University(1L, "Sookmyung", "02-123-456", "서울");
        final University university3 = new University(1L, "Sookmyung", "02-123-456", "서울");

        universityArrayList.add(university1);
        universityArrayList.add(university2);
        universityArrayList.add(university3);

        System.out.println("-----------대학교-----------");

        for(final University u : universityArrayList) {
            System.out.println(u.toString());
        }

        /**학과**/
        final ArrayList<Department> departmentArrayList = new ArrayList<>();

        final Department department1 = new Department(1L, "Sookmyung", "02-123-456", "서울",
                1L, "IT공학과", "02-345-678", "공과대학");
        final Department department2 = new Department(1L, "Sookmyung", "02-123-456", "서울",
                1L, "IT공학과", "02-345-678", "공과대학");
        final Department department3 = new Department(1L, "Sookmyung", "02-123-456", "서울",
                1L, "IT공학과", "02-345-678", "공과대학");

        departmentArrayList.add(department1);
        departmentArrayList.add(department2);
        departmentArrayList.add(department3);

        System.out.println("-----------학과-----------");

        for(final Department d : departmentArrayList) {
            System.out.println(d.toString());
        }

        /**교수**/
        final ArrayList<Professor> professorArrayList = new ArrayList<>();

        final Professor professor1 = new Professor(1L, "Sookmyung", "02-123-456", "서울",
                1L, "IT공학과", "02-345-678", "공과대학",
                1L, "신혜란", "IT공학과", "010-8021-0096", "스프링");
        final Professor professor2 = new Professor(1L, "Sookmyung", "02-123-456", "서울",
                1L, "IT공학과", "02-345-678", "공과대학",
                1L, "신혜란", "IT공학과", "010-8021-0096", "스프링");
        final Professor professor3 = new Professor(1L, "Sookmyung", "02-123-456", "서울",
                1L, "IT공학과", "02-345-678", "공과대학",
                1L, "신혜란", "IT공학과", "010-8021-0096", "스프링");

        professorArrayList.add(professor1);
        professorArrayList.add(professor2);
        professorArrayList.add(professor3);

        System.out.println("-----------교수-----------");

        for(final Professor p : professorArrayList) {
            System.out.println(p.toString());
        }

    }
}
