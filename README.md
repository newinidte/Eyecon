# Eyecon

PLease find the Execution steps and the technology and tools involved
1.Maven
2.Spring Boot
3.Java
4.RestAPI
5.JPA & Hibernate
6.MYSQL
7.POSTMAN - To test the RESTful Service

Few Asumption Made due to time constraints( Not able to complete few things :-))
1. No time to create frontend HTML, so tested the Restful service using postman
Samples are
a.    {
      "player1Action": "ROCK"     - Play with the server     
     }
b.   {
      "player1Action": "ROCK",     - Playing two players
      "player2Action": "SCISSORS"
    }
    
2. Not able to create all tables, so made the data available in one table which is "game_audit_result"
game_audit_result contains - ID, player1Action,Player2Action,Winner

Restful service 
1. POST - Determine who is the winner and insert data into DB
2.GET - Get all details of the match in the DB
 
 Sample output of GET(WE can restrict the output to single player as well... again time shortage :-))
 [
    {
        "id": 1,
        "player1Action": "ROCK",
        "player2Action": "ROCK",
        "winnerPlayer": "T"
    },
    {
        "id": 2,
        "player1Action": "ROCK",
        "player2Action": "PAPER",
        "winnerPlayer": "B"
    }
]

