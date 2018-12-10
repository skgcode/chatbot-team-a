[![Waffle.io - Columns and their card count](https://badge.waffle.io/skgcode/chatbot-team-a.svg?columns=all)](https://waffle.io/skgcode/chatbot-team-a) 
# Chatbot Real Estate
We have to create a real estate chatbot from scratch for house purchases - rentals that will offer the best service to customers 24/7 . The chatbot should answer frequently asked questions whether customers are homeowners or interested.
It should solve their queries and possible problems, as well as be user-friendly to facilitate the service of the users.

# Website Implementation:

To complete this project, we used open standards and frameworks. For the UI and the navigation bar, we used Bootstrap v3.3.7, for the result page we used the Coveo Javascript Search Framework, for the footer we used Font-Awesome and for the UI chatbot we used Normalize. 

To implement it, we created an index html which by default loads the header, the footer and the carousel, which is just for visuals. 
Whenever the user presses any of the items in the navigation bar, it loads the content of that html into the <div> element with the id "webpage", which by default has the carousel in it. This is implement by event listeners with jQuery. 

The "FAQs" page and the "About Us" page use accordions and they expand and shrink on click. 

The "Contact" form is also just for visuals(as is the "map" which is actually an image) and doesn't actually submit the form in the server.

When you click on "List your Property", it loads a form in which someone can submit a new properties in the database which is also just for visuals.

In the search bar, there are the parameters based on which the user can search for a property only in Thessaloniki. When the user selects something from each dropdown and presses on the "Let's Go" button, it sends a call to the server for a query search in the database based on the filters selected.

# Chatbot REA

The creation of the bot was the main goal of this whole project. 

To create it, we used Dialogflow (former api.ai) which is a framework from Google and is used to create bots in general and deploy them easily in many sites. 
REA is the name of our bot which stands for Real Estate Agent.

In Dialogflow we had to train the bot to be able to understand the input of the user so that it could chat successfully with the user in order to help her/him what she/he wants. 

We had to create Entities, also known as keywords, that the bot could understand during the conversation.Then, these Entities had to be mapped with Intents. To define how conversations work, you create Intents in your agent that map user input to responses. In each Intent, you define examples of user utterances that can trigger the Intent, what to extract from the utterance, and how to respond.

In the Intents, we created follow-ups for a more controlled and guided conversation between the bot and the user. 

Our bot, generally, recognizes human names (we had to train it on some specific ones for this purpose). 
The chatbot couldn't directly be connected to our database, so, in order to display the properties from our database to user based on their filters, we had to get the parameters on the frontend based on the JSON file that the Dialogflow sends, and then send the request to the backend for it to make a query search and then display them in the index. That was achieved using a javascript function which searched the message bubble for specific words and when it found them it, it send the corresponding request to the server. 

For more information on how the Dialogflow works, check the documentation in the link below:
https://dialogflow.com/docs

# Building it as a Web App

To make it work as whole, we had to build it as a web app. To achieve that, we used the Spring Framework. We added the database in SQL, wrote all the exposed API calls in Java and wrapped the html,css, and javascript files using Maven. The WebApp runs locally on each machine using Tomcat as server.

# Sources

For more documentation on the frameworks we used check out these links : 

Bootstrap - https://getbootstrap.com/docs/

Font Awesome - https://fontawesome.com/v4.7.0/

Normalize - https://yuilibrary.com/yui/docs/cssnormalize/

Coveo Javascript Search Framework - https://docs.coveo.com/en/313/javascript-search-framework/getting-started-with-the-javascript-search-framework

Tomcat - http://tomcat.apache.org/

Spring Framework - https://spring.io/guides

Java - https://docs.oracle.com/javase/tutorial/
