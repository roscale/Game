package core

import plus
import processing.core.PVector

object Camera: GameObject() {
    var zoom = 1.0f

    fun windowToWorldCoords(x: Float, y: Float): PVector =
            (transform.position + PVector(x, y)) / zoom
}