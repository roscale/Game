package components

import core.GameObject
import core.World
import managers.InputManager
import processing.core.PVector

class Input(gameObject: GameObject) : Component(gameObject) {
	val offset = PVector()
	val size = PVector()

	init {
		InputManager.inputs.add(this)
	}

	override fun getType(): ComponentType {
		return ComponentType.Input
	}

	override fun destroy() {
		World.queue.add(Runnable {
			InputManager.inputs.remove(this)
		})
		gameObject = null
	}
}