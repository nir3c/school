package com.school.pojo

/**
 * Created by Nir.
 */
abstract class Person(name: String, age: Int) {

  private val PERSON_STARTED_AGE = 0

  private val nameCondition = Option(name).exists(n => !n.isEmpty)
  private val ageCondition = Option(age).exists(ag => PERSON_STARTED_AGE <= ag)

  require(nameCondition, "name must contain value")
  require(ageCondition, "age must be positive value")

}
