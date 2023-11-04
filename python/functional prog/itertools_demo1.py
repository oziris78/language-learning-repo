import itertools

my_iter = itertools.zip_longest([40,41,42,43,44,45],[0,1],fillvalue=999)
print(next(my_iter))    # (40, 0), (41, 1), (42, 999), (43, 999), (44, 999), (45, 999), StopIteration
print(next(my_iter))    # (40, 0), (41, 1), (42, 999), (43, 999), (44, 999), (45, 999), StopIteration
print(next(my_iter))    # (40, 0), (41, 1), (42, 999), (43, 999), (44, 999), (45, 999), StopIteration
print(next(my_iter))    # (40, 0), (41, 1), (42, 999), (43, 999), (44, 999), (45, 999), StopIteration
print(next(my_iter))    # (40, 0), (41, 1), (42, 999), (43, 999), (44, 999), (45, 999), StopIteration
print(next(my_iter))    # (40, 0), (41, 1), (42, 999), (43, 999), (44, 999), (45, 999), StopIteration
