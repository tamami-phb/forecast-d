package phb.forecast.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import phb.forecast.model.Periode
import phb.forecast.repo.ResumeRepo
import phb.forecast.util.LeastSquare

@Controller
class MainController {

    var logger = LoggerFactory.getLogger("MainController")

    @Autowired
    lateinit var resumeRepo: ResumeRepo

    @RequestMapping(value = [ "/" ], method = [ RequestMethod.GET ])
    fun index(model: Model): String {
        model.addAttribute("param", Periode())
        return "index"
    }

    @RequestMapping(value = [ "/proses" ], method = [ RequestMethod.POST ])
    fun proses(param: Periode, model: Model): String {
        logger.info("tanggal awal: " + param.tglAwal.toString())
        val data = resumeRepo.findByTglBetween(
            LeastSquare.convertTglToInt(param.tglAwal),
            LeastSquare.convertTglToInt(param.tglAkhir))
        val result = LeastSquare.calculate(data)
        model.addAttribute("result", result)
        return "proses"
    }

}