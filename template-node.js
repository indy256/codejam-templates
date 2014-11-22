// node template-node.js < A-small.in > A-small.out

function main() {
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
                a.sort(function(a, b) { return a - b; });
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
}

// auxiliary code
process.stdin.resume();
process.stdin.setEncoding('utf8');

var inputBuffer = '', curLine = 0;

function readline() {
    return inputBuffer[curLine++];
}

function print(data) {
    process.stdout.write(data + '\n');
}

process.stdin.on('data', function (chunk) {
    inputBuffer += chunk;
});

process.stdin.on('end', function () {
    inputBuffer = inputBuffer.split('\n');
    main();
});
