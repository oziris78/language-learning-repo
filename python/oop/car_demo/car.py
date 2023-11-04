

class Car:
    def __init__(self, year, model):
        self.__year = year
        self.__model = model
        
    def getYear(self):
        return self.__year
    
    def setYear(self, year):
        self.__year = year
        
    def getModel(self):
        return self.__model
    
    def setModel(self, model):
        self.__model = model