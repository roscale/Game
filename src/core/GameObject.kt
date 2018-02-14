package core

import components.*

open class GameObject : IEvents {
	val components = ArrayList<Component>()
	var transform: Transform = Transform(this)

	init {
		components.add(transform)

		World.addQueue.add(this)
	}

	fun getComponent(type: ComponentType): Component = components.first { it.getType() == type }

	fun addComponent(type: ComponentType): Component =
		when (type) {
			ComponentType.Transform -> {
				transform
			}
			ComponentType.Physics -> {
				val component = Physics(this)
				components.add(component)
				component
			}
			ComponentType.SpriteRenderer -> {
				val component = SpriteRenderer(this)
				components.add(component)
				component
			}
			ComponentType.Input -> {
				val component = Input(this)
				components.add(component)
				component
			}
			ComponentType.TextRenderer -> {
				val component = TextRenderer(this)
				components.add(component)
				component
			}
		}

	fun removeComponent(component: Component) = components.remove(component)
}
