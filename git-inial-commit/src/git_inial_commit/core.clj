(ns git-inial-commit.core
  (:require [clojure.java.shell :as shell])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (case (first args)
    "random" (do
               (println (:out (shell/sh "git" "add" ".")))
               (println (:out (shell/sh "git" "commit" "-m" "\"feat(testing): ༼ つ ◕_◕ ༽つ\""))))
    (println "select ")))
