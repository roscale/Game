package managers

import components.Input
import core.Camera
import core.IEvents
import plus
import processing.core.PVector
import processing.event.KeyEvent
import processing.event.MouseEvent

fun pointInRect(point: PVector , pos: PVector, size: PVector): Boolean =
        point.x >= pos.x &&
        point.x < pos.x + size.x &&
        point.y >= pos.y &&
        point.y < pos.y + size.y

object InputManager {
    val inputs = ArrayList<Input>()

    fun onKeyPressed(event: KeyEvent) {

    }

    fun onKeyReleased(event: KeyEvent) {

    }

    fun onKeyTyped(event: KeyEvent) {

    }

    fun onMouseMoved(event: MouseEvent) {

    }

    fun onMousePressed(event: MouseEvent) {
        val worldPos = Camera.windowToWorldCoords(event.x.toFloat(), event.y.toFloat())

        for (input: Input in inputs) {
            if (pointInRect(worldPos, input.gameObject.transform.position + input.offset, input.size)) {
                input.gameObject.onMousePressed(worldPos, event)
                return
            }
        }
    }

    fun onMouseReleased(event: MouseEvent) {

    }

    fun onMouseClicked(event: MouseEvent) {

    }

    fun onMouseDragged(event: MouseEvent) {

    }

    fun onMouseEntered(event: MouseEvent) {

    }

    fun onMouseExited(event: MouseEvent) {

    }
}