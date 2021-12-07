package phb.forecast.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "resume")
class Resume(
    @Id @Column(name = "tgl")
    var tgl: Int,
    @Column(name = "sum")
    var nilai: Double
) {
    constructor(): this(0, 0.0)
}