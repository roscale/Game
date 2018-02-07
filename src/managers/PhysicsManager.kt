package managers

import components.Physics
import plus
import plusAssign
import timesAssign

object PhysicsManager {
    val physicsComponents = ArrayList<Physics>()

    fun update() {
        for (physicsComponent in physicsComponents) {
            physicsComponent.velocity += (physicsComponent.gravity + physicsComponent.acceleration)
            physicsComponent.acceleration *= 0f

            physicsComponent.gameObject.transform.position += physicsComponent.velocity
        }
    }
}