package org.ienumerable.wonderland.generation.field;

import java.util.function.Function;

public class MathFunction extends Field{

    private final double scale, factor, phase;
    private final Fn fn;
    private final Axis axis;

    public MathFunction(double scale, double factor, double phase, String fn, String axis) {
        this.scale = scale;
        this.factor = factor;
        this.phase = phase;
        this.fn = Fn.valueOf(fn.toUpperCase());
        this.axis = Axis.valueOf(axis.toUpperCase());
    }

    @Override
    public Boolean getPos(int x, int y, int z) {
        int a = axis.get(x, z);
        double v = fn.get((a + phase) * scale) * factor;
        return y <= v;
    }

    private enum Fn{
        SIN(Math::sin),
        COS(Math::cos),
        TAN(Math::tan),
        EXP(Math::exp),
        LOG(Math::log);

        private final Function<Double, Double> fn;
        public double get(double x){
            return fn.apply(x);
        }

        Fn(Function<Double, Double> fn) {
            this.fn = fn;
        }
    }

    private enum Axis{
        X((x, z) -> x),
        Z((x, z) -> z);

        private final TriFunction fn;
        public int get(int x, int z){
            return fn.get(x, z);
        }

        Axis(TriFunction fn) {
            this.fn = fn;
        }

    }

    interface TriFunction{
        int get(int x, int z);
    }
}
