(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

#_(deftest lists
    (testing "map"
      (testing "identity with single coll"
        (is (= [1 2 3] (map' identity [1 2 3]))))))


(deftest filter-test
  (testing "filter"
    (are [x y] (= x y)
               (filter' even? [1 2 3 4]) '(2 4)
               (filter' even? '(1 2 3 4)) '(2 4))))

(deftest count-test
  (testing "count"
    (are [x y] (= x y)
               (count'  [1 2 3 4]) 4
               (count' '()) '0)))

(deftest reduce-test
  (testing "reduce"
    (are [x y] (= x y)
               (reduce' + [1 2 3 4]) 10
               (reduce' + 10 [1 2 3 4]) 20
               (reduce' * '(1 2 3 4)) 24
               (reduce' * 0 '(1 2 3 4)) 0)))

