def rod_cutting(length_prices, length)
  max_prices =  [0] * (length + 1)
  1.upto(length) do |l|
    max = 0
    length_prices.each_with_index do |lp, i|
      if l >= lp
        max = [max, lp + length_prices[l - lp]].max
      end
    end
    max_prices[l] = max
  end
  max_prices[length]

