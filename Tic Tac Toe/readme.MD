# Distributed Tic-Tac-Toe

The aim of the project was to develop a distributed Tic Tac Toe, in a client-server setup using Java RMI protocol.
You can think of the server as moderator conducting the game. The server will be maintaining the state of the game and also the server will be one providing APIs to inquire or change the state of board.
Clients will be the player, which will inquire or play their chance by remotely calling the server APIs.

## Conduct

### Server-Client Relationship
1. Server will be up always.
2. User will deal only with client. User should be prompted to start the game. As
soon as she wants to play, client should connect to server prompting to join the
game.
3. At a time, only two clients can be connected to server. The server should send a
Busy/Wait message in case third client wants to connect.

### Game Play
1. When first client connects, the server should wait for the second client to connect and send a corresponding message to the first client.
2. As soon as second client connects, it assigns player1/player2 randomly to the two clients and should start the game. Player 1 has ‘x’ marker and Player 2 has ‘o’ marker.
3. Whichever player has to make a move will receive the current state of the board from the server and other player will wait for the other player to make a move. Respective messages should be displayed for both.
4. Player 1 is requested to make a move first.
5. As soon as Player 1 makes the move, updates in the board state will be made
and Player 2 will receive the updated board state.
6. When the game is over:
a. Player who won should get the “Win” message
b. Player who lost should get the “Lose” message
c. In case of draw, both should get “Draw” message.
d. Both should be prompted with “Play another game?” message. If both
agrees, fresh game should start else both the clients disconnect and
close.

### Input/Output
1. Please follow the input/output guidelines for smooth evaluation.
2. Server will not output anything.
3. When client runs, it should prompt the user if she wants to join the game.
4. On joining, if other player has not joined, respective message should be
displayed.
5. When game starts, Player1/Player2 should be displayed for respective user.
6. Whichever player has to make a move will have her client print the board state
and prompt for an input. Other player will receive a “Wait for your turn” message.
7. When game is over, respective Win/Lose/Draw should be displayed and a prompt should be made to the user by client to play another game.
8. User should input 1/0 to play another game.
