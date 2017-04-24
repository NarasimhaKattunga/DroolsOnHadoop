package DomainObjects

/**
  * Created by 396885 on 06/04/2017.
  */
case class Products(
                    retCountry: String,
                    orderMethod: String,
                    retailerType: String,
                    prodLine: String,
                    prodType: String,
                    prod: String,
                    year: Long,
                    quarter: String,
                    revenue: Double,
                    qty: Double,
                    grossMargin: Double
                  ) {

  var isValid = false;

  def isValid(value: Boolean): Unit = {
    this.isValid = value
  }

}

