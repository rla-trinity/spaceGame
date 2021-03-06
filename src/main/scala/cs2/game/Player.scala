package cs2.game

import scalafx.scene.image.Image
import cs2.util.Vec2

/** The player representation for a simple game based on sprites. Handles all 
 *  information regarding the player's positions, movements, and abilities.
 *  
 *  @param avatar the image representing the player
 *  @param initPos the initial position of the '''center''' of the player
 *  @param bulletPic the image of the bullets fired by this player
 */
class Player(avatar:Image, initPos:Vec2, private val bulletPic:Image) 
                extends Sprite(avatar, initPos) with ShootsBullets {
  
  //player position and velocity of player movement
  val speed = 8
  var showPos = initPos
  
  //limits player to screen
  val maxPosX = 1000 - 61
  val maxPosY = 930 - 80
  val minPosX = 0
  val minPosY = 5
  
  /** moves the player sprite one "step" to the left.  The amount of this 
   *  movement will likely need to be tweaked in order for the movement to feel 
   *  natural.
   *  
   *  @return none/Unit
   */
  def moveLeft() {
    if(this.initPos.x < minPosX) {
      moveRight
    }
    this.move(new Vec2(-speed, 0.0))
  }
  
  /** moves the player sprite one "step" to the right (see note above)
   * 
   *  @return none/Unit
   */
  def moveRight() {
    if(this.initPos.x > maxPosX) {
      moveLeft
    }
    this.move(new Vec2(speed, 0.0))
  }
  
  /** creates a new Bullet instance beginning from the player, with an 
   *  appropriate velocity
   * 
   *  @return Bullet - the newly created Bullet object that was fired
   */
  
  def moveUp() {
    if(this.initPos.y < minPosY) {
      moveDown
    }
    this.move(new Vec2(0.0, -speed))
  }
  
  def moveDown() {
    if(this.initPos.y > maxPosY) {
      moveUp
    }
    this.move(new Vec2(0.0, speed))
  }
  
  def shoot():Bullet = {
    new Bullet(bulletPic, new Vec2(initPos.x+ 20.5, initPos.y - 20), new Vec2(0, -8))
  }
    
}