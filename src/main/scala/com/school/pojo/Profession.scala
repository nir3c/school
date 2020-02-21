package com.school.pojo

/**
 * Created by Nir.
 */
object Profession {
  val MATH: String = "math"
  val CHEMISTRY: String = "chemistry"
  val GEOGRAPHY: String = "geography"
  val LITERATURE: String = "literature"
  val PHYSICS: String = "physics"
  val SPORTS: String = "sports"

  val SCHOOL_PROFESSIONS: Seq[String] = Seq[String](MATH, CHEMISTRY, GEOGRAPHY,
    LITERATURE, PHYSICS, SPORTS)
}
