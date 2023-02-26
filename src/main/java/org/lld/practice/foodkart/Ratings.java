package org.lld.practice.foodkart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Ratings {
    private final int star;
    private final Comment comment;

    public Ratings(int star, final String comment) throws Exception {
        if (star < 0 || star > 5)
            throw new Exception("Invalid Input");
        this.comment = new Comment(comment);
        this.star = star;
    }

    @Setter
    private User user;

    @Setter
    private Restaurants restaurants;
}
