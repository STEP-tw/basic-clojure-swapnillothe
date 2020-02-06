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
               (filter' even? '(1 2 3 4)) '(2 4)
               )))
