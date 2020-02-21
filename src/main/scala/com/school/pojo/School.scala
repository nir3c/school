package com.school.pojo

/**
 * Created by Nir.
 */
case class School(classRooms: Seq[ClassRoom]){

  private val NUMBER_OF_CLASSES_IN_SCHOOL: Int = 15
  private val classRoomsNumberCondition =
    Option(classRooms).exists(classes => classes.length == NUMBER_OF_CLASSES_IN_SCHOOL)
  require(classRoomsNumberCondition, s"Number of classes in school must be $NUMBER_OF_CLASSES_IN_SCHOOL")

}