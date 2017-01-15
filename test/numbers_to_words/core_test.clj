(ns numbers-to-words.core-test
  (:require [clojure.test :refer :all]
            [numbers-to-words.core :refer :all]))

(deftest numbers-to-words-conversion
  (testing "zero to a billion"
    (are [actual expected] (= (to-words actual) expected)
      0 "zero"
      1 "one"
      2 "two"
      10 "ten"
      12 "twelve"
      35 "thirty five"
      100 "one hundred"
      123 "one hundred and twenty three"
      500 "five hundred"
      999 "nine hundred and ninety nine"
      1000 "one thousand"
      1100 "one thousand and one hundred"
      1123 "one thousand and one hundred and twenty three"
      10000 "ten thousand"
      10001 "ten thousand and one"
      100000 "one hundred thousand"
      1000000 "one million"
      1000001 "one million and one"
      1000020 "one million and twenty"
      1000023 "one million and twenty three"
      10000000 "ten million"
      1000000000 "one billion")))
