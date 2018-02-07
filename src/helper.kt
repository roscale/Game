import processing.core.PVector

operator fun PVector.plus(v: PVector): PVector = PVector.add(this, v)
operator fun PVector.plusAssign(v: PVector) { this.add(v) }

operator fun PVector.minus(v: PVector): PVector = PVector.sub(this, v)
operator fun PVector.minusAssign(v: PVector) { this.sub(v) }

operator fun PVector.times(f: Float): PVector = PVector.mult(this, f)
operator fun PVector.timesAssign(f: Float) { this.mult(f) }
