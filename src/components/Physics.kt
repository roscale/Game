package components

import core.GameObject
import managers.PhysicsManager
import processing.core.PVector

class Physics(gameObject: GameObject): Component(gameObject) {
    val gravity = PVector(0f, 0.1f)
    val velocity = PVector()
    val acceleration = PVector()

    init {
        PhysicsManager.physicsComponent.add(this)
    }

    override fun getType(): ComponentType {
        return ComponentType.Physics
    }
}