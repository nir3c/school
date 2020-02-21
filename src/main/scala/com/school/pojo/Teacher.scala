package com.school.pojo

/**
 * Created by Nir.
 */
case class Teacher(name: String,age: Int, profession: String) extends Person(name, age) {

  private val professionCondition = Option(profession)
    .exists(p => Profession.SCHOOL_PROFESSIONS.contains(p))
  require(professionCondition, s"profession should be on of ${Profession.SCHOOL_PROFESSIONS.mkString(",")}")

}
