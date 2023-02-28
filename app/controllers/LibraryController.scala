package controllers

import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import javax.inject.Inject
import javax.inject.Singleton
import scala.collection.mutable
import models.Book
import play.api.libs.json._

@Singleton
class LibraryController @Inject()(val controllerComponents: ControllerComponents)
  extends BaseController {

  implicit val bookListJson = Json.format[Book]

  val bookList = new mutable.ListBuffer[Book]()
  bookList += Book(1, "Neil deGrasse Tyson", "Astrophysics for People in a Hurry", true)
  bookList += Book(2, "Stephen Hawking", "A Brief History of Time", true)
  bookList += Book(3, "Carl Sagan", "Cosmos", false)
  bookList += Book(4, "Andrzej Dragan", "Kwantechizm", false)

  def getAll(): Action[AnyContent] = Action {
    if (bookList.isEmpty) {
      NoContent
    } else {
      Ok(Json.toJson(bookList))
    }
  }

  def getById(bookId: Int): Action[AnyContent] = Action {
    val book = bookList.find(_.id == bookId)
    book match {
      case Some(value) => Ok(Json.toJson(value))
      case None => NotFound
    }
  }

  def setAvailability(bookId: Int): Action[AnyContent] = Action {
    val bookIndex = bookList.indexWhere(_.id == bookId)
    if (bookIndex >= 0) {
      val book = bookList(bookIndex)
      val updatedBook = book.copy(isAvailable = !book.isAvailable)
      bookList.update(bookIndex, updatedBook)
      Ok(Json.toJson(updatedBook))
    } else {
      NoContent
    }
  }
}