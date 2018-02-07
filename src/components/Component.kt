package components
import core.GameObject

enum class ComponentType {
    Transform,
    Physics,
    SpriteRenderer
}

abstract class Component(gameObject: GameObject) {
    val gameObject: GameObject = gameObject

    abstract fun getType(): ComponentType
}