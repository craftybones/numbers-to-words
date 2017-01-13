(ns numbers-to-words.core-test
  (:require [clojure.test :refer :all]
            [numbers-to-words.core :refer :all]))

(deftest splitting-into-units-test
  (testing "unit's place"
    (are [expected actual] (= expected (split-into-units actual))
      [[0 1]] 0
      [[1 1]] 1
      [[2 1]] 2
      [[3 1]] 3
      [[4 1]] 4
      [[5 1]] 5
      [[6 1]] 6
      [[7 1]] 7
      [[8 1]] 8
      [[9 1]] 9
      [[10 1]] 10
      [[11 1]] 11
      [[12 1]] 12
      [[13 1]] 13
      [[14 1]] 14
      [[15 1]] 15
      [[16 1]] 16
      [[17 1]] 17
      [[18 1]] 18
      [[19 1]] 19))
  (testing "ten's place"
    (are [expected actual] (= expected (split-into-units actual))
      [[2 10]] 20
      [[3 10]] 30
      [[3 10]] 30
      [[4 10]] 40
      [[5 10]] 50
      [[6 10]] 60
      [[7 10]] 70
      [[8 10]] 80
      [[9 10]] 90))
  (testing "ten's place when there is a digit in the unit's place"
    (are [expected actual] (= expected (split-into-units actual))
      [[2 10] [1 1]] 21
      [[2 10] [2 1]] 22
      [[2 10] [3 1]] 23
      [[2 10] [4 1]] 24
      [[2 10] [5 1]] 25
      [[2 10] [6 1]] 26
      [[2 10] [7 1]] 27
      [[2 10] [8 1]] 28
      [[2 10] [9 1]] 29))
  (testing "hundred's place"
    (are [expected actual] (= expected (split-into-units actual))
      [[1 100]] 100
      [[2 100]] 200
      [[3 100]] 300
      [[4 100]] 400
      [[5 100]] 500
      [[6 100]] 600
      [[7 100]] 700
      [[8 100]] 800
      [[9 100]] 900))
  (testing "hundred's place when there are digits in the unit's place"
    (are [expected actual] (= expected (split-into-units actual))
      [[1 100] [1 1]] 101
      [[1 100] [2 1]] 102
      [[1 100] [3 1]] 103
      [[1 100] [4 1]] 104
      [[1 100] [5 1]] 105
      [[1 100] [6 1]] 106
      [[1 100] [7 1]] 107
      [[1 100] [8 1]] 108
      [[1 100] [9 1]] 109))
  (testing "hundred's place when there are digits in the ten's place"
    (are [expected actual] (= expected (split-into-units actual))
      [[1 100] [1 10]] 110
      [[1 100] [2 10]] 120
      [[1 100] [3 10]] 130
      [[1 100] [4 10]] 140
      [[1 100] [5 10]] 150
      [[1 100] [6 10]] 160
      [[1 100] [7 10]] 170
      [[1 100] [8 10]] 180
      [[1 100] [9 10]] 190))
  (testing "hundred's place when there are digits in the ten's and unit's place"
    (are [expected actual] (= expected (split-into-units actual))
      [[1 100] [1 10] [1 1]] 111
      [[1 100] [1 10] [2 1]] 112
      [[1 100] [1 10] [3 1]] 113
      [[1 100] [1 10] [4 1]] 114
      [[1 100] [1 10] [5 1]] 115
      [[1 100] [1 10] [6 1]] 116
      [[1 100] [1 10] [7 1]] 117
      [[1 100] [1 10] [8 1]] 118
      [[1 100] [1 10] [9 1]] 119))
  (testing "thousand's place"
    (are [expected actual] (= expected (split-into-units actual))
      [[1 1000]] 1000
      [[2 1000]] 2000
      [[3 1000]] 3000
      [[4 1000]] 4000
      [[5 1000]] 5000
      [[6 1000]] 6000
      [[7 1000]] 7000
      [[8 1000]] 8000
      [[9 1000]] 9000
      [[10 1000]] 10000
      [[11 1000]] 11000
      [[12 1000]] 12000
      [[13 1000]] 13000
      [[14 1000]] 14000
      [[15 1000]] 15000
      [[16 1000]] 16000
      [[17 1000]] 17000
      [[18 1000]] 18000
      [[19 1000]] 19000
      [[20 1000]] 20000
      [[100 1000]] 100000
      [[555 1000]] 555000)))

