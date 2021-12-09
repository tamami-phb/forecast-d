package phb.forecast.util

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import phb.forecast.repo.ResumeRepo

@SpringBootTest
class LeastSquareTest {

    var logger = LoggerFactory.getLogger("LeastSquareTest")

    @Autowired
    lateinit var resumeRepo: ResumeRepo

    @Test
    fun convertTglToIntTest() {
        val result = LeastSquare.convertTglToInt("2005-06-07")
        logger.info("hasilnya : " + result.toString())
        Assertions.assertEquals(20050607, result)
    }

    @Test
    fun calculateATest() {
        val data = resumeRepo.findByTglBetween(20050524, 20050530)
        val result = LeastSquare.calculateA(data)
        logger.info("Hasilnya : " + result.toString())
        Assertions.assertEquals(589.01, result)
    }

    @Test
    fun generateXOdd() {
        val result = LeastSquare.generateXOdd(7)
        result.forEach {
            logger.info("Data : " + it.toString())
        }
        Assertions.assertEquals(-3, result[0])
    }

    @Test
    fun generateXEven() {
        val result = LeastSquare.generateXEven(6)
        result.forEach {
            logger.info("Data : " + it.toString())
        }
        Assertions.assertEquals(-5, result[0])
    }

    @Test
    fun calculateXYTest() {
        val data = resumeRepo.findByTglBetween(20050524, 20050530)
        val result = LeastSquare.calculateXY(data, LeastSquare.generateX(data))
        logger.info("Nilai : " + result.toString())
        Assertions.assertEquals(1994.9399999999998, result)
    }

    @Test
    fun calculateX2Test() {
        val data = LeastSquare.generateXOdd(7)
        val result = LeastSquare.calculateX2(data)
        logger.info("Nilai : " + result.toString())
        Assertions.assertEquals(28, result)
    }

    @Test
    fun calculateTest() {
        val data = resumeRepo.findByTglBetween(
            LeastSquare.convertTglToInt("2005-05-24"),
            LeastSquare.convertTglToInt("2005-05-30"))
        val result = LeastSquare.calculate(data)
        logger.info("Nilai : " + result.toString())
        Assertions.assertNotNull(result)
    }

}