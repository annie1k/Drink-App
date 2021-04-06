# My Personal Project

## Possible Application Name: Drink Water
*This application aims to encourage people to drink water on 
time and will track the water drinking history*

**Functionality**:
- Set daily goals (water to drink in ml) and system will remind 
  every hour and automatically calculate how much water
  should drink to achieve the goal.
- Can increase or decrease the daily water drinking goals.
- Will show how much water have drank today by visualize it on a 
  virtual cup, and some text beside.
- Will track and record the drinking history on a calendar 
  and visualize by line graph.
- Every time user achieve drinking 100000 ml will earn a medal
  with the user's name on it, random metal from metal-bank.

**Target User**:

- People who have need for drink a certain amount of water to keep healthy,
  it can be some patients who have special needs.
  
- Public users want to track water drinking history.

- Public users want to be reminded to drink water.

**Why this application**:

I choose this theme because I often forget to drink water 
until I feel too thirsty. The main reason is my mom did a surgery
for the kidney stone in HongKong. That surgery made her suffering
from weakness for more than a month. Therefore, I want to design a water
drinking reminder application for people like her to keep her kidney healthier.
The application will have clean interface and no ads. for better user
experience.


**User Stories**:
- As a user, I want to be able to save my drinking history to file.

- As a user, I want to be able to be able to load my history that tracks the list of drinking history from file.

- As a user, I want to be able to get a suggested daily drinking.
  
- As a user, I want to be able to get a suggested daily drinking according to my age and gender if possible.
  
- As a user, I want to be able to increase or decrease my daily goals 
  according to the daily needs 
  (say want to drink more for days have heavy sports activity).
  
- As a user, I want to be able to add how many (ml) I've drunk, and
  subtract when I accidentally add the wrong amount.
  
- As a user, I want to be able to have visualized water drinking 
  process for the day.
  
- As a user, I want to be able to get some warm encourage after achieving 
  my daily goal.
  
- As a user, I want to be able to tracking my water drinking history 
  by some understandable and easy read graphs.
  
- As a user, I hope it is a free and clean application.


**Phase 4: Task 2**:

Include a type hierarchy in your code other than the one that uses the Saveable interface introduced in Phase 2.
You must have more than one subclass and your subclasses must have distinct functionality.  They must therefore 
override at least one method inherited from a super type and override it in different ways in each of the subclasses.

-more specifically: My AwardsBagPage, AddDrinkingPage, and History Page are
subpages for DrinkIt (which is the home page); So I generated a interface called
Subpages and let AwardsBagPage, AddDrinkingPage, and History Page implement it.
So, for each of them, they have to have a method called setUp and a method called quit.
Because all of them should have heavy workload to set up and have to be "closeable"