(deftest splitting-further-test
  (testing "split thousand when most significant digits >= 20"
    (are [expected actual] (= expected (split-further actual))
      [[[2 10]] 1000] [20 1000]
      [[[2 10] [1 1]] 1000] [21 1000]
      [[[1 100]] 1000] [100 1000]
      [[[1 100] [1 1]] 1000] [101 1000]
      [[[1 100] [1 10]] 1000] [110 1000]
      [[[1 100] [1 10] [1 1]] 1000] [111 1000]))
  (testing "split thousand should not split further when msd < 20"
    (are [expected actual] (= expected (split-further actual))
      [1 1] [1 1]
      [19 1] [19 1]
      [1 10] [1 10]
      [9 10] [9 10]
      [1 100] [1 100]
      [9 100] [9 100]
      [1 1000] [1 1000]
      [19 1000] [19 1000])))

(deftest breaking-number-down-into-terms
  (testing "unit's place"
    (are [expected actual] (= expected (break-number-down actual))
      [[0 1]] 0
      [[1 1]] 1
      [[2 1]] 2
      [[3 1]] 3
      [[4 1]] 4
      [[5 1]] 5
      [[6 1]] 6
      [[7 1]] 7
      [[8 1]] 8
      [[9 1]] 9
      [[10 1]] 10
      [[11 1]] 11
      [[12 1]] 12
      [[13 1]] 13
      [[14 1]] 14
      [[15 1]] 15
      [[16 1]] 16
      [[17 1]] 17
      [[18 1]] 18
      [[19 1]] 19))
  (testing "ten's place"
    (are [expected actual] (= expected (break-number-down actual))
      [[2 10]] 20
      [[3 10]] 30
      [[4 10]] 40
      [[5 10]] 50
      [[6 10]] 60
      [[7 10]] 70
      [[8 10]] 80
      [[9 10]] 90))
  (testing "ten's place with a unit's place"
    (are [expected actual] (= expected (break-number-down actual))
      [[2 10] [1 1]] 21
      [[2 10] [2 1]] 22
      [[2 10] [3 1]] 23
      [[2 10] [4 1]] 24
      [[2 10] [5 1]] 25
      [[2 10] [6 1]] 26
      [[2 10] [7 1]] 27
      [[2 10] [8 1]] 28
      [[2 10] [9 1]] 29))
  (testing "hundred's place"
    (are [expected actual] (= expected (break-number-down actual))
      [[1 100]] 100
      [[2 100]] 200
      [[3 100]] 300
      [[4 100]] 400
      [[5 100]] 500
      [[6 100]] 600
      [[7 100]] 700
      [[8 100]] 800
      [[9 100]] 900))
  (testing "hundred's place with a ten's place"
    (are [expected actual] (= expected (break-number-down actual))
      [[1 100] [1 10]] 110
      [[1 100] [2 10]] 120
      [[1 100] [3 10]] 130
      [[1 100] [4 10]] 140
      [[1 100] [5 10]] 150
      [[1 100] [6 10]] 160
      [[1 100] [7 10]] 170
      [[1 100] [8 10]] 180
      [[1 100] [9 10]] 190))
  (testing "hundred's place with a ten's place and unit's place"
    (are [expected actual] (= expected (break-number-down actual))
      [[1 100] [1 10] [1 1]] 111
      [[1 100] [1 10] [2 1]] 112
      [[1 100] [1 10] [3 1]] 113
      [[1 100] [1 10] [4 1]] 114
      [[1 100] [1 10] [5 1]] 115
      [[1 100] [1 10] [6 1]] 116
      [[1 100] [1 10] [7 1]] 117
      [[1 100] [1 10] [8 1]] 118
      [[1 100] [1 10] [9 1]] 119))
  (testing "thousand's place"
    (are [expected actual] (= expected (break-number-down actual))
      [[1 1000]] 1000
      [[2 1000]] 2000
      [[3 1000]] 3000
      [[4 1000]] 4000
      [[5 1000]] 5000
      [[6 1000]] 6000
      [[7 1000]] 7000
      [[8 1000]] 8000
      [[9 1000]] 9000
      [[10 1000]] 10000
      [[11 1000]] 11000
      [[12 1000]] 12000
      [[13 1000]] 13000
      [[14 1000]] 14000
      [[15 1000]] 15000
      [[16 1000]] 16000
      [[17 1000]] 17000
      [[18 1000]] 18000
      [[19 1000]] 19000))
  (testing "thousand's place when msd > 20"
    (are [expected actual] (= expected (break-number-down actual))
      [[[[2 10]] 1000]] 20000
      [[[[2 10] [1 1]] 1000]] 21000
      [[[[1 100]] 1000]] 100000
      [[[[1 100] [1 1]] 1000]] 101000
      [[[[1 100] [1 10]] 1000]] 110000
      [[[[1 100] [1 10] [1 1]] 1000]] 111000))
  (testing "compound numbers above thousand"
    (are [expected actual] (= expected (break-number-down actual))
      [[1 1000] [2 100] [3 10] [4 1]] 1234
      [[12 1000] [3 100] [4 10] [5 1]] 12345
      [[[[2 10] [3 1]] 1000] [4 100] [5 10] [6 1]] 23456
      [[[[1 100] [2 10] [3 1]] 1000] [4 100] [5 10] [6 1]] 123456)))

