# Drinks project of BSD20

## General info
**Name of the repository**: Konf_B20_Bobik_Steirer  
**Members**: Lukas Bobik and Andreas Steirer

---

## Motivation
This is a simple example project for the subject 'Configuration Mangement' in 2021.  
The main purpose of it is getting to know GIT and all its commands,  
but also to get used to technologies like Maven, Junit etc.

---

## Submissions

As base for this project we got a zip file, containing  4 java classe (Drink(abstract), Liquid, SimpleDrink, Main)

### Submission 1
Each group member had to derive a new class from Drink/SimpleDrink or from the class his/her groupmate created.<br>
Create an Object from this class in the Main class, and call a method that prints text that includes infos for each drink.<br>
Merge your files in a github repository.

**Procedure:**<br>
To extend a class from an abstracted class, all methods from abstract class have to be implemented in the new class.<br>
The new class needs a constructor, and for every attribute there has to be at least a getter (setter optional, if you set attributes with the constructor and never want to change them).<br>
In the toString method, you can create a custom message that gets shown if you print the object from main class.
In the Main class you create one new object from the new class, and print toString.<br>
Then merge it with your groupmate
(The code is pretty rudimental, not sure what else i should explain)

### Submission 2
Each group member had to create a new git branch for every class that he/she created, and implement JUnit tests, and try to get a coverage of 100%,<br>
adapt all his/her java classes to follow javadoc guidelines, and then push each branch onto the github server before merging it into the main branch.

**Procedure:**<br>
To start a new test (for example SimpleDrinkTest), you create a new test class (in Intellij, you can autocreate test classes (ALT+Paste, then choose test and mark what methods you want to test) or just create a new class in src/test).
One test object (simpledrink) acts as attribute, and for every method in the base class there has to be one test method.

'@BeforeEach' indicates a method that is executed before every test.<br>
'@Test' is used in front of test methods<br>
'@DisplayName(string)' in front of a testmethod is used to display a different name for a test<br>
With assertEquals(param, param) you can test if a method return what it should. As first parameter you type what is expected, the second is called by the method. If it's the same, the test gets passed.
To test methods like setName, you set the name during the test, and call it by getName.
(thats done for all methods.  The code is pretty easy and self explaining, so I won't explain it in detail for all classes and methods)



---


## JavaDoc CrashCourse
Javadoc tool is a tool from JDK, for generating documentation in HTML format.<br>
In order to for the tool to create documentation from .java files, comments inside code have to be written as javadoc comments.<br>
Javadoc comments are similar to normal comments, but with a second asterisk at the beginning of the first comment line.

         /**
          *
          */

JavaDoc comments are written in HTML, placed in front of class, field or method declaration and contain two parts, a description and block tags.
Description simply means what a class or method does, preferred in a way more descriptive than can be read from the method name.
Block tags contain important infos and references.

Some common block tags:<br>
**@author** (Name of the programmer, only for classes and interfaces, multiple @authors should be order chronological)<br>
**@version** (tells the version of the software, classes and interfaces only)<br>
**@param** (what parameters are used in a method, methods and constructors only, should be listed as in the argument's order)<br>
**@return** (what a method returns, methods only)<br>
**@exception/@throws** explains cases in which an exception is expected)<br>
**@see** (links or references something)<br>
**@since** (tells in what version a class or method was added)<br>
**@deprecated** (tells why code is deprecated and what the alternatives are)<br>

for further infos read:
https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html


---

## Test Coverage

**Cocktail**<br>covered all methods and lines

**LongDrink**<br>covered all methods and lines

**Smoothie**<br>covered all methods and lines

**Fruit**<br>covered all methods and lines

**Tea**<br>covered all methods and lines

**SimpleDrink**<br>covered all methods and lines

**Liquid**<br>covered all methods and lines

---

## Changelog

### Version 1.0

#### Added classes
- Brand
- SoftDrink
- Tea
- Cocktail
- Smoothie
- Fruit

### Changes of Lukas Bobik
#### Version 1.0
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
  
6. **Commit**: adds a new drink subclass `Smoothie` and a `Fruit` class as ingredients 
   Add corresponding new `Smoothie` to main method. 
   (also adds a small gimmick that praises the superiority of milkshakes over normal smoothies if milk is chosen as liquid)
   
7. **Commit**: update descriptions and format

#### Version 2.0
1. **Commit**: add LongDrink class that extends Drink class, and contains 1 alcoholic liquid and 1 softdrink
   fixed a small typo in fruit class
   
1. **Commit** add and implements a Test class for Tea, and removed an unnecessary constructor from Tea

---

### Changes of Andreas Steirer
#### Version 1.0
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

---

### Version 2.0

#### Added classes
- LongDrink

#### Changes of Lukas Bobik
1. **Commit**: add LongDrink class that extends Drink class, and contains 1 alcoholic liquid and 1 softdrink
   fixed a small typo in fruit class
   
1. **Commit** add tests for Tea, removed unnecessary constructor

1. **Commit** add tests for Smoothie and Fruit classes

1. **Commit** add tests for Longdrink class

1. **commit** add missing javdoc descriptions

1. **commit** merged my test branches to main

1. **commit** add tests for Liquid and SimpleDrink classes

1. **commit** minor change to some test names

1. **commit** changes to readme (Test coverage, Javadocs)
   
#### Changes of Andreas Steirer
