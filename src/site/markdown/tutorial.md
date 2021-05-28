
#Developer tutorial - How can YOU use our Code
We created a CashRegister that logs sales and prices for different drinks, those drinks consist of different Ingredients.
###Ingredients

**Liquid**  
Liquids are the base for every  drink, so drink consists of at least one liquid.   
One example to create a new `Water` liquid with a volume of `0,5` and alcohol percentage of `0` would be:  
`Liquid water = new Liquid("Milk", 0.5, 0);`  
Additional documentation can be found on the JavaDoc page for [Liquid](apidocs/at/fhj/iit/base/Liquid.html)

**Fruit**  
Fruits are ingredients for smoothies  
One example to create a new `Strawberry`:  
`fruit fruit = new Fruit("Strawberry");`  
[Further infos on the JavaDoc page for Fruit](apidocs/at/fhj/iit/custom/misc/Fruit.html)

**SoftLiquid**  
SoftLiquid extends Liquid with an alcohol percentage of `0`.  
One example to create a new `Orange juice` softliquid with a volume of `0,5` and from a Brand `COCA_COLA` would be:  
`SoftLiquid softLiquid = new SoftLiquid("Orange juice", 0.5, Brand.COCA_COLA);`  
Additional documentation can be found on the JavaDoc page for [SoftLiquid](apidocs/at/fhj/iit/custom/misc/SoftLiquid.html)

###Drinks
**General methods** from Drinks  
`getVolume()` Returns the drink volume  
`getAlcoholPercentage()` Returns the alcohol percentage per volume  
`isAlcoholic` Returns true if a drink has an alcoholic liquid  
`calculatePrize()` is a method implemented from the IDrinkSpecificaation interface. It returns the price of a drink based on its ingredients  

**Cocktail**  
Cocktails consist of a List of different Liquids.  
One example to create a new `Cocktail` from 2 liquids `Rum` with a volume of `2.0` and alcohol percentage of `40` and `Cointreau` with a volume of `0.5` and percentage of `35`:  
`Cocktail cocktail = new Cocktail("Cocktail", List.of(new Liquid("Rum", 2.0, 40.0), new Liquid("Cointreau", 0.5, 35.0)));`  
Additional documentation can be found on the JavaDoc page for [Cocktail](apidocs/at/fhj/iit/custom/drink/Cocktail.html)

**LongDrink**  
Longdrink consists of one Liquid and one Softliquid.  
One example to create a new `Rom Cola` from 1 liquid `Rum` with a volume of `0.3` and alcohol percentage of `40` and a SoftLiquid `Cola` with a volume of `0.5` from Brand `PEPSI`:  
`LongDrink ´longdrink = new LongDrink("Rum Cola", new Liquid("Rum", 0.3, 40), new SoftLiquid("Cola", 0.5, Brand.PEPSI)`  
Additional documentation can be found on the JavaDoc page for [LongDrink](apidocs/at/fhj/iit/custom/drink/LongDrink.html)

**Smoothie**  
Smoothie consists of one liquid, a list of Fruits and a boolean that tells if it contains sugar.  
One example to create a new `Milkshakre` from 1 liquid `Milk` with a volume of `0.5` and alcohol percentage of `0`, a list of fruits `Strawberry and Raspberry` and without sugar `false`:  
`Smoothie milkshake = new Smoothie("Milkshake", new Liquid("Milk", 0.5, 0), List.of(new Fruit("Strawberry), new Fruit("Raspberry")), false);`  
Additional documentation can be found on the JavaDoc page for [Smoothie](apidocs/at/fhj/iit/custom/drink/Smoothie.html)

**Tea**>  
Teas consitsts of one liquid, booleans for sugar and/or milk.  
One example to create a new `Tea` Tea with a volume of `0,5` and alcohol percentage of `0`, with sugar `true` and without milk `false`:  
`Tea tea = new Tea("Early Grey", new Liquid("water", 0.5, 0), true,false);`  
Additional documentation can be found on the JavaDoc page for [Tea](apidocs/at/fhj/iit/custom/drink/Tea.html)


