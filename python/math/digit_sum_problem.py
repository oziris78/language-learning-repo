

def print_all_nums(up_until):
    for i in range(up_until+1):
        digit_sum = get_digit_sum(i)
    
        if i == digit_sum:
            print(i)


def get_digit_sum(i: int):
    str_i = str(i)
    digit_sum = 0
    for j in range(len(str_i)):
        digit_sum += int(str_i[j]) ** 3
    return digit_sum



    
if __name__ == '__main__':
    print_all_nums(1000)



