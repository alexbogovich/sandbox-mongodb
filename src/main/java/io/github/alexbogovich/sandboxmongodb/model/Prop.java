package io.github.alexbogovich.sandboxmongodb.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class Prop implements Serializable {
    protected String value;
}
