(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "non zero denominator"
    (is (= 2 (informative-divide 4 2))))
  (testing "zero denominator"
    (is (= :infinite (informative-divide 3 0)))))

(deftest harishchandra-truth
  (testing "truthy value"
    (are [x] (true? x)
             (harishchandra 2)
             (harishchandra [1 2])
             (harishchandra '())
             (harishchandra 0)
             (harishchandra "")))
  (testing "falsy value"
    (are [x] (nil? x)
             (harishchandra nil)
             (harishchandra false))))

(deftest yudishtira-truth
  (testing "yudishtira's truthy values"
    (are [x y] (= x y)
               2 (yudishtira 2)
               [1 2] (yudishtira [1 2])
               '() (yudishtira '())
               0 (yudishtira 0)
               "" (yudishtira "")))
  (testing "yudishtira's falsy value"
    (are [x] (= :ashwathama x)
             (yudishtira nil)
             (yudishtira false))))

(deftest duplicate-first-test
  (testing "non empty"
    (is (= [1 1 2 3] (duplicate-first [1 2 3]))))
  (testing "empty"
    (is (= nil (duplicate-first [])))))

(deftest five-point-someone-test
  (testing "five point someone"
    (are [x y] (= x y)
               :chetan-bhagat (five-point-someone 4 5)
               :satan-bhagat (five-point-someone 5 4)
               :greece (five-point-someone 6 4)
               :universe (five-point-someone 3 4))))

(deftest conditions-apply-test
  (testing "conditions apply"
    (are [x y] (= x y)
               :wonder-woman (conditions-apply [1 :a 2 3])
               :durga (conditions-apply '(:a :b :c))
               :cleopatra (conditions-apply [[:a :b] [2 3] [1 2] [4 5]])
               :tuntun (conditions-apply [4 5 2]))))


(deftest zero-separated-palindrome-test
  (testing "zero separated palindrome"
    (is (= '(4 3 2 0 2 3 4) (zero-separated-palindrome [1 2 3])))))

(deftest zero-aliases-test
  (testing "zero aliases"
    (are [x y] (= x y)
               (zero-aliases 0) :zero
               (zero-aliases []) :empty
               (zero-aliases '()) :empty
               (zero-aliases #{}) :empty-set
               (zero-aliases {}) :empty-map
               (zero-aliases "") :empty-string)))

(deftest order-in-words-test
  (testing "order in words"
    (are [x y] (= x y)
               (order-in-words 4 3 2) [:x-greater-than-y :y-greater-than-z]
               (order-in-words 4 3 5) [:x-greater-than-y :z-greater-than-x]
               (order-in-words 2 3 4) [:z-greater-than-x])))

(deftest repeat-and-truncate-test
  (testing "repeat and truncate"
    (are [x y] (= x y)
               (repeat-and-truncate (range 4) true true 6) '(0 1 2 3 0 1)
               (repeat-and-truncate (range 4) true true 16) '(0 1 2 3 0 1 2 3)
               (repeat-and-truncate (range 4) true false 6) '(0 1 2 3 0 1 2 3)
               (repeat-and-truncate (range 4) false true 6) '(0 1 2 3))))
