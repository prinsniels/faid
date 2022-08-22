package faid

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.io.Source.fromFile
import java.io.File

enum Category:
  case Boodschapen, Kleding, Overig, Media, Verzekeringen, WaterEnElectra, Lasten, Hypotheek

case class Balance(amount: Int):
  def +(other: Mutation): Balance =
    Balance(amount + other.amount)

  def +(other: Balance): Balance =
    Balance(amount + other.amount)

  override def toString(): String =
    s"${amount / 100.0}"

case class Mutation(amount: Int, accountNr: String, date: LocalDate, description: String):
  override def toString(): String =
    s"${amount / 100} \n$accountNr $date \n$description"



object MutationReader:

  def readFile(fp: String): List[String] =
    val src = fromFile(new File(fp))
    try { src.getLines.toList }
    finally { src.close }

  def parseLine(line: String): Mutation =
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")

    val cache = line.split("\t")
    val accountNr = cache(0).strip
    val date = LocalDate.parse(cache(2).strip, formatter)
    val amount = (cache(6).strip.replace(',', '.').toDouble * 100).toInt
    val description = cache(7).strip()

    Mutation(
      amount = amount,
      accountNr = accountNr,
      date = date,
      description = description
    )


// object Main:
//   def main(args: Array[String]): Unit =
//     import MutationReader.*

//     val x = readFile("./src/main/resources/TXT220820082241.TAB")
//       .map(parseLine)
//       .groupBy(_.date.getMonthValue())
//       .map((m, mutations) => (m, mutations.foldLeft(Balance(0))(_ + _)))
//       .toList
//       .sortBy(_._1)
//       .map(_._2)
//       .foldLeft(Balance(0))(_ + _)
//     println(x)
//     println(Category.Boodschapen)