(ns alphabet-cipher.coder
  (:require [clojure.string :as s]))

;;I want to build something like that:
;; {"A" {"A" "a" "B" "b" "C" "c" "D" "d" "E" "e" "F "f" "G" "g" ...}
;;  "B" {"A" "b" "B" "c" "C" "d" "D" "e" "E" "f" "F" "g" "G" "h" ...}}

;; Sequences of the alphabet:
(def up-alphabet (mapv str (map char (concat (range 65 91)))))
;; ["A" "B" "C" "D" "E" "F" "G" "H" "I" "J" "K" "L" "M" "N" "O" "P" "Q" "R" "S" "T" "U" "V" "W" "X" "Y" "Z"]

(def lo-alphabet (mapv str (map char (concat (range 97 123)))))
;; ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"]

(defn sort-by-letter
  "Sorts a vector of letters as strings 
  starting with the letter passed in."
  [letters-vec letter]
  (into [] (concat (subvec letters-vec
                           (.indexOf letters-vec letter))
                   (subvec letters-vec 0
                           (.indexOf letters-vec letter)))))

(defn substitution-chart
  "Builds the substitution map
  used to code and decode."
  []
  (map #(hash-map %
                  (zipmap
                   up-alphabet
                   (sort-by-letter
                    lo-alphabet
                    (s/lower-case %))))
       up-alphabet))


(defn encode [keyword message]
  "encodeme"
  )

(defn decode [keyword message]
  "decodeme")
