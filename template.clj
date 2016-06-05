;java -jar clojure-1.8.0.jar template.clj 
(def infile "A-small.in")
(def outfile "A-small.out")

(java.util.Locale/setDefault (java.util.Locale/US))

(defn solve [a]
  (let [cmd (first a)
        s (sort (map #(Double/parseDouble %) (next (next a))))
        len (count s)]
    (if (= "median" cmd)
      (nth s (quot len 2))
      (/ (reduce + s) len))))

(with-open [reader (clojure.java.io/reader infile)
            writer (clojure.java.io/writer outfile)]
  (binding [*in* reader]
    (doseq [test-case (range 1 (inc (Integer/parseInt (read-line))))]
      (.write writer (format "Case #%d: %.10f\n" test-case (solve (clojure.string/split (read-line) #" ")))))))
