import components.ComponentType
import components.Physics
import components.SpriteRenderer
import core.Camera
import core.GameObject
import core.World
import processing.core.PApplet
import processing.core.PImage

fun main(args: Array<String>) {
    PApplet.main("Game")
}

lateinit var p: PApplet

class Game() : PApplet() {
    lateinit var go: GameObject

    init {
        p = this
    }

    override fun settings() {
        size(800, 600)
    }

    override fun setup() {
        val image = loadImage("res/wall7.bmp")

        go = GameObject()
        go.transform.position.set(width / 2f - 300f, height / 2f)


        var spriteRenderer = go.addComponent(ComponentType.SpriteRenderer) as SpriteRenderer
        spriteRenderer.image = image
        spriteRenderer.size.set(150f, 150f)

        go = GameObject()
        go.transform.position.set(width / 2f + 50f, height / 2f)


        spriteRenderer = go.addComponent(ComponentType.SpriteRenderer) as SpriteRenderer
        spriteRenderer.image = image
        spriteRenderer.size.set(150f, 150f)

//        val phyiscs = go.addComponent(ComponentType.Physics) as Physics
//
//        phyiscs.acceleration.set(2f, 0f)
//        phyiscs.gravity *= 0f
    }

    override fun draw() {
        World.tick()

        Camera.transform.position.x += 0.1f
        Camera.zoom = 0.01f
    }
}