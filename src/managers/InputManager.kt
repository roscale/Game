package managers

import components.Input
import core.Camera
import core.World
import minus
import p
import plus
import div
import processing.core.PVector
import processing.event.KeyEvent
import processing.event.MouseEvent

fun pointInRect(point: PVector, pos: PVector, size: PVector): Boolean =
		point.x >= pos.x &&
		point.x < pos.x + size.x &&
		point.y >= pos.y &&
		point.y < pos.y + size.y


object InputManager {
	val inputs = ArrayList<Input>()
	val oldMousePos = PVector()
	val relMouse = PVector()

	fun update() {
		val mousePos = PVector(p.mouseX.toFloat(), p.mouseY.toFloat())

		relMouse.set(mousePos - oldMousePos)
		oldMousePos.set(mousePos)
	}

	fun onKeyPressed(event: KeyEvent) {
		World.gameObjects.forEach { it.onKeyPressed(event) }
	}

	fun onKeyReleased(event: KeyEvent) {

	}

	fun onKeyTyped(event: KeyEvent) {
		World.gameObjects.forEach { it.onKeyTyped(event) }
	}

	fun onMouseMoved(event: MouseEvent) {
		val worldPos = Camera.windowToWorldCoords(PVector(event.x.toFloat(), event.y.toFloat()))
		val relPos = PVector.div(relMouse, Camera.zoom)

		for (input: Input in inputs) {
			if (pointInRect(worldPos, input.gameObject!!.transform.position + input.offset, input.size)) {
				input.gameObject!!.onMouseMoved(worldPos, relPos, event)
				return
			}
		}
	}

	fun onMousePressed(event: MouseEvent) {
		val worldPos = Camera.windowToWorldCoords(PVector(event.x.toFloat(), event.y.toFloat()))

		for (input: Input in inputs) {
			if (pointInRect(worldPos, input.gameObject!!.transform.position + input.offset, input.size)) {
				input.gameObject!!.onMousePressed(worldPos, event)
				return
			}
		}
	}

	fun onMouseReleased(event: MouseEvent) {
		val worldPos = Camera.windowToWorldCoords(PVector(event.x.toFloat(), event.y.toFloat()))

		for (input: Input in inputs) {
			if (pointInRect(worldPos, input.gameObject!!.transform.position + input.offset, input.size)) {
				input.gameObject!!.onMouseReleased(worldPos, event)
				return
			}
		}
	}

	fun onMouseClicked(event: MouseEvent) {
		val worldPos = Camera.windowToWorldCoords(PVector(event.x.toFloat(), event.y.toFloat()))

		for (input: Input in inputs) {
			if (pointInRect(worldPos, input.gameObject!!.transform.position + input.offset, input.size)) {
				input.gameObject!!.onMouseClicked(worldPos, event)
				return
			}
		}
	}

	fun onMouseDragged(event: MouseEvent) {
		val worldPos = Camera.windowToWorldCoords(PVector(event.x.toFloat(), event.y.toFloat()))
		val relPos = PVector.div(relMouse, Camera.zoom)

		for (input: Input in inputs) {
			if (pointInRect(worldPos, input.gameObject!!.transform.position + input.offset, input.size)) {
				input.gameObject!!.onMouseDragged(worldPos, relPos, event)
				return
			}
		}
	}
}