package phb.forecast.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import phb.forecast.model.Fakta

@Repository
interface FaktaRepo: JpaRepository<Fakta, Int> {
}