

import random
import string
import os
os.chdir(os.path.dirname(__file__))


word_length = 50
letter_ratio = 0.35 # [0, 1]
word_count = 10


with open("random_strings.txt", "a+") as file:
    file.truncate(0)
    for i in range(word_count):
        s = str()
        for j in range(word_length):
            m = random.randint(1,99)
            if(m > letter_ratio * 100):
                s += str(random.randint(1,9))
            else:
                s += str(random.sample(string.ascii_letters, 1))[2]
        if(i == word_count-1): 
            file.write(s)
        else: 
            file.write(s + "\n")
            
        

