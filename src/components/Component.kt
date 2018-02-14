package components

import core.GameObject

enum class ComponentType {
	Transform,
	Physics,
	SpriteRenderer,
	Input,
	TextRenderer
}

abstract class Component(var gameObject: GameObject?) {
	abstract fun getType(): ComponentType
	abstract fun destroy()
}