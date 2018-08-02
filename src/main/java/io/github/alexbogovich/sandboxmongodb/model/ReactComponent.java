package io.github.alexbogovich.sandboxmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document
@TypeAlias("ReactComponent")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReactComponent implements Serializable {
    @Id
    private String id;
    private String name;
    private List<ReactElement> reactElements;
}
