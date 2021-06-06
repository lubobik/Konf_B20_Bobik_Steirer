# Developer tutorial - How can YOU use our code
We have created a CashRegister that logs sales and their 
corresponding prices for different kinds of `Drink`s.  
Those `Drink`s can consist of different ingredients.

### Ingredients

**Liquid**  
`Liquid`s are the base for every `Drink`. So, a `Drink` consists of at least one `Liquid`.   
An example would be to create a new `Liquid` called `Milk` with a volume of `0.5` 
and an alcohol percentage of `0.0`:  

```
Liquid water = new Liquid("Milk", 0.5, 0.0);
``` 

Additional documentation can be found on the JavaDoc page for 
[Liquid](apidocs/at/fhj/iit/base/Liquid.html).

**Fruit**  
`Fruit`s are ingredients for `Smoothie`s.  
Following up, an example to create a new `Fruit` called `Strawberry`:  

```
Fruit fruit = new Fruit("Strawberry");
```  

Additional documentation can be found on the JavaDoc page for 
[Fruit](apidocs/at/fhj/iit/custom/misc/Fruit.html).

**SoftLiquid**  
A `SoftLiquid` extends the `Liquid` class and has an alcohol percentage of `0.0`.  
An example would be to create a new `Orange juice` of kind `SoftLiquid` with a volume of `0.5` 
and the specified `Brand.COCA_COLA`:  

```
SoftLiquid softLiquid = 
        new SoftLiquid("Orange juice", 0.5, Brand.COCA_COLA);
``` 

Additional documentation can be found on the JavaDoc page for 
[SoftLiquid](apidocs/at/fhj/iit/custom/misc/SoftLiquid.html).

### Drinks

**General methods**  
- `getVolume()` - Returns the `Drink` volume.  
- `getAlcoholPercentage()` - Returns the alcohol percentage based on the alcoholic fluid volume(s).  
- `isAlcoholic()` - Returns true if a `Drink` has an alcoholic `Liquid`.  
- `calculatePrize()` - Is a method implemented from the `IDrinkSpecification` interface. 
It returns the price of a `Drink` based on its corresponding ingredients.  

**Cocktail**  
`Cocktail`s consist of a `List` of different alcoholic and non-alcoholic `Liquid`s.  
Following up, a little example to create a new `Cocktail` from two `Liquid`s. `Rum` with a volume of `2.0` and 
an alcohol percentage of `40.0` and `Cointreau` with a volume of `0.5` and an alcohol percentage of `35.0`:  

```
Cocktail cocktail = 
    new Cocktail("Cocktail", List.of(
       new Liquid("Rum", 2.0, 40.0), 
       new Liquid("Cointreau", 0.5, 35.0)));
```  

Additional documentation can be found on the JavaDoc page for 
[Cocktail](apidocs/at/fhj/iit/custom/Drink/Cocktail.html).

**LongDrink**  
A `LongDrink` consists out of one `Liquid` and one `SoftLiquid`.  
An example would be to create a new `LongDrink` called `Rum Cola` from a `Liquid` in form of `Rum` with a volume of `0.3`, 
an alcohol percentage of `40.0` and a `SoftLiquid` named `Cola` with a volume of `0.5` from `Brand.PEPSI`:  

```
LongDrink ´longdrink = 
    new LongDrink("Rum Cola",
         new Liquid("Rum", 0.3, 40.0), 
         new SoftLiquid("Cola", 0.5, Brand.PEPSI));
```  

Additional documentation can be found on the JavaDoc page for 
[LongDrink](apidocs/at/fhj/iit/custom/Drink/LongDrink.html).

**Smoothie**  
A `Smoothie` consists of a `Liquid`, a list of `Fruit`s and a boolean which tells if it contains sugar or not.  
An example would be to create a new `Milkshake` from one `Liquid` called `Milk`, with a volume of `0.5` and  
an alcohol percentage of `0.0`, a list of `Fruit`s including `Strawberry` and `Raspberry`. 
The shake also features no artificial sugars, so the flag will set to `false`:  

```
Smoothie milkshake = 
    new Smoothie("Milkshake", 
        new Liquid("Milk", 0.5, 0.0), 
        List.of(new Fruit("Strawberry), new Fruit("Raspberry")), false);
```   

Additional documentation can be found on the JavaDoc page for 
[Smoothie](apidocs/at/fhj/iit/custom/Drink/Smoothie.html).

**Tea**  
`Tea`s consist of one `Liquid` and booleans for sugar and / or milk.  
A simple example would be to create a new `Tea` named `Early Grey` with a volume of `0.5` and 
an alcohol percentage of `0.0`, with sugar included (`true`) and without milk (`false`):  

```
Tea tea = new Tea("Early Grey", new Liquid("Water", 0.5, 0.0), true, false);
``` 
 
Additional documentation can be found on the JavaDoc page for 
[Tea](apidocs/at/fhj/iit/custom/Drink/Tea.html).

