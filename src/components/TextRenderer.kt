package components

import core.GameObject
import p
import processing.core.PApplet
import processing.core.PConstants.CENTER
import processing.core.PFont

class TextRenderer(gameObject: GameObject): Component(gameObject) {
	var text: String = "Default"
	var size = 16f
	var color: Int = p.color(128)
	var font: PFont? = null
	var rotation = 0f

	fun show() {
		with(gameObject!!.transform.position) {
			p.pushMatrix()

			p.translate(x, y)
			p.rotate(rotation)
			p.translate(-x, -y)

			p.textSize(size)
			p.fill(color)
			p.text(text, x, y)

			p.popMatrix()
		}
	}

	override fun getType(): ComponentType {
		return ComponentType.TextRenderer
	}

	override fun destroy() {
		gameObject = null
	}
}