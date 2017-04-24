package utils

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
/**
  * Created by 396885 on 06/04/2017.
  */
object SparkConnectionManager {

  def getSparkSQLContext(sc:SparkContext) : SQLContext = {
    val sqlContext = new SQLContext(sc)
    sqlContext.setConf("spark.sql.avro.compression.codec", "snappy")
    sqlContext
  }

def getSparkContext(appName:String) : SparkContext = {
  val conf = new SparkConf().setAppName(appName).setMaster("local")
  //conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
  val sparkCtx =  new SparkContext(conf)
  sparkCtx.hadoopConfiguration.set("mapreduce.input.fileinputformat.input.dir.recursive", "true")
  sparkCtx
}


}
