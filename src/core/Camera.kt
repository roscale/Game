package core

import plus
import processing.core.PVector

object Camera : GameObject() {
	var zoom = 1.0f

	fun windowToWorldCoords(coords: PVector): PVector =
			(transform.position + coords) / zoom
}