(deftest numbers-in-words
  (testing "0 - 100"
    (are [actual expected] (= (in-words actual) expected)
      0 "zero"
      1 "one"
      2 "two"
      3 "three"
      4 "four"
      5 "five"
      6 "six"
      7 "seven"
      8 "eight"
      9 "nine"
      10 "ten"
      11 "eleven"
      12 "twelve"
      13 "thirteen"
      14 "fourteen"
      15 "fifteen"
      16 "sixteen"
      17 "seventeen"
      18 "eighteen"
      19 "nineteen"
      20 "twenty"
      21 "twenty one"
      22 "twenty two"
      23 "twenty three"
      24 "twenty four"
      25 "twenty five"
      26 "twenty six"
      27 "twenty seven"
      28 "twenty eight"
      29 "twenty nine"
      30 "thirty"
      31 "thirty one"
      32 "thirty two"
      33 "thirty three"
      34 "thirty four"
      35 "thirty five"
      36 "thirty six"
      37 "thirty seven"
      38 "thirty eight"
      39 "thirty nine"
      40 "forty"
      41 "forty one"
      42 "forty two"
      43 "forty three"
      44 "forty four"
      45 "forty five"
      46 "forty six"
      47 "forty seven"
      48 "forty eight"
      49 "forty nine"
      50 "fifty"
      51 "fifty one"
      52 "fifty two"
      53 "fifty three"
      54 "fifty four"
      55 "fifty five"
      56 "fifty six"
      57 "fifty seven"
      58 "fifty eight"
      59 "fifty nine"
      60 "sixty"
      61 "sixty one"
      62 "sixty two"
      63 "sixty three"
      64 "sixty four"
      65 "sixty five"
      66 "sixty six"
      67 "sixty seven"
      68 "sixty eight"
      69 "sixty nine"
      70 "seventy"
      71 "seventy one"
      72 "seventy two"
      73 "seventy three"
      74 "seventy four"
      75 "seventy five"
      76 "seventy six"
      77 "seventy seven"
      78 "seventy eight"
      79 "seventy nine"
      80 "eighty"
      81 "eighty one"
      82 "eighty two"
      83 "eighty three"
      84 "eighty four"
      85 "eighty five"
      86 "eighty six"
      87 "eighty seven"
      88 "eighty eight"
      89 "eighty nine"
      90 "ninety"
      91 "ninety one"
      92 "ninety two"
      93 "ninety three"
      94 "ninety four"
      95 "ninety five"
      96 "ninety six"
      97 "ninety seven"
      98 "ninety eight"
      99 "ninety nine"
      100 "one hundred"))
  (testing "200 300 ... 1000"
    (are [actual expected] (= (in-words actual) expected)
      200 "two hundred"
      300 "three hundred"
      400 "four hundred"
      500 "five hundred"
      600 "six hundred"
      700 "seven hundred"
      800 "eight hundred"
      900 "nine hundred"
      1000 "one thousand"))
  (testing "1000s"
    (are [actual expected] (= (in-words actual) expected)
      2000 "two thousand"
      3000 "three thousand"
      4000 "four thousand"
      5000 "five thousand"
      6000 "six thousand"
      7000 "seven thousand"
      8000 "eight thousand"
      9000 "nine thousand"
      10000 "ten thousand")))
