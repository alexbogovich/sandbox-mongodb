package io.github.alexbogovich.sandboxmongodb.model;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropObject implements Prop {
    private Map<String, Prop> objects = new HashMap<>();

    private String value;
}
