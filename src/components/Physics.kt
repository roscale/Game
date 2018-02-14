package components

import core.GameObject
import core.World
import managers.PhysicsManager
import processing.core.PVector

class Physics(gameObject: GameObject) : Component(gameObject) {
	val gravity = PVector(0f, 0.1f)
	val velocity = PVector()
	val acceleration = PVector()

	init {
		PhysicsManager.physicsComponents.add(this)
	}

	override fun getType() = ComponentType.Physics

	override fun destroy() {
		World.queue.add(Runnable {
			PhysicsManager.physicsComponents.remove(this)
		})
		gameObject = null
	}
}