(ns fizzbuzz.core)

(def *SET-RANGE* (range 101))
(def *FB-RANGE* (drop 1 *SET-RANGE*))

(def *S3* (set (take-nth 3 *SET-RANGE*)))
(def *S5* (set (take-nth 5 *SET-RANGE*)))
(def *S15* (set (take-nth 15 *SET-RANGE*)))

(defn make-filter [pred msg]
  (fn [n] (if (pred n) msg n)))

(def f-filter (make-filter *S3* "fizz"))
(def b-filter (make-filter *S5* "buzz"))
(def fb-filter (make-filter *S15* "fizzbuzz"))

(def fizzbuzz (comp f-filter b-filter fb-filter))

(def fizzbuzz-results (map fizzbuzz *FB-RANGE*))

