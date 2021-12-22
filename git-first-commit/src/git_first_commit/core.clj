(ns git-first-commit.core
  (:require [clojure.java.shell :refer :all]
            [clojure.string :as str])
  (:gen-class))

(def emoji-options
  {"1" "( ͝° ͜ʖ͡°)"
   "2" "ᕦ( ͡° ͜ʖ ͡°)ᕤ"
   "3" "(づ｡◕‿‿◕｡)づ"})

(defn -reduce-options
  [previous option]
  (let [[key value] option]
      (str previous key ":" value "\n")))

(defn -get-message
  []
  (let [options 
        (reduce -reduce-options "" emoji-options)]
    (str "Select the option \n" options)))

(defn -main
  [& args]
  (println (-get-message))
  (let [selected (get emoji-options (read-line))]
      (do
        (println (:out (sh "git" "add" ".")))
        (println (:out (sh "git" "commit" "-m" (str "feat(testing): " selected)))))
      (case (first args)
        "--push" (println (:out (sh "git" "push"))))
      (println "Wow! Commited successfully (づ｡◕‿‿◕｡)づ")
      (shutdown-agents)))

