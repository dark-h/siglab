(ns siglab.signal)
(use '(incanter core charts))

(defn thiscos [x] (Math/cos (* 2 Math/PI 1000 x)))

(defn mycos [timebase]
  "generate cosine function for the given timebase"
  (zipmap timebase (map thiscos timebase)))

(defn signals [generator tStart tEnd fs & rest]
  "generate a basic signal"
  (if (<= tEnd tStart)
    (println "invalid arguments")
    (println ""))
  (if (> (/ 1 (- tEnd tStart)) fs)
    (println "invalid arguments"))
  (println "")
  (let [mysignal (generator (range tStart tEnd (/ 1 fs)))]
    (println (keys mysignal))
    (println (vals mysignal))
    (view (time-series-plot (range 0 (count (vals mysignal))) (vals mysignal)))))

;(defn signals [generator tStart tEnd fs & rest]
;  "generate a basic signal"
;  (if (<= tEnd tStart)
;    (println "invalid arguments")
;    (println ""))
;  (if (> (/ 1 (- tEnd tStart)) fs)
;    (println "invalid arguments"))
;  (println "")
;  (def ys (map thiscos (range tStart tEnd (/ 1 fs))))
;  (def xs (range 0 (count ys)))
;  (view (time-series-plot xs ys)))

(signals mycos 0.0 0.01 8000.00 1)
