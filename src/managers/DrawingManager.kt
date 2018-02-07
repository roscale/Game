package managers

import components.SpriteRenderer
import p
import processing.core.PVector

object DrawingManager {
    val spriteRenderers = ArrayList<SpriteRenderer>()

    fun draw() {
        for (spriteRenderer in spriteRenderers) {
            with (spriteRenderer.gameObject.transform.position) {
                if (spriteRenderer.image != null) {
                    if (spriteRenderer.size == PVector(0f, 0f)) {
                        p.image(spriteRenderer.image, x, y)
                    } else {
                        p.image(spriteRenderer.image, x, y, spriteRenderer.size.x, spriteRenderer.size.y)
                    }
                }
            }
        }
    }
}