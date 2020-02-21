package com.school.pojo

/**
 * Created by Nir.
 */
case class Grade(profession: String, score: Int){

  private val MIN_GRADE_SCORE = 40
  private val MAX_GRADE_SCORE = 100

  private val professionCondition = Option(profession)
    .exists(p => Profession.SCHOOL_PROFESSIONS.contains(p))
  private val scoreCondition = Option(score).exists(s => MIN_GRADE_SCORE <= s && s <= MAX_GRADE_SCORE)
  require(professionCondition, s"profession should be on of ${Profession.SCHOOL_PROFESSIONS.mkString(",")}")
  require(scoreCondition, s"Score Should be in range of $MIN_GRADE_SCORE and $MAX_GRADE_SCORE")

}

