var reversePrefix = function(word, ch) {
    let firstOccAr = word.indexOf(ch);
    let arr = word.split("");
    let i = 0;
    let j = firstOccAr;

    while (i < j) {
        let first = arr[i];
        let last = arr[j];
        console.log(first, last)
        arr[i] = last
        arr[j] = first;

        i++
        j--
    }
    return arr.join("")
};


console.log(reversePrefix("abcdefd", "d"))
