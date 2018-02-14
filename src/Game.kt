import core.GameObject
import core.World
import managers.InputManager
import processing.core.PApplet
import processing.core.PVector
import processing.event.KeyEvent
import processing.event.MouseEvent
import components.ComponentType
import components.Physics
import components.TextRenderer
import processing.core.PImage
import java.io.File
import java.lang.System.gc

fun main(args: Array<String>) {
	PApplet.main("Game")
}

lateinit var p: PApplet

class Letter(letter: String, color: Int, size: Float): GameObject() {
	var rotation: Float = 0f

	init {
		val tr = addComponent(ComponentType.TextRenderer) as TextRenderer
		tr.text = letter
		tr.color = color
		tr.size = size
		rotation = p.random(0.1f, 0.3f)

		val physics = addComponent(ComponentType.Physics) as Physics

		physics.gravity.set(0f, 1f)
	}

	fun start() {
		val physics = addComponent(ComponentType.Physics) as Physics

		val f = (PVector(p.width / 2f, 0f) - transform.position)

		physics.acceleration.set(f / p.random(20f, 30f))
	}

	override fun onUpdate() {
		val tr = getComponent(ComponentType.TextRenderer) as TextRenderer

		tr.rotation += rotation

		if (transform.position.y > p.height * 2) {
			World.remove(this)
			letterList.remove(this)
		}
	}
}

val letterList = arrayListOf<Letter>()

class KeyboardListener: GameObject() {
	init {
		addComponent(ComponentType.Input)
	}

	override fun onKeyTyped(event: KeyEvent) {
		val r = p.random(150f, 255f)
		val g = p.random(150f, 255f)
		val b = p.random(150f, 255f)

		val letter = Letter("${event.key}", p.color(r, g, b), p.random(p.width / 100f, p.width / 5f))
		letterList.add(letter)
		letter.transform.position.set(p.random(0f, p.width.toFloat()), p.height.toFloat())
		letter.start()

//		gc()
	}
}

class Game : PApplet() {
	lateinit var a: GameObject

	init {
		p = this
	}

	override fun settings() {
		size(1920, 1020)
	}

	override fun setup() {
		frameRate(60f)
		bg = loadImage("res/bg.jpg")

		KeyboardListener()
	}

	lateinit var bg: PImage
	override fun draw() {
		image(bg, 0f ,0f)
		World.tick()
//		println(World.gameObjects)
//		println(letterList)
		letterList.forEach { (it.getComponent(ComponentType.TextRenderer) as TextRenderer).show() }
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
}
