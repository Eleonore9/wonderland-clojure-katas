(ns alphabet-cipher.coder)

(defn encode [keyword message]
  "encodeme")

(defn decode [keyword message]
  "decodeme")

;;I want to build something like that:
;; {:A {:A "a" :B "b" :C "c" :D "d" :E "e" :F "f" :G "g" ...}
;;  :B {:A "b" :B "c" :C "d" :D "e" :E "f" :F "g" :G "h" ...}}

;; for now:
(def up-alphabet (mapv str (map char (concat (range 65 91)))))
;; ["A" "B" "C" "D" "E" "F" "G" "H" "I" "J" "K" "L" "M" "N" "O" "P" "Q" "R" "S" "T" "U" "V" "W" "X" "Y" "Z"]
(def lo-alphabet (mapv str (map char (concat (range 97 123)))))
;; ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"]

(reduce conj (mapv (fn [x] {(keyword (str x)) 
                            (clojure.string/lower-case x)}) up-alphabet))
{:L "l", :M "m", :I "i", :R "r", :O "o", :A "a", :F "f", :W "w", :Q "q", :P "p", :D "d", :B "b", :J "j", :Z "z", :T "t", :C "c", :E "e", :G "g", :Y "y", :X "x", :H "h", :V "v", :U "u", :S "s", :N "n", :K "k"}


(def decoder
  (let [up-alphabet (map char (concat (range 65 91)))
        lo-alphabet (map char (concat (range 97 123)))]))
