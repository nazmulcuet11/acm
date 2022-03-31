def validStartingCity(distances, fuel, mpg):
    numberOfCities = len(distances)
    remaingMilesCapacity = 0
    
    startingCityIdx = 0
    remaingMilesCapacityAtStartingCityIdx = 0
    for i in range(numberOfCities):
        if remaingMilesCapacity < remaingMilesCapacityAtStartingCityIdx:
            startingCityIdx = i
            remaingMilesCapacityAtStartingCityIdx = remaingMilesCapacity

        remaingMilesCapacity = remaingMilesCapacity + fuel[i] * mpg - distances[i]

    return startingCityIdx
