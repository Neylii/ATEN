package se.aten.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alex Gabay
 * This class represents the games being sold in the webstore and extends the Product class
 */

@Entity
public class Game extends Product implements Serializable {
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int ageLimit;

    public Game() {
    }

    public Game(Genre genre, int ageLimit) {
        super();
        this.genre = genre;
        this.ageLimit = ageLimit;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    @Override
    public String toString() {
        return "Game :" +
                ", genre:" + genre +
                ", ageLimit" + ageLimit;
    }
}
