package com.epam.mrmrmr

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class PersonReaderTest extends AnyFunSuite{
  test("Read data from file test") {
    val real = PersonReader.get_lines("src/test/resources/data.csv").next()
    val expected = "Test,User,1,Senior"

    real should equal(expected)
  }

  test("Readed person should be equals to expected") {
    val real = PersonReader.read("src/test/resources/data.csv").last
    val expected = Person("Test", "User", 1, "Senior")

    real should equal(expected)
  }

}
