package com.school

import com.school.pojo.{ClassRoom, Profession, School, Student}
import com.school.util.{SchoolGenerator, SchoolStatistics}

/**
 * Created by Nir.
 */
object Main {

  def main(args: Array[String]): Unit = {
    val school = SchoolGenerator.generateSchool
    SchoolStatistics.schoolGradesAverage(school)
    SchoolStatistics.classesGradesAverage(school)
    SchoolStatistics.professionsGradesAverage(school)
    SchoolStatistics.studentsBetween20And30Statistics(school)
    SchoolStatistics.studentsBeyond31Statistics(school)
    SchoolStatistics.schoolAgeAvg(school)
    SchoolStatistics.realisticProfessionTeachers(school)
    SchoolStatistics.sportAndLiteratureTeachers(school)
    SchoolStatistics.schoolSportsTeam(school)
  }

}
