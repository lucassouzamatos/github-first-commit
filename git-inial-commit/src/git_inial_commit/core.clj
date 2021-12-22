(ns git-inial-commit.core
  (:require [clojure.java.shell :as shell])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
   (do
     (println (:out (shell/sh "git" "add" ".")))
     (println (:out (shell/sh "git" "commit" "-m" "\"feat(testing): ༼ つ ◕_◕ ༽つ\""))))
   (println args)
   (case (first args)
    "push" (println (:out (shell/sh "git" "push")))))
