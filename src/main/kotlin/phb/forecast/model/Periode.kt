package phb.forecast.model

import org.springframework.format.annotation.DateTimeFormat
import java.util.*

class Periode(
    var tglAwal: String,
    var tglAkhir: String
) {
    constructor(): this("", "")
}