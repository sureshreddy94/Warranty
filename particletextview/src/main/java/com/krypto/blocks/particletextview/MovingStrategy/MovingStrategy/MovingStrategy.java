package com.krypto.blocks.particletextview.MovingStrategy.MovingStrategy;

import com.krypto.blocks.particletextview.MovingStrategy.Object.Particle;

public abstract class MovingStrategy {
    public abstract void setMovingPath(Particle particle, int rangeWidth, int rangeHeight, double[] targetPosition);
}
