# YahtzeeW0ah

                Welcome to the Yahtzee game

HOW TO RUN: In order to launch the application, you will have to clone it using the github link, open the project in your IDE and run the main class that exists in the src folder. (It is outside any other the MVC packages.)

CLASS DIAGRAM: http://postimg.org/image/epafv84oz/
SEQUENCE DIAGRAM: http://postimg.org/image/pgqosqd1r/ 

DOMAIN MODEL: http://postimg.org/image/qp9lsjl5h/ 



WHAT WE DID: Me and daniel implemented the game yahtzee, following the instructions provided in the assignment on the coursepress page. We tried to follow Object Oriented Design as much as we could as well as implement as many requerments as we could.
We also looked alot on your implementation of the blackjack game and were inspired of how the game->rule->player relations. So we tried to create our yahtzee to operate in a similar way.

The one requierment we were unable to implement was the computer AI system as we found it too complicated and hard to do, especially considering the time we had to complete this assignment. We had an idea for a simple one, which would check the possible categories and always attempt to either score in the highest scoring category and then move down through the rest. Or simply always score in the first available category. But we chose to focus more on doing our best to complete as many of the other requirements first, which in the end meant that we didn't have enough time to create an AI.

Another thing you might notice in your database class ( DB ) is that we tried to use serializable to implement the save/load game function, but it didnt work out very well since we had too little knowlage of how it works, so we used an arraylist instead. This means that the user is able to save and load games, but only as long as the execution is not stopped. We were planning on perhaps making a MYSQL database, but we prioritized this lower since we have shown that we know how to make one in the Yachtclub assignment.
We tried to ensure that as many errors as possible were handled through good error messages on invalid input and similar, and we think we got almost all of them. We used recursive methodcalls to return the user to the same step if an incorrect input was entered, so the user doesnt lose their progress in say trying to score in a category.

We tried to keep as much of the previous feedbacks in mind regarding MVC, hidden dependencies and similar. And we hope that this will be enough to pass the course.
