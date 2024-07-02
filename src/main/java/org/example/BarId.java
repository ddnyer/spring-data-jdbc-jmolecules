package org.example;

import org.jmolecules.ddd.types.Identifier;

import java.util.UUID;

public record BarId(UUID uuid) implements Identifier {
}
