(ns numbers-to-words.words-test
  (:require [clojure.test :refer :all]
            [numbers-to-words.words :refer :all]))

(deftest num-to-words
  (testing "units place"
    (are [actual expected] (= actual expected)
      "one" (number-to-words [1 1])
      "two" (number-to-words [2 1])
      "three" (number-to-words [3 1])
      "four" (number-to-words [4 1])
      "five" (number-to-words [5 1])
      "six" (number-to-words [6 1])
      "seven" (number-to-words [7 1])
      "eight" (number-to-words [8 1])
      "nine" (number-to-words [9 1])))
  (testing "tens place"
    (are [actual expected] (= actual expected)
      "ten" (number-to-words [1 10])
      "twenty" (number-to-words [2 10])
      "thirty" (number-to-words [3 10])
      "forty" (number-to-words [4 10])
      "fifty" (number-to-words [5 10])
      "sixty" (number-to-words [6 10])
      "seventy" (number-to-words [7 10])
      "eighty" (number-to-words [8 10])
      "ninety" (number-to-words [9 10]))))
