package async.effects

import async.fixtures.Fixture
import spire.implicits._

/**
  * An effect represents a single connected effect within a show.
  */
abstract class Effect[T]{

  def onFrame(t: Long, x: Float, y: Float, z: Float): T

  def onPulse: Unit = {}

  def onBeat: Unit = {}




}
