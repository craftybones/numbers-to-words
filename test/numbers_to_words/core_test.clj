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
      [[1 100] [9 1]] 109)))
