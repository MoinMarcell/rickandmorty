package com.github.moinmarcell.rickandmorty.model;

import java.util.List;

public record Response(
        List<Result> results
) {
}
