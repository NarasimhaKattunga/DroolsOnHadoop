package utils

import DomainObjects.Products

import scala.util.Try

/**
  * Created by 396885 on 06/04/2017.
  */
object CSVParser {

  def productDataParser(line: String): Products = {
    val splitedProdData = line.split(",")
    val retCountry = Try(splitedProdData(0).toString).getOrElse("")
    val orderMethod = Try(splitedProdData(1).toString).getOrElse("")
    val retailerType = Try(splitedProdData(2).toString).getOrElse("")
    val prodLine = Try(splitedProdData(3).toString).getOrElse("")
    val prodType = Try(splitedProdData(4).toString).getOrElse("")
    val prod = Try(splitedProdData(5).toString).getOrElse("")
    val year = Try(splitedProdData(6).toLong).getOrElse(0L)
    val quarter = Try(splitedProdData(7).toString).getOrElse("")
    val revenue = Try(splitedProdData(8).toDouble).getOrElse(0.00)
    val qty = Try(splitedProdData(9).toDouble).getOrElse(0.00)
    val grossMargin = Try(splitedProdData(10).toDouble).getOrElse(0.00)
    Products(retCountry, orderMethod, retailerType, prodLine, prodType, prod, year, quarter, revenue, qty, grossMargin)

  }

}
