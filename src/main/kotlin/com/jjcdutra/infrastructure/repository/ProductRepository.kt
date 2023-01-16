package com.jjcdutra.infrastructure.repository

import com.jjcdutra.domain.entity.Product
import com.jjcdutra.domain.repository.ProductRepositoryInterface
import com.jjcdutra.infrastructure.db.jpa.model.ProductModel
import org.springframework.stereotype.Service

@Service
class ProductRepository(
    val repository: ProductModelRepository
) : ProductRepositoryInterface {
    override fun create(entity: Product) {
        val productModel = ProductModel(
            id = entity.id,
            name = entity.name,
            price = entity.price
        )
        repository.save(productModel)
    }

    override fun update(entity: Product) {
        val product = repository.findById(entity.id).get()
        repository.save(
            ProductModel(
                id = product.id,
                name = product.name,
                price = product.price
            )
        )
    }

    override fun find(id: String): Product {
        val productModel = repository.findById(id).get()
        return Product(productModel.id, productModel.name, productModel.price)
    }

    override fun findAll(): List<Product> {
        val productModels = repository.findAll()
        return productModels.map {
            Product(id = it.id, name = it.name, price = it.price)
        }
    }

}
