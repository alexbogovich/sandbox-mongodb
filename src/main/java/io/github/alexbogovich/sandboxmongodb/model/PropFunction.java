package io.github.alexbogovich.sandboxmongodb.model;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
//@NoArgsConstructor
public class PropFunction extends Prop {
    public PropFunction(String value) {
        this.value = value;
    }
}
