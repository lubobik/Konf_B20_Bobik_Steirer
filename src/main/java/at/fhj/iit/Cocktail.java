package at.fhj.iit;

import java.util.List;
import java.util.stream.Collectors;

public class Cocktail extends Drink {

    private final List<Liquid> liquids;

    /**
     * Creates a Cocktail object with a give name and some included liquids
     *
     * @param name name of the drink
     */
    public Cocktail(String name, List<Liquid> liquids) {
        super(name);
        this.liquids = liquids;
    }

    /**
     * Returns the sum of included liquids in liters
     *
     * @return volume of the cocktail
     */
    @Override
    public double getVolume() {
        return liquids
                .stream()
                .mapToDouble(Liquid::getVolume)
                .sum();
    }

    /**
     * Retrieves the total alcohol volume in percent
     *
     * @return alcohol volume percent
     */
    @Override
    public double getAlcoholPercent() {
        return (isAlcoholic() ?
                liquids
                        .stream()
                        .filter(liquid -> liquid.getAlcoholPercent() > 0)
                        .mapToDouble(liquid -> (liquid.getVolume() * (liquid.getAlcoholPercent() / 100)))
                        .sum() / getVolume()
                : 0.0) * 100.0;
    }

    /**
     * States if the cocktail is alcoholic or not
     *
     * @return true when alcoholic liquids are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        return liquids
                .stream()
                .anyMatch(liquid -> liquid.getAlcoholPercent() > 0);
    }

    /**
     * Formatted output of a Cocktail object
     */
    @Override
    public String toString() {
        String formattedLiquidNames = liquids
                .stream()
                .map(Liquid::getName)
                .collect(Collectors.joining(", "));
        String totalAlcoholPercentage = String.format("%.2f", getAlcoholPercent());

        return "The '" + name + "' includes following ingredients [" +
                formattedLiquidNames + "] with a total alcohol percentage of " + totalAlcoholPercentage + "%.";
    }
}
