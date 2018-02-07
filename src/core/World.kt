package core

import com.sun.jmx.remote.internal.ArrayQueue
import managers.DrawingManager
import managers.PhysicsManager
import p
import java.util.*

object World {
    val gameObjects = ArrayList<GameObject>()
    val addQueue = ArrayQueue<GameObject>(10)

    fun remove(gameObject: GameObject) {
        gameObjects.remove(gameObject)
    }

    fun tick() {
        PhysicsManager.update()

        p.translate(-Camera.transform.position.x, -Camera.transform.position.y)
        p.scale(Camera.zoom)

        p.background(0f)
        DrawingManager.draw()
    }
}