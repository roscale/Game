package components
import core.GameObject

enum class ComponentType {
    Transform,
    Physics,
    SpriteRenderer,
    Input
}

abstract class Component(val gameObject: GameObject) {
    abstract fun getType(): ComponentType
}