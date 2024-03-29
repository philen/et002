package et002

import com.badlogic.gdx.{Application, ApplicationListener, Gdx}

/** Scala reimplementation of [[com.badlogic.gdx.Game]] */
class UIListener(ready: Application => Unit) extends ApplicationListener {
  private var screen: Option[UIScreen] = None

  def create(): Unit = {
    ready(Gdx.app)
  }

  def resize(width: Int, height: Int): Unit = {
    screen.foreach(_.resize(width, height))
  }

  def render(): Unit = {
    screen.foreach(_.render(Gdx.graphics.getDeltaTime))
  }

  def pause(): Unit = {
    screen.foreach(_.pause())
  }

  def resume(): Unit = {
    screen.foreach(_.resume())
  }

  def dispose(): Unit = {
    screen.foreach(_.hide())
    screen.foreach(_.dispose())
  }

  def replace(s: UIScreen): Unit = {
    screen.foreach(_.dispose())
    screen = Option(s)
    screen.foreach(_.show())
  }

}
