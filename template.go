package main

import (
	"fmt"
	"sort"
)

func main() {
	var testCases int
	fmt.Scanln(&testCases)

	for testCase := 1; testCase <= testCases; testCase++ {
		var cmd string
		var n int
		fmt.Scan(&cmd, &n)

		a := make([] float64, n)
		for i := range a {
			fmt.Scan(&a[i])
		}

		var res float64 = 0

		if cmd == "median" {
			sort.Float64s(a)
			res = a[n / 2]
		} else {
			var sum float64 = 0
			for i := range a {
				sum += a[i]
			}
			res = sum / float64(n)
		}

		fmt.Printf("Case #%d: %.10f\n", testCase, res)
	}
}
