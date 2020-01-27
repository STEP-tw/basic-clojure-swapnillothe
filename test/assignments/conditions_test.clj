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

(deftest duplicate-first-test
  (testing "non empty"
    (is (= [1 1 2 3] (duplicate-first [1 2 3]))))
  (testing "empty"
    (is (= nil (duplicate-first [])))))
