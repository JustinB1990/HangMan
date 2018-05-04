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
    * Track how many wrong guesses our user makes and limit them to 3 incorrect guesses.
 
 After creating my to-do list, I began to list out the methods I would need to create in order to accomplish 
 all of the necessary tasks this program would involve:
 
 * A method that will initialize a new game, selecting a Movie title from our list at random.
 * A method that will take the Movie title that was chosen and create the `hiddenWord`.
 * A method that takes in a User's guess.
 * A method that takes the User's guess and compares it to the movie title. Changing the dashes in the `hiddenWord`.
 * A method that will check to see if the user has won the game.
 * A 'getter' method that will return how many wrong guesses the user has made.
 
 As I began working on each method, I would periodically test to see if the outcome of that method would be as I expected.
 
 ---
 I started by creating the `newGame()` method - using `System.out.println()` to make sure the program would initialize and assign 
 a movie title from the text file to `gameAnswer`. After successfully doing this, I then figured out the logic to choosing the 
 Movie Title at random.
 
 I did this by running a loop that would iterate over the text file and increment a variable for each line in that file.
 Then I would multiply that variable by `Math.random()` to get a random number between 0 and the number of lines in that text file.
 
 ---
 Now that I was able to pull a random Movie title from my list, I needed to figure out how to hide the title with dashes.
 I figured I would start with an empty string, loop over the Movie title, and concatenate dashes or spaces appropriately.
 I ran into a little trouble with trying to concatenate chars onto strings, but I quickly figured out the issue with a google search.
 
 ---
