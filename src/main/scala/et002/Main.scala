package et002

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application

object Main extends App {
  try {
    val ui = new UIListener(Loader.ready)
    val cfg = Loader.load(ui)
    // FIXME returns only on program exit, _must_ run on the main thread
    new Lwjgl3Application(ui, cfg)
  } catch {
    case err: Throwable =>
      err.printStackTrace()
      System.exit(1)
  }
}
