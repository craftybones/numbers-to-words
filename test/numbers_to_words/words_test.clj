(ns numbers-to-words.words-test
  (:require [clojure.test :refer :all]
            [numbers-to-words.words :refer :all]))

(deftest num-to-words
  (testing "units place"
    (are [actual expected] (= actual expected)
      ["zero"] (number-to-words [0 1])
      ["one"] (number-to-words [1 1])
      ["two"] (number-to-words [2 1])
      ["three"] (number-to-words [3 1])
      ["four"] (number-to-words [4 1])
      ["five"] (number-to-words [5 1])
      ["six"] (number-to-words [6 1])
      ["seven"] (number-to-words [7 1])
      ["eight"] (number-to-words [8 1])
      ["nine"] (number-to-words [9 1])
      ["ten"] (number-to-words [10 1])
      ["eleven"] (number-to-words [11 1])
      ["twelve"] (number-to-words [12 1])
      ["thirteen"] (number-to-words [13 1])
      ["fourteen"] (number-to-words [14 1])
      ["fifteen"] (number-to-words [15 1])
      ["sixteen"] (number-to-words [16 1])
      ["seventeen"] (number-to-words [17 1])
      ["eighteen"] (number-to-words [18 1])
      ["nineteen"] (number-to-words [19 1])))
  (testing "tens place"
    (are [actual expected] (= actual (number-to-words expected))
      ["ten"] [1 10]
      ["twenty"] [2 10]
      ["thirty"] [3 10]
      ["forty"] [4 10]
      ["fifty"] [5 10]
      ["sixty"] [6 10]
      ["seventy"] [7 10]
      ["eighty"] [8 10]
      ["ninety"] [9 10]))
  (testing "hundreds place"
    (are [actual expected] (= actual (number-to-words expected))
      [["one" "hundred"]] [1 100]
      [["two" "hundred"]] [2 100]
      [["three" "hundred"]] [3 100]
      [["four" "hundred"]] [4 100]
      [["five" "hundred"]] [5 100]
      [["six" "hundred"]] [6 100]
      [["seven" "hundred"]] [7 100]
      [["eight" "hundred"]] [8 100]
      [["nine" "hundred"]] [9 100]))
  (testing "thousands place"
    (are [actual expected] (= actual (number-to-words expected))
      [["one" "thousand"]] [1 1000]
      [["two" "thousand"]] [2 1000]
      [["three" "thousand"]] [3 1000]
      [["four" "thousand"]] [4 1000]
      [["five" "thousand"]] [5 1000]
      [["six" "thousand"]] [6 1000]
      [["seven" "thousand"]] [7 1000]
      [["eight" "thousand"]] [8 1000]
      [["nine" "thousand"]] [9 1000]
      [["ten" "thousand"]] [10 1000]
      [["eleven" "thousand"]] [11 1000]
      [["twelve" "thousand"]] [12 1000]
      [["thirteen" "thousand"]] [13 1000]
      [["fourteen" "thousand"]] [14 1000]
      [["fifteen" "thousand"]] [15 1000]
      [["sixteen" "thousand"]] [16 1000]
      [["seventeen" "thousand"]] [17 1000]
      [["eighteen" "thousand"]] [18 1000]
      [["nineteen" "thousand"]] [19 1000]))
  (testing "thousands place when the msd is not just a unit number"
    (are [actual expected] (= actual (number-to-words expected))
      [[["twenty"]] "thousand"] [[[2 10]] 1000]
      [[["twenty"] ["one"]] "thousand"] [[[2 10] [1 1]] 1000]
      [[["twenty"] ["two"]] "thousand"] [[[2 10] [2 1]] 1000]
      [[["twenty"] ["three"]] "thousand"] [[[2 10] [3 1]] 1000]
      [[["twenty"] ["four"]] "thousand"] [[[2 10] [4 1]] 1000]
      [[["twenty"] ["five"]] "thousand"] [[[2 10] [5 1]] 1000]
      [[["twenty"] ["six"]] "thousand"] [[[2 10] [6 1]] 1000]
      [[["twenty"] ["seven"]] "thousand"] [[[2 10] [7 1]] 1000]
      [[["twenty"] ["eight"]] "thousand"] [[[2 10] [8 1]] 1000]
      [[["twenty"] ["nine"]] "thousand"] [[[2 10] [9 1]] 1000])
    (are [actual expected] (= actual (number-to-words expected))
      [[[["one" "hundred"]]] "thousand"] [[[1 100]] 1000]
      [[[["one" "hundred"]] ["one"]] "thousand"] [[[1 100] [1 1]] 1000]
      [[[["one" "hundred"]] ["eleven"]] "thousand"] [[[1 100] [11 1]] 1000]
      [[[["one" "hundred"]] ["twenty"]] "thousand"] [[[1 100] [2 10]] 1000]
      [[[["one" "hundred"]] ["twenty"] ["five"]] "thousand"] [[[1 100] [2 10] [5 1]] 1000])))
