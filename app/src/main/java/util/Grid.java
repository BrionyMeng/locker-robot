package util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Grid {
    public status occupationStatus;

    public int id;

    public Grid(int id) {
        this.id = id;
    }

    public enum status{
        occupied,
        empty
    }
}
