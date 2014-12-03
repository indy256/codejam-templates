// node template.js < A-small.in > A-small.out

function main() {
    var testCases = nextInt();

    for (var testCase = 1; testCase <= testCases; ++testCase) {
        var cmd = next();
        var n = nextInt();
        var a = [];
        for (var i = 0; i < n; i++) {
            a[i] = parseFloat(next());
        }

        var res;

        switch (cmd) {
            case "median":
                a.sort(function (a, b) {
                    return a - b;
                });
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
var curTokens = [], curToken = 0;

function next() {
    while (curToken >= curTokens.length) {
        curTokens = readline().split(/[\s]+/);
        curToken = 0;
    }
    return curTokens[curToken++];
}

function nextInt() {
    return parseInt(next());
}

// code for nodejs
var inputBuffer = '', curLine = 0;

function readline() {
    return inputBuffer[curLine++];
}

function print(data) {
    process.stdout.write(data + '\n');
}

process.stdin.resume();
process.stdin.setEncoding('utf8');

process.stdin.on('data', function (chunk) {
    inputBuffer += chunk;
});

process.stdin.on('end', function () {
    inputBuffer = inputBuffer.split(/[\s]+/);
    main();
});
