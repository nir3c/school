package com.school.util

import com.school.pojo.{ClassRoom, Profession, School, Student}

/**
 * Created by Nir.
 */
object SchoolStatistics {

  def schoolGradesAverage(school: School): Unit = {
    println(s"School Average: ${calcStudentsGradesAverage(school.classRooms.flatMap(clzz => clzz.students))}")
  }

  def classesGradesAverage(school: School): Unit = {
    school.classRooms.foreach(r => classAverage(r))
  }

  private def classAverage(clazz: ClassRoom): Unit = {
    println(s"Class[${clazz.name}]  Avg  ${calcStudentsGradesAverage(clazz.students)}")
  }

  def professionsGradesAverage(school: School): Unit ={
    Profession.SCHOOL_PROFESSIONS.foreach{ pro =>
      val studentsProFilter = studentsProfessionFilter(school, pro)
      println(s"Average Grade for profession $pro : ${calcStudentsGradesAverage(studentsProFilter)}")
    }
  }

  def realisticProfessionTeachers(school: School): Unit ={
    val chemistryTeachers = teacherProfessionFilter(school, Profession.CHEMISTRY)
    val mathTeachers = teacherProfessionFilter(school, Profession.MATH)
    println(s"Number of real teachers: ${chemistryTeachers.length + mathTeachers.length}")
  }

  def sportAndLiteratureTeachers(school: School): Unit = {
    val literatureTeachers = teacherProfessionFilter(school, Profession.LITERATURE)
    val sportTeachers = teacherProfessionFilter(school, Profession.SPORTS)
    println(s"Number of literature teachers: ${literatureTeachers.length}")
    println(s"Number of sport teachers: ${sportTeachers.length}")
  }
  
  def schoolSportsTeam(school: School): Unit = {
    val sportTeam = school.classRooms.flatMap(room => room.students)
      .filter(s => s.grades.exists(g => g.profession.equals(Profession.SPORTS) && g.score > 90))
      .map(s => s.name).mkString(",")
    println(s"Sport Team: $sportTeam")
  }

  def studentsBetween20And30Statistics(school: School): Unit = {
    val age20_30 = findAllStudentsByAge(school, 20, 30)
    println(s"number of students age 20-30: ${age20_30.length}")
    println(s"avg of students age 20-30: ${calcStudentsGradesAverage(age20_30)}")
  }

  def studentsBeyond31Statistics(school: School): Unit = {
    val age31AndUp = findAllStudentsByAge(school, 31)
    println(s"number of students age 31+: ${age31AndUp.length}")
    println(s"avg of students age 31+: ${calcStudentsGradesAverage(age31AndUp)}")
  }

  def schoolAgeAvg(school: School): Unit = {
    val students = findAllStudentsByAge(school, 0)
    val studentsTotalAge = students.map(s => s.age).sum
    println(s"Average of students age: ${studentsTotalAge / students.length}")
  }

  private def calcStudentsGradesAverage(students: Seq[Student]) = {
    val grades = students.flatMap(s => s.grades).map(g => g.score)
    val totalScore = grades.sum
    val totalGrades = grades.length
    totalScore / totalGrades
  }

  private def studentsProfessionFilter(school: School, profession: String) = {
    school.classRooms.flatMap(r => r.students)
      .filter(s => s.grades.exists(g => g.profession.equals(profession)))
  }

  private def teacherProfessionFilter(school: School, profession: String) = {
    school.classRooms.map(r => r.teacher)
      .filter(g => g.profession.equals(profession))
  }

  private def findAllStudentsByAge(school: School, minAge: Int): Seq[Student] = {
    findAllStudentsByAge(school, minAge, Int.MaxValue)
  }

  private def findAllStudentsByAge(school: School, minAge: Int, maxAge: Int): Seq[Student] = {
    school.classRooms.flatMap(r => r.students)
      .filter(s => minAge <= s.age && s.age <= maxAge )
  }


}
