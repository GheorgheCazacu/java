package com.clyde.scala.old

object QuickSortFP extends App {

  // create an array of random 10m random ints
  val r = scala.util.Random
  val randomArray = (for (i <- 1 to 1000) yield r.nextInt(10000)).toArray

  // do the sorting
  val sortedArray = quickSort(randomArray)

  // the fp/recursive algorithm
  def quickSort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      Array.concat(
        quickSort(xs filter (pivot >)),
        xs filter (pivot ==),
        quickSort(xs filter (pivot <)))
    }
  }


  def swapElements[A](arr: Array[A], indexI: Int, indexJ: Int): Array[A] = {
    val temp = arr(indexI)
    arr(indexI) = arr(indexJ)
    arr(indexJ) = temp
    arr
  }

  def partition(arr: Array[Int], low: Int, high: Int) = {
    val pivot = arr(high)
    var i = low - 1 // index of smaller element
    for (j <- low until high) { // If current element is smaller than the pivot
      if (arr(j) < pivot) {
        i += 1
        swapElements(arr, i, j)
      }
    }
    // swap arr[i+1] and arr[high] (or pivot)
    swapElements(arr, i + 1, high)
    i + 1
  }

  // n = 100
  def sort(arr: Array[Int], low: Int, high: Int): Unit = {
    if (low < high) {
      /* pi is partitioning index, arr[pi] is
                   now at right place */
      val pi = partition(arr, low, high)
      // Recursively sort elements before
      // partition and after partition
      sort(arr, low, pi - 1)
      sort(arr, pi + 1, high)
    }
  }

  sort(randomArray, 0, randomArray.length - 1)
  randomArray.foreach(println)

}
