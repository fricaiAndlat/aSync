package async.fixtures

/**
  * Created by Peer on 24.04.2017.
  */

/**
  *
  * @param r red component in color [0; 1]
  * @param g green component in color [0; 1]
  * @param b blue component in color [0; 1]
  */
class ColorInfo(val r: Float, val g: Float, val b: Float) {

  override def toString: String = {
    "Color("+r+", "+g+", "+b+")"
  }

  def combineToInt:Int = {
    ((r*255).toInt << 16) | ((g*255).toInt)<<8 | (b*255).toInt

  }

}

object ColorInfo{

  /**
    * creates an rgb-converted object from given values
    *
    * @param hue hue of color [0; 1[
    * @param saturation saturation of color [0; 1]
    * @param value value of color [0; 1]
    * @return newly Created RGB-converted ColorInfo
    */
  def createFromHSV(hue: Float, saturation: Float, value: Float): ColorInfo = {
    val h = (hue * 6).toInt
    val f = hue * 6 - h
    val p = value * (1 - saturation)
    val q = value * (1 - f * saturation)
    val t = value * (1 - (1 - f) * saturation)

    h match {
      case 0 => new ColorInfo(value, t, p)
      case 1 => new ColorInfo(q, value, p)
      case 2 => new ColorInfo(p, value, t)
      case 3 => new ColorInfo(p, q, value)
      case 4 => new ColorInfo(t, p, value)
      case 5 => new ColorInfo(value, p, q)
      case _ => throw new IllegalArgumentException("input hue is out of range")
    }
  }

}
