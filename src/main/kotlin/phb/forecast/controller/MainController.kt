package phb.forecast.controller

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import phb.forecast.model.Periode

@Controller
class MainController {

    var logger = LoggerFactory.getLogger("MainController")

    @RequestMapping(value = [ "/" ], method = [ RequestMethod.GET ])
    fun index(model: Model): String {
        model.addAttribute("param", Periode())
        return "index"
    }

    @RequestMapping(value = [ "/proses" ], method = [ RequestMethod.POST ])
    fun proses(param: Periode): String {
        logger.info("tanggal awal: " + param.tglAwal.toString())

        return "proses"
    }

}