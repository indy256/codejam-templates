// d8 template.js < A-small.in > A-small.out

var testCases = readline();

for (var testCase = 1; testCase <= testCases; ++testCase) {
    var line = readline().split(' ');
    var cmd = line[0];
    var n = parseInt(line[1]);
    var a = [];
    for (var i = 0; i < n; i++) {
        a[i] = parseFloat(line[i + 2]);
    }

    var res;

    switch (cmd) {
        case "median":
            a.sort();
            res = a[n >> 1];
            break;
        case "mean":
            var sum = 0;
            for (var j = 0; j < n; j++) {
                sum += a[j];
            }
            res = sum / n;
            break;
    }

    print('Case #' + testCase + ': ' + res.toFixed(10))
}
