package com.github.codersparks.brickorganiser.model.rebrickable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model to represent a Rebrickable Piece
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RebrickablePiece {

    private String id;

    private String description;

    private String category;
}
