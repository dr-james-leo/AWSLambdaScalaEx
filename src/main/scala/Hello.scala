package ScalaAWS

import com.amazonaws.services.lambda.runtime.Context
//import com.fasterxml.jackson.annotation.JsonProperty
//import com.fasterxml.jackson.annotation.JsonProperty
//import scala.beans.BeanProperty
import java.io.InputStream
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

//case class AWSInput1(Count: Int)

//class AWSInput(@JsonProperty @BeanProperty var Count: Int)
case class AWSInput(Count: Int)

class Hello {


  def myHandler(input: InputStream, context: Context): String = {

    val scalaMapper = {
      new ObjectMapper().registerModule(new DefaultScalaModule)
    }

    val awsinput = scalaMapper.readValue(input, classOf[AWSInput])

    val count = awsinput.Count
    val t1 = java.util.Calendar.getInstance().getTime()
    val logger = context.getLogger
    logger.log("received : " + count)
    Thread.sleep(count * 1000)
    val t2 = java.util.Calendar.getInstance().getTime()
    String.valueOf("v2 t1 = " + t1 + "; t2 = " + t2)
  }
}

//  def this(cnt: Int) = {
//    this()
//    this.count = cnt
//  }
//def this() = this(Count = 1)