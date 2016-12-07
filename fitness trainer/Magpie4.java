/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 *      Uses advanced search for keywords 
 *</li><li>
 *      Will transform statements as well as react to keywords
 *</li></ul>
 * @author Laurie White
 * @version April 2012
 *
 */
public class Magpie4
{
    /**
     * Get a default greeting   
     * @return a greeting
     */ 
    public String getGreeting()
    {
        return "Hello, let's get fit. Practice your endurance, strength, balance, and flexibility";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        
        statement = statement.toLowerCase();
        
        if (statement.length() == 0)
        {
            response = "Say something, please.";
        }
        else if (findKeyword(statement, "yes") >= 0)
        {
            response = "Tuck in those gluts.";
        }

        else if (findKeyword(statement, "no") >= 0)
        {
            response = "Tuck in those gluts.";
        }
        
        // Responses which require transformations
        else if (findKeyword(statement, "i need you", 0) >= 0)
        {
            response = "Yes you do to get fit.";
        }
        else if (findKeyword(statement, "endurance", 0) >= 0)
        {
            response = "Let's work on your endurance. Do some mild jogging and slowly increase your speed and length each time.";
        }
        else if (findKeyword(statement, "strength", 0) >= 0)
        {
            response = "Let's work on your strangth. Hit the gym and pump some iron.";
        }
        else if (findKeyword(statement, "balance", 0) >= 0)
        {
            response = "Let's work on your balance! Improving the core and lower-body muscles by standing on one leg, balancing on a wobble board, take a taichi class, or walk heel to toe";
            
        }
        else if (findKeyword(statement, "flexibility", 0) >= 0)
        {
            response = "Let's work on your flexibility. Touch your toes.";
        }
        else if (findKeyword(statement, "intensity", 0) >= 0)
        {
            response = "Let's step up the intensity!";
        }
         else if (findKeyword(statement, "Sweat", 0) >= 0)
        {
            response = "Sweat is just fat crying!";
        }
         else if (findKeyword(statement, "Stronger", 0) >= 0)
        {
            response = "Be Stronger than your excuses!";
        }
         else if (findKeyword(statement, "Doctor", 0) >= 0)
        {
            response = "An apple a day keeps the doctor away.";
        }           
          else if (findKeyword(statement, "Just", 0) >= 0)
        {
            response = "Just Do It.";
        }
         else if (findKeyword(statement, "Running", 0) >= 0)
        {
            response = "Start running today.";
        }
         else if (findKeyword(statement, "Smile", 0) >= 0)
        {
            response = "Sweat, smile, and repeat.";
        }
         else if (findKeyword(statement, "Clear", 0) >= 0)
        {
            response = "Clear your mind, close your eyes and deep breath.";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        
        //  Refinement--make sure the goal isn't part of a word 
        while (psn >= 0) 
        {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " "; 
            if (psn > 0)
            {
                before = phrase.substring (psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }
            
            //  If before and after aren't letters, we've found the word
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
                    && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            
            //  The last position didn't work, so let's find the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
            
        }
        
        return -1;
    }
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }
    


    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 10;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Let's get a good stretch.";
        }
        else if (whichResponse == 1)
        {
            response = "Let's tone up those legs.";
        }
        else if (whichResponse == 2)
        {
            response = "Feel the burn in your thighs and gluts.";
        }
        else if (whichResponse == 3)
        {
            response = "Don't forget to take a deep breath when exerting yourself.";
        }
        else if (whichResponse == 4)
        {
            response = "You're wobbling. Try to keep your balance.";
        }
        else if (whichResponse == 5)
        {
            response = "Watch your posture. Keep those gluts tucked in!";
        }
        else if (whichResponse == 6)
        {
            response = "Be aware of your body as you move.";
        }

        else if (whichResponse == 7)
        {
            response = "You're wobbling. Try to keep your balance.";
        }
        else if (whichResponse == 8)
        {
            response = "Now that was a great workout?";
        }
        else if (whichResponse == 9)
        {
            response = "Exercise everyday to tone your body.";
        }
        



        return response;
    }

}
