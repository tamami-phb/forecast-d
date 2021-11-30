package phb.forecast.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "fakta")
class Fakta(
    @Id @Column(name = "id")
    var id: Int,
    @Column(name = "sk_waktu")
    var skWaktu: Int,
    @Column(name = "amount")
    var amount: Double,
    @Column(name = "sk_film")
    var skFilm: Int,
    @Column(name = "sk_customer")
    var skCustomer: Int,
    @Column(name = "sk_staf")
    var skStaf: Int
)
{
    constructor(): this(0, 0, 0.0, 0,
        0, 0)
}