(ns numbers-to-words.core
  (:require [clojure.string :as cstr]
            [numbers-to-words.words :as words]))

(def lookup {0 0
             1 1
             2 2
             3 3
             4 3
             5 3})

(defn closest-power-of-10 [n]
  (->> n Math/log10 Math/floor int lookup (Math/pow 10) int))

(defn most-significant-digits [n]
  (-> n (/ (closest-power-of-10 n)) Math/floor int))

(def msd-magnitude (juxt most-significant-digits closest-power-of-10))

(defn split-into-units [number]
  (loop [n number units []]
    (if (zero? n)
      units
      (if (< n 20)
        (conj units [n 1])
        (let [msd-mag (msd-magnitude n)
              residue (- n (apply * msd-mag))]
          (recur residue (conj units msd-mag)))))))

(defn split-further [[msd r :as unit]]
  (if (< msd 20)
    unit
    [(split-into-units msd) r]))

(def break-number-down
  (comp (partial map split-further) split-into-units))

(defn prefix-for [term]
  ({"hundred" "and"} term))

(defn add-prefix
  [[terms prefix] next-term]
  (let [new-terms (if prefix
                    (conj terms prefix next-term)
                    (conj terms next-term))]
    [new-terms (prefix-for next-term)]))

(defn in-words [number]
  (->> number
       break-number-down
       (map words/number-to-words)
       flatten
       (reduce add-prefix [[] nil])
       first
       (cstr/join " ")))
