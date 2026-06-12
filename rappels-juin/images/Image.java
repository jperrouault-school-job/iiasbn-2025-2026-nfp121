package images;

import java.util.UUID;

public class Image {
    private UUID id = UUID.randomUUID();

    public String getId() {
        return this.id.toString();
    }
}
