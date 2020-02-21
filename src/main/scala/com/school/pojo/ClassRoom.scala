package com.school.pojo

/**
 * Created by Nir.
 */
case class ClassRoom(name: String, teacher: Teacher, students: Seq[Student]) {

  private val NUMBER_OF_STUDENTS_IN_CLASS: Int = 15


  private val classNameCondition = Option(name).exists(n => !n.isEmpty)
  private val teacherCondition = Option(teacher).nonEmpty
  private val studentsNumberCondition =
    Option(students).exists(studs => studs.length == NUMBER_OF_STUDENTS_IN_CLASS)

  require(studentsNumberCondition, s"Number of students in class must be $NUMBER_OF_STUDENTS_IN_CLASS")
  require(classNameCondition, "className must contain value")
  require(teacherCondition, "classRoom should have a teacher")

}
