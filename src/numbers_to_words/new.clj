(ns numbers-to-words.new)

(def concatv (comp vec concat))

(def units (-> (hash-set)
               (into (range 0 20))
               (into (range 20 100 10))))

(def map-num-of-zeroes (zipmap (range) [0 1 2 3 3 3 6 6 6]))

(defn raise-ten-by [x]
  (->> (repeat x "0")
       (apply str)
       (str "1")
       read-string))

(defn closest-power-of-ten [x]
  (-> x
      str
      count
      dec
      map-num-of-zeroes
      raise-ten-by))

(defn msd [x]
  (quot x (closest-power-of-ten x)))

(def msd-closest-ten
  (juxt msd closest-power-of-ten))

(declare split-into-terms)

(defn- split-further-if-needed [m c]
  (if (units (* m c))
    [(* m c)]
    (conj (split-into-terms m) c)))

(defn- split-into-terms-loop [n terms]
  (cond
    (zero? n) terms
    (contains? units n) (conj terms n)
    :else (let [[m c] (msd-closest-ten n)
                remaining (- n (* m c))
                new-terms (split-further-if-needed m c)]
            (recur remaining (concatv terms new-terms)))))

(defn split-into-terms [x]
  (if (units x)
    [x]
    (split-into-terms-loop x [])))
