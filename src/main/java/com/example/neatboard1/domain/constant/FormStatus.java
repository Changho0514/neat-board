package com.example.neatboard1.domain.constant;

import lombok.Getter;
import org.hibernate.cache.spi.entry.StructuredCacheEntry;

public enum FormStatus {
    CREATE("저장", false),
    UPDATE("수정", true);

    @Getter private final String description;
    @Getter private final Boolean update;

    FormStatus(String description, Boolean update) {
        this.description = description;
        this.update = update;
    }
}
