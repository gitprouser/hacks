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