###Cash Register Components
**Operator**
Operater consists of 2 Strings representing first and last name and getter `getFullName()` that returns the full name.
`Operator op = new Operator("Lukas", "Bobik");`  
Additional documentation can be found on the JavaDoc page for [Operator](apidocs/at/fhj/iit/custom/cashRegister/Operator.html)

**DrinkSale**
DrinkSales are created with an operator `Person` and a `Drink`, additionally at creation `LocalTime` gets set as timestap for the sale and the price of the drink is automatically computed with`calculatePrize()`.
`DrinkSale sale = new Drinksale(Person,Drink);`  
Additional documentation can be found on the JavaDoc page for [DrinkSale](apidocs/at/fhj/iit/custom/cashRegister/DrinkSale.html)


**Cash Register Management**
CashRegisterManagement contains a list of `DrinkSales`. It's possible to add either single Drink sales or even a List of multiple DrinkSales.  
`CashRegisterManagement cash = new CashRegistermanagement();  
cash.addDrinkSale(DrinkSale drinkSale);  
addMultiDrinkSales(List<DrinkSale> drinkSales);  `

Methods to compute the total sum of sales:  
`retrieveTotalOfAlcoholicBeveragesIntense()` returns the sum of sales of all hard alcoholic drinks  
`retrieveTotalOfAlcoholicBeveragesWeak()`returns the sum of sales of all weak alcoholic drinks  
`retrieveTotalOfNonAlcoholicBeverages()`returns the sum of sales of all nonalcoholic drinks  
`retrieveTotalByDate()` returns the sum of sales of drinks of a specific date  
`retrieveTotal()` returns the sum of all sales
`retrieveTotalByOperator()` returns the sum of sales of drinks from a specific operator
`retrieveTotalByDateAndOperator()` returns the sum of sales of drinks from a specific operator of a specific date  

Some other methods use above methods to print total sales to the console, depending on what the parameters are:  
`printAlcoholicWeak()` prints the sum of sales of all weak alcoholic drinks   
`printAlcoholicIntense()` prints the sum of sales of all hard alcoholic drinks  
`printNonAlcoholic()` prints the sum of sales of all nonalcoholic drinks  
`printTotal(LocalDate date)` prints total sales depending on the parameter. If the parameter `LocalDate date` is initialized, this method prints total sales of the specific date, if the parameter is `null` the all-time sum of sales is printed  
`printOperators(LocalDate date, String fullName)` prints total sales from operatores, depending on the parameter.
if the parameter is `all` total sales from each Operator are printed, otherwise only the sales from operator `fullName`
If the parameter `LocalDate date` is initialized, this method prints total sales of the specific date, if the parameter is `null` the all-time sum of sales is printed.  
Additional documentation can be found on the JavaDoc page for [Cash Register Management](apidocs/at/fhj/iit/custom/cashRegister/CashRegisterManagement.html)

###Other classes
Those classes are not an essential part of the CashRegister. They either for utility or for demonstration purpose.  

**CashRegisterRandomizer**  
Creates a random `CashRegisterManagement` with several random `DrinkSales`
Further documentation can be found on the JavaDoc page for [CashRegisterRandomizer](apidocs/at/fhj/iit/custom/util/CashRegisterRandomizer.html)

**DrinksUtils**  
Contains utility methods for example to `printSeperatorLines()` or to `roundToTwoDecimals(double value)`.
Additional documentation can be found on the JavaDoc page for [DrinksUtils](apidocs/at/fhj/iit/custom/util/DrinksUtil.html)

**Main**  
Contains a demonstration for the implementations of our project.  
One demonstration for each of our implemented drink-classes,
Additional documentation can be found on the JavaDoc page for [Main](apidocs/at/fhj/iit/Main.html)