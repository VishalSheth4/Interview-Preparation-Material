Problem statement : TicTacToe 
Features :
    Timed game
    Undo feature
    Spectature
    Statistics
    Tournaments
    AI
    Ratings as per each game played.

Choose a subset of problem to tackle in low level design.

Common features in game problem :
    Timed gamed
    undo
    statistics/ratings after game.

Class :
    Board - 2d matrix (Used in TicTacToe, Chess, snakes)
    Winner - 4 state (FIRST, SECOND, DRAW, UNDECIDED)
    -> Behavior board will have
        intialize2DMatrix()
        getWinner()
        getCurrentPlayer() - (Flag between to player.)
        makeMove() - row, col

    User -
        userID
        statistics

    Game -
        gameId
        userId
        ListOf<Moves>


    Observation :
        A win always uses the let move.
        Only X can win after their move.
        After each move you need to check col,row,diagonal.