### Cash register components

**Operator**  
An `Operator` consists out of two strings representing `first`- and `lastname`. 
Also, a custom getter method called `getFullName()` is implemented, 
which simply returns the full name (`first`- and `lastname` concatenated).

```
Operator operator = new Operator("Lukas", "Bobik");
```

Additional documentation can be found on the JavaDoc page for 
[Operator](apidocs/at/fhj/iit/custom/cashRegister/Operator.html).

**DrinkSale**  
`DrinkSale`s are created with the help of an `Operator` and a `Drink`. 
Additionally, at creation a timestamp will be stored for each sale. 
The price of each `Drink` is automatically computed through the `calculatePrize()` method 
of its individual implementation.

```
DrinkSale sale = new Drinksale(Drink drink, Operator operator);
```

Additional documentation can be found on the JavaDoc page for 
[DrinkSale](apidocs/at/fhj/iit/custom/cashRegister/DrinkSale.html).


**CashRegisterManagement**  
A `CashRegisterManagement` contains a list / history of `DrinkSale`s. 
It is possible to add either single `DrinkSale`s or even a `List` of multiple `DrinkSale`s.  

```
CashRegisterManagement cashRegisterOne = new CashRegistermanagement();  
cash.addDrinkSale(DrinkSale drinkSale);  
addMultiDrinkSales(List<DrinkSale> drinkSales);

CashRegisterManagement cashRegisterTwo = new CashRegistermanagement(List<DrinkSale> drinkSales);  
```

Methods to compute report metrics:  
- `retrieveTotal()` - Returns the sum of all sales.  
- `retrieveTotalOfNonAlcoholicBeverages()` - Returns the sum of sales for all non-alcoholic `Drink`s.   
- `retrieveTotalOfAlcoholicBeveragesWeak()` - Returns the sum of sales for all weak alcoholic `Drink`s.  
- `retrieveTotalOfAlcoholicBeveragesIntense()` - Returns the sum of sales for all hard alcoholic `Drink`s.  
- `retrieveTotalByDate(LocalDate soldAt)` - Returns the sum of sales of `Drink`s for a potential date.  
- `retrieveTotalByOperator(Operator soldBy)` - Returns the sum of sales of `Drink`s for a potential `Operator`.
- `retrieveTotalByDateAndOperator(LocalDate soldAt, Operator soldBy)` - 
Returns the sum of sales of `Drink`s for a potential `Operator` and / or of a potential date.  

The following methods use above realisations to print total sales in a formatted way to the console, 
depending on what the parameters are (specific cases are served by fallbacks):  
- `printTotal()` - Prints total sales of the whole history.  
- `printTotalOfNonAlcoholic()` - Prints the sum of sales for all non-alcoholic `Drink`s.  
- `printTotalOfWeakAlcoholic()` - Prints the sum of sales for all weak alcoholic `Drink`s.   
- `printTotalOfIntenseAlcoholic()` - Prints the sum of sales for all hard alcoholic `Drink`s.  
- `printTotalByOperator(Operator soldBy)` - Prints the sum of sales for all `Drink`s by a potential `Operator`. 
(Fallback implementation is available.)  
- `printTotalByEachOperator(LocalDate soldAt)` - Prints the individual sum of sales for all `Drink`s 
for each selling `Operator` by a potential `soldAt` date. 
(Fallback implementation is available.)  
- `printTotalByDate(LocalDate soldAt)` - Prints the sum of sales for all `Drink`s by a potential day / date.  
(Fallback implementation is available.)  
- `printTotalByDateAndOperator(LocalDate soldAt, Operator soldBy)` - 
Prints the total sales based on the passed `soldAt` and `soldBy` parameters. 
(Fallback implementation is available.)
 
Additional documentation can be found on the JavaDoc page for 
[CashRegisterManagement](apidocs/at/fhj/iit/custom/cashRegister/CashRegisterManagement.html).
All possible fallback cases are more precisely explained there.

### Other / Miscellaneous classes
Those classes are not an essential part of the CashRegister-Feature. 
They are either for utility or for demonstration purposes.  

**CashRegisterRandomizer**  
Creates a random `CashRegisterManagement` with several random `DrinkSale`s.

Further documentation can be found on the JavaDoc page for 
[CashRegisterRandomizer](apidocs/at/fhj/iit/util/CashRegisterRandomizer.html).

**DrinksUtils**  
Contains utility methods for example `printSeperator()`, `roundToTwoDecimals(double value)`, etc.

Additional documentation can be found on the JavaDoc page for 
[DrinksUtils](apidocs/at/fhj/iit/util/DrinkUtils.html).

**Main**  
Contains a demonstration for all implementations of our project,  
e.g. a demonstration for each of our implemented `Drink`-classes, can be found there.

Additional documentation can be found on the JavaDoc page for [Main](apidocs/at/fhj/iit/Main.html).