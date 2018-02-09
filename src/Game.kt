import components.ComponentType
import components.Input
import components.SpriteRenderer
import core.Camera
import core.GameObject
import core.World
import managers.InputManager
import processing.core.PApplet
import processing.core.PVector
import processing.event.KeyEvent
import processing.event.MouseEvent

fun main(args: Array<String>) {
	PApplet.main("Game")
}

lateinit var p: PApplet

class Photo : GameObject() {
	val image = p.loadImage("res/wall7.bmp")
	
	init {
		val size = PVector(150f, 150f)
		
		val spriteRenderer = addComponent(ComponentType.SpriteRenderer) as SpriteRenderer
		spriteRenderer.image = image
		spriteRenderer.size.set(size)
		
		val input = addComponent(ComponentType.Input) as Input
		input.size.set(size)
	}
	
	override fun onMousePressed(pos: PVector, event: MouseEvent) {
		(p as Game).debugging.add(pos)
		println("${this} CLICKED ${event.button} at ${pos}")
	}
}

class Game : PApplet() {
	lateinit var go: GameObject
	
	init {
		p = this
	}
	
	override fun settings() {
		size(800, 600)
	}
	
	var debugging = ArrayList<PVector>()
	
	override fun setup() {
		go = Photo()
		go.transform.position.set(width / 2f - 300f, height / 2f)
		
		go = Photo()
		go.transform.position.set(width / 2f + 50f, height / 2f)

//        val phyiscs = go.addComponent(ComponentType.Physics) as Physics
//
//        phyiscs.acceleration.set(2f, 0f)
//        phyiscs.gravity *= 0f
	}
	
	override fun draw() {
		World.tick()
		debugging.forEach { fill(255); ellipse(it.x, it.y, 20f, 20f)}
		
		if (p.mouseX < width / 10 * 2)
			Camera.transform.position.x -= 0.5f
		else if (p.mouseX >= width / 10 * 8)
			Camera.transform.position.x += 0.5f
		
		if (p.mouseY < height / 10 * 2)
			Camera.transform.position.y -= 0.5f
		else if (p.mouseY >= height / 10 * 8)
			Camera.transform.position.y += 0.5f
		
		Camera.zoom = 0.5f
	}
	
	override fun keyPressed(event: KeyEvent) {
		InputManager.onKeyPressed(event)
	}
	
	override fun keyReleased(event: KeyEvent) {
		InputManager.onKeyReleased(event)
	}
	
	override fun keyTyped(event: KeyEvent) {
		InputManager.onKeyTyped(event)
	}
	
	override fun mouseMoved(event: MouseEvent) {
		InputManager.onMouseMoved(event)
	}
	
	override fun mousePressed(event: MouseEvent) {
		InputManager.onMousePressed(event)
	}
	
	override fun mouseReleased(event: MouseEvent) {
		InputManager.onMouseReleased(event)
	}
	
	override fun mouseClicked(event: MouseEvent) {
		InputManager.onMouseClicked(event)
	}
	
	override fun mouseDragged(event: MouseEvent) {
		InputManager.onMouseDragged(event)
	}
	
	override fun mouseEntered(event: MouseEvent) {
		InputManager.onMouseEntered(event)
	}
	
	override fun mouseExited(event: MouseEvent) {
		InputManager.onMouseExited(event)
	}
}