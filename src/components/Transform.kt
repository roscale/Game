package components
import core.GameObject
import processing.core.PVector

class Transform(gameObject: GameObject): Component(gameObject) {
    val position = PVector()

    override fun getType(): ComponentType {
        return ComponentType.Transform
    }
}