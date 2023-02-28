package controllers

import play.api.mvc.{BaseController, ControllerComponents}
import javax.inject.Inject
import javax.inject.Singleton
import scala.collection.mutable
import models.Book
@Singleton
class LibraryController @Inject()(val controllerComponents: ControllerComponents)
  extends BaseController {


  val bookList = new mutable.ListBuffer[Book]()
  bookList += Book(1, "Neil deGrasse Tyson", "Astrophysics for People in a Hurry", true)
  bookList += Book(2, "Stephen Hawking", "A Brief History of Time", true)
  bookList += Book(3, "Carl Sagan", "Cosmos", false)
  bookList += Book(4, "Andrzej Dragan", "Kwantechizm", false)

}