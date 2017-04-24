package com.nk.drools.service

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import utils.{CSVParser, DroolsDriver}
import com.databricks.spark.avro._


/**
  * Created by 396885 on 12/04/2017.
  */
object ProductSalesSparkService {

  def droolsValidator( sparkCtx: SparkContext, sparkSqlCtx: SQLContext ): Unit = {

    val rules = DroolsDriver.loadRules
    val broadcastRules = sparkCtx.broadcast( rules )
    val productRDD = sparkCtx.textFile( "C:\\Narasimha\\new_projects\\DroolsHadoop\\src\\main\\resources\\data_sets\\Sales_Products_2012-14.csv" ).
      filter( prodLine => !isHeader( prodLine ) ).
      map( product => CSVParser.productDataParser( product ) )
      .map( p => DroolsDriver.applyRules( broadcastRules.value, p ) ).
      filter( p => p.isValid ).sortBy( p => p.revenue ).sortBy( prod => prod.revenue, false ).take( 5 )
    productRDD.foreach( prod => println( "Country=>" + prod.retCountry + ",Retailer Type=>" + prod.retailerType + ",Quarter=>" + prod.quarter + ",Revinue:" + prod.revenue + ",Gross:" + prod.grossMargin ) )
    //Creating dataframe
    val prodDF = sparkSqlCtx.createDataFrame( productRDD )
        //saving to avro
    prodDF.write.mode("overwrite").avro("C:\\Narasimha\\Telia\\io\\drools")
    prodDF.show()
    sparkCtx.stop()
  }

  def isHeader( line: String ) = {
    line.contains( "Retailer country" )
  }


}
