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

    /**
     * Constructor for creating a game.
     * @param name the name of the game
     * @param desc a fitting description of the game
     * @param price the amount a user have to pay to be able to purchase the game
     * @param genre which genre the game is
     * @param ageLimit an age limit that confirms that the game contains content suitable for a certain age and above
     */
    public Game(String name, String desc, double price, Genre genre, int ageLimit) {
        super(name, desc, price);
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
