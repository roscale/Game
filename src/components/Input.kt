package components

import core.GameObject
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
}