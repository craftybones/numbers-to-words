(ns numbers-to-words.new-test
  (:require [clojure.test :refer :all]
            [numbers-to-words.new :refer :all]))

(deftest splitting-into-terms
  (testing "units"
    (are [actual expected] (= (split-into-terms actual) expected)
      0 [0]
      1 [1]
      2 [2]
      3 [3]
      4 [4]
      5 [5]
      6 [6]
      7 [7]
      8 [8]
      9 [9]
      10 [10]
      11 [11]
      12 [12]
      13 [13]
      14 [14]
      15 [15]
      16 [16]
      17 [17]
      18 [18]
      19 [19]      
      20 [20]
      30 [30]
      40 [40]
      50 [50]
      60 [60]
      70 [70]
      80 [80]
      90 [90]
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
      123456 [1 100 20 3 1000 4 100 50 6]))
  (testing "twenties thirties etc"
    (are [actual expected] (= (split-into-terms actual) expected)
      21 [20 1]
      22 [20 2]
      23 [20 3]
      24 [20 4]
      25 [20 5]
      26 [20 6]
      27 [20 7]
      28 [20 8]
      29 [20 9]
      31 [30 1]
      32 [30 2]
      33 [30 3]
      34 [30 4]
      35 [30 5]
      36 [30 6]
      37 [30 7]
      38 [30 8]
      39 [30 9]
      41 [40 1]
      42 [40 2]
      43 [40 3]
      44 [40 4]
      45 [40 5]
      46 [40 6]
      47 [40 7]
      48 [40 8]
      49 [40 9]
      51 [50 1]
      52 [50 2]
      53 [50 3]
      54 [50 4]
      55 [50 5]
      56 [50 6]
      57 [50 7]
      58 [50 8]
      59 [50 9]
      61 [60 1]
      62 [60 2]
      63 [60 3]
      64 [60 4]
      65 [60 5]
      66 [60 6]
      67 [60 7]
      68 [60 8]
      69 [60 9]
      71 [70 1]
      72 [70 2]
      73 [70 3]
      74 [70 4]
      75 [70 5]
      76 [70 6]
      77 [70 7]
      78 [70 8]
      79 [70 9]
      81 [80 1]
      82 [80 2]
      83 [80 3]
      84 [80 4]
      85 [80 5]
      86 [80 6]
      87 [80 7]
      88 [80 8]
      89 [80 9]
      91 [90 1]
      92 [90 2]
      93 [90 3]
      94 [90 4]
      95 [90 5]
      96 [90 6]
      97 [90 7]
      98 [90 8]
      99 [90 9]))
  (testing "100 200 etc.."
    (are [actual expected] (= (split-into-terms actual) expected)
      100 [1 100]
      200 [2 100]
      300 [3 100]
      400 [4 100]
      500 [5 100]
      600 [6 100]
      700 [7 100]
      800 [8 100]
      900 [9 100]))
  (testing "101 102 etc.."
    (are [actual expected] (= (split-into-terms actual) expected)
      101 [1 100 1]
      102 [1 100 2]
      103 [1 100 3]
      104 [1 100 4]
      105 [1 100 5]
      106 [1 100 6]
      107 [1 100 7]
      108 [1 100 8]
      109 [1 100 9]
      110 [1 100 10]
      111 [1 100 11]
      112 [1 100 12]
      113 [1 100 13]
      114 [1 100 14]
      115 [1 100 15]
      116 [1 100 16]
      117 [1 100 17]
      118 [1 100 18]
      119 [1 100 19]
      120 [1 100 20]))
  (testing "121 122 etc.."
    (are [actual expected] (= (split-into-terms actual) expected)
      121 [1 100 20 1]
      122 [1 100 20 2]
      123 [1 100 20 3]
      124 [1 100 20 4]
      125 [1 100 20 5]
      126 [1 100 20 6]
      127 [1 100 20 7]
      128 [1 100 20 8]
      129 [1 100 20 9])))
