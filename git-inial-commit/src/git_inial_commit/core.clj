(ns git-inial-commit.core
  (:require [clojure.java.shell :as shell])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
   (do
     (println "adding all to repository")
     (println (:out (shell/sh "git" "add" ".")))
     (println "commiting with selected message")
     (println (:out (shell/sh "git" "commit" "-m" "\"feat(testing): ༼ つ ◕_◕ ༽つ\""))))
   (case (first args)
    "--push" (do 
               (println "pushing to repository...")
               (println (:out (shell/sh "git" "push"))))))
