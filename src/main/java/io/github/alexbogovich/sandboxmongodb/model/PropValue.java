package io.github.alexbogovich.sandboxmongodb.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropValue implements Prop {
    private String value;
}
