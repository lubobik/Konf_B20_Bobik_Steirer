# Drinks project of BSD20


## General info
**Name of the repository**: Konf_B20_Bobik_Steirer  
**Members**: Lukas Bobik and Andreas Steirer

---

## Motivation
This is a simple example project for the subject 'Configuration Mangement' in 2021.  
The main purpose of it is getting to know GIT and all its commands,  
but also to get used to technologies like Maven, etc.

---

## Changelog

### Added classes
- Brand
- SoftDrink
- Tea
- Cocktail

### Changes of Lukas Bobik
1. **Commit**: add new `Tea` class
   Add a new tea and print tea to main method
   Add "sugar" as attribute
   
1. **Commit**: merge  
  Merge Main class, done in IntelliJ directly
   
1. **Commit**: 
   Add a new attribute to Tea "Milk"
   Changes to toString Method
   
3. **Commit**: 
   Add setter  
   updates to some method description and small code changes  
   changes to toString  

4. **Commit**: 
   Updates to README.md
   
5. **Commit**: 
    Small readme changes
  
6. **Commit**: adds a new drink subclass "Smoothie" and a "Fruit" class as ingredients 
   Add corresponding new Smoothie to main method. 
   (also adds a small gimmick that praises the superiority of milkshakes over normal smoothies if milk is chosen as liquid)
   
7. **Commit**: update descriptions and format

    
    
 
   

### Changes of Andreas Steirer
1. **Commit**: add Brand enum  
   Add a `Brand` enumeration for future use in our drinks-project.  
   This enum represents a cleaner way of handling different static types in our implementation.  
   **Additional information**:  
   - Introduce title variable to achieve a better readable name.
   - Implement toString-Method for cleaner / easier usage of Brand.
   
1. **Commit**: add SoftDrink class  
   Add `SoftDrink` which extends from the already defined `Liquid` class.  
   Additional parameter `Brand` can be found in there specifying the newly  
   defined `Liquid` (`SoftDrink`) a little further.  
   Next to that soft drinks always got a name and a volume. For the variable `alcoholPercent`
   a default value (0.0) is passed to the super constructor as there is never alcohol in a `SoftDrink`.
   
1. **Commit**: minor changes to SimpleDrink class  
   Some formatting clean-up and simplification of an expression.

1. **Commit**: add .gitignore file to disable change tracking for the specified files    
   Introduce a .gitignore file to the root of the project, 
   to get rid of the annoying generated IDE and build files in our changelist.
   
1. **Commit**: add description to Brand getter / setter in SoftDrink  
   Introduce a description to the two extra specified methods because of the Brand implementation.
   
1. **Commit**: update structure of README  
   Clean-up and extend structure of `README`. Introduce mark-up syntax and some general information.
   
1. **Commit**: minor changes to Brand enum (do not use same naming like base implementation)  
   Prevent a misuse / shadow of the main `name` definition of an enumeration. We now use `title` instead.
   
1. **Commit**: update README with commit- and changelog-history and minor formatting changes  
   Extend the already defined structure with all the changes I applied to the project.
   Apply auto-formatting to all project files.
   
1. **Commit**: minor changes to toString method of SoftDrink  
   Update the `toString` method in terms of formulation.
   
1. **Commit**: clean-up in Main class  
   Minor clean-up work to prevent too much code duplication.
   
1. **Commit**: fix mismatch in SoftDrink toString formulation  
   Again fix the formulation of `SoftDrink` method as there were errors.
   
1. **Commit**: update description of SoftDrink  
   Fix some wrong descriptions inside `SoftDrink` class.

1. **Commit**: add Cocktail class which extends from Drink and add corresponding Main demonstration  
   Implement a second class / beverage called `Cocktail` to make sure, 
   that I do not act against the task description (inherit from `Drink` / `SimpleDrink`) :D
   The new `Cocktail` class and later on its objects contain information about its name and included liquids.
   The implementation of the inherited methods uses information of the object
   to compute values such as the total alcohol percentage and the volume of the whole `Cocktail`. 
   It also states if the `Cocktail` includes alcohol or not as a little shortcut.
