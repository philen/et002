package et002

import com.badlogic.gdx.Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.badlogic.gdx.graphics.glutils.HdpiMode
import monix.catnap.MVar
import monix.eval.Task
import monix.execution.Scheduler.Implicits.global

object Loader {

  type AppChannel = MVar[Task, Application]
  private val appChannel: AppChannel =
    MVar[Task].empty[Application]().runSyncUnsafe()
  def ready(app: Application): Unit = {
    appChannel.put(app).runAsync(defaultAsyncHandler)
  }

  def load(ui: UIListener): Lwjgl3ApplicationConfiguration = {
    appChannel.take.runAsync {
      case Left(err)  => throw err
      case Right(app) => app.postRunnable(() => ui.replace(new LoadingScreen()))
    }

    // TODO load from file in a Task
    new Lwjgl3ApplicationConfiguration() {
      setTitle("Engine Test 002")
      setWindowPosition(-1, -1)
      setWindowedMode(900, 900)
      setBackBufferConfig(8, 8, 8, 8, 16, 0, 4)
      setHdpiMode(HdpiMode.Pixels)
      setWindowSizeLimits(800, 600, 9999, 9999)
      useOpenGL3(false, 3, 2)
    }
  }

}
