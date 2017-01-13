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

(defn split-into-units-greater-than-twenty [number]
  (loop [n number units []]
    (if (zero? n)
      units
      (let [msd-mag (msd-magnitude n)
            residue (- n (apply * msd-mag))]
        (recur residue (conj units msd-mag))))))

(defn split-into-units [number]
  (if (< number 20)
    [[number 1]]
    (split-into-units-greater-than-twenty number)))

(defn split-further [[msd r :as unit]]
  (if (< msd 20)
    unit
    [(split-into-units msd) r]))

(def break-number-down
  (comp (partial map split-further) split-into-units))

(defn in-words [number]
  (->> number
       break-number-down
       (map words/number-to-words)
       flatten
       (reduce words/add-prefix [[] nil])
       first
       (cstr/join " ")))
