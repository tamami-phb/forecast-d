package phb.forecast.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import phb.forecast.model.Resume

@Repository
interface ResumeRepo: JpaRepository<Resume, Int> {

    fun findByTglBetween(dari: Int, sampai: Int): List<Resume>

}