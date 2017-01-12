(ns numbers-to-words.core-test
  (:require [clojure.test :refer :all]
            [numbers-to-words.core :refer :all]))

(deftest splitting-into-units-test
  (testing "unit's place"
    (are [expected actual] (= expected (split-into-units actual))
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
      [[9 10]] 90)))
