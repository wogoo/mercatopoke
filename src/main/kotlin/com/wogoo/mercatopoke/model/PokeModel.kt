package com.wogoo.mercatopoke.model

import com.wogoo.mercatopoke.enums.Errors
import com.wogoo.mercatopoke.enums.PokeStatus
import com.wogoo.mercatopoke.exception.BadRequestException
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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
        ) {
    @Column
    @Enumerated(EnumType.STRING)
    var status: PokeStatus? = null
        set(value) {
            if(field == PokeStatus.CANCELADO || field == PokeStatus.DELETADO)
                throw BadRequestException(Errors.MP2002.message.format(field), Errors.MP2002.code)
                field = value

        }

    constructor(id: Int? = null,
                name: String,
                price: BigDecimal,
                customer: CustomerModel? = null,
                status: PokeStatus?): this(id, name, price, customer) {
                    this.status = status
                }

}