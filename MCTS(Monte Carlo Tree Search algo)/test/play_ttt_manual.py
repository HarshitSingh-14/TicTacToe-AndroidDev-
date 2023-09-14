from src import ttt

tictactoe = ttt.TicTacToe()
player = 1

state = tictactoe.get_initial_state()

while True:
    print(state)
    valid_moves = tictactoe.get_valid_moves(state)
    print("valid moves", [i for i in range(tictactoe.action_size) if valid_moves[i] == 1])
    action = int(input(f"{player}:"))

    if valid_moves[action] == 0:
        print("action not valid")
        continue

    state = tictactoe.get_next_state(state, action, player)

    value, is_terminal = tictactoe.get_value_and_terminated(state, action)

    if is_terminal:
        print(state)
        if value == 1:
            print(player, "won")
        else:
            print("draw")
        break

    player = tictactoe.get_opponent(player)
