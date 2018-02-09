package core

import processing.core.PVector
import processing.event.KeyEvent
import processing.event.MouseEvent

interface IEvents {
    fun onKeyPressed(pos: PVector, event: KeyEvent) {}
    fun onKeyReleased(pos: PVector, event: KeyEvent) {}
    fun onKeyTyped(pos: PVector, event: KeyEvent) {}
    fun onMouseMoved(pos: PVector, event: MouseEvent) {}
    fun onMousePressed(pos: PVector, event: MouseEvent) {}
    fun onMouseReleased(pos: PVector, event: MouseEvent) {}
    fun onMouseClicked(pos: PVector, event: MouseEvent) {}
    fun onMouseDragged(pos: PVector, event: MouseEvent) {}
    fun onMouseEntered(pos: PVector, event: MouseEvent) {}
    fun onMouseExited(pos: PVector, event: MouseEvent) {}
}
