(ns numbers-to-words.core
  (:require [clojure.string :as cstr]
            [numbers-to-words.math :as math]
            [numbers-to-words.words :as words]))

(defn to-words [x]
  (->> x
      math/split-into-terms
      words/in-words
      (cstr/join " ")))

