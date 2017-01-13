(ns numbers-to-words.words)

(def tens {"one" "ten"
           "two" "twenty"
           "three" "thirty"
           "four" "forty"
           "five" "fifty"
           "six" "sixty"
           "seven" "seventy"
           "eight" "eighty"
           "nine" "ninety"})

(def units {0 "zero"
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
            19 "nineteen"})

(defn- in-thousands [msd]
  [msd "thousand"])

(defn- in-hundreds [msd]
  [msd "hundred"])

(defn- in-tens [msd]
  (tens msd))

(defn- in-units [msd]
  (units msd))

(def words {1 identity
            10 in-tens
            100 in-hundreds
            1000 in-thousands})

(defn number-to-words [[msd mag :as msd-mag]]
  (if (integer? msd)
    [((words mag) (in-units msd))]
    ((words mag) (map number-to-words msd))))

(defn prefix-for [term]
  ({"hundred" "and"} term))

(defn add-prefix
  [[terms prefix] next-term]
  (let [new-terms (if prefix
                    (conj terms prefix next-term)
                    (conj terms next-term))]
    [new-terms (prefix-for next-term)]))
