package async.simulating

import java.awt.{Color, Graphics, Graphics2D}
import java.awt.image.BufferedImage
import java.util.ArrayList
import javax.swing.JPanel

import async.effects.Effect
import async.fixtures.ColorInfo

/**
  * Created by Peer on 24.04.2017.
  */
class EffectSimulator (val effect: Effect[ColorInfo]) extends JPanel {

  var buffer: BufferedImage = null
  var bufferG: Graphics2D = null

  val factor = 4

  EffectSimulator.registerSimulator(this)

  override def paintComponent(g: Graphics) {
    if(buffer == null || buffer.getWidth!= getWidth/factor || buffer.getHeight!=getHeight/factor){
      buffer = new BufferedImage(getWidth/factor, getHeight/factor, BufferedImage.TYPE_INT_RGB)
      bufferG = buffer.createGraphics()
    }

    var i = 0
    while(i < buffer.getWidth){
      var j = 0
      while(j < buffer.getHeight){

        bufferG.setColor(
          new Color(
            effect.onFrame(System.currentTimeMillis(), i.toFloat/buffer.getWidth, j.toFloat/buffer.getHeight).combineToInt))

        bufferG.fillRect(i, j, 1, 1)

        j += 1
      }
      i += 1
    }

    g.drawImage(buffer, 0, 0, getWidth, getHeight, this)

    //System.out.println("done");


  }

}

object EffectSimulator {

  val simulatorList = new ArrayList[EffectSimulator]
  val dt = 2

  val worker = new Thread( () => {
    while(true){
      val start = System.currentTimeMillis

      simulatorList.synchronized{
        simulatorList.forEach( s => s.repaint() )
      }

      val wait = start + dt - System.currentTimeMillis

      if(wait < 0){
        System.out.println("cant keep up");
      }else{
        Thread.sleep(wait)
      }

    }
  })

  worker.start



  def registerSimulator(simulator: EffectSimulator): Unit = {
    simulatorList.synchronized{
      simulatorList.add(simulator)
    }
  }

}
