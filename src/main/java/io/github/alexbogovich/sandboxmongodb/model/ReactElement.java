package io.github.alexbogovich.sandboxmongodb.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReactElement implements Serializable {
    private String type;
    private Map<String, Prop> props = new HashMap<>();
    // children could be simple string - value, nested element, and element with refer to ReactComponent
    // TODO: extend children three different options
    private List<ReactElement> children = new ArrayList<>();
}
