package model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Category {
    private String id;
    private String name;
}


/*public class Category {
    private String id;
    private String name;

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}*/