package main

import (
	"bufio"
	"bytes"
	"io"
	"math/rand"
	"os"
	"runtime"
	"sort"
	"strconv"
	"strings"
	"sync"
	"time"
)

const (
	name             = "A-small"
	path             = ""
	float64Precision = 10
	procs            = 4 //number of goroutines to be processed concurrently
)

//number of test cases
var TestCases int

var scGlobal *bufio.Scanner
var wGlobal *bufio.Writer
var answers []bytes.Buffer

func main2(sc *bufio.Scanner, w *bytes.Buffer) {
	//place your code here
	cmd := next(sc)
	n := nextInt32(sc)
	a := make([]float64, n)
	for i := 0; i < n; i++ {
		a[i] = nextFloat64(sc)
	}
	if cmd == "median" {
		sort.Float64s(a)
		printFloat64(w, a[n/2])
	} else {
		if cmd == "mean" {
			res := a[0]
			for i := 1; i < n; i++ {
				res += a[i]
			}
			printFloat64(w, res/float64(n))
		}
	}
}

func next(sc *bufio.Scanner) string {
	if ok := sc.Scan(); !ok {
		if sc.Err() == nil {
			panic("unexpected EOF")
		} else {
			panic(sc.Err().Error())
		}
	}
	return sc.Text()
}
func nextInt32(sc *bufio.Scanner) int {
	if n, err := strconv.Atoi(next(sc)); err != nil {
		panic(err.Error())
	} else {
		return n
	}
}
func nextInt64(sc *bufio.Scanner) int64 {
	if n, err := strconv.ParseInt(next(sc), 10, 64); err != nil {
		panic(err.Error())
	} else {
		return n
	}
}
func nextFloat64(sc *bufio.Scanner) float64 {
	if n, err := strconv.ParseFloat(next(sc), 64); err != nil {
		panic(err.Error())
	} else {
		return n
	}
}

func space(w io.ByteWriter) { w.WriteByte(' ') }
func endl(w io.ByteWriter)  { w.WriteByte('\n') }

//strSlice := []string{"1", "2", "3"}
//print(strSlice...)

func print(w io.ByteWriter, s ...string) {
	for i, str := range s {
		if i > 0 {
			endl(w)
		}
		for _, y := range str {
			w.WriteByte(byte(y))
		}
	}
}
func printInt32(w io.ByteWriter, n ...int) {
	for i, x := range n {
		if i > 0 {
			space(w)
		}
		for _, y := range strconv.Itoa(x) {
			w.WriteByte(byte(y))
		}
	}
}
func printInt64(w io.ByteWriter, n ...int64) {
	for i, x := range n {
		if i > 0 {
			space(w)
		}
		for _, y := range strconv.FormatInt(x, 10) {
			w.WriteByte(byte(y))
		}
	}
}
func printFloat64(w io.ByteWriter, n ...float64) {
	for i, x := range n {
		if i > 0 {
			space(w)
		}
		for _, y := range strconv.FormatFloat(x, 'f', float64Precision, 64) {
			w.WriteByte(byte(y))
		}
	}
}

func init() {

	//init concurrency
	runtime.GOMAXPROCS(procs)

	//init I/O
	if f, err := os.Open(path + name + ".in"); err != nil {
		panic(err.Error())
	} else {
		scGlobal = bufio.NewScanner(f)
	}
	if f, err := os.Create(path + name + ".out"); err != nil {
		panic(err.Error())
	} else {
		wGlobal = bufio.NewWriter(f)
	}
	scGlobal.Split(bufio.ScanWords)

	//init RNG
	rand.Seed(time.Now().UnixNano())
}

func main() {
	TestCases = nextInt32(scGlobal)

	answers = make([]bytes.Buffer, TestCases)

	scGlobal.Split(bufio.ScanLines)

	var wg sync.WaitGroup

	for i := 0; i < TestCases; i++ {
		testCaseData := ""
		linesInTestCase := 1
		for j := 0; j < linesInTestCase; j++ {
			if j > 0 {
				testCaseData += "\n"
			}
			testCaseData += next(scGlobal)
		}
		testCaseData += "\n"
		sc := bufio.NewScanner(strings.NewReader(testCaseData))
		sc.Split(bufio.ScanWords)

		wg.Add(1)
		go func(sc *bufio.Scanner, b *bytes.Buffer) {
			defer wg.Done()
			main2(sc, b)
		}(sc, &answers[i])
	}

	wg.Wait()

	for i, ans := range answers {
		if i > 0 {
			endl(wGlobal)
		}
		print(wGlobal, "Case #"+strconv.Itoa(i+1)+": ")
		wGlobal.Write(ans.Bytes())
	}
	endl(wGlobal)
	wGlobal.Flush()
}
