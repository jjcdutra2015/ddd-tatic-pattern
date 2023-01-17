package com.jjcdutra.infrastructure.repository

import com.jjcdutra.domain.entity.Address
import com.jjcdutra.domain.entity.Customer
import com.jjcdutra.domain.repository.CustomerRepositoryInterface
import com.jjcdutra.infrastructure.db.jpa.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerRepository(
    val repository: CustomerModelRepository
) : CustomerRepositoryInterface {
    override fun create(entity: Customer) {
        val customerModel = CustomerModel(
            id = entity.id,
            name = entity.name,
            street = entity.address!!.street,
            number = entity.address!!.number,
            zip = entity.address!!.zip,
            city = entity.address!!.city,
            active = entity.isActive(),
            rewardPoints = entity.rewardPoints
        )
        repository.save(customerModel)
    }

    override fun update(entity: Customer) {
        val customerFind = repository.findById(entity.id).get()
        val customer = customerFind.copy(
            name = entity.name,
            street = entity.address!!.street,
            number = entity.address!!.number,
            zip = entity.address!!.zip,
            city = entity.address!!.city,
            active = entity.isActive(),
            rewardPoints = entity.rewardPoints
        )
        repository.save(customer)
    }

    override fun find(id: String): Customer {
        val model = repository.findById(id).get()
        return Customer(
            model.id,
            model.name,
            model.active,
            model.rewardPoints,
            Address(model.street, model.number, model.zip, model.city)
        )
    }

    override fun findAll(): List<Customer> {
        val models = repository.findAll()
        return models.map {
            Customer(
                it.id,
                it.name,
                it.active,
                it.rewardPoints,
                Address(it.street, it.number, it.zip, it.city)
            )
        }
    }
}
