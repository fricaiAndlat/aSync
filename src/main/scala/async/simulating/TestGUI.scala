package async.simulating

import java.awt.{Graphics, BorderLayout, Frame}
import javax.swing.{JPanel, JFrame}

import async.effects.RainbowEffect
import async.fixtures.ColorInfo

/**
  * Created by Peer on 24.04.2017.
  */
object TestGUI extends App{

  val frame = new JFrame("Effect Test")
  frame.setSize(800, 600);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  //frame.setExtendedState(Frame.MAXIMIZED_BOTH)
  frame.setLayout(new BorderLayout)

  frame.add(new EffectSimulator(new RainbowEffect(1000)), BorderLayout.CENTER)


  frame.setVisible(true)

  System.out.println(ColorInfo.createFromHSV(0f, 1, 1))


}
