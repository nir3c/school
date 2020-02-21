package com.school.util

import com.school.pojo.{ClassRoom, Grade, Profession, School, Student, Teacher}

import scala.util.Random

/**
 * Created by Nir.
 */
object SchoolGenerator {

  private val MIN_TEACHER_AGE = 30
  private val MAX_TEACHER_AGE = 67
  private val MIN_STUDENT_AGE = 15
  private val MAX_STUDENT_AGE = 100
  private val MIN_GRADE_SCORE = 40
  private val MAX_GRADE_SCORE = 100
  private val NUMBER_OF_STUDENT_GRADES: Int = 6
  private val NUMBER_OF_STUDENTS_IN_CLASS: Int = 15
  private val NUMBER_OF_CLASSES_IN_SCHOOL: Int = 15

  def generateSchool: School = {
    val teachers = generateTeachers(NUMBER_OF_CLASSES_IN_SCHOOL)
    val students = generateStudents(NUMBER_OF_CLASSES_IN_SCHOOL * NUMBER_OF_STUDENTS_IN_CLASS)
    val classRooms = generateClassRooms(teachers, students)
    School(classRooms)
  }

  private def generateTeachers(numberOfTeachers: Int): Seq[Teacher] ={
    val rand = new Random
    Seq.tabulate(numberOfTeachers)(i => generateTeacher(i.toString,
      rand.between(MIN_TEACHER_AGE, MAX_TEACHER_AGE),
      Profession.SCHOOL_PROFESSIONS(rand.nextInt(Profession.SCHOOL_PROFESSIONS.length))))
  }

  private def generateTeacher(TeacherSuffixName: String, teacherAge: Int, profession: String): Teacher = {
    Teacher(s"Teacher_$TeacherSuffixName", teacherAge, profession)
  }

  private def generateStudents(numberOfTeachers: Int): Seq[Student] = {
    val rand = new Random
    Seq.tabulate(numberOfTeachers)(i => generateStudent(i.toString,
      rand.between(MIN_STUDENT_AGE, MAX_STUDENT_AGE), generateGrades(rand)))
  }

  private def generateStudent(studentSuffixName: String, studentAge: Int, grades: Seq[Grade]): Student = {
    Student(s"Student_$studentSuffixName", studentAge, grades)
  }

  private def generateGrades(rand: Random): Seq[Grade] = {
    var schoolProfessions = Seq.from(Profession.SCHOOL_PROFESSIONS)
    Seq.fill(NUMBER_OF_STUDENT_GRADES){
      val index = rand.nextInt(schoolProfessions.length)
      val profession = schoolProfessions(index)
      schoolProfessions = schoolProfessions.take(index) ++ schoolProfessions.drop(index + 1)
      generateGrade(rand, profession)
    }
  }



  private def generateGrade(rand: Random, profession: String) = {
    Grade(profession,
      rand.between(MIN_GRADE_SCORE, MAX_GRADE_SCORE + 1) )
  }

  private def generateClassRooms(teachers: Seq[Teacher], students: Seq[Student]): Seq[ClassRoom] = {
    Seq.tabulate(NUMBER_OF_CLASSES_IN_SCHOOL) {
      i =>
        generateClassRoom(i.toString, teachers(i),
          students.slice(i * NUMBER_OF_STUDENTS_IN_CLASS, (i * NUMBER_OF_STUDENTS_IN_CLASS) + NUMBER_OF_STUDENTS_IN_CLASS)
        )
    }
  }

  private def generateClassRoom(classRoomSuffixName: String, teacher: Teacher, students: Seq[Student]): ClassRoom = {
    ClassRoom(s"ClassRoom_$classRoomSuffixName", teacher, students)
  }

}
