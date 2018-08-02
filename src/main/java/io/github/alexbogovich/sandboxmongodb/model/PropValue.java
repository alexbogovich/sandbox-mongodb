package io.github.alexbogovich.sandboxmongodb.model;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
//@NoArgsConstructor
public class PropValue extends Prop {
    public PropValue(String value) {
        this.value = value;
    }
}
