package async.effects

import async.fixtures.ColorInfo

/**
  * Created by Peer on 24.04.2017.
  */

/**
  * A simple shifting Rainbowaffect on the x-axis
  *
  * @param colorChange velocity of change in ms, colorChange==2000 means a full change in color all 2 seconds
  */
class RainbowEffect(val colorChange: Long) extends Effect[ColorInfo] {

  override def onFrame(t: Long, x: Float, y: Float, z: Float): ColorInfo = {
    //System.out.println(t.toFloat%colorChange)
    ColorInfo.createFromHSV((x+(t%colorChange)/colorChange.toFloat)%1, Math.min(y*2, 1), Math.min(1-(y-0.5f)*2, 1))

  }
}
