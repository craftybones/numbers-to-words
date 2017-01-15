(ns numbers-to-words.words-test
  (:require [clojure.test :refer :all]
            [numbers-to-words.words :refer :all]))

(deftest prefixing-next-term
  (testing "prefixing when the next term is 100,1000 etc"
    (is (= [[1 100] :and] (prefix-next-term [[1] nil] 100)))
    (is (= [[1 100 :and 1] nil] (prefix-next-term [[1 100] :and] 1)))
    (is (= [[1 1000] :and] (prefix-next-term [[1] nil] 1000)))
    (is (= [[1 1000 :and 1] nil] (prefix-next-term [[1 1000] :and] 1)))
    (is (= [[1 100 1000] :and] (prefix-next-term [[1 100] :and] 1000)))
    (is (= [[1 100 1000 :and 1] nil] (prefix-next-term [[1 100 1000] :and] 1)))))

(deftest prefixing-with-and
  (testing "cases with 100, 1000 etc"
    (are [actual expected] (= (attach-prefix actual) expected)
      [1 100] [1 100]
      [1 100 1] [1 100 :and 1]
      [1 100 20 3] [1 100 :and 20 3]
      [5 1000] [5 1000]
      [1 1000 1 100] [1 1000 :and 1 100] 
      [5 1000 1] [5 1000 :and 1]
      [5 1000 20 1] [5 1000 :and 20 1]
      [5 1000 1 100] [5 1000 :and 1 100]
      [5 1000 100 1] [5 1000 100 :and 1]
      [1 100 1000 1] [1 100 1000 :and 1]
      [1 100 1000 1 100] [1 100 1000 :and 1 100])))

(deftest numbers-in-words
  (testing "Assorted cases"
    (are [actual expected] (= (in-words actual) expected)
      [0] ["zero"]
      [1] ["one"]
      [2] ["two"]
      [3] ["three"]
      [4] ["four"]
      [5] ["five"]
      [6] ["six"]
      [7] ["seven"]
      [8] ["eight"]
      [9] ["nine"]
      [10] ["ten"]
      [11] ["eleven"]
      [12] ["twelve"]
      [13] ["thirteen"]
      [14] ["fourteen"]
      [15] ["fifteen"]
      [16] ["sixteen"]
      [17] ["seventeen"]
      [18] ["eighteen"]
      [19] ["nineteen"]
      [20] ["twenty"]
      [20 1] ["twenty" "one"]
      [30 2] ["thirty" "two"]
      [40 3] ["forty" "three"]
      [50 4] ["fifty" "four"]
      [60 5] ["sixty" "five"]
      [70 6] ["seventy" "six"]
      [80 7] ["eighty" "seven"]
      [90 8] ["ninety" "eight"]
      [1 100] ["one" "hundred"])))
