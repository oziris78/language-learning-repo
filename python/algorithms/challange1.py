

# https://www.youtube.com/watch?v=rqjth5hPqN8

def array_diff(arr1 : list, arr2 : list):
    return [elem for elem in arr1 if arr2.count(elem) == 0]


# print(array_diff([-1,1,2,3], [-1,1]))
# print(array_diff([-1,1,2,3], [-1]))
# print(array_diff([-1,1,2,3], [1]))
# print(array_diff([-1,1,2,3], [-1,3]))
# print(array_diff([-1,1,2,3], [-1,3,2]))
# print(array_diff([-1,1,2,3], [-1,3,2,1]))



def phone_number(n : list):
    return "(" + ''.join(map(str, n[0:3])) + ") " + ''.join(map(str, n[3:6])) + "-" + ''.join(map(str, n[6:10]))


# print( phone_number([1,2,3,4,5,6,7,8,9,0]) )


def generate_hashtag(s : str):
    result = s.strip().title().replace(' ', '')
    if len(result) + 1 > 140 or s == '' or result == '': return False
    else: return '#' + result
    
print( generate_hashtag("hello guys my name is jeff") )
print( generate_hashtag("never gonna give you up never gonna let you down ") )
print( generate_hashtag('') )
print( generate_hashtag(' ') )