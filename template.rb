name = "A-small"
path = ""

$stdin = File.open path + name + ".in", "r"
$stdout = File.open path + name + ".out", "w"

test_cases = gets.to_i

test_cases.times do |test_case|

  line = gets.split
  cmd = line[0]
  n = line[1].to_i
  a = line[2..-1].map(&:to_f)

  if cmd == "median"
    res = a.sort[n / 2]
  elsif cmd == "mean"
    res = a.inject { |sum, e| sum + e }.to_f / a.size
  end

  print "Case ##{test_case+1}: #{format("%.10f", res)}\n"
end
