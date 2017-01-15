(ns numbers-to-words.words)

(def numbers-that-have-words
  (concat (range 21)
          (range 30 101 10)
          [1000 1000000 1000000000]))

(def words '("zero"
             "one"
             "two"
             "three"
             "four"
             "five"
             "six"
             "seven"
             "eight"
             "nine"
             "ten"
             "eleven"
             "twelve"
             "thirteen"
             "fourteen"
             "fifteen"
             "sixteen"
             "seventeen"
             "eighteen"
             "nineteen"
             "twenty"
             "thirty"
             "forty"
             "fifty"
             "sixty"
             "seventy"
             "eighty"
             "ninety"
             "hundred"
             "thousand"
             "million"
             "billion"))

(def word-for-term (-> (zipmap numbers-that-have-words words)
                       (assoc :and "and")))

(def prefixes #{100 1000 1000000 1000000000})

(defn prefix-next-term [[terms prefix] next-term]
  (cond
    (contains? prefixes next-term) [(conj terms next-term) :and]
    prefix [(conj terms :and next-term) nil]
    :else [(conj terms next-term) nil]))

(def attach-prefix (comp first (partial reduce prefix-next-term [[] nil])))

(def in-words (comp (partial map word-for-term) attach-prefix))
