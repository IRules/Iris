package com.volmit.iris.util.noise;

import com.volmit.iris.util.math.RNG;
import org.jetbrains.annotations.NotNull;

public class OffsetNoiseGenerator implements NoiseGenerator {
    private final NoiseGenerator base;
    private final double ox, oz;

    public OffsetNoiseGenerator(NoiseGenerator base, long seed) {
        this.base = base;
        RNG rng = new RNG(seed);
        ox = rng.nextDouble(Integer.MIN_VALUE, Integer.MAX_VALUE);
        oz = rng.nextDouble(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public double noise(double x) {
        return base.noise(x + ox);
    }

    @Override
    public double noise(double x, double z) {
        return base.noise(x + ox, z + oz);
    }

    @Override
    public double noise(double x, double y, double z) {
        return base.noise(x + ox, y, z + oz);
    }

    @Override
    public boolean isNoScale() {
        return base.isNoScale();
    }

    @Override
    public boolean isStatic() {
        return base.isStatic();
    }

    @NotNull
    public NoiseGenerator getBase() {
        return base;
    }
}
