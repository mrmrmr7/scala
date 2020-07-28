package com.epam.mrmrmr

import java.io.FileInputStream

import scala.io.{BufferedSource, Source}

object PersonPrinter {
  def main(args: Array[String]): Unit = {
    println(PersonReader.get_lines("src/main/resources/data.csv").next());
    val persons = PersonReader.read("src/main/resources/data.csv")
    persons.foreach(println)
  }
}

object PersonReader {

  def get_lines(path: String): Iterator[String] = {
    Source.fromInputStream(new FileInputStream(path)).getLines()
  }

  def read(path: String): Seq[Person] = {
    get_lines(path).map(line => {
      val parts = line.split(",")
      Person(parts(0), parts(1), parts(2).toInt, parts(3))
    }).toSeq
  }
}

case class Person (name: String, surname: String, age: Int, position: String)