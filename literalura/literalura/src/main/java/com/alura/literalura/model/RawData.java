package com.alura.literalura.model;

import java.util.List;

public record RawData(Integer count,
                      String next,
                      String previous,
                      List<BookData> results
                        ) {
}
