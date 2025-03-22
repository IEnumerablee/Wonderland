package org.ienumerable.wonderland.generation.field;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.ienumerable.wonderland.generation.layers.BlockProvider;
import org.ienumerable.wonderland.generation.layers.Signature;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Rect.class, name = "rect"),
        @JsonSubTypes.Type(value = MathFunction.class, name = "math"),
})
public abstract class Field implements BlockProvider<Boolean> {
    public String type;

    public abstract Boolean getPos(int x, int y, int z);

    @Override
    public Signature<Boolean> get(int x, int y, int z) {
        return new Signature<>(x, y, x, getPos(x, y, z));
    }
}
