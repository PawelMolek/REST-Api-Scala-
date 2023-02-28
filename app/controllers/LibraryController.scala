package controllers

import play.api.mvc.{BaseController, ControllerComponents}
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LibraryController @Inject()(val controllerComponents: ControllerComponents)
  extends BaseController {


}