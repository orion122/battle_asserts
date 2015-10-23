(ns battle-asserts.issues.reverse-each-word
  (:require [clojure.test.check.generators :as gen]
            [faker.generate :as faker]))

(def level :elementary)

(def description "#FIXME написать функию, принимающую строку
                 и возвращающую входную строку с развернутыми словами")

(defn arguments-generator []

  (let [sentences (repeatedly 30 #(faker/sentence {:words-range [1 10]}))]
    (gen/tuple (gen/elements sentences))))

(def test-data
  [{:expected  "olleH ,ereht dna woh era ?uoy"
    :arguments  ["Hello there, and how are you?"]}
   {:expected "I’m Fine, Thanks. And You?"
    :arguments ["m’I ,eniF .sknahT dnA ?uoY"]}
   {:expected "ehT kciuq nworb xof spmuj revo eht yzal god"
    :arguments  ["The quick brown fox jumps over the lazy dog"]}])

(defn solution [string]
  (->>
   (clojure.string/split string #" ")
   (map clojure.string/reverse)
   (clojure.string/join " ")))