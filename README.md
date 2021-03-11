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

### Changes of Lukas Bobik
1. Added new `Tea` class
	- `Tea` can be with or without milk and/or sugar
	- is non alcoholic
1. Added a new `Liquid` (water) to `Main`, created a new `Tea`
1. Merged `Main` class over github, but directly inside Intellij

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
   Again fix the formulation of SoftDrink method as there were errors.
