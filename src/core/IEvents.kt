package core

import processing.core.PVector
import processing.event.KeyEvent
import processing.event.MouseEvent

interface IEvents {
	fun onUpdate() {}

	fun onKeyPressed(event: KeyEvent) {}
	fun onKeyReleased(event: KeyEvent) {}
	fun onKeyTyped(event: KeyEvent) {}
	fun onMouseMoved(pos: PVector, relPos: PVector, event: MouseEvent) {}
	fun onMousePressed(pos: PVector, event: MouseEvent) {}
	fun onMouseReleased(pos: PVector, event: MouseEvent) {}
	fun onMouseClicked(pos: PVector, event: MouseEvent) {}
	fun onMouseDragged(pos: PVector, relPos: PVector, event: MouseEvent) {}
}
