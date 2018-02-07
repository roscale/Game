package components

import core.GameObject
import managers.DrawingManager
import processing.core.PImage
import processing.core.PVector

class SpriteRenderer(gameObject: GameObject): Component(gameObject) {
    var image: PImage? = null
    val size = PVector(0f, 0f)

    init {
        DrawingManager.spriteRenderers.add(this)
    }

    override fun getType(): ComponentType {
        return ComponentType.SpriteRenderer
    }
}