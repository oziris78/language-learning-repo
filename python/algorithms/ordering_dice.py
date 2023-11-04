

def game_result(dice1, dice2):
    dice_win1 = 0
    dice_win2 = 0
    s1 = dice1[0]
    s2 = dice2[0]
    dice1 = dice1[1:]
    dice2 = dice2[1:]
    for elem in dice1:
        for elem2 in dice2:
            if elem > elem2:
                dice_win1 += 1
    for elem in dice2:
        for elem2 in dice1:
            if elem > elem2:
                dice_win2 += 1
    print(s1 + "-" + s2 + " : " + str(dice_win1) + "-" + str(dice_win2))
                

def apply_all_dices(dices):
    for dice in dices:
        index = dices.index(dice)
        for i in range(index+1, len(dices)):
            game_result(dice, dices[i])



dice1 = ["A", 1, 4, 5]
dice2 = ["B", 2, 5, 9]
dice3 = ["C", 3, 6, 10]
dice4 = ["D", 0, 11,12]


apply_all_dices( [dice1, dice2, dice3, dice4] )