package com.school.pojo

/**
 * Created by Nir.
 */
case class Student(name: String, age: Int, grades: Seq[Grade]) extends Person(name, age){

  private val NUMBER_OF_STUDENT_GRADES: Int = 6

  private val studentsNumberCondition =
    Option(grades).exists(gradz => gradz.length == NUMBER_OF_STUDENT_GRADES)

  require(studentsNumberCondition, s"Number of student's grads must be $NUMBER_OF_STUDENT_GRADES")

}
