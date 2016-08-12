def rod_cutting(prices, desired_length):
	dp_prices = [0] * (desired_length + 1)
	dp_prices[1] = prices[1]

	for length in range(2, desired_length + 1):
		for sub_length in range(length + 1):
			dp_prices[length] = prices[length]
			dp_prices[length] = max(dp_prices[length], dp_prices[sub_length] + dp_prices[length - sub_length])

	print dp_prices
	return dp_prices[desired_length]

print rod_cutting([0,3,4,7,10,12], 4)


// TJ code

def maxRevenue(rodPrice,length):

    maxArray = [0]*len(rodPrice)

    maxArray[0] = rodPrice[0]
    
    for i in range(0,length+1):
        
        if i == 0:
            maxArray[0] = rodPrice[0]
            continue

        maxPrice = 0

        for j in range(0,i+1):
            print maxPrice
            print rodPrice[j] + maxArray[i-j]
            maxPrice = max(rodPrice[j], maxArray[j-i]  + maxArray[i-j])

        maxArray[i] = maxPrice
  
    print maxArray 
    return maxArray[length]



rodPrice = [2,3,5,8,10,13,15]
print maxRevenue(rodPrice,5)
