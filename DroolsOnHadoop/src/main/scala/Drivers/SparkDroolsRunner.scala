package Drivers


import com.nk.drools.service.ProductSalesSparkService
import org.apache.log4j.Logger
import utils.SparkConnectionManager


/**
  * Created by 396885 on 06/04/2017.
  */
object SparkDroolsRunner {
  val logger = Logger.getLogger( SparkDroolsRunner.getClass )

  def main( args: Array[ String ] ): Unit = {
    System.setProperty( "hadoop.home.dir", "C:/winutils" )
    val sparkCtx = SparkConnectionManager.getSparkContext( "droolsOnSpark" )

    val sparkSqlCtx = SparkConnectionManager.getSparkSQLContext( sparkCtx )
     ProductSalesSparkService.droolsValidator( sparkCtx, sparkSqlCtx )

  }

}
