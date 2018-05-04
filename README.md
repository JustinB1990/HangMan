# HangMan

This is a personal project that simulates a game of HangMan using movie titles as the subject.

I approached this project in a way that was specified through instructions.
There are a lot of ways I could have made this game, but the instructions given were to 
create a single class, Game, that would hold the methods used for the HangMan Game.

When starting out on a blank page, I wrote out a to-do list:
* Figure out how to read the text file that contains the possible Movie Names the game would use.
* Once I can read the text file, I want to select a single line from that file and store it into a variable, `gameAnswer`.
* Then I want to figure out how to change the letters in the string to dashes creating a new variable, `hiddenWord`.
* Now I want to check if a letter is in the Movie Name and if it is, reveal those letters in `hiddenWord`.
* Once I am able to do all of the above, then I can begin implementing the smaller things such as:
    * Using `Math.random()` to be able to choose the Movie name from the file at random.
    * Using Scanner to read user input.
    * Check to make sure the user is only guessing a single letter, and make sure the user hasn't previously made the same guess.
    * Check to see if the user had fully guessed the `gameAnswer`.
    * Track how many wrong guesses the user makes and limit them to 3 incorrect guesses.
 
 After creating my to-do list, I began to list out the methods I would need to create in order to accomplish 
 all of the necessary tasks this program would involve:
 
 * A method that will initialize a new game, selecting a Movie title from the list at random.
 * A method that will take the Movie title that was chosen and create the `hiddenWord`.
 * A method that takes in a User's guess.
 * A method that takes the User's guess and compares it to the movie title. Changing the dashes in our `hiddenWord`.
 * A method that will check to see if the user has won the game.
 * A 'getter' method that will return how many wrong guesses the user has made.
 
 As I began working on each method, I would periodically test to see if the outcome of that method would be as I expected.
 
 ---
 I started by creating the `newGame()` method - using `System.out.println()` to make sure the program would initialize and assign 
 a movie title from our text file to `gameAnswer`. After successfully doing this, I then figured out the logic to choosing the 
 Movie Title at random.
 
 I did this by running a loop that would iterate over the text file and increment a variable for each line in that file.
 Then I would multiply that variable by `Math.random()` to get a random number between 0 and the number of lines in that text file.
 
 ---
 Now that I was able to pull a random Movie title from my list, I needed to figure out how to hide the title with dashes.
 I figured I would start with an empty string, loop over the Movie title, and concatenate dashes or spaces appropriately.
 I ran into a little trouble with trying to concatenate chars onto strings, but I quickly figured out the issue with a google search.
 
 ---
 After having my `gameAnswer` and my `hiddenWord`, I wanted to take a letter, compare it to each letter in `gameAnswer` 
 and if there are any matches, reveal that letter in the appropriate place in the `hiddenWord`.
 
 I considered using `indexOf()` to do this, but I would still need to run a loop in the case that there would be multiple characters to reveal in the `hiddenWord`. I figured - if I'm going to run a loop, instead of calling a function to return the position of a specific char, It would be easier to just loop over the string `gameAnswer` and compare each character in the string to the letter I'm looking for.
 
I can see using `indexOf()` if my string contained hundreds or thousands of characters, but these strings are very small as they are movie titles.

---
Now that I have a random `gameAnswer`, that answer hidden with dashes as `hiddenWord`, and I can now compare a letter and reveal any matches in the `hiddenWord` - it was time to actually make this a game.

1. I integrated `Scanner` to take in a guess from the user.
2. I made a loop in `main` that would exit out once the `hiddenWord` had fully been revealed.
      * I decided to make a method that would compare `hiddenWord` to `gameAnswer` to see if they matched.
3. I added a String `ArrayList` that would hold each answer our user would give. I would be able to iterate over this `ArrayList` to see if our user is repeating a guess, and if they are, give them a chance to make a different guess.
4. I added a loop to make sure that our user wasn't entering in more than one letter.
5. I added a counter that kept track of the number of incorrect guesses our user would make - and then included that counter in the `main`'s `while` loop so that the game out end after 3 incorrect guesses.

---
After completing all of those smaller changes, the Movie Hangman game came together quickly.
