package com.wogoo.mercatopoke.repository

import com.wogoo.mercatopoke.model.PurchaseModel
import org.springframework.data.repository.CrudRepository


interface PurchaseRepository : CrudRepository<PurchaseModel, Int> {

}
