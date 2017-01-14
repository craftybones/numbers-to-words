(ns numbers-to-words.new-test
  (:require [clojure.test :refer :all]
            [numbers-to-words.new :refer :all]))

(deftest splitting-into-terms
  (testing "twenties thirties etc"
    (are [actual expected] (= (split-into-terms actual) expected)
      0 [0]
      5 [5]
      10 [10]
      15 [15]
      20 [20]
      21 [20 1]
      88 [80 8]
      100 [1 100]
      101 [1 100 1]
      121 [1 100 20 1]
      180 [1 100 80]
      1100 [1 1000 1 100]
      1123 [1 1000 1 100 20 3]
      1700 [1 1000 7 100]
      11234 [11 1000 2 100 30 4]
      17000 [17 1000]
      19023 [19 1000 20 3]
      100000 [1 100 1000]
      123456 [1 100 20 3 1000 4 100 50 6])))
