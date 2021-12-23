package com.wogoo.mercatopoke.model

import com.wogoo.mercatopoke.enums.PokeStatus
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "poke")
data class PokeModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,
    @Column
    var price: BigDecimal,
    @Column
    @Enumerated(EnumType.STRING)
    var status: PokeStatus? = null,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
        )