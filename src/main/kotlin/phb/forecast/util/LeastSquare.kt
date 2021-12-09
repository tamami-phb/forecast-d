package phb.forecast.util

import org.springframework.beans.factory.annotation.Autowired
import phb.forecast.model.Resume
import phb.forecast.repo.ResumeRepo

class LeastSquare {
    companion object {
        fun calculate(data: List<Resume>): Double {

            val a = calculateA(data)
            val b = calculateB(data)
            val x = getX(generateX(data))

            return a + (b * x)
        }

        fun getX(list: List<Int>): Int {
            if(list.size % 2 == 0) { // genap
                return list[list.size-1] + 2
            } else
                return list[list.size-1] + 1
        }

        fun calculateB(data: List<Resume>): Double {
            val listX = generateX(data)
            val xy = calculateXY(data, listX)
            val x2 = calculateX2(listX)

            return xy / x2
        }

        fun calculateX2(listX: List<Int>): Int {
            var result = 0;
            listX.forEach {
                result += (it*it)
            }
            return result
        }

        fun calculateXY(data: List<Resume>, listX: List<Int>): Double {
            var xy = mutableListOf<Double>()
            var i=0
            while(i < data.size) {
                xy.add(data[i].nilai * listX[i])
                i++
            }
            var result = 0.0
            xy.forEach {
                result += it
            }
            return result
        }

        fun generateX(data: List<Resume>): List<Int> {
            var result = mutableListOf<Int>()
            if(data.size % 2 == 0) { // jumlah data genap
                return generateXEven(data.size)
            } else { // jumlah data ganjil
                return generateXOdd(data.size)
            }
        }

        fun generateXEven(jumlahData: Int): List<Int> {
            var result = mutableListOf<Int>()
            var start = jumlahData - 1 - ((jumlahData - 1) * 2)
            var i=1
            while(i <= jumlahData) {
                result.add(start)
                start += 2
                i++
            }
            return result
        }

        fun generateXOdd(jumlahData: Int): List<Int> {
            var result = mutableListOf<Int>()
            var start = (jumlahData / 2).toInt() - jumlahData + 1
            var i=1
            while(i <= jumlahData) {
                result.add(start++)
                i++
            }
            return result
        }


        fun calculateA(data: List<Resume>): Double {
            var total = 0.0;

            data.forEach {
                total += it.nilai
            }

            return total / data.size
        }

        fun convertTglToInt(tgl: String): Int {
            val result = tgl.substring(0, 4) + tgl.substring(5,7) + tgl.substring(8,10)
            return Integer.parseInt(result);
        }
    }

}