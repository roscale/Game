package managers

import components.Physics
import plus
import plusAssign
import timesAssign

object PhysicsManager {
    val physicsComponent = ArrayList<Physics>()

    fun update() {
        for (physics in physicsComponent) {
            physics.velocity += (physics.gravity + physics.acceleration)
            physics.acceleration *= 0f

            physics.gameObject.transform.position += physics.velocity
        }
    }
}