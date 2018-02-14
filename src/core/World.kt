package core

import managers.DrawingManager
import managers.InputManager
import managers.PhysicsManager
import p
import java.util.*

object World {
	val gameObjects = ArrayList<GameObject>()
	val addQueue = ArrayDeque<GameObject>()

	val queue = ArrayDeque<Runnable>()

	fun remove(gameObject: GameObject) {
		queue.add(Runnable {
			gameObjects.remove(gameObject)
		})
	}

	fun tick() {
		while (queue.isNotEmpty()) {
			val runnable = queue.pop()
			runnable.run()
		}

		while (addQueue.isNotEmpty()) {
			val go = addQueue.pop()
			gameObjects.add(go)
		}


		InputManager.update()
		PhysicsManager.update()

		for (gameObject: GameObject in gameObjects) {
			gameObject.onUpdate()
		}

		p.translate(-Camera.transform.position.x, -Camera.transform.position.y)
		p.scale(Camera.zoom)

		DrawingManager.draw()
	}
}