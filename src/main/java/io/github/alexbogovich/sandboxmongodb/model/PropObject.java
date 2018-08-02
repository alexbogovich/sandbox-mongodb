package io.github.alexbogovich.sandboxmongodb.model;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropObject extends Prop {
    private Map<String, Prop> objects = new HashMap<>();

    public PropObject(Map<String, Prop> objects, String value) {
        this.objects = objects;
        this.value = value;
    }
}
