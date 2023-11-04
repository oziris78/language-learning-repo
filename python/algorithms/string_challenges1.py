


vowel_list = ['a','e','i','o','u','A','E','I','O','U']

def remove_vowels(string):
    for i in vowel_list: 
        string = string.replace(i, '')
    return string


def remove_consonants(string):
    for i in string:  
        if i not in vowel_list: 
            string = string.replace(i, '')
    return string
    

reverse_string = lambda s: s[::-1]


def spinning_sentence(sentence):
    result = ''
    for word in sentence.split(' '):
        if len(word) >= 5: result += word[::-1]
        else: result += word
        result += ' '        
    return result[:-1]

def how_many_duplicate_letters(text):
    occured_once = []
    occured_atleast_twice = []
    for c in text:
        c = str(c).lower()
        if c in occured_once:
            if c not in occured_atleast_twice:
                occured_atleast_twice.append(c)
        else:
            occured_once.append(c)
    return len(occured_atleast_twice)
    



print(remove_vowels("This website is for losers LOL!"))
print(remove_consonants("This website is for losers LOL!"))
print(spinning_sentence("This website is for losers LOL!"))
print(reverse_string("This website is for losers LOL!"))

print(how_many_duplicate_letters('abcde'))             # 0
print(how_many_duplicate_letters('aabbcde'))           # 2 
print(how_many_duplicate_letters('aabBcde'))           # 2
print(how_many_duplicate_letters('indivisibility'))    # 1
print(how_many_duplicate_letters('indivisibilities'))  # 2
print(how_many_duplicate_letters('aA11'))              # 2
print(how_many_duplicate_letters('ABBA'))              # 2







