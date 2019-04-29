package fr.alegent.Swingy;

import fr.alegent.Swingy.models.Coordinate;
import lombok.val;
import javax.validation.Validation;

public class Main {

    public static void main(String[] args) {
        val coordinates = new Coordinate(-1, -1);
        val validator = Validation.buildDefaultValidatorFactory().getValidator();
        val violations = validator.validate(coordinates);

        if (violations.isEmpty()) {
            System.out.println(coordinates);
            return ;
        }

        for (val violation: violations) {
            val error = String.format("%s %s", violation.getPropertyPath(), violation.getMessage());
            System.err.println(error);
        }
    }